package com.loggar.datetimes;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.regex.Pattern;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loggar.tools.common.StringUtil;

public class DateTimeUtil {
	private static final Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);

	private DateTimeUtil() {
		throw new AssertionError(DateTimeUtil.class.getName() + " cannot be instantiable.");
	}

	/**
	 * dd/mm/yyyy to dd/Month Name/yyyy
	 *
	 * @param strDate
	 * @return
	 */
	public static String convertDescriptionDate(String strDate) {
		StringBuilder sb = new StringBuilder();
		sb.setLength(0);
		if (!StringUtil.isEmpty(strDate) && !"N/A".equals(StringUtil.getEmptyIfNull(strDate))) {
			String[] da = strDate.split("/");
			if (da.length >= 3) {
				sb.append(da[0]).append(" ");
				sb.append(convertMonthToString(da[1])).append(" ");
				sb.append(da[2]);
			} else {
				sb.append(strDate);
			}
		} else {
			sb.append("N/A");
		}
		return sb.toString();
	}

	/**
	 * int month to string MonthName
	 *
	 * @param mm
	 * @return
	 */
	public static String convertMonthToString(String mm) {
		String mmStr = "";
		switch (StringUtil.parseInt(mm)) {
		case 1:
			mmStr = "January";
			break;
		case 2:
			mmStr = "Febuary";
			break;
		case 3:
			mmStr = "March";
			break;
		case 4:
			mmStr = "April";
			break;
		case 5:
			mmStr = "May";
			break;
		case 6:
			mmStr = "June";
			break;
		case 7:
			mmStr = "July";
			break;
		case 8:
			mmStr = "August";
			break;
		case 9:
			mmStr = "September";
			break;
		case 10:
			mmStr = "October";
			break;
		case 11:
			mmStr = "November";
			break;
		case 12:
			mmStr = "December";
			break;
		default:
			break;
		}
		return mmStr;
	}

	/**
	 * current time to int
	 * 
	 * @return 121212 int
	 */
	public static int getTime() {
		String[] ids = TimeZone.getAvailableIDs(+9 * 60 * 60 * 1000);
		SimpleTimeZone pdt = new SimpleTimeZone(+9 * 60 * 60 * 1000, ids[0]);
		Calendar date = new GregorianCalendar(pdt);
		java.util.Date trialTime = new java.util.Date();
		date.setTime(trialTime);

		int timex = (date.get(Calendar.HOUR_OF_DAY) * 10000) + (date.get(Calendar.MINUTE) * 100) + date.get(Calendar.SECOND);
		return timex;
	}

	/**
	 * current time to string
	 * 
	 * @return 121212 String
	 */
	public static String getTimeStr() {
		return StringUtil.zeroFill(getTime(), 6);
	}

	/**
	 * current time to long
	 * 
	 * @return 121212 123 long (.000)
	 */
	public static long getMilliTime() {
		String[] ids = TimeZone.getAvailableIDs(+9 * 60 * 60 * 1000);
		SimpleTimeZone pdt = new SimpleTimeZone(+9 * 60 * 60 * 1000, ids[0]);
		Calendar date = new GregorianCalendar(pdt);
		java.util.Date trialTime = new java.util.Date();
		date.setTime(trialTime);

		int timexm = date.get(Calendar.MILLISECOND);
		return timexm;
	}

	/**
	 * current time(millisecond) - 1 / 1000 second
	 * 
	 * @return
	 */
	public static long getMilliTimeMinus() {
		return getMilliTime() - 1;
	}

	/**
	 * current time - minusTime
	 * 
	 * @param minusTime
	 * @return
	 */
	public static long getMilliTimeMinus(int minusTime) {
		return getMilliTime() - minusTime;
	}

	/**
	 * current time to string
	 * 
	 * @param void
	 * @return String 092706012 (am 9h, 27m, 6s, 12 Milisec)
	 */
	public static String getSeqTime(String prefix) {
		return prefix + StringUtil.zeroFill(getTime(), 6) + StringUtil.zeroFill((int) getMilliTime(), 3);
	}

	/**
	 * current date and current time to string
	 * 
	 * @param void
	 * @return String 20080923134220999 (2008Y 09M 23D, 13h 42m 20s 999Milisec)
	 * @author JM,Son (since 20080924)
	 */
	public static String getDayMilliSeqTime() {
		return getDayStr() + StringUtil.zeroFill(getTime(), 6) + StringUtil.zeroFill((int) getMilliTime(), 3);
	}

	/**
	 * today
	 * 
	 * @param void
	 * @return 20020101 int
	 */
	public static int getDay() {
		return getDay(0);
	}

	/**
	 * today
	 * 
	 * @return 20020101 String
	 */
	public static String getDayStr() {
		return String.valueOf(getDay());
	}

	/**
	 * compare years
	 * 
	 * @param gap
	 * @return year : yyyy
	 */
	public static int getYear(int gap) {
		return Integer.parseInt(String.valueOf(getDay(gap)).substring(0, 4));
	}

	/**
	 * compare months
	 * 
	 * @param gap
	 * @return month : mm
	 */
	public static int getMonth(int gap) {
		return Integer.parseInt(String.valueOf(getDay(gap)).substring(4, 6));
	}

	/**
	 * compare days
	 * 
	 * @param gap
	 * @return day : dd
	 */
	public static int getSingleDay(int gap) {
		return Integer.parseInt(String.valueOf(getDay(gap)).substring(6));
	}

	/**
	 * today - gap
	 * 
	 * @param gapDate int
	 * @return 20020101 int
	 */
	public static int getDay(int gap) {
		int day = 0;
		String[] ids = TimeZone.getAvailableIDs(+9 * 60 * 60 * 1000);
		SimpleTimeZone pdt = new SimpleTimeZone(+9 * 60 * 60 * 1000, ids[0]);

		Calendar date = new GregorianCalendar(pdt);
		java.util.Date trialTime = new java.util.Date();
		date.setTime(trialTime);
		date.set(Calendar.DATE, date.get(Calendar.DAY_OF_MONTH) + gap);

		day = (date.get(Calendar.YEAR) * 10000) + ((date.get(Calendar.MONTH) + 1) * 100) + date.get(Calendar.DAY_OF_MONTH);
		return day;
	}

	/**
	 * last day of the month
	 * 
	 * @param int nowDate
	 * @return int 20020131
	 */
	public static int lastMonthDay(int nowDate) {
		int allDate = nowDate;
		int yearx = nowDate / 10000;
		int monthx = (nowDate - (yearx * 10000)) / 100;

		if (monthx == 12) {
			yearx += 1;
			monthx = 1;
			allDate = yearx * 10000 + monthx * 100 + 1;
		} else {
			monthx += 1;
			allDate = yearx * 10000 + monthx * 100 + 1;
		}

		int day = gapDay(allDate, -1);

		return day;
	}

	/**
	 * last day of the month
	 * 
	 * @param void
	 * @return int 20020131
	 */
	public static int lastMonthDay() {
		return lastMonthDay(getDay());
	}

	/**
	 * compare day
	 * 
	 * @param int nowDate, int gap
	 * @return int 20020131
	 */
	public static int gapDay(int nowDate, int gap) {
		int yearx = nowDate / 10000;
		int monthx = (nowDate - (yearx * 10000)) / 100;
		int dayx = nowDate - (yearx * 10000) - (monthx * 100);

		int day = 0;
		Calendar date = Calendar.getInstance();
		date.set(yearx, (monthx - 1), dayx);
		date.set(Calendar.DATE, date.get(Calendar.DAY_OF_MONTH) + gap);

		day = (date.get(Calendar.YEAR) * 10000) + ((date.get(Calendar.MONTH) + 1) * 100) + date.get(Calendar.DAY_OF_MONTH);
		return day;
	}

	/**
	 * compare day
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return int
	 */
	public static int gapFromTo(int fromDate, int toDate) {
		Calendar fDate = Calendar.getInstance();
		Calendar tDate = Calendar.getInstance();

		int fYear = fromDate / 10000;
		int fMonth = (fromDate - (fYear * 10000)) / 100;
		int fDay = fromDate - (fYear * 10000) - (fMonth * 100);

		int tYear = toDate / 10000;
		int tMonth = (toDate - (tYear * 10000)) / 100;
		int tDay = toDate - (tYear * 10000) - (tMonth * 100);

		fDate.set(fYear, (fMonth - 1), fDay);
		tDate.set(tYear, (tMonth - 1), tDay);

		long cal1sec = fDate.getTime().getTime();
		long cal2sec = tDate.getTime().getTime();
		long gap = cal2sec - cal1sec;
		int gapday = (int) (gap / 86400) / 1000;
		return gapday;
	}

	/**
	 * campare date
	 * 
	 * @see #getDateTimeGapLong(String, String)
	 * @param fromDateTime yyyymmddHHmiss
	 * @param toDateTime   yyyymmddHHmiss
	 * @return gapDayTime - String hhmiss
	 */
	public static String getDateTimeGap(String fromDateTime, String toDateTime) {
		long datedif;

		try {

			SimpleDateFormat fmt = new java.text.SimpleDateFormat("yyyyMMddHHmmss");

			if (fromDateTime.equals("") && toDateTime.equals("")) {
				return "";
			}

			if (fromDateTime.trim().equals("") || fromDateTime.trim().equals("00")) {
				Calendar cal = Calendar.getInstance();
				fromDateTime = fmt.format(cal.getTime()).trim();
			}

			datedif = ((fmt.parse(toDateTime).getTime() - fmt.parse(fromDateTime).getTime()) / 1000);

			datedif = (datedif > 0) ? datedif : Math.abs(datedif);

			double ss = datedif;
			ss = (ss > 59) ? (ss % 60) : ss;

			double mm = Math.floor((datedif - ss) / 60);
			mm = (mm > 59) ? (mm % 60) : mm;

			double hh = Math.floor((datedif - ((mm * 60) + ss)) / 60 / 60);
			String hour = String.valueOf((int) hh);
			String min = String.valueOf((int) mm);
			String sec = String.valueOf((int) ss);

			if (hh < 10) {
				hour = "0" + hour;
			}
			if (mm < 10) {
				min = "0" + min;
			}
			if (ss < 10) {
				sec = "0" + sec;
			}

			return hour + min + sec;

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * campare date
	 * 
	 * @see #getDateTimeGap(fromDateTime, toDateTime)
	 * @param fromDateTime yyyymmddhhmiss
	 * @param toDateTime   yyyymmddhhmiss
	 * @return gapDayTime - long hhmiss
	 */
	public static long getDateTimeGapLong(String fromDateTime, String toDateTime) {
		if (Double.parseDouble(fromDateTime) > Double.parseDouble(toDateTime)) {
			return Long.parseLong(getDateTimeGap(fromDateTime, toDateTime)) * -1;
		}

		return Long.parseLong(getDateTimeGap(fromDateTime, toDateTime));
	}

	/**
	 * compare date
	 * 
	 * @param fromDateTime yyyymmddhhmiss
	 * @param toDateTime   yyyymmddhhmiss
	 * @param delim
	 * @return
	 */
	public static String getDateTimeGap(String fromDateTime, String toDateTime, String delim) {
		StringBuffer str = new StringBuffer();
		String gap = getDateTimeGap(fromDateTime, toDateTime);
		if (Double.parseDouble(fromDateTime) > Double.parseDouble(toDateTime)) {
			str.append("-");
		}
		str.append(gap.substring(0, gap.length() - 4));
		str.append(delim);
		str.append(gap.substring(gap.length() - 4, gap.length() - 2));
		str.append(delim);
		str.append(gap.substring(gap.length() - 2));
		return str.toString();
	}

	/**
	 * compare minute
	 * 
	 * @param fromDateTime
	 * @param toDateTime
	 * @param format       (yyyyMMddHHmmss or yyyyMMddHHmm)
	 * @return minute
	 */
	public static double getGapTimeReturnMinute(String fromDateTime, String toDateTime, String format) {
		double datedif;

		try {

			SimpleDateFormat fmt = new java.text.SimpleDateFormat(format);

			if (fromDateTime.equals("") && toDateTime.equals("")) {
				return 0;
			}

			if (fromDateTime.trim().equals("") || fromDateTime.trim().equals("00")) {
				Calendar cal = Calendar.getInstance();
				fromDateTime = fmt.format(cal.getTime()).trim();
			}

			datedif = ((fmt.parse(toDateTime).getTime() - fmt.parse(fromDateTime).getTime()) / 1000);

			datedif = (datedif > 0) ? datedif : Math.abs(datedif);

			double ss = datedif;
			ss = (ss > 59) ? (ss % 60) : ss;

			double mm = Math.floor((datedif - ss) / 60);

			String min = String.valueOf((int) mm);
			String sec = String.valueOf((int) ss);

			if (mm < 10) {
				min = "0" + min;
			}
			if (ss < 10) {
				sec = "0" + sec;
			}

			return Double.parseDouble(min) + Double.parseDouble(sec) / 60;

		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * compare day
	 * 
	 * @param dayTime yyyymmddhh24miss
	 * @param gapTime hh24miss
	 * @param pm      gapTime +|-
	 * @return
	 */
	public static String gapDayTime(String dayTime, String gapTime, String pm) {
		StringBuffer gapDayTime = new StringBuffer();

		int fhour = Integer.parseInt(dayTime.substring(8, 10));
		int fmin = Integer.parseInt(dayTime.substring(10, 12));
		int fsec = Integer.parseInt(dayTime.substring(12));
		int ghour = Integer.parseInt(gapTime.substring(0, gapTime.length() - 4));
		int gmin = Integer.parseInt(gapTime.substring(gapTime.length() - 4, gapTime.length() - 2));
		int gsec = Integer.parseInt(gapTime.substring(gapTime.length() - 2));
		int rday = 0, rhour = 0, rmin = 0, rsec = 0;
		if ("-".equals(pm)) {
			ghour *= -1;
			gmin *= -1;
			gsec *= -1;
		}
		rsec = fsec + gsec;
		if (rsec < 0) {
			rsec += 60;
			fmin -= 1;
		} else if (rsec > 59) {
			rsec -= 60;
			fmin += 1;
		}
		rmin = fmin + gmin;
		if (rmin < 0) {
			rmin += 60;
			fhour -= 1;
		} else if (rmin > 59) {
			rmin -= 60;
			fhour += 1;
		}
		rhour = fhour + ghour;
		if (rhour < 0) {
			rday = rhour / 24 - 1;
			rhour = 24 - Math.abs(rhour) % 24;
			if (rhour > 23) {
				rday++;
				rhour = 0;
			}

		} else if (rhour > 23) {
			rday = rhour / 24;
			rhour = rhour % 24;
		}
		gapDayTime.append(DateTimeUtil.gapDay(Integer.parseInt(dayTime.substring(0, 8)), rday));
		if (rhour < 10) {
			gapDayTime.append("0");
		}
		gapDayTime.append(String.valueOf(rhour));
		if (rmin < 10) {
			gapDayTime.append("0");
		}
		gapDayTime.append(String.valueOf(rmin));
		if (rsec < 10) {
			gapDayTime.append("0");
		}
		gapDayTime.append(String.valueOf(rsec));
		return gapDayTime.toString();
	}

	/**
	 * compare day
	 * 
	 * @param dayTime
	 * @param gapTime
	 * @return
	 */
	public static String gapDayTime(String dayTime, double gapTime) {
		DecimalFormat df = new DecimalFormat("#00");
		String pm = null;
		StringBuffer gapTimeStr = new StringBuffer();
		if (gapTime >= 0) {
			pm = "+";
		} else {
			pm = "-";
		}

		double ss = 0.0;
		double mm = 0.0;
		double hh = 0.0;
		ss = Math.abs(gapTime);
		ss = (ss > 59) ? (ss % 60) : ss;

		mm = Math.floor((Math.abs(gapTime) - ss) / 60);
		mm = (mm > 59) ? (mm % 60) : mm;
		hh = Math.floor((Math.abs(gapTime) - ((mm * 60) + ss)) / 60 / 60);
		gapTimeStr.append(df.format(hh));
		gapTimeStr.append(df.format(mm));
		gapTimeStr.append(df.format(ss));
		return gapDayTime(dayTime, gapTimeStr.toString(), pm);
	}

	/**
	 * is in working hours
	 * 
	 * @param inTime hhmm String
	 * @return boolean
	 */
	public static boolean isWorkTime(String inTime) {
		int hour = Integer.parseInt(inTime.substring(0, 2));
		int min = Integer.parseInt(inTime.substring(2));

		if ((hour >= 0 && hour <= 24) && (min >= 0 && min <= 59)) {
			return true;
		}

		return false;
	}

	/**
	 * is leap year
	 * 
	 * @param year YYYY
	 * @return
	 */
	public static boolean isLeapYear(int year) {
		return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
	}

	/**
	 * how may days in provided month
	 * 
	 * @see #getDaysInMonth(int, int)
	 * @param day
	 * @return
	 */
	public static int getDaysInMonth(int day) {
		String yyyy = String.valueOf(day).substring(0, 4);
		String mm = String.valueOf(day).substring(4, 6);

		return getDaysInMonth(Integer.parseInt(yyyy), Integer.parseInt(mm));
	}

	/**
	 * how may days in provided month
	 * 
	 * @param yyyy
	 * @param mm
	 * @return
	 */
	public static int getDaysInMonth(int yyyy, int mm) {
		switch (mm) {
		case 1:
			return 31;
		case 2:
			if (isLeapYear(yyyy)) {
				return 29;
			}
			return 28;
		case 3:
			return 31;
		case 4:
			return 30;
		case 5:
			return 31;
		case 6:
			return 30;
		case 7:
			return 31;
		case 8:
			return 31;
		case 9:
			return 30;
		case 10:
			return 31;
		case 11:
			return 30;
		case 12:
			return 31;
		default:
			return 0;
		}
	}

	/**
	 * get weekday
	 * 
	 * 1 : SUNDAY<br />
	 * 2 : MONDAY<br />
	 * 3 : TUESDAY<br />
	 * 4 : WEDNESDAY<br />
	 * 5 : THURSDAY<br />
	 * 6 : FRIDAY<br />
	 * 7 : SATURDAY<br />
	 * 
	 * @param day
	 * @return int
	 */
	public static int getWeekDay(int day) {
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, day);
		int dow = today.get(Calendar.DAY_OF_WEEK);

		return dow;
	}

	/**
	 * get weekday
	 * 
	 * @return int
	 */
	public static int getWeekDay() {
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, getDay());
		int dow = today.get(Calendar.DAY_OF_WEEK);
		return dow;
	}

	/**
	 * last day of provided week
	 * 
	 * @param day
	 * @return lastDay - yyyymmdd
	 */
	public static int getEndOfWeekDay(int day) {
		int lastDay = 0;

		if (getWeekDay(day) == 7) {
			lastDay = day;
		} else {
			int gap = 7 - (getWeekDay(day) + 1);
			lastDay = gapDay(day, gap);
		}
		return lastDay;
	}

	/**
	 * first day of provided week
	 * 
	 * @param day
	 * @return firstDay - yyyymmdd
	 */
	public static int getStartOfWeekDay(int day) {
		int firstDay = 0;

		if (getWeekDay(day) == 1) {
			firstDay = day;
		} else {
			int gap = 1 - (getWeekDay(day) + 1);
			firstDay = gapDay(day, gap);
		}
		return firstDay;
	}

	/**
	 * get weekday
	 * 
	 * @param day
	 * @return
	 */
	public static String getWeekTitle(int day) {
		switch (getWeekDay(day)) {
		case 1:
			return "SUNDAY";
		case 2:
			return "MONDAY";
		case 3:
			return "TUESDAY";
		case 4:
			return "WEDNESDAY";
		case 5:
			return "THURSDAY";
		case 6:
			return "FRIDAY";
		case 7:
			return "SATURDAY";
		default:
			return "";
		}
	}

	/**
	 * format day
	 * 
	 * @param day
	 * @param delim
	 * @return
	 */
	public static String getDayType(int day, String delim) {
		String DAY = day + "";

		if (day == 0) {
			DAY = "";
		} else if (day > 10000000) {
			DAY = DAY.substring(0, 4) + delim + DAY.substring(4, 6) + delim + DAY.substring(6, 8);
		} else if (day > 100000) {
			DAY = DAY.substring(0, 4) + delim + DAY.substring(4, 6);
		}
		return DAY;
	}

	/**
	 * format day
	 * 
	 * @param day
	 * @param delim
	 * @return
	 */
	public static String getDayTypeStr(String day, String delim) {
		StringBuffer DAY = new StringBuffer();
		if (day.length() == 8) {
			DAY.append(day.substring(0, 4));
			DAY.append(delim);
			DAY.append(day.substring(4, 6));
			DAY.append(delim);
			DAY.append(day.substring(6));
		} else if (day.length() == 6) {
			DAY.append(day.substring(0, 2));
			DAY.append(delim);
			DAY.append(day.substring(2, 4));
			DAY.append(delim);
			DAY.append(day.substring(4));
		} else {
			DAY.append("");
		}

		return DAY.toString();
	}

	/**
	 * format time
	 * 
	 * @param time
	 * @param delim
	 * @return
	 */
	public static String getTimeTypeStr(String time, String delim) {
		StringBuffer TIME = new StringBuffer();
		if (time.length() == 6) {
			TIME.append(time.substring(0, 2));
			TIME.append(delim);
			TIME.append(time.substring(2, 4));
			TIME.append(delim);
			TIME.append(time.substring(4));
		} else if (time.length() == 5) {
			TIME.append(time.substring(0, 1));
			TIME.append(delim);
			TIME.append(time.substring(1, 3));
			TIME.append(delim);
			TIME.append(time.substring(3));
		} else if (time.length() == 4) {
			TIME.append(time.substring(0, 2));
			TIME.append(delim);
			TIME.append(time.substring(2, 4));
		} else if (time.length() == 9) {
			TIME.append(time.substring(0, 2));
			TIME.append(delim);
			TIME.append(time.substring(2, 4));
			TIME.append(delim);
			TIME.append(time.substring(4, 6));
			TIME.append(delim);
			TIME.append(time.substring(6));
		} else {
			TIME.append("");
		}

		return TIME.toString();
	}

	/**
	 * get a date by string pattern
	 * 
	 * @param date    a date
	 * @param pattern a string pattern, ex) "yyyy-MM-dd HH:mm:ss"
	 * @return string value
	 */
	public static String getDateFormat(Date date, String pattern) {
		if (date == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * <pre>
	 * date to long
	 * </pre>
	 * 
	 * @param trialTime
	 * @return
	 */
	public static long getDayTime(Date trialTime) {
		StringBuffer daytime = new StringBuffer();
		String[] ids = TimeZone.getAvailableIDs(+9 * 60 * 60 * 1000);
		SimpleTimeZone pdt = new SimpleTimeZone(+9 * 60 * 60 * 1000, ids[0]);
		Calendar date = new GregorianCalendar(pdt);
		date.setTime(trialTime);
		int timex = (date.get(Calendar.HOUR_OF_DAY) * 10000) + (date.get(Calendar.MINUTE) * 100) + date.get(Calendar.SECOND);

		Calendar date2 = new GregorianCalendar(pdt);
		date2.setTime(trialTime);
		date2.set(Calendar.DATE, date.get(Calendar.DAY_OF_MONTH));
		daytime.append((date2.get(Calendar.YEAR) * 10000) + ((date2.get(Calendar.MONTH) + 1) * 100) + date2.get(Calendar.DAY_OF_MONTH));
		daytime.append(StringUtil.zeroFill(timex, 6));
		return Long.parseLong(daytime.toString());
	}

	public static String getAusTypeDayAndTime(String delim) {
		StringBuilder sb = new StringBuilder();
		String day = getDayStr();
		sb.append(day.substring(6));
		sb.append(delim);
		sb.append(day.substring(4, 6));
		sb.append(delim);
		sb.append(day.substring(0, 4));
		sb.append("_");
		sb.append(getTimeStr());
		return sb.toString();
	}

	public static boolean isValidAUDateFormat(String dateStr) {
		Pattern DATE_PATTERN = Pattern.compile(
				"^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
		return DATE_PATTERN.matcher(dateStr).matches();
	}

	public static boolean isValidTimeStringFormat(String timeStr) {
		Pattern TIME_PATTERN = Pattern.compile("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$");
		return TIME_PATTERN.matcher(timeStr).matches();
	}

	public static XMLGregorianCalendar convertToUSIGregorianCalendarFormat(String dateStr) {
		if (StringUtil.isEmpty(dateStr)) {
			return null;
		}
		try {
			GregorianCalendar cal = new GregorianCalendar();
			Date dob = null;
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			dob = df.parse(dateStr);
			cal.setTime(dob);
			XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
			return xmlDate;
		} catch (Exception e) {
			logger.error("{}", e.getMessage());
			return null;
		}
	}

	public static String converDateToOtherFormat(String originalDate, String originFormatString, String targetFormatString) {
		if (StringUtil.isEmptyOrStrNull(originalDate))
			return "";
		DateFormat originalFormat = new SimpleDateFormat(originFormatString, Locale.ENGLISH);
		DateFormat targetFormat = new SimpleDateFormat(targetFormatString);
		Date date = null;
		try {
			date = originalFormat.parse(originalDate);
		} catch (ParseException e) {
			logger.error("{}", e.getMessage());
			return "";
		}
		String formattedDate = targetFormat.format(date);
		return formattedDate;
	}
}
