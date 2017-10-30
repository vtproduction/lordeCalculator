package midsummer.lordecalculator.ui.addKQSX;

import java.util.List;

import io.realm.Realm;
import midsummer.lordecalculator.helper.DateTimeFormatHelper;
import midsummer.lordecalculator.helper.LogUtil;
import midsummer.lordecalculator.model.KQSX.KQSX;
import midsummer.lordecalculator.model.KQSX.KQSXDataSource;
import midsummer.lordecalculator.model.KQSX.KQSXRepository;

/**
 * Created by NIENLM on 10/26/17.
 */

public class AddKQSXPresenter implements AddKQSXContract.Presenter {
    private AddKQSXContract.View mView;
    private Realm realm;
    private KQSXDataSource mKQSX;

    public AddKQSXPresenter(AddKQSXContract.View mView, Realm realm) {
        this.mView = mView;
        this.realm = realm;
        this.mKQSX = new KQSXRepository(realm);
    }

    @Override
    public void load() {
        try {
            long dt = DateTimeFormatHelper.DateTimeNowToLong();
            KQSX kqsx = mKQSX.getKQSX(dt);
            mView.load(kqsx);
        }catch (Exception e){
            LogUtil.e(e);
        }
    }

    @Override
    public void addToDB(List<Integer> values) {
        try {
            long dt = DateTimeFormatHelper.DateTimeNowToLong();
            mKQSX.updateKQSX(dt, values);
            mView.displayMessage("Cập nhật thành công");
        }catch (Exception e){
            LogUtil.e(e);
        }
    }

    @Override
    public void stop() {
        realm.close();
    }
}
