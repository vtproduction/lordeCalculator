package midsummer.lordecalculator.helper;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import midsummer.lordecalculator.model.LordeData.LordeDataSource;

/**
 * Created by NIENLM on 10/25/17.
 */

public class StringUtil {


    public static String formatConcurrency(long input){
        try {
            DecimalFormat formater = new DecimalFormat("#.###");
            return formater.format(input);

        }catch (Exception e){
            LogUtil.e(e);
            return "0";
        }
    }

    public static String formatDateName(int dayOfWeek){
        switch (dayOfWeek){
            case 1:
                return "Thứ Hai";
            case 2:
                return "Thứ Ba";
            case 3:
                return "Thứ Tư";
            case 4:
                return "Thứ Năm";
            case 5:
                return "Thứ Sáu";
            case 6:
                return "Thứ Bảy";
            case 7:
                return "Chủ Nhật";
            default:
                return "";
        }
    }



    public static String getLordeDataType(int type){
        switch (type){
            case LordeDataSource.TYPE_DE:
                return "đề";
            case LordeDataSource.TYPE_LO:
                return "lô";
            case LordeDataSource.TYPE_XIEN:
                return "xiên";
            default:
                return "khác";
        }
    }


    public static List<Integer> StringToIntArray(String source, int type){
        source = source.trim().replaceAll("\\s+"," ");
        List<Integer> integers = new ArrayList<>();
        String[] tmp = source.split(" ");
        List<Integer> intTemp = new ArrayList<>();
        for (String stringTmp : tmp){
            try {
                int val = Integer.parseInt(stringTmp);
                if (0 <= val && val <= 99) intTemp.add(val);
                else if (val > 99){
                    LogUtil.d(stringTmp.substring(0,1) + " " + stringTmp.substring(1,2) + " " + stringTmp.substring(0,2));
                    int val1 = Integer.parseInt(stringTmp.substring(0,2));
                    int val2 = Integer.parseInt(stringTmp.substring(1,3));
                    intTemp.add(val1);
                    intTemp.add(val2);
                }
            }catch (Exception e){
                LogUtil.e(e);
            }
        }
        switch (type){
            case LordeDataSource.TYPE_LO:
            case LordeDataSource.TYPE_DE:
            case LordeDataSource.TYPE_XIEN:
            case LordeDataSource.TYPE_QUAY:
                return intTemp;
            case LordeDataSource.TYPE_DAU:
                return DauDitHelper.getDau(intTemp.get(0));
            case LordeDataSource.TYPE_DIT:
                return DauDitHelper.getDit(intTemp.get(0));
            case LordeDataSource.TYPE_DAU_DIT:
                integers.addAll(DauDitHelper.getDau(intTemp.get(0)));
                integers.addAll(DauDitHelper.getDit(intTemp.get(0)));
                return integers;


        }


        return integers;
    }
}
