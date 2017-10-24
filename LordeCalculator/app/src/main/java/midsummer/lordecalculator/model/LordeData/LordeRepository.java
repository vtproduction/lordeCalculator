package midsummer.lordecalculator.model.LordeData;

import io.realm.Realm;
import io.realm.RealmList;
import midsummer.lordecalculator.helper.RandomString;

/**
 * Created by NIENLM on 10/24/17.
 */

public class LordeRepository implements LordeDataSource {
    private Realm realm;

    public LordeRepository(Realm realm) {
        this.realm = realm;
    }

    @Override
    public String setLordeData(RealmList<Integer> numbers, int value, int type) {
        String id = new RandomString(16).nextString();
        final LordeData lordeData = new LordeData();
        lordeData.setId(id);
        lordeData.setNumbers(numbers);
        lordeData.setValue(value);
        lordeData.setType(type);
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(lordeData);
            }
        });
        return id;
    }


}
