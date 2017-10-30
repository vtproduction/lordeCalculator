package midsummer.lordecalculator.helper;

import java.text.DecimalFormat;

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
            case LordeDataSource.TYPE_XIEN_QUAY:
                return "xiên quay";
            default:
                return "khác";
        }
    }
}
