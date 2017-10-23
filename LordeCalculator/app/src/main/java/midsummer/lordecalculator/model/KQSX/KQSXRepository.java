package midsummer.lordecalculator.model.KQSX;

import java.util.List;

import io.realm.Realm;
import midsummer.lordecalculator.helper.DateTimeFormatHelper;

/**
 * Created by NIENLM on 10/23/17.
 */

public class KQSXRepository implements KQSXDataSource {
    private Realm realm;

    public KQSXRepository() {
        this.realm = Realm.getDefaultInstance();
    }

    @Override
    public KQSX getKQSX(long date) {
        return realm.where(KQSX.class).equalTo("date",date).findFirst();
    }

    @Override
    public KQSX getLastestKQSX() {
        return realm.where(KQSX.class).findFirst();
    }

    @Override
    public List<KQSX> getKQSXBetween(long from, long to) {
        return realm.where(KQSX.class).between("date",from, to).findAll();
    }

    @Override
    public void setKQSX(final List<Integer> data) {
        final long date = DateTimeFormatHelper.DateTimeNowToLong();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                KQSX kqsx = new KQSX(date, data);
                realm.copyToRealmOrUpdate(kqsx);
            }
        });

    }

    @Override
    public void updateKQSX(final KQSX data) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(data);
            }
        });
    }
}
