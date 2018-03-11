package com.basics.practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.TimeZone;

/*
 * If we get ACCESS RESTRICTION error in ECLIPSE
 * Access restriction: The type QName is not accessible due to restriction on required library C:\Program Files\Java\jdk1.5.0_16\jre\lib\rt.jar
 * 
 * Solution 1:
 * On Windows: Windows -> Preferences -> Java -> Compiler -> Errors/Warnings -> Deprecated and restricted API -> 
 * Forbidden reference (access rules): -> change to warning
 * On Mac OS X/Linux: Eclipse -> Preferences -> Java -> Compiler -> Errors/Warnings -> Deprecated and restricted API -> 
 * Forbidden reference (access rules): -> change to warning
 * 
 * Solution 2: There's another solution that also works. 
 * Go to the Build Path settings in the project properties.
 * Remove the JRE System Library
 * Add it back; Select "Add Library" and select the JRE System Library. The default worked for me.
 * This works because you have multiple classes in different jar files. 
 * Removing and re-adding the JRE lib will make the right classes be first. 
 * If you want a fundamental solution make sure you exclude the jar files with the same classes.
 * 
 * 
 */

public final class UtilityProg {
	
	public static void printListValues(List<Student> studentList){
		Iterator<Student> iter = studentList.iterator();
		while(iter.hasNext()){
			Student s = (Student)iter.next();
			System.out.println(s.getStudentId());
			System.out.println(s.getStudentName());
			System.out.println(s.getStudentScore());
		}
	}
	
	public static void copyFileUsingFileStreams(File s,File d){
		InputStream is = null;
		OutputStream os = null;
		
		try {
			is = new FileInputStream(s);
			os = new FileOutputStream(d);
			byte[] buffer = new byte[1024];
			int bytesRead = is.read(buffer);
			
			System.out.println(bytesRead);
			os.write(buffer,0,bytesRead);
			System.out.println("Writing complete");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				is.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static void copyFileUsingFileChannels(File source, File dest) throws IOException {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } finally {
            inputChannel.close();
            outputChannel.close();
        }
	}
	
	public static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }
	
	public static void createFile(String fileName){
		PrintWriter writer;
		try {
			writer = new PrintWriter(fileName, "UTF-8");
			writer.println("The first line");
			writer.println("The second line");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("createFile() Done");
	}

	public static void writeContentToFile(String fileName,String content) throws IOException{
		File file = new File(fileName);

		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content);
		bw.close();

		System.out.println("writeContentToFile() Done");
	}
	
	
	/**
	 * @param fileName
	 * @param key
	 * @return
	 */
	public static String propertyReader(String fileName,String key){
		String value = null;
		try{
			ResourceBundle resBundle = ResourceBundle.getBundle(fileName);
			if(resBundle != null){
				value = resBundle.getString(key);
			}
		}catch(MissingResourceException mre){
			mre.printStackTrace();
		}
		return value;
	}
	
	/**
	 * Tests whether two given dates are in the same day.
	 * 
	 * @param d1
	 *            The first date to test
	 * @param d2
	 *            The second date to test
	 * @return <code>true</code> if the two dates are in the same day;
	 *         <code>false</code> otherwise.
	 */
	public static  boolean isSameDay(final Date d1, final Date d2) {
		boolean result = false;
		if (d1 != null && d2 != null) {
			Calendar c1 = Calendar.getInstance();
			c1.setTime(d1);
			Calendar c2 = Calendar.getInstance();
			c2.setTime(d2);
			result = (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
					&& c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH) && c2
					.get(Calendar.DATE) == c2.get(Calendar.DATE));
		}
		return result;
	}
	
	/**
	 * Finds the index of a given string array matches given comparing string by
	 * ignoring their cases.
	 * 
	 * @param array
	 *            The string array for comparison
	 * @param match
	 *            The string for comparing
	 * @return The index of match found in the array. If the value is -1, it
	 *         means no match can be found.
	 */
	public static  int findIndexOfMatchIgnoreCase(final String[] array,final String match) {
		int index = -1;
		String tempMatch = null;
		if ( match != null ){
			tempMatch = match.trim();
		}
		if (array != null && tempMatch != null && tempMatch.length() > 0) {
			int ix = 0;
			for (String str : array) {
				if (tempMatch.equalsIgnoreCase(str)) {
					index = ix;
					break;
				}
				ix++;
			}
		}
		return index;
	}
	
	/**
     * This is responsible for converting an array of byte to String.
     * 
     * @param digestBits byte[].
     * @return String value of digest bites.
     */
    public static String convertToString(final byte[] digestBits) {

        StringBuffer result = new StringBuffer(64);
        for(int i = 0; i < digestBits.length; i++) {
            hexDigit(result, digestBits[i]);
        }
        return result.toString();
    }
    
    /**
     * This is responsible for identifying the String value for the respective byte.
     * @param s {@link StringBuffer}.
     * @param x byte value.
     */
    private static void hexDigit(final StringBuffer s, final byte x) {
        
        char c;

        c = (char) ((x >> 4) & 15);
        if(c > 9) {
            c = (char) ((c - 10) + 'a');
        } else {
            c = (char) (c + '0');
        }
        s.append(c);
        c = (char) (x & 15);
        if(c > 9) {
            c = (char)((c-10) + 'a');
        } else {
            c = (char)(c + '0');
        }
        s.append(c);
     }
    
    /**
     * Convert the given date to the date relevant to the given time zone.
     * @param date date needs to be converted
     * @param timeZoneKey the target time zone
     * @return Date converted date
     */
    public static Date convertDate(final Date date,final String timeZoneKey){
    	Date convertedDate = null;
        if (date != null) {
            TimeZone tz = TimeZones.getTimeZone(timeZoneKey);
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(date.getTime() + tz.getOffset(date.getTime()));
            convertedDate = cal.getTime();
        }
        return convertedDate;
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
     * Takes a given string and clear up all entities that conflict with XML
     * entity.  Assume the original string is not <code>null</code>.
     * 
     * @param original  The original string
     * @return  The cleared string.
     */
    public static final String stringNormalize(String original) {
    	String result="";
    	if(original!=null){
        String temp = original.replaceAll("&amp;", "&");
        temp = temp.replaceAll("&apos;", "'");
        temp = temp.replaceAll("&gt;", ">");
        temp = temp.replaceAll("&lt;", "<");
        temp = temp.replaceAll("&quot;", "\"");
        result = temp.replaceAll("&", "&amp;");
        result = result.replaceAll("'", "&apos;");
        result = result.replaceAll(">", "&gt;");
        result = result.replaceAll("<", "&lt;");
        result = result.replaceAll("\"", "&quot;");
        
    	}
    	return result;
    }
	
}
