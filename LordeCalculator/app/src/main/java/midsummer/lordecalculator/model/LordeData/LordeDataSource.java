package midsummer.lordecalculator.model.LordeData;

/**
 * Created by NIENLM on 10/24/17.
 */

public interface LordeDataSource {
    int TYPE_LO = 1;
    int TYPE_DE = 2;
    int TYPE_XIEN = 3;

    long setLordeData(LordeData lordeData);

}
