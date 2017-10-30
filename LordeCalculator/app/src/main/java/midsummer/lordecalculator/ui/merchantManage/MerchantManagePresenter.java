package midsummer.lordecalculator.ui.merchantManage;

import java.util.List;

import io.realm.Realm;
import midsummer.lordecalculator.helper.LogUtil;
import midsummer.lordecalculator.model.Merchant.Merchant;
import midsummer.lordecalculator.model.Merchant.MerchantDataSource;
import midsummer.lordecalculator.model.Merchant.MerchantRepository;

/**
 * Created by NIENLM on 10/25/17.
 */

public class MerchantManagePresenter implements MerchantManageContract.Presenter {
    private Realm realm;
    private MerchantDataSource mMerchant;
    private MerchantManageContract.View mView;

    public MerchantManagePresenter(Realm realm, MerchantManageContract.View mView) {
        this.realm = realm;
        this.mView = mView;
        this.mMerchant = new MerchantRepository(realm);
    }

    @Override
    public void loadUser() {
        try {
            List<Merchant> merchantList = mMerchant.getAllMerchants();
            mView.loadMerChantList(merchantList);
        }catch (Exception e){
            LogUtil.e(e);
        }
    }

    @Override
    public void stop() {
        mMerchant = null;
        realm.close();
    }
}
