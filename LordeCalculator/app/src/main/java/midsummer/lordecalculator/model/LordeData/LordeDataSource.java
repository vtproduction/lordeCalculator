package midsummer.lordecalculator.model.LordeData;

/**
 * Created by NIENLM on 10/24/17.
 */

public interface LordeDataSource {
    int TYPE_LO = 1;
    int TYPE_DE = 2;
    int TYPE_XIEN = 3;
    int TYPE_QUAY = 4;
    int TYPE_DAU = 5;
    int TYPE_DIT = 6;
    int TYPE_DAU_DIT = 7;
    int TYPE_BO = 8;


    long setLordeData(LordeData lordeData);


}
