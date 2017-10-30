package midsummer.lordecalculator.model.LordeData;

import io.realm.Realm;

/**
 * Created by NIENLM on 10/24/17.
 */

public class LordeRepository implements LordeDataSource {
    private Realm realm;

    public LordeRepository(Realm realm) {
        this.realm = realm;
    }

    @Override
    public long setLordeData(final LordeData lordeData) {
        /*String id = new RandomString(6).nextString();
        long now = DateTime.now().getMillis();
        final LordeData lordeData = new LordeData();
        lordeData.setId(now + Long.parseLong(id));
        lordeData.setNumbers(numbers);
        lordeData.setValue(value);
        lordeData.setType(type);*/
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(lordeData);
            }
        });
        return lordeData.getId();
    }


}
