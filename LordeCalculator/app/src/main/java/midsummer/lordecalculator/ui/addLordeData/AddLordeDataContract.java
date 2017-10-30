package midsummer.lordecalculator.ui.addLordeData;

import android.content.Context;
import android.content.Intent;

import com.jaychang.srv.SimpleRecyclerView;

import java.util.List;

import midsummer.lordecalculator.model.LordeData.LordeData;
import midsummer.lordecalculator.model.Merchant.Merchant;

/**
 * Created by NIENLM on 10/30/17.
 */

public interface AddLordeDataContract {
    int TYPE_LO = 1;
    int TYPE_DE = 2;
    int TYPE_XIEN = 3;
    int TYPE_QUAY = 4;
    int TYPE_DAU = 5;
    int TYPE_DIT = 6;
    int TYPE_DAU_DIT = 7;
    int TYPE_BO = 8;



    interface View{
        void addToList(LordeData lordeData);
        void removeFromList(LordeData lordeData);
        void initData(Merchant merchant);
        boolean validateValue();
        boolean validateNumbers();
        void displayMessage(String message);

    }


    interface Presenter{
        void start(Intent intent);
        void addNew(int type, List<Integer> numbers, int value);
        void submit(SimpleRecyclerView recyclerView);
        void stop();
    }
}
