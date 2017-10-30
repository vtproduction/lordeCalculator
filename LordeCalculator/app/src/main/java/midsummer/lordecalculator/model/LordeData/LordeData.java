package midsummer.lordecalculator.model.LordeData;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by NIENLM on 10/24/17.
 */

public class LordeData extends RealmObject {

    @PrimaryKey
    public long id;

    public int type;
    public RealmList<Integer> numbers;
    public int value;
    public long merChantId;

    public long getMerChantId() {
        return merChantId;
    }

    public void setMerChantId(long merChantId) {
        this.merChantId = merChantId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public RealmList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(RealmList<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
