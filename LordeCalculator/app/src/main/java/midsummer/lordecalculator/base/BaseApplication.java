package midsummer.lordecalculator.base;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by NienLe on 11-Oct-17.
 */

public class BaseApplication extends Application {
    public static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Realm.init(this);
    }


    public static BaseApplication get(){
        return instance;
    }
}
