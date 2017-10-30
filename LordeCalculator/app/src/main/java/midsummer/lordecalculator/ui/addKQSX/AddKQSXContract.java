package midsummer.lordecalculator.ui.addKQSX;

import java.util.List;

import midsummer.lordecalculator.model.KQSX.KQSX;

/**
 * Created by NIENLM on 10/26/17.
 */

public interface AddKQSXContract {
    interface View{
        void load(KQSX kqsx);
        void displayMessage(String message);
    }


    interface Presenter{
        void load();
        void addToDB(List<Integer> values);
        void stop();
    }
}
