package midsummer.lordecalculator.ui.addLordeData;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaychang.srv.SimpleRecyclerView;

import org.joda.time.DateTime;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import midsummer.lordecalculator.R;
import midsummer.lordecalculator.helper.DateTimeFormatHelper;
import midsummer.lordecalculator.helper.LogUtil;
import midsummer.lordecalculator.helper.StringUtil;
import midsummer.lordecalculator.helper.ToastUtil;
import midsummer.lordecalculator.model.LordeData.LordeData;
import midsummer.lordecalculator.model.Merchant.Merchant;

/**
 * Created by nienb on 30-Oct-17.
 */

public class AddLordeActivity extends AppCompatActivity implements AddLordeDataContract.View, AddLordeDataCell.LordeDataCellClickListener {


    @BindView(R.id.btn_back)
    LinearLayout btnBack;
    @BindView(R.id.btn_add_new)
    TextView btnAddNew;
    @BindView(R.id.btn_add_1)
    Button btnAdd1;
    @BindView(R.id.btn_add_2)
    Button btnAdd2;
    @BindView(R.id.btn_add_3)
    Button btnAdd3;
    @BindView(R.id.btn_add_4)
    Button btnAdd4;
    @BindView(R.id.btn_add_5)
    Button btnAdd5;
    @BindView(R.id.btn_add_6)
    Button btnAdd6;
    @BindView(R.id.btn_add_7)
    Button btnAdd7;
    @BindView(R.id.btn_add_8)
    Button btnAdd8;
    @BindView(R.id.txt_merchant_name)
    TextView txtMerchantName;
    @BindView(R.id.txt_date)
    TextView txtDate;
    @BindView(R.id.recycler_view)
    SimpleRecyclerView recyclerView;

    private AddLordeDataContract.Presenter mPresenter;
    private Merchant merchant;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lorde_data);
        ButterKnife.bind(this);
        mPresenter.start(getIntent());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter == null)
            mPresenter = new AddLordeDataPresenter(Realm.getDefaultInstance(), this);
    }

    @Override
    public void addToList(LordeData lordeData) {
        recyclerView.addCell(new AddLordeDataCell(lordeData, this));
    }

    @Override
    public void removeFromList(LordeData lordeData) {
        int posToRemove = -1;
        for (int i = 0; i < recyclerView.getItemCount(); i++){
            if (recyclerView.getCell(i).getItem() instanceof LordeData
                    && ((LordeData)recyclerView.getCell(i).getItem()).getId() == lordeData.getId()){
                posToRemove = i;
                break;
            }
        }
        if (posToRemove > -1 && posToRemove < recyclerView.getItemCount())
            recyclerView.removeCell(posToRemove);
    }

    @Override
    public void initData(Merchant merchant) {
        try {
            if (merchant == null){
                onBackPressed();
            }
            this.merchant = merchant;
            txtDate.setText(DateTimeFormatHelper.FormatDateTime(DateTime.now()));
            txtMerchantName.setText(merchant.getName());
        }catch (Exception e){
            LogUtil.e(e);
        }
    }

    @Override
    public boolean validateValue() {
        return true;
    }

    @Override
    public boolean validateNumbers() {
        return true;
    }

    @Override
    public void displayMessage(String message) {
        ToastUtil.show(message);
    }

    @Override
    public void onCellClick(LordeData lordeData) {

    }

    @OnClick({R.id.btn_back, R.id.btn_add_new, R.id.btn_add_1, R.id.btn_add_2, R.id.btn_add_3, R.id.btn_add_4, R.id.btn_add_5, R.id.btn_add_6, R.id.btn_add_7, R.id.btn_add_8})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_add_new:
                mPresenter.submit(recyclerView);
                break;
            case R.id.btn_add_1:
                break;
            case R.id.btn_add_2:
                break;
            case R.id.btn_add_3:
                break;
            case R.id.btn_add_4:
                break;
            case R.id.btn_add_5:
                break;
            case R.id.btn_add_6:
                break;
            case R.id.btn_add_7:
                break;
            case R.id.btn_add_8:
                break;
        }
    }


    private void showAddNewDialog(int type){

    }
}
