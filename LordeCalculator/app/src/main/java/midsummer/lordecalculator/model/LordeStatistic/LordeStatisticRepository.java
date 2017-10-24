package midsummer.lordecalculator.model.LordeStatistic;

import io.realm.Realm;
import io.realm.RealmList;
import midsummer.lordecalculator.model.LordeData.LordeData;
import midsummer.lordecalculator.model.Merchant.MerchantDataSource;
import midsummer.lordecalculator.model.Merchant.MerchantRepository;

/**
 * Created by NIENLM on 10/24/17.
 */

public class LordeStatisticRepository implements LordeStatisticDataSource {
    private Realm realm;
    private MerchantDataSource mMerchant;
    public LordeStatisticRepository(Realm realm) {
        this.realm = realm;
        this.mMerchant = new MerchantRepository(realm);
    }

    @Override
    public String addNew(int merChantId, long date, RealmList<LordeData> data) {
        return null;
    }

    @Override
    public LordeStatistic get(long date) {
        return null;
    }
}
