package midsummer.lordecalculator.model.LordeStatistic;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import midsummer.lordecalculator.model.LordeData.LordeData;

/**
 * Created by NIENLM on 10/24/17.
 */

public class LordeStatistic extends RealmObject{

    @PrimaryKey
    public String id;

    public int merChantId;
    public long date;
    public RealmList<LordeData> data;
    public long totalIncome;
    public long totalOutcome;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMerChantId() {
        return merChantId;
    }

    public void setMerChantId(int merChantId) {
        this.merChantId = merChantId;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public RealmList<LordeData> getData() {
        return data;
    }

    public void setData(RealmList<LordeData> data) {
        this.data = data;
    }

    public long getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(long totalIncome) {
        this.totalIncome = totalIncome;
    }

    public long getTotalOutcome() {
        return totalOutcome;
    }

    public void setTotalOutcome(long totalOutcome) {
        this.totalOutcome = totalOutcome;
    }
}
