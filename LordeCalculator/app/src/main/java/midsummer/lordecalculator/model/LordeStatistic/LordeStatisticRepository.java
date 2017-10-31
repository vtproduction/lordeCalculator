package midsummer.lordecalculator.model.LordeStatistic;

import io.realm.Realm;
import io.realm.RealmList;
import midsummer.lordecalculator.helper.RandomString;
import midsummer.lordecalculator.model.LordeData.LordeData;
import midsummer.lordecalculator.model.Merchant.MerchantDataSource;
import midsummer.lordecalculator.model.Merchant.MerchantRepository;

/**
 * Created by NIENLM on 10/24/17.
 */

public class LordeStatisticRepository implements LordeStatisticDataSource {
    private Realm realm;
    public LordeStatisticRepository(Realm realm) {
        this.realm = realm;
    }

    @Override
    public String addNew(final String merChantId, final long date, final RealmList<LordeData> data) {
        final String id = new RandomString(12).nextString();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                LordeStatistic lordeStatistic = new LordeStatistic();
                lordeStatistic.setData(data);
                lordeStatistic.setDate(date);
                lordeStatistic.setId(id);
                lordeStatistic.setMerChantId(merChantId);
                lordeStatistic.setTotalIncome(0);
                lordeStatistic.setTotalOutcome(0);
                realm.copyToRealmOrUpdate(lordeStatistic);
            }
        });
        return id;
    }

    @Override
    public LordeStatistic get(long date) {
        return realm.where(LordeStatistic.class).equalTo("date", date).findFirst();
    }
}
