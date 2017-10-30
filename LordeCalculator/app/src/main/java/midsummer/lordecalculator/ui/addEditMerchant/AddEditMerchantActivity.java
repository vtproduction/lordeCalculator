package midsummer.lordecalculator.ui.addEditMerchant;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import midsummer.lordecalculator.R;
import midsummer.lordecalculator.helper.LogUtil;
import midsummer.lordecalculator.helper.ToastUtil;
import midsummer.lordecalculator.model.Merchant.Merchant;

/**
 * Created by NIENLM on 10/26/17.
 */

public class AddEditMerchantActivity extends AppCompatActivity implements AddEditMerchantContract.View {

    @BindView(R.id.btn_back)
    LinearLayout btnBack;
    @BindView(R.id.label_1)
    TextView label1;
    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.btn_switch_owner)
    TextView btnSwitchOwner;
    @BindView(R.id.edt_phone)
    EditText edtPhone;
    @BindView(R.id.edt_rate_de)
    EditText edtRateDe;
    @BindView(R.id.edt_rate_lo)
    EditText edtRateLo;
    @BindView(R.id.edt_rate_xien)
    EditText edtRateXien;
    @BindView(R.id.edt_remain_loan)
    EditText edtRemainLoan;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    private AddEditMerchantContract.Presenter mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_update_merchant);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter == null)
            mPresenter = new AddEditMerchantPresenter(this, Realm.getDefaultInstance());
        mPresenter.loadMerchant(getIntent());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.stop();
    }

    @Override
    public void onUpdate(Merchant merchant) {

    }

    @Override
    public void loadContent(Merchant merchant) {
        try {

            if (merchant == null) clearAllInput();
            else {

                edtName.setText(merchant.getName());
                edtPhone.setText(merchant.getPhone());
                edtRateDe.setText(merchant.getRateDE() + "");
                edtRateLo.setText(merchant.getRateLO() + "");
                edtRateXien.setText(merchant.getRateXIEN() + "");
                edtRemainLoan.setText(merchant.getRemainLoan() + "");
                btnSwitchOwner.setBackground(getResources().getDrawable(merchant.isOwner() ? R.drawable.btn_is_owner_selected : R.drawable.btn_is_owner_unselected));
                btnSwitchOwner.setTag(merchant.isOwner());
                btnSubmit.setText("cập nhật");
            }
        }catch (Exception e){
            LogUtil.e(e);
        }
    }

    @Override
    public void displayError(String error) {
        ToastUtil.show(error);
    }

    @Override
    public void onSubmitCompleted() {
        ToastUtil.show("Cập nhật thành công!");
        finish();
    }

    @OnClick({R.id.btn_back, R.id.btn_switch_owner, R.id.btn_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                onBackPressed();
                break;
            case R.id.btn_switch_owner:
                setBtnSwitchOwner();
                break;
            case R.id.btn_submit:
                onSubmitClicked();
                break;
        }
    }


    private void setBtnSwitchOwner(){
        if ((boolean)btnSwitchOwner.getTag()){
            btnSwitchOwner.setTag(false);
            btnSwitchOwner.setBackground(getResources().getDrawable(R.drawable.btn_is_owner_unselected));
        }else {
            btnSwitchOwner.setTag(true);
            btnSwitchOwner.setBackground(getResources().getDrawable(R.drawable.btn_is_owner_selected));
        }
    }

    private void onSubmitClicked(){
        String name = edtName.getText().toString();
        String phone = edtPhone.getText().toString();
        float rateDe = Float.parseFloat(edtRateDe.getText().toString());
        float rateLo = Float.parseFloat(edtRateLo.getText().toString());
        float rateXien = Float.parseFloat(edtRateXien.getText().toString());
        long remainLoan = Long.parseLong(edtRemainLoan.getText().toString());
        boolean isOwner = (boolean)btnSwitchOwner.getTag();
        if (btnSubmit.getText().equals("tạo mới"))
            mPresenter.addNewMerchant(name, phone, isOwner, rateLo, rateDe, rateXien, remainLoan);
        else
            mPresenter.updateMerchant(name, phone, isOwner, rateLo, rateDe, rateXien, remainLoan);
    }


    private void clearAllInput(){
        try {
            edtName.setText("");
            edtPhone.setText("");
            edtRateDe.setText("");
            edtRateLo.setText("");
            edtRateXien.setText("");
            edtRemainLoan.setText("");
            btnSwitchOwner.setBackground(getResources().getDrawable(R.drawable.btn_is_owner_unselected));
            btnSwitchOwner.setTag(false);
            btnSubmit.setText("tạo mới");
        }catch (Exception e){
            LogUtil.e(e);
        }
    }
}
