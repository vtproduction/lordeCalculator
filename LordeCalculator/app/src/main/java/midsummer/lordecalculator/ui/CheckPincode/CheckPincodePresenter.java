package midsummer.lordecalculator.ui.CheckPincode;

import android.content.Context;
import android.content.SharedPreferences;

import midsummer.lordecalculator.base.BaseApplication;

/**
 * Created by NienLe on 11-Oct-17.
 */

public class CheckPincodePresenter implements CheckPincodeContract.presenter {
    private CheckPincodeContract.View mView;
    private final String ACCEPT_PINCODE = "1759";

    public CheckPincodePresenter(CheckPincodeContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void checkAtStartup() {
        SharedPreferences sharedPreferences = BaseApplication.get().getSharedPreferences("data", Context.MODE_PRIVATE);
        if (sharedPreferences.getBoolean("auth", false))
            mView.navigateToMain();


    }

    @Override
    public void checkPinCode(String pincode) {
        try {
            if (pincode != null && pincode.equals(ACCEPT_PINCODE)){
                SharedPreferences sharedPreferences = BaseApplication.get().getSharedPreferences("data", Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean("auth", true).apply();
                mView.navigateToMain();
            }

        }catch (Exception e){

        }
    }
}
