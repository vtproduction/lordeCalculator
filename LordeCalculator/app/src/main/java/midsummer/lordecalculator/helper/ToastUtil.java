package midsummer.lordecalculator.helper;

import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import midsummer.lordecalculator.base.BaseApplication;

/**
 * Created by NIENLM on 1/4/17.
 */

public class ToastUtil {
    private static Toast toast;

    public static void show(String text) {
        if (BaseApplication.get() == null) return;
        if (text.equals("")){
            //LogUtil.e("TOAST không hiển thị gì ???");
            return;
        }
        toast = Toast.makeText(BaseApplication.get(), text, Toast.LENGTH_SHORT);
        //NIENLM: centered the text inside toast.
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        if( v != null) v.setGravity(Gravity.CENTER);
        if (toast != null && toast.getView() != null && !toast.getView().isShown())
            toast.show();
    }

    public static void show(int textId) {
        if (BaseApplication.get() == null) return;
        toast = Toast.makeText(BaseApplication.get(), BaseApplication.get().getString(textId), Toast.LENGTH_SHORT);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        if( v != null) v.setGravity(Gravity.CENTER);
        if (toast != null && toast.getView() != null && !toast.getView().isShown())
            toast.show();
    }



}
