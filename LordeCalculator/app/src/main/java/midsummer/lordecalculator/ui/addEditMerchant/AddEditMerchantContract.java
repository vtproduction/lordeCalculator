package midsummer.lordecalculator.ui.addEditMerchant;

import android.content.Intent;

import midsummer.lordecalculator.model.Merchant.Merchant;

/**
 * Created by NIENLM on 10/25/17.
 */

public interface AddEditMerchantContract {

    interface View{
        void onSubmitCompleted();
        void onUpdate(Merchant merchant);
        void loadContent(Merchant merchant);
        void displayError(String error);
    }

    interface Presenter{
        void loadMerchant(Intent intent);
        void addNewMerchant(String merchantName, String merchantPhone, boolean isOwner, float rateLO, float rateDE, float rateXIEN, long remainLoan);
        void updateMerchant(String merchantName, String merchantPhone, boolean isOwner, float rateLO, float rateDE, float rateXIEN, long remainLoan);
        void stop();
    }


}
