package com.basics.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

public final class DateUtil {

    /**
     * Constant used to pad unit numbers with zeros.
     */
    private static final String PADDINGS_ZERO = "00000000";
    
    /**
     * Constant used to specify the accepted unit number length.
     */
    private static final int DESIRED_LENGTH = 8;
    
    /**
     * Obtains a new date object from specified year, month, and
     * day of the month.
     * 
     * @param y - the value that is used to set year of this date
     * @param m - the value that is used to set month of this date.
     * @param d - the value that is used to set day of this date.
     * @return  a <code>Date</code> object corresponds to specified
     *          year, month, and day.
     */
    public static Date newDate(int y, int m, int d) {
        Calendar cal = Calendar.getInstance();
        cal.set(y, m - 1, d, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * Obtains a new date object from specified date string, which takes
     * standard format yyyy-MM-dd.
     * 
     * @param date  A string of date with format: yyyy-MM-dd
     * @return  a <code>Date</code> object if the format is right;
     */
    public static Date string2date(String date) {
        Date theDate = null;
        SimpleDateFormat sdf = null;
        try {
            if (date.indexOf("/") >= 0) {
                sdf = new SimpleDateFormat("MM/dd/yyyy");
            }else{
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            }
            theDate = sdf.parse(date);
        }catch(ParseException pe) {
            throw new NumberFormatException("Invalid date string: " + date + ". " +
                    pe.getMessage());
        }
        return  theDate;
    }

    /**
     * Converts a <code>Date</code> object into yyyy-MM-dd format date string.
     * 
     * @param d     A date object.
     * @return  a <code>String</code> of date in yyyy-MM-dd format.
     */
    public static String date2string(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);
    }
	
	
	/**
     * Returns the number that represents the year of this date object.
     * 
     * @param d     A date object.
     * @return  an <code>int</code> represents the year of this date.
     */
    public static int getYear(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return cal.get(Calendar.YEAR);
    }

    /**
     * Returns the number that represents the year of this date object.
     * 
     * @param date  A string of date in yyyy-MM-dd format.
     * @return  an <code>int</code> represents the year of this date.
     */
    public static int getYearOf(String date) {
        return getYear(string2date(date));
    }

    /**
     * Returns the number that represents the month of this date object.
     * 
     * @param d     A date object.
     * @return  An <code>int</code> represents the month of this date.
     */
    public static int getMonth(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * Returns the number that represents the month of this date object.
     * 
     * @param date  A string of date in yyyy-MM-dd format.
     * @return  An <code>int</code> represents the month of this date.
     */
    public static int getMonthOf(String date) {
        return getMonth(string2date(date));
    }

    /**
     * Returns the day of month represented by pass-in date object.
     * 
     * @param d     A date object.
     * @return  an <code>int</code> represents the day of the month of this
     *          date object.
     */
    public static int getDay(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return cal.get(Calendar.DATE);
    }

    /**
     * Returns the day of month represented by pass-in date string.
     * 
     * @param date  A string of date in yyyy-MM-dd
     * @return  An <code>int</code> represents the day of the month of
     *          this date object.
     */
    public static int getDayOf(String date) {
        return getDay(string2date(date));
    }

    /**
     * Returns a string indicates the day of the week of a given date object.
     * 
     * @param d     A date object.
     * @return  the <code>String</code> of weekday such as Sunday, Monday, Tuesday,
     *          Wednesday, Thursday, Friday, and Saturday.
     */
    public static String getWeekday(Date d) {
        String weekday = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        int wd = cal.get(Calendar.DAY_OF_WEEK);
        if (wd == Calendar.SUNDAY) {
            weekday = "Sunday";
        }else if (wd == Calendar.MONDAY) {
            weekday = "Monday";
        }else if (wd == Calendar.TUESDAY) {
            weekday = "Tuesday";
        }else if (wd == Calendar.WEDNESDAY) {
            weekday = "Wednesday";
        }else if (wd == Calendar.THURSDAY) {
            weekday = "Thursday";
        }else if (wd == Calendar.FRIDAY) {
            weekday = "Friday";
        }else if (wd == Calendar.SATURDAY) {
            weekday = "Saturday";
        }else{
            throw new NumberFormatException("Unknown weekday format. Code: " + wd + " and Date is: " + d.toString());
        }
        return weekday;
    }

    /**
     * Returns a string indicates the day of the week of a given date string.
     * 
     * @param date  A date string in yyyy-MM-dd format.
     * @return  the <code>String</code> of weekday, such as Sunday, Monday, Tuesday,
     *          Wednesday, Thursday, Friday, and Saturday.
     */
    public static String getWeekdayOf(String date) {
        return getWeekday(string2date(date));
    }

    /**
     * Returns a date object as result of forward a given date object to certain years.
     * Note if the number of years is negative, it is backward operation.
     * 
     * @param d     A date object as starting date.
     * @param years Number of years that will be forward to.
     * @return  a date after being forwarded.
     */
    public static Date forwardYears(Date d, int years) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.YEAR, years);
        return cal.getTime();
    }

    /**
     * Returns a date object as result of forward a given date object to certain number
     * of months. Note if the number of months is negative, it is backward.
     * 
     * @param d     A date object as starting date.
     * @param months    Number of months that will be forward to.
     * @return  A date after being forwarded.
     */
    public static Date forwardMonths(Date d, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

    /**
     * Returns a date object as result of forward a given date object to certain number
     * of days. Note if the number of days is negative, it is backward operation.
     * 
     * @param d     A date object as starting date.
     * @param days  Number of days that will be forward to.
     * @return  A date after being forwarded.
     */
    public static Date forwardDays(Date d, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    /**
     * Returns a date object as result of roll a given date to certain years. It
     * normally won't affect other part of date field. However, if there is conflict,
     * the other field may change.
     * 
     * @param d     A date object as starting date.
     * @param years Number of years that will be added or substracted (positive/negative).
     * @return  The date after rolling.
     */
    public static Date rollYears(Date d, int years) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.roll(Calendar.YEAR, years);
        return cal.getTime();
    }

    /**
     * Returns a date object as result of roll a given date to certain months. It
     * normally won't affect other part of date field. However, if there is conflict,
     * the other field may change.
     * 
     * @param d     A date object as starting date.
     * @param months    Number of months that will be added or substracted (positive/negative).
     * @return  The date after rolling.
     */
    public static Date rollMonths(Date d, int months) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.roll(Calendar.MONTH, months);
        return cal.getTime();
    }

    /**
     * Returns a date object as result of roll a given date to certain days. It
     * normally won't affect other part of date field. However, if there is conflict,
     * the other field may change.
     * 
     * @param d     A date object as starting date.
     * @param days  Number of days that will be added or substracted (positive/negative).
     * @return  The date after rolling.
     */
    public static Date rollDays(Date d, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.roll(Calendar.DATE, days);
        return cal.getTime();
    }

    /**
     * Tests whether a given date is Sunday.
     * @param d     A date object.
     * @return  <code>true</code> if this date is Sunday. <code>false </code> otherwise.
     */
    public static boolean isSunday(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
    }

    /**
     * Tests whether a given date is Monday.
     * 
     * @param d     A date object.
     * @return  <code>true</code> if this date is Monday; <code>false</code> otherwise.
     */
    public static boolean isMonday(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY);
    }

    /**
     * Tests whether a given date is Tuesday.
     * 
     * @param d     A date object.
     * @return  <code>true</code> if this date is Tuesday; <code>false</code> otherwise.
     */
    public static boolean isTuesday(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return (cal.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY);
    }

    /**
     * Tests whether a given date is Wednesday.
     * 
     * @param d     A date object.
     * @return  <code>true</code> if this date is Wednesday; <code>false</code> otherwise.
     */
    public static boolean isWednesday(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return (cal.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY);
    }

    /**
     * Tests whether a given date is Thursday.
     * 
     * @param d     A date object.
     * @return  <code>true</code> if this date is Thursday; <code>false</code> otherwise.
     */
    public static boolean isThursday(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return (cal.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY);
    }

    /**
     * Tests whether a given date is Friday.
     * 
     * @param d     A date object.
     * @return  <code>true</code> if this date is Friday; <code>false</code> otherwise.
     */
    public static boolean isFriday(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY);
    }

    /**
     * Tests whether a given date is Saturday.
     * 
     * @param d     A date object.
     * @return  <code>true</code> if this date is Saturday; <code>false</code> otherwise.
     */
    public static boolean isSaturday(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY);
    }

    /**
     * Returns an immediately working day. If a given day is a working day, that is
     * Monday to Friday, it returns this day itself; otherwise, it returns following
     * Monday.
     * 
     * @param d     A date object.
     * @return  A date that is nearlyest working day.
     */
    public static Date getWorkingDay(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            cal.add(Calendar.DATE, 2);
        }else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            cal.add(Calendar.DATE, 1);
        }
        return cal.getTime();
    }

    /**
     * Computing the difference of month(s) between two dates. It will returns the
     * largest value before d1 can catch d2. For example, if d1 is 3/20/2001 and
     * d2 is 9/05/2001, the return value is 5 months.
     * 
     * @param d1    First date.
     * @param d2    Second date.
     * @return  Maximum number of months that can make d1 close to d2 but not later than d2.
     */
    public static int monthsDifferenceFloor(Date d1, Date d2) {
        int diff = 0;
        int seed = 0;
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(d1);
        cal2.setTime(d2);
        if (d1.before(d2)) {
            seed = 1;
            cal1.add(Calendar.MONTH, seed);
            while (cal1.before(cal2)) {
                diff += seed;
                cal1.add(Calendar.MONTH, seed);
            }
        }else{
            seed = -1;
            cal1.add(Calendar.MONTH, seed);
            while (cal1.after(cal2)) {
                diff += seed;
                cal1.add(Calendar.MONTH, seed);
            }
        }
        return diff;
    }

    /**
     * Computing the difference of month(s) between two dates. It will returns the
     * smallest value that d1 can catch d2. For example, if d1 is 3/20/2001 and
     * d2 is 9/05/2001, the return value is 6 months.
     * 
     * @param d1    The first date
     * @param d2    The second date
     * @return  Minimum number of months that can make d1 exceed d2.
     */
    public static int monthsDifferenceCeil(Date d1, Date d2) {
        int diff = 0;
        int seed = 0;
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(d1);
        cal2.setTime(d2);
        if (d1.before(d2)) {
            seed = 1;
            while (cal1.before(cal2)) {
                diff += seed;
                cal1.add(Calendar.MONTH, seed);
            }
        }else{
            seed = -1;
            while (cal1.after(cal2)) {
                diff += seed;
                cal1.add(Calendar.MONTH, seed);
            }
        }
        return diff;
    }

    /**
     * Computing the difference of day(s) between two dates.
     * 
     * @param d1    First date.
     * @param d2    Second date.
     * @return  Number of days that can make d1 close to d2 but not later than d2.
     */
    public static int daysDifference(Date d1, Date d2) {
        int diff = 0;
        int seed = 1;
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(d1);
        cal2.setTime(d2);
        if (d1.before(d2)) {
            while (cal1.before(cal2)) {
                diff += seed;
                cal1.add(Calendar.DATE, seed);
            }
        }else{
            seed = -1;
            while (cal1.after(cal2)) {
                diff += seed;
                cal1.add(Calendar.DATE, seed);
            }
        }
        return diff;
    }

    /**
     * Tests whether a first date is earlier than the second date.
     * 
     * @param d1    A first given date.
     * @param d2    A second given date.
     * @return  <code>true</code> if the first date is earlier than the second date;
     *          <code>false</code> otherwise.
     */
    public static boolean isEarlierThan(Date d1, Date d2) {
        boolean is = false;
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(d1);
        cal2.setTime(d2);
        if (cal1.get(Calendar.YEAR) < cal2.get(Calendar.YEAR)) {
            is = true;
        }else if (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)) {
            if (cal1.get(Calendar.MONTH) < cal2.get(Calendar.MONTH)) {
                is = true;
            }else if (cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)) {
                if (cal1.get(Calendar.DATE) < cal2.get(Calendar.DATE)) {
                    is = true;
                }
            }
        }
        return is;
    }

    /**
     * Tests whether a first date is later than the second date.
     * 
     * @param d1    A first given date.
     * @param d2    A second given date.
     * @return  <code>true</code> if the first date is later than the second date;
     *          <code>false</code> otherwise.
     */
    public static boolean isLaterThan(Date d1, Date d2) {
        boolean is = false;
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(d1);
        cal2.setTime(d2);
        if (cal1.get(Calendar.YEAR) > cal2.get(Calendar.YEAR)) {
            is = true;
        }else if (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)) {
            if (cal1.get(Calendar.MONTH) > cal2.get(Calendar.MONTH)) {
                is = true;
            }else if (cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)) {
                if (cal1.get(Calendar.DATE) > cal2.get(Calendar.DATE)) {
                    is = true;
                }
            }
        }
        return is;
    }

    /**
     * Tests whether two dates are at the same day.
     * 
     * @param d1    A first given date
     * @param d2    A second given date
     * @return  <code>true</code> if the first date is at the same day that the second
     *          date is; <code>false</code> otherwise.
     */
    public static boolean isSameDate(Date d1, Date d2) {
        boolean is = false;
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(d1);
        cal2.setTime(d2);
        if ((cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)) &&
                (cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)) &&
                (cal1.get(Calendar.DATE) == cal2.get(Calendar.DATE))) {
            is = true;
        }
        return is;
    }

    /**
     * Tests whether the first date is not earlier than the second date.
     * 
     * @param d1    A first given date.
     * @param d2    A second given date
     * @return  <code>true</code> if the first date is not earlier than the second date.
     */
    public static boolean notEarlierThan(Date d1, Date d2) {
        boolean is = false;
        if (isLaterThan(d1, d2) || isSameDate(d1, d2)) {
            is = true;
        }
        return is;
    }

    /**
     * Tests whether the first date is not later than the second date.
     * 
     * @param d1    A first given date
     * @param d2    A second given date
     * @return  <code>true</code> if the first date is not later than the second date.
     */
    public static boolean notLaterThan(Date d1, Date d2) {
        boolean is = false;
        if (isEarlierThan(d1, d2) || isSameDate(d1, d2)) {
            is = true;
        }
        return is;
    }
	
}
