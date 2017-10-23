package midsummer.lordecalculator.helper;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by NIENLM on 10/23/17.
 */

public class DateTimeFormatHelper {

    public static DateTime longToDateTime(long input){
        DateTime dateTime;
        DateTimeFormatter df = DateTimeFormat.forPattern("yyyyMMdd");
        try {
            dateTime = df.parseDateTime(input + "");
        }catch (Exception e){
            LogUtil.e(e);
            dateTime = DateTime.now();
        }
        return dateTime;
    }

    public static long DateTimeNowToLong(){
        return DateTimeToLong(DateTime.now());
    }

    public static long DateTimeToLong(DateTime dateTime){
        try {
            DateTimeFormatter dtfOut = DateTimeFormat.forPattern("yyyyMMdd");
            return Long.parseLong(dtfOut.print(dateTime));
        }catch (Exception e){
            LogUtil.e(e);
            return 0;
        }
    }
}
