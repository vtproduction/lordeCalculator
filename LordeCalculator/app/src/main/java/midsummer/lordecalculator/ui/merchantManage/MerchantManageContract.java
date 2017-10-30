package midsummer.lordecalculator.ui.merchantManage;

import java.util.List;

import midsummer.lordecalculator.model.Merchant.Merchant;

/**
 * Created by NIENLM on 10/25/17.
 */

public interface MerchantManageContract {

    interface View{
        void onNewMerchantBtnClick();
        void loadMerChantList(List<Merchant> merchants);
        void onMerchantDetailClick(Merchant merchant);
    }


    interface Presenter{
        void loadUser();
        void stop();
    }
}
