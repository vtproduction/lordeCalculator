package midsummer.lordecalculator.ui.merchantManage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaychang.srv.SimpleRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import midsummer.lordecalculator.R;
import midsummer.lordecalculator.helper.LogUtil;
import midsummer.lordecalculator.model.Merchant.Merchant;
import midsummer.lordecalculator.ui.addEditMerchant.AddEditMerchantActivity;
import midsummer.lordecalculator.ui.addEditMerchant.AddEditMerchantPresenter;
import midsummer.lordecalculator.ui.addLordeData.AddLordeActivity;

/**
 * Created by NIENLM on 10/24/17.
 */

public class MerchantManageActivity extends AppCompatActivity implements MerchantManageContract.View {

    @BindView(R.id.btn_back)
    LinearLayout btnBack;
    @BindView(R.id.btn_add_new)
    TextView btnAddNew;
    @BindView(R.id.recycler_view)
    SimpleRecyclerView recyclerView;
    private Realm realm;
    private MerchantManageContract.Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_merchant);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (realm == null) realm = Realm.getDefaultInstance();
        if (mPresenter == null) mPresenter = new MerchantManagePresenter(realm, this);
        mPresenter.loadUser();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.stop();
    }

    @Override
    public void onNewMerchantBtnClick() {
        startActivity(new Intent(this, AddEditMerchantActivity.class).putExtra(AddEditMerchantPresenter.KEY_MERCHANT,""));
    }

    @Override
    public void loadMerChantList(List<Merchant> merchants) {
        try {
            recyclerView.removeAllCells();
            for (Merchant merchant : merchants)
                recyclerView.addCell(new MerchantDataCell(merchant, this, new MerchantDataCell.MerchantDataCellClickListener() {
                    @Override
                    public void onClick(Merchant merchant) {
                        onMerchantDetailClick(merchant);
                    }
                }));
        }catch (Exception e){
            LogUtil.e(e);
        }
    }

    @Override
    public void onMerchantDetailClick(Merchant merchant) {
        startActivity(new Intent(this, AddLordeActivity.class).putExtra("merchantId",merchant.getId()));
    }

    @OnClick({R.id.btn_back, R.id.btn_add_new})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_add_new:
                onNewMerchantBtnClick();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
