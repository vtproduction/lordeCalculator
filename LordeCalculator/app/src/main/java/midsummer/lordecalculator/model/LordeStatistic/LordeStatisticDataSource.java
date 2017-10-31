package midsummer.lordecalculator.model.LordeStatistic;

import io.realm.RealmList;
import midsummer.lordecalculator.model.LordeData.LordeData;

/**
 * Created by NIENLM on 10/24/17.
 */

public interface LordeStatisticDataSource {
    String addNew(String merChantId, long date, RealmList<LordeData> data);
    LordeStatistic get(long date);
}
