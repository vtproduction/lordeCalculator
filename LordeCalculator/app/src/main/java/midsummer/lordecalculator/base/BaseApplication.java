package midsummer.lordecalculator.base;

import android.app.Application;

/**
 * Created by NienLe on 11-Oct-17.
 */

public class BaseApplication extends Application {
    public static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }


    public static BaseApplication get(){
        return instance;
    }
}
