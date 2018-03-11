/*
 * @(#)TimeZones.java     [v.4.0] 2007/04/09
 *
 * Copyright (c) 2000-2001 Reqwired, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Reqwired, Inc. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance
 * with the term of the license agreement you entered into with
 * Reqwired, Inc.
 *
 * History
 *   09-APR-2007 Zhongjian Chen
 *             - Created
 */
package com.basics.practice;

import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * This class defines all time-zones that are supported by the Reqwired system.
 *  
 * @version 4.0
 * @since   Reqwired 4.0
 */
public final class TimeZones {
	
    /**
     * An array of constants of names of the time zones that Reqwired system is supporting.
     */
	/* Defect#246934 - Anil
	 * Commented daylight savings as per the call we had with webinar team regarding time zone defect.
	 * Returning Standard time always even if it is Daylight savings.
	 * Eg: Returning
	 * 1. CST for CST or CDT,
	 * 2. EDT for EST or EDT.
	 * */
    public static final String[] TIMEZONE_NAMES = {
        "(GMT-12:00) International Date Line West",
        "(GMT-11:00) Midway Island, Samoa",
        "(GMT-10:00) Hawaii",
        "(GMT-09:00) Alaska",
        "(GMT-08:00) Alaska Daylight Saving",
        "(GMT-08:00) Pacific Time (US/Canada)",
        "(GMT-07:00) Pacific Daylight Saving",
        "(GMT-08:00) Tijuana; Baja California",
        "(GMT-07:00) Arizona",
        "(GMT-07:00) Mountain Time (US/Canada)",
        "(GMT-06:00) Mountain Daylight Saving",
        "(GMT-06:00) Central America",
        "(GMT-06:00) Central Time (US/Canada)",
        "(GMT-05:00) Central Daylight Saving",
        "(GMT-06:00) Mexico City",
        "(GMT-06:00) Saskatchewan",
        "(GMT-05:00) Bogota, Lima, Quito, Rio Rranco",
        "(GMT-05:00) Eastern Time (US/Canada)",
        "(GMT-04:00) Eastern Daylight Saving",
        "(GMT-05:00) Indiana (East) - Discontinued",
        "(GMT-04:00) Atlantic Time (Canada)",
        "(GMT-03:00) Atlantic Daylight Saving (Can.)",
        "(GMT-04:00) Caracas, La Paz",
        "(GMT-04:00) Santiago",
        "(GMT-03:30) Newfoundland",
        "(GMT-03:00) Brasilia",
        "(GMT-03:00) Buenos Aires, Georgetown",
        "(GMT-03:00) Greenland",
        "(GMT-02:00) Mid-Atlantic",
        "(GMT-01:00) Azores",
        "(GMT-01:00) Cape Verde Is",
        "(GMT) Casablanca, Monrovia",
        "(GMT) Dublin, Edinburgh, Lisbon, London",
        "(GMT+01:00) Central European Time",
        "(GMT+01:00) Amsterdam, Berlin, Bern, Rome",
        "(GMT+01:00) Stockholm, Vienna",
        "(GMT+01:00) Belgrade, Bratislava, Budapest",
        "(GMT+01:00) Ljubljana, Prague",
        "(GMT+01:00) Brussels, Copenhagen",
        "(GMT+01:00) Madrid, Paris",
        "(GMT+01:00) Sarajevo, Skopje, Warsaw, Zagreb",
        "(GMT+01:00) West Central Africa",
        "(GMT+02:00) Athens, Istanbul, Minsk",
        "(GMT+02:00) Bucharest",
        "(GMT+02:00) South Africa Standard Time, Cairo, Finland",
        "(GMT+02:00) Harare, Pretoria",
        "(GMT+02:00) Helsinki, Riga, Tallinn",
        "(GMT+03:00) Jerusalem",
        "(GMT+03:00) Baghdad",
        "(GMT+03:00) Kuwait, Iraq, Russia, Saudi Arabia",
        "(GMT+03:00) Moscow, St. Petersburg, Volgograd",
        "(GMT+03:00) Nairobi",
        "(GMT+03:30) Tehran",
        "(GMT+04:00) Abu Dhabi, Muscat",
        "(GMT+04:00) Baku, Tbilisi, Yerevan",
        "(GMT+04:30) Kabul",
        "(GMT+05:00) Ekaterinburg",
        "(GMT+05:00) Islamabad, Karachi, Tashkent",
        "(GMT+05:30) Calcutta, Mumbai, New Delhi",
        "(GMT+05:30) Sri Jayawardenepura",
        "(GMT+05:45) Kathmandu",
        "(GMT+06:00) Almaty, Novosibirsk",
        "(GMT+06:00) Astana, Dhaka",
        "(GMT+06:30) Rangoon",
        "(GMT+07:00) Bangkok, Hanoi, Jakarta",
        "(GMT+08:00) Krasnoyarsk",
        "(GMT+08:00) Beijing, Chongqing, Hong Kong, Taipei, Singapore",
        "(GMT+08:00) Kuala Lumpur, Singaproe",
        "(GMT+08:00) Perth",
        "(GMT+08:00) Taipei",
        "(GMT+09:00) Osaka, Sapporo, Tokyo, Seoul",
        "(GMT+09:00) Yakutsk",
        "(GMT+09:30) Adelaide",
        "(GMT+09:30) Darwin",
        "(GMT+10:00) Brisbane",
        "(GMT+10:00) Canberra, Melbourne, Sydney",
        "(GMT+10:00) Guam, Port Moresby",
        "(GMT+10:00) Hobart",
        "(GMT+10:00) Vladivostok",
        "(GMT+11:00) Magadan, Solomon Is., New Caledonia",
        "(GMT+12:00) Auckland, Wellington",
        "(GMT+12:00) Fiji, Kamchatka, Marshall Is",
        "(GMT+13:00) Nuku alofa"
    };


    /**
     * An array of constants of keys of the time zones that Reqwired system is supporting.
     * It matches <code>TIMEZONE_NAMES</code> array.
     */
    public static final String[] TIMEZONE_KEYS = {
        "UTCTW",
        "Midway",
        "HST",
        "AKST",
        "AKDT",
        "PST",
        "PDT",
        "UTCEI",
        "Arizona",
        "MST",
        "MDT",
        "CAT",
        "CST",
        "CDT",
        "MexicoCity",
        "SAS",
        "Lima",
        "EST",
        "EDT",
        "Indiana",
        "AST",
        "ADT",
        "LaPaz",
        "SanTigO",
        "NewfO",
        "Brasil",
        "BuenosAires",
        "GreenLand",
        "MidAtlantic",
        "Azores",
        "Cape",
        "Casa",
        "GMT",
        "CET",
        "AMS",
        "Stockholm",
        "Belgrade",
        "Prague",
        "Brussels",
        "Paris",
        "Warsaw",
        "CAfrica",
        "Athens",
        "Buch",
        "SAST",
        "Harare",
        "Riga",
        "Jeru",
        "Baghdad",
        "Russia",
        "Moscow",
        "Nairobi",
        "Iran",
        "AbuDhabi",
        "Baku",
        "Kabul",
        "Ekater",
        "Karachi",
        "Mumbai",
        "Sri",
        "Kathm",
        "Almaty",
        "Astana",
        "Rangoon",
        "Bangkok",
        "Krasno",
        "Beijing",
        "Kuala",
        "Perth",
        "Taipei",
        "JST",
        "Yakutsk",
        "Adelaide",
        "Darwin",
        "Bris",
        "Sydney",
        "Guam",
        "Hobart",
        "Vladi",
        "Magadan",
        "Auckland",
        "Fiji",
        "Nuku"
    };

    /**
     * Retrieves a time zone that matches to a specified key.  If the key is invalid
     * or non-exist, it returns <code>null</code> instead.
     * 
     * @param key   The key for searching
     * @return  The time zone that matches specified key.
     */
    public static final SimpleTimeZone getTimeZone(String key) {
    	
        SimpleTimeZone zone = null;
        if (key != null && "UTCTW".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-43200000,
                    "UTCTW");
        } else if (key != null && "Midway".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-39600000,
                    "Midway");
        } else if (key != null && "HST".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-36000000,
                    "HST");
        } else if (key != null && ("AKST".equalsIgnoreCase(key.trim()) )) {
            zone = new SimpleTimeZone(-32400000,
                    "AKST");
        } else if (key != null && "AKDT".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-28800000,
                    "AKDT");
        } else if (key != null && ("PST".equalsIgnoreCase(key.trim()) )) {
            zone = new SimpleTimeZone(-28800000,
                    "PST");
        } else if (key != null && "PDT".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-25200000,
                    "PDT");
        } else if (key != null && "UTCEI".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-28800000,
                    "UTCEI");
        } else if (key != null && "Arizona".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-25200000,
                    "Arizona");
        } else if (key != null && ("MST".equalsIgnoreCase(key.trim()) ) ){
            zone = new SimpleTimeZone(-25200000,
                    "MST");
        } else if (key != null && "MDT".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-21600000,
                    "MDT");
        } else if (key != null && "CAT".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-21600000,
                    "CAT");
        } else if (key != null && ("CST".equalsIgnoreCase(key.trim()) ) ){
            zone = new SimpleTimeZone(-21600000,
                    "CST");
        } else if (key != null && "CDT".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-18000000,
                    "CDT");
        } else if (key != null && "MexicoCity".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-21600000,
                    "MexicoCity");
        } else if (key != null && "SAS".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-21600000,
                    "SAS");
        } else if (key != null && "Lima".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-18000000,
                    "Lima");
        } else if (key != null && ("EST".equalsIgnoreCase(key.trim()) ) ){
            zone = new SimpleTimeZone(-18000000,
                    "EST");
        } else if (key != null && "EDT".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-14400000,
                    "EDT");
        } else if (key != null && "Indiana".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-18000000,
                    "Indiana");
        } else if (key != null && ("AST".equalsIgnoreCase(key.trim()) )) {
             zone = new SimpleTimeZone(-14400000,
                     "AST");
        } else if (key != null && "ADT".equalsIgnoreCase(key.trim())) {
             zone = new SimpleTimeZone(-10800000,
                     "ADT");
        } else if (key != null && "LaPaz".equalsIgnoreCase(key.trim())) {
             zone = new SimpleTimeZone(-14400000,
                     "LaPaz");
        } else if (key != null && "SanTigO".equalsIgnoreCase(key.trim())) {
             zone = new SimpleTimeZone(-14400000,
                     "SanTigO");
        } else if (key != null && "NewfO".equalsIgnoreCase(key.trim())) {
             zone = new SimpleTimeZone(-12600000,
                     "NewfO");
        } else if (key != null && "Brasil".equalsIgnoreCase(key.trim())) {
             zone = new SimpleTimeZone(-10800000,
                     "Brasil");
        } else if (key != null && "BuenosAires".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-10800000,
                    "BuenosAires");
        } else if (key != null && "GreenLand".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-10800000,
                    "GreenLand");
        } else if (key != null && "MidAtlantic".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-7200000,
                    "MidAtlantic");
        } else if (key != null && "Azores".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-3600000,
                    "Azores");
        } else if (key != null && "Cape".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(-3600000,
                    "Cape");
        } else if (key != null && "Casa".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(0,
                    "Casa");
        } else if (key != null && "GMT".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(0,
                    "GMT");
        } else if (key != null && "CET".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(3600000,
                    "CET");
        } else if (key != null && "AMS".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(3600000,
                    "AMS");
        } else if (key != null && "Stockholm".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(3600000,
                    "Stockholm");
        } else if (key != null && "Belgrade".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(3600000,
                    "Belgrade");
        } else if (key != null && "Prague".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(3600000,
                    "Prague");
        } else if (key != null && "Brussels".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(3600000,
                    "Brussels");
        } else if (key != null && "Paris".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(3600000,
                    "Paris");
        } else if (key != null && "Warsaw".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(3600000,
                    "Warsaw");
        } else if (key != null && "CAfrica".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(3600000,
                    "CAfrica");
        } else if (key != null && "Athens".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(7200000,
                    "Athens");
        } else if (key != null && "Buch".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(7200000,
                    "Buch");
        } else if (key != null && "SAST".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(7200000,
                    "SAST");
        } else if (key != null && "Harare".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(7200000,
                    "Harare");
        } else if (key != null && "Riga".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(7200000,
                    "Riga");
        } else if (key != null && "Jeru".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(10800000,
                    "Jeru");
        } else if (key != null && "Baghdad".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(10800000,
                    "Baghdad");
        } else if (key != null && "Russia".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(10800000,
                    "Russia");
        } else if (key != null && "Moscow".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(10800000,
                    "Moscow");
        } else if (key != null && "Nairobi".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(10800000,
                    "Nairobi");
        } else if (key != null && "Iran".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(12600000,
                    "Iran");
        } else if (key != null && "AbuDhabi".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(14400000,
                    "AbuDhabi");
        } else if (key != null && "Baku".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(14400000,
                    "Baku");
        } else if (key != null && "Kabul".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(16200000,
                    "Kabul");
        } else if (key != null && "Ekater".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(18000000,
                    "Ekater");
        } else if (key != null && "Karachi".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(18000000,
                    "Karachi");
        } else if (key != null && "Mumbai".equalsIgnoreCase(key.trim())) {        	
            zone = new SimpleTimeZone(19800000,
                    "Mumbai");
        } else if (key != null && "Sri".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(19800000,
                    "Sri");
        } else if (key != null && "Kathm".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(20700000,
                    "Kathm");
        } else if (key != null && "Almaty".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(21600000,
                   "Almaty");
        } else if (key != null && "Astana".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(21600000,
                   "Astana");
        } else if (key != null && "Rangoon".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(23400000,
                   "Rangoon");
        } else if (key != null && "Bangkok".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(25200000,
                   "Bangkok");
        } else if (key != null && "Krasno".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(25200000,
                   "Krasno");
        } else if (key != null && "Beijing".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(28800000,
                    "Beijing");
        } else if (key != null && "Kuala".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(28800000,
                    "Kuala");
        } else if (key != null && "Perth".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(28800000,
                    "Perth");
        } else if (key != null && "Taipei".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(28800000,
                    "Taipei");
        } else if (key != null && "JST".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(32400000,
                    "JST");
        } else if (key != null && "Yakutsk".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(32400000,
                    "Yakutsk");
        } else if (key != null && "Adelaide".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(34200000,
                    "Adelaide");
        } else if (key != null && "Darwin".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(34200000,
                    "Darwin");
        } else if (key != null && "Bris".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(36000000,
                    "Bris");
        } else if (key != null && "Sydney".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(36000000,
                    "Sydney");
        } else if (key != null && "Guam".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(36000000,
                    "Guam");
        } else if (key != null && "Hobart".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(36000000,
                    "Hobart");
        } else if (key != null && "Vladi".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(36000000,
                    "Vladi");
        } else if (key != null && "Magadan".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(39600000,
                    "Magadan");
        } else if (key != null && "Auckland".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(43200000,
                    "Auckland");
        } else if (key != null && "Fiji".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(43200000,
                    "Fiji");
        } else if (key != null && "Nuku".equalsIgnoreCase(key.trim())) {
            zone = new SimpleTimeZone(46800000,
                    "Nuku");
        } else {  // default use EST
            zone = new SimpleTimeZone(-18000000,
                    "EST");
        }
        return zone;
    }

    /**
     * Reverse searching the name of the time zone that associated with a specified key.
     * If the key is invalid, it returns <code>null</code> instead.
     *
     * @param key   The key for searching
     * @return  The name of the corresponding time zone.
     */
    public static final String getTimeZoneName(String key) {
        String name = null;
        if (key != null) {
            for (int ix = 0; ix < TIMEZONE_KEYS.length; ix++) {
                if (key.trim().equalsIgnoreCase(TIMEZONE_KEYS[ix])) {
                    name = TIMEZONE_NAMES[ix];
                    break;
                }
            }
        }
        return name;
    }
}