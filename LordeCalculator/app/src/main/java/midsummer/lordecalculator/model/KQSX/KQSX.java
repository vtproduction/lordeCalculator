package midsummer.lordecalculator.model.KQSX;

import java.util.Arrays;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by NienLe on 12-Oct-17.
 */

public class KQSX extends RealmObject{
    @PrimaryKey
    public String date;

    public int[] results;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int[] getResults() {
        return results;
    }

    public void setResults(int[] results) {
        this.results = results;
    }


    public int getGiaiDacbiet(){
        return results[0];
    }

    public int getGiainhat(){
        return results[1];
    }

    public int[] getGiaiNhi(){
        return Arrays.copyOfRange(getResults(), 2,2);
    }
    public int[] getGiaiBa(){
        return Arrays.copyOfRange(getResults(), 4,6);
    }
    public int[] getGiaiBon(){
        return Arrays.copyOfRange(getResults(), 10,4);
    }
    public int[] getGiaiNam(){
        return Arrays.copyOfRange(getResults(), 14,6);
    }
    public int[] getGiaiSau(){
        return Arrays.copyOfRange(getResults(), 20,3);
    }
    public int[] getGiaiBay(){
        return Arrays.copyOfRange(getResults(), 23,4);
    }
}
