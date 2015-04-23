package com.graffiti75.android.lungo.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * DateHelper class.
 * 
 * @author Rodrigo Cericatto
 * @since Oct 2, 2013
 */
public class DateHelper {
	
	//--------------------------------------------------
	// Constants
	//--------------------------------------------------
	
	public static final Long SECOND = 1000l;
	public static final Long MINUTE = SECOND * 60;
	public static final Long HOUR = MINUTE * 60;
	public static final Long DAY = HOUR * 24;
	public static final Long WEEK = DAY * 7;
	public static final Long MONTH = DAY * 30;
	
	//--------------------------------------------------
	// Methods
	//--------------------------------------------------

	/**
	 * Format a date.
	 * 
	 * @param date The date to be formatted.
	 * @param dayOrMonth Is true if the date is day or month (and false if is year).
	 * @return The formatted date.
	 */
	public static String formatDateTerm(Integer date, Boolean dayOrMonth) {
		String format = null;
		
		// Gets the right format.
		if (dayOrMonth) {
			format = "00";
		} else {
			format = "0000";
		}

		// Performs the formatting.
		DecimalFormat df = new DecimalFormat(format);
		return df.format(date);
	}

    /**
     * Gets current date.
     *
     * @return The current date, in formatted string.
     */
    public static Integer[] getCurrentFormattedDate() {
        // Gets current time in mili seconds.
        Long currentTime = Calendar.getInstance().getTimeInMillis();
        SimpleDateFormat formatter;
        Integer values[] = new Integer[3];

        // Gets the values.
        formatter = new SimpleDateFormat("dd");
        values[0] = Integer.valueOf(formatter.format(currentTime));

        formatter = new SimpleDateFormat("MM");
        values[1] = Integer.valueOf(formatter.format(currentTime));

        formatter = new SimpleDateFormat("yyyy");
        values[2] = Integer.valueOf(formatter.format(currentTime));

        // Return value.
        return values;
    }

    /**
     * Gets the correct month.
     *
     * @param value
     */
    public static Integer getMonth(String value) {
        Integer month = 0;
        switch (value) {
            case "JAN":
                month = 1;
                break;
            case "FEV":
                month = 2;
                break;
            case "MAR":
                month = 3;
                break;
            case "ABR":
                month = 4;
                break;
            case "MAI":
                month = 5;
                break;
            case "JUN":
                month = 6;
                break;
            case "JUL":
                month = 7;
                break;
            case "AGO":
                month = 8;
                break;
            case "SET":
                month = 9;
                break;
            case "OUT":
                month = 10;
                break;
            case "NOV":
                month = 11;
                break;
            case "DEZ":
                month = 12;
                break;
        }
        return month;
    }

    /**
     * Gets the correct month.
     *
     * @param value
     */
    public static String getMonthInString(Integer value) {
        String month = "";
        switch (value) {
            case 1:
                month = "JAN";
                break;
            case 2:
                month = "FEV";
                break;
            case 3:
                month = "MAR";
                break;
            case 4:
                month = "ABR";
                break;
            case 5:
                month = "MAI";
                break;
            case 6:
                month = "JUN";
                break;
            case 7:
                month = "JUL";
                break;
            case 8:
                month = "AGO";
                break;
            case 9:
                month = "SET";
                break;
            case 10:
                month = "OUT";
                break;
            case 11:
                month = "NOV";
                break;
            case 12:
                month = "DEZ";
                break;
        }
        return month;
    }
}