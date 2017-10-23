package midsummer.lordecalculator.model.KQSX;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by NienLe on 12-Oct-17.
 */

public class KQSX extends RealmObject{
    @PrimaryKey
    public long date;


    public RealmList<Integer> results;
    

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public RealmList<Integer> getResults() {
        return results;
    }

    public void setResults(RealmList<Integer> results) {
        this.results = results;
    }


    public Integer getGiaiDacbiet(){
        return getResults().get(0);
    }

    public Integer getGiainhat(){
        return getResults().get(1);
    }

    public List<Integer> getGiaiNhi(){
        return getResults().subList(2,2);
    }
    public List<Integer> getGiaiBa(){
        return getResults().subList(4,6);
    }
    public List<Integer> getGiaiBon(){
        return getResults().subList(10,4);
    }
    public List<Integer> getGiaiNam(){
        return getResults().subList(14,6);
    }
    public List<Integer> getGiaiSau(){
        return getResults().subList(20,3);
    }
    public List<Integer> getGiaiBay(){
        return getResults().subList(23,4);
    }

    public KQSX(long date, List<Integer> results) {

        this.date = date;
        RealmList<Integer> tmp = new RealmList<>();
        tmp.addAll(results);
        this.results = tmp;
    }
}
