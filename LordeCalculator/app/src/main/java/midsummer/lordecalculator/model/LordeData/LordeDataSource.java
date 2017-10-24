package midsummer.lordecalculator.model.LordeData;

import io.realm.RealmList;

/**
 * Created by NIENLM on 10/24/17.
 */

public interface LordeDataSource {
    int TYPE_LO = 1;
    int TYPE_DE = 2;
    int TYPE_XIEN = 3;
    int TYPE_XIEN_QUAY = 4;

    String setLordeData(RealmList<Integer> numbers, int value, int type);

}
