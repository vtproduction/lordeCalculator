package midsummer.lordecalculator.model.KQSX;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import midsummer.lordecalculator.helper.DateTimeFormatHelper;

/**
 * Created by NIENLM on 10/23/17.
 */

public class KQSXRepository implements KQSXDataSource {
    private Realm realm;

    public KQSXRepository(Realm realm) {
        this.realm = realm;
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
    public void updateKQSX(final long dt, final List<Integer> data) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                KQSX kqsx = getKQSX(dt);
                if (kqsx != null){
                    RealmList<Integer> tmp = new RealmList<Integer>();
                    tmp.addAll(data);
                    kqsx.setResults(tmp);
                    realm.copyToRealmOrUpdate(kqsx);
                }else {
                    kqsx = new KQSX(dt, data);
                    realm.copyToRealmOrUpdate(kqsx);
                }

            }
        });
    }
}
