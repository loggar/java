package com.loggar.datetimes;

import java.util.Date;
import java.util.Locale;

/**
 * java.util.date Util - jdk7 rule
 * 
 */
public interface DateTimeComponent {
	/**
	 * dd/MM/yyyy
	 */
	static String str_dateFormat_1 = "dd/MM/yyyy";

	/**
	 * dd/MM/yyyy 00:00:00
	 */
	static String str_dateFormat_1_0 = "dd/MM/yyyy 00:00:00";

	/**
	 * dd/MM/yyyy HH:mm:ss
	 */
	static String str_dateFormat_1_1 = "dd/MM/yyyy HH:mm:ss";

	/**
	 * dd/MM/yyyy h:mm a
	 */
	static String str_dateFormat_1_2 = "dd/MM/yyyy h:mm a";

	/**
	 * yyyyMMddHHmm
	 */
	static String str_dateFormat_2 = "yyyyMMddHHmm";

	/**
	 * yyyyMMdd HH:mm:ss
	 */
	static String str_dateFormat_3 = "yyyyMMdd HH:mm:ss";

	/**
	 * yyyy/MM/dd HH:mm:ss
	 */
	static String str_dateFormat_4 = "yyyy/MM/dd HH:mm:ss";

	/**
	 * 04 July 2018
	 */
	static String str_dateFormat_5 = "dd MMMMM yyyy";

	/**
	 * yyyy-MM-dd
	 */
	static String str_dateFormat_6 = "yyyy-MM-dd";

	/**
	 * HH:mm:ss
	 */
	static String str_timeFormat_1 = "HH:mm:ss";

	static String[] day_of_week = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

	void setLocale(Locale locale);

	Date toDate(String strDate, String strFormat);

	Date toDate(String strDate, String strFormat, Locale locale);

	String parse(String strFormat);

	String parse(Date date, String strFormat);

	String parse(String str_date, String orgFormat, String destFormat);

	String parse(String strFormat, Locale paramLocale);

	String parse(Date date, String strFormat, Locale paramLocale);

	String parse(String str_date, String strFormat, Locale paramLocale);

	int getYear();

	int getYear(Date date);

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	boolean isBetween(Date startDate, Date endDate);

	/**
	 * 
	 * @param issueDate
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	boolean isBetween(Date issueDate, Date startDate, Date endDate);

	/**
	 * isssueDate between two days?
	 * 
	 * @param str_issueDate
	 * @param strStartDate
	 * @param str_endDate
	 * @return
	 */
	boolean isBetween(String str_issueDate, String strStartDate, String str_endDate, String strDateFormat);

	/**
	 * today between two days?
	 * 
	 * @param str_startDate
	 * @param str_endDate
	 * @return
	 */
	boolean isBetween(String str_startDate, String str_endDate, String strDateFormat);

	/**
	 * is today on some duration
	 * 
	 * @param startDate
	 * @param durationType
	 *            Calendar.MONTH, Calendar.YEAR
	 * @param duration
	 * @return
	 */
	boolean isExpired(Date startDate, int durationType, int duration);

	/**
	 * is today on some duration
	 * 
	 * @param startDate
	 * @param durationType
	 *            Calendar.MONTH, Calendar.YEAR
	 * @param duration
	 * @return
	 */
	boolean isExpired(String startDate, int durationType, int duration, String strDateFormat);

	/**
	 * add plus or minus from startDate
	 * 
	 * @param startDate
	 * @param durationType
	 * @param duration
	 * @return
	 */
	Date addDate(Date startDate, int durationType, int duration);

	boolean isTimeBetweenTwoTime(String initialTime, String finalTime, String targetTime);

	boolean isTimeBetweenTwoTime(String initialTime, String finalTime);
}