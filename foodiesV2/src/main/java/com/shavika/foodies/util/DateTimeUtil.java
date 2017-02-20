package com.shavika.foodies.util;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class DateTimeUtil {

    // Letter Description Examples
    // ---------------------------------------
    // y------Year------2013
    // M------Month in year------July, 07, 7
    // d------Day in month------1-31
    // E------Day name in week------Friday, Sunday
    // a------Am/pm marker------AM, PM
    // H------Hour in day------0-23
    // h------Hour in am/pm------1-12
    // m------Minute in hour------0-60
    // s------Second in minute------0-60

    public static final String DATEFORMAT_DD_SL_MM_SL_YYYY_SP_HH_CO_MM_CO_SS_SP_APPM = "dd/MM/yyyy hh:mm:ss a";

    /**
     * @param
     * @return
     * @method getMilliSecond
     */
    public static long getMilliSecond(String txtDate, String txtTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy H:mm");
        long returnMilliSecond = -1;
        try {
            Date date = formatter.parse(new StringBuilder().append(txtDate).append(" ").append(txtTime).toString());
            returnMilliSecond = date.getTime();
        } catch (Exception e) {
            return -1;
        }
        return returnMilliSecond;
    }

    /**
     * @param timeStamp
     * @return
     * @method getTxtDate
     */
    public static String getTxtDate(String timeStamp) {
        SimpleDateFormat fromFormat = new SimpleDateFormat("M/d/yyyy");
        SimpleDateFormat toFormat = new SimpleDateFormat("MMM dd yyyy");
        String returnDate = null;
        try {
            Date date = fromFormat.parse(timeStamp);
            returnDate = toFormat.format(date);
        } catch (Exception e) {
            return null;
        }
        return returnDate;
    }

    /**
     * @param timeStamp
     * @return
     * @method getTxtTime
     */
    public static String getTxtTime(String timeStamp) {
        SimpleDateFormat fromFormat = new SimpleDateFormat("H:mm");
        SimpleDateFormat toFormat = new SimpleDateFormat("hh:mm a");
        String returnDate = null;
        try {
            Date date = fromFormat.parse(timeStamp);
            returnDate = toFormat.format(date);
        } catch (Exception e) {
            return null;
        }
        return returnDate;
    }

    /**
     * @param millisec
     * @return
     * @method getDateFromMilliSecond
     */
    public static Date getDateTimeFromMilliSecond(long millisec) {
        Date date = null;
        try {
            date = new Date(millisec);
        } catch (Exception e) {
            return null;
        }
        return date;
    }

    /**
     * @param date
     * @param format
     * @return
     */
    public static String getFormatedTimeStamp(Date date, String format) {
        SimpleDateFormat Format = new SimpleDateFormat(format);
        try {
            return Format.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @return
     */
    public static long getCurrentTimeStamp() {
        try {
            return new Date().getTime();
        } catch (Exception e) {
            return -1;
        }
    }

    public static String getJodaMilliSecond(String txtDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String returnMilliSecond = "-1";
        try {
            if (txtDate.contains("T")) {
                txtDate = txtDate.substring(0, txtDate.indexOf("T"));
            }
            Date date = formatter.parse(txtDate);
            long returnMSecond = date.getTime();
            returnMilliSecond = String.valueOf(returnMSecond);
        } catch (Exception e) {
            return "-1";
        }
        return returnMilliSecond;
    }

    public static String dateWithFormat(long mills, String format) {
        DateFormat formatter = new SimpleDateFormat(format);
        String strDate = null;
        Date date = new Date(mills);
        strDate = formatter.format(date);
        return strDate;
    }

    public static String dateWithFormat() {
        long mills = getMillis();
        DateFormat formatter = new SimpleDateFormat(DATEFORMAT_DD_SL_MM_SL_YYYY_SP_HH_CO_MM_CO_SS_SP_APPM);
        String strDate = null;
        Date date = new Date(mills);
        strDate = formatter.format(date);
        return strDate;
    }

    public static String dateWithDefaultFormat(long mills) {
        DateFormat formatter = new SimpleDateFormat(DATEFORMAT_DD_SL_MM_SL_YYYY_SP_HH_CO_MM_CO_SS_SP_APPM);
        String strDate = null;
        Date date = new Date(mills);
        strDate = formatter.format(date);
        return strDate;
    }

    public static long getMillis() {
        return new DateTime().getMillis();
    }

    public static String getCurrentWeekday(){
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        return new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
    }

    public static String getCurrentTime(){
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        return new SimpleDateFormat("HH", Locale.ENGLISH).format(date.getTime());
    }

    public static void main(String[] args) {
        //System.out.println(getMilliSecond("6/2/2014", "16:28"));
        //System.out.println(getTxtDate("6/2/2014"));
        //System.out.println(getTxtTime("16:28"));
        //System.out.println(getDateTimeFromMilliSecond(getMilliSecond("6/2/2014", "16:28")));
        //System.out.println(getFormatedTimeStamp(getDateTimeFromMilliSecond(getCurrentTimeStamp()), "hh:mm a, dd MMM yyyy"));
        //System.out.println(getCurrentTimeStamp());
        //System.out.println(getJodaMilliSecond("2016-05-03T05:30:00+05:30"));

        long mils = getMillis();
        System.out.println("mils==>" + mils);
        String date = dateWithFormat(mils, DATEFORMAT_DD_SL_MM_SL_YYYY_SP_HH_CO_MM_CO_SS_SP_APPM);
        System.out.println("date==>" + date);

    }
}
// /************************************/
// * --------- OutPut -----------------
// * 1401706680000
// * Jun 02 2014
// * 04:28 PM
// * Mon Jun 02 16:28:00 IST 2014
// * 12:11 AM, 03 Jul 2014
// * 1404326512068
// /*************************************/
