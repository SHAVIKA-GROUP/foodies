package com.shavika.foodies.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {

    private final static String PHONE_NUMBER = "\\d{10}";
    private final static String PIN = "\\d{4}";
    private final static String PINCODE = "\\d{6}";
    private final static String CUSTOMER_CODE = "^CUS\\d{3}";
    private final static String PASSWORD_PATTERN = "[a-zA-Z0-9_-]{4,8}$";

    private final static String TEXTING = "[\\sa-zA-Z0-9_,-]+";
    private final static String NUMARIC = "[0-9]+";
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String IPADDRESS_PATTERN =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    private final static String AMOUNT = "(0|([1-9]\\d{0,7}))?";

    public static boolean validateAmount(final String value) {
        Pattern pattern = null;
        Matcher matcher = null;
        pattern = Pattern.compile(AMOUNT);
        matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public static boolean validateEmailAddress(final String value) {
        Pattern pattern = null;
        Matcher matcher = null;
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public static boolean validateIPAddress(String data) {
        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches() ? true : false;
    }

    public static boolean validatePhoneNumber(String data) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches() ? true : false;
    }

    public static boolean validatePin(String data) {
        Pattern pattern = Pattern.compile(PIN);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches() ? true : false;
    }

    public static boolean validatePinCode(String data) {
        Pattern pattern = Pattern.compile(PINCODE);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches() ? true : false;
    }

    public static boolean validatePassword(String data) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches() ? true : false;
    }

    public static boolean validateText(String data) {
        Pattern pattern = Pattern.compile(TEXTING);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches() ? true : false;
    }

    public static boolean validateNumber(String data) {
        Pattern pattern = Pattern.compile(NUMARIC);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches() ? true : false;
    }

    public static boolean validateCustomerID(String data) {
        Pattern pattern = Pattern.compile(CUSTOMER_CODE);
        Matcher matcher = pattern.matcher(data);
        return matcher.matches() ? true : false;
    }

    public static boolean isNullString(String data) {
        if (data == null || data.length() == 0 || data.isEmpty())
            return true;
        return false;
    }
}
