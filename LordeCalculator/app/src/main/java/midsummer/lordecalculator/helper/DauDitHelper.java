package midsummer.lordecalculator.helper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by macbook on 10/31/17.
 */

public class DauDitHelper {

    public static List<Integer> getDau(int value){
        List<Integer> values = new ArrayList<>();
        if (value < 0 || value > 9) return values;
        int v0 = value * 10;
        int v1 = v0 + 10;
        for (int i = v0; i < v1; i++)
            values.add(i);
        return values;
    }

    public static List<Integer> getDit(int value){
        List<Integer> values = new ArrayList<>();
        if (value < 0 || value > 9) return values;
        for (int i = value; i < 100; i = i + 10)
            values.add(i);
        return values;
    }

}
