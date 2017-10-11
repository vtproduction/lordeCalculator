package midsummer.lordecalculator.CheckPincode;

/**
 * Created by NienLe on 11-Oct-17.
 */

public interface CheckPincodeContract {
    interface View{
        void setup();
        void navigateToMain();
    }

    interface presenter{
        void checkAtStartup();
        void checkPinCode(String pincode);
    }


}
