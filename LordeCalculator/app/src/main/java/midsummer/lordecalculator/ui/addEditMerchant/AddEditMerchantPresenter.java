package midsummer.lordecalculator.ui.addEditMerchant;

import android.content.Intent;

import io.realm.Realm;
import midsummer.lordecalculator.helper.LogUtil;
import midsummer.lordecalculator.helper.RandomString;
import midsummer.lordecalculator.model.Merchant.Merchant;
import midsummer.lordecalculator.model.Merchant.MerchantDataSource;
import midsummer.lordecalculator.model.Merchant.MerchantRepository;

/**
 * Created by NIENLM on 10/26/17.
 */

public class AddEditMerchantPresenter implements AddEditMerchantContract.Presenter {
    public static final String KEY_MERCHANT = "merchant";
    private AddEditMerchantContract.View mView;
    private Realm realm;
    private MerchantDataSource mMerchant;
    private Merchant merchant;

    public AddEditMerchantPresenter(AddEditMerchantContract.View mView, Realm realm) {
        this.mView = mView;
        this.realm = realm;
        this.mMerchant = new MerchantRepository(realm);
    }

    @Override
    public void loadMerchant(Intent intent) {
        try {
            String merchantId = intent.getStringExtra(KEY_MERCHANT);
            if (merchantId == null || merchantId.isEmpty())
                mView.loadContent(null);
            else{
                this.merchant = mMerchant.getMerchantById(merchantId);
                mView.loadContent(merchant);
            }
        }catch (Exception e){
            LogUtil.e(e);
        }
    }

    @Override
    public void addNewMerchant(String merchantName, String merchantPhone, boolean isOwner, float rateLO, float rateDE, float rateXIEN, long remainLoan) {
        try {
            if (!validateData(merchantName, merchantPhone, rateLO, rateDE, rateXIEN)) return;
            Merchant newMerchant = new Merchant();
            newMerchant.setId(new RandomString().nextString());
            newMerchant.setName(merchantName);
            newMerchant.setPhone(merchantPhone);
            newMerchant.setOwner(isOwner);
            newMerchant.setRateLO(rateLO);
            newMerchant.setRateDE(rateDE);
            newMerchant.setRateXIEN(rateXIEN);
            newMerchant.setRemainLoan(remainLoan);
            mMerchant.addNewMerchant(newMerchant);
            mView.onSubmitCompleted();
        }catch (Exception e){
            LogUtil.e(e);
        }
    }

    @Override
    public void updateMerchant(String merchantName, String merchantPhone, boolean isOwner, float rateLO, float rateDE, float rateXIEN, long remainLoan) {
        try {
            if (!validateData(merchantName, merchantPhone, rateLO, rateDE, rateXIEN)) return;
            if (merchant == null) return;
            mMerchant.updateMerchant(merchant.getId(),merchantName, merchantPhone, isOwner, rateLO, rateDE, rateXIEN, remainLoan);
            mView.onSubmitCompleted();
        }catch (Exception e){
            LogUtil.e(e);
        }
    }

    @Override
    public void stop() {
        realm.close();
    }



    private boolean validateData(String merchantName, String merchantPhone,  float rateLO, float rateDE, float rateXIEN){
        if (merchantName.isEmpty()){
            mView.displayError("Tên không được để trống!");
            return false;
        }

        if (merchantPhone.isEmpty()){
            mView.displayError("SDT không được để trống!");
            return false;
        }

        if (rateLO <= 0){
            mView.displayError("Tỉ lệ LÔ không hợp lệ!");
            return false;
        }

        if (rateDE <= 0){
            mView.displayError("Tỉ lệ ĐỀ không hợp lệ!");
            return false;
        }

        if (rateXIEN <= 0){
            mView.displayError("Tỉ lệ XIÊN không hợp lệ!");
            return false;
        }

        return true;
    }
}
