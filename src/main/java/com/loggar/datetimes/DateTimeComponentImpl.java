package com.loggar.datetimes;

import java.lang.invoke.MethodHandles;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Date Util
 *
 */
public class DateTimeComponentImpl implements DateTimeComponent {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	Locale locale = Locale.ENGLISH;

	@Override
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@Override
	public Date toDate(String strDate, String strFormat) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat(strFormat);

		Date date = null;

		try {
			date = dateFormatter.parse(strDate);
		} catch (ParseException e) {
			logger.error("{}" + e);
			date = new Date();
		}

		return date;
	}

	@Override
	public Date toDate(String strDate, String strFormat, Locale paramLocale) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat(strFormat, paramLocale);

		Date date = null;

		try {
			date = dateFormatter.parse(strDate);
		} catch (ParseException e) {
			logger.error("fail to parse date {} -> {}, {}\n{}" + strDate, strFormat, paramLocale, e);
			date = new Date();
		}

		return date;
	}

	@Override
	public String parse(String strFormat) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat(strFormat);
		return dateFormatter.format(new Date());
	}

	@Override
	public String parse(Date date, String strFormat) {
		return (new SimpleDateFormat(strFormat)).format(date);
	}

	@Override
	public String parse(String str_date, String orgFormat, String destFormat) {
		SimpleDateFormat orgFormatter = new SimpleDateFormat(orgFormat);
		SimpleDateFormat destFormatter = new SimpleDateFormat(destFormat);
		Date date = null;
		try {
			date = orgFormatter.parse(str_date);
		} catch (ParseException e) {
			logger.error("fail to parse date {} -> {}\n{}" + str_date, orgFormatter, e);
			date = new Date();
		}
		return destFormatter.format(date);
	}

	@Override
	public String parse(String strFormat, Locale paramLocale) {
		return parse(new Date(), strFormat, paramLocale);
	}

	@Override
	public String parse(Date date, String strFormat, Locale paramLocale) {
		return (new SimpleDateFormat(strFormat, paramLocale).format(date));

	}

	@Override
	public String parse(String str_date, String strFormat, Locale paramLocale) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat(strFormat, (paramLocale == null) ? this.locale : paramLocale);
		Date date = null;
		try {
			date = dateFormatter.parse(str_date);
		} catch (ParseException e) {
			logger.error("{}" + e);
			date = new Date();
		}

		return dateFormatter.format(date);
	}

	@Override
	public boolean isBetween(Date startDate, Date endDate) {
		return this.isBetween(new Date(), startDate, endDate);
	}

	@Override
	public boolean isBetween(String str_issueDate, String str_StartDate, String str_endDate, String strDateFormat) {
		SimpleDateFormat formatter_01 = new SimpleDateFormat(strDateFormat);

		try {
			Date issueDate = formatter_01.parse(str_issueDate);
			Date startDate = formatter_01.parse(str_StartDate);
			Date endDate = formatter_01.parse(str_endDate);

			return isBetween(issueDate, startDate, endDate);
		} catch (ParseException e) {
			logger.error("{}" + e);
			return false;
		}
	}

	@Override
	public boolean isBetween(Date issueDate, Date startDate, Date endDate) {
		SimpleDateFormat formatter_1_0 = new SimpleDateFormat(str_dateFormat_1_0);

		Date issueDate_0 = null;
		Date startDate_0 = null;
		Date endDate_0 = null;

		try {
			issueDate_0 = formatter_1_0.parse(formatter_1_0.format(issueDate));
			startDate_0 = formatter_1_0.parse(formatter_1_0.format(startDate));
			endDate_0 = formatter_1_0.parse(formatter_1_0.format(endDate));
		} catch (ParseException e) {
			logger.error("{}" + e);

			issueDate_0 = issueDate;
			startDate_0 = startDate;
			endDate_0 = endDate;
		}

		if ((issueDate_0.after(startDate_0) || issueDate_0.equals(startDate_0)) && (issueDate_0.before(endDate_0) || issueDate_0.equals(endDate_0))) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isBetween(String str_startDate, String str_endDate, String strDateFormat) {
		SimpleDateFormat formatter_1 = new SimpleDateFormat(strDateFormat);

		try {
			Date issueDate = new Date();
			Date startDate = formatter_1.parse(str_startDate);
			Date endDate = formatter_1.parse(str_endDate);

			return isBetween(issueDate, startDate, endDate);
		} catch (ParseException e) {
			logger.error("{}" + e);
			return false;
		}
	}

	@Override
	public int getYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(Calendar.YEAR);
	}

	@Override
	public int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	@Override
	public boolean isExpired(Date startDate, int durationType, int duration) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(durationType, duration);

		Date date = new Date();
		Date expiredDate = new Date(calendar.getTimeInMillis());

		if (date.after(expiredDate) || date.equals(expiredDate)) return true;
		else return false;
	}

	@Override
	public boolean isExpired(String str_startDate, int durationType, int duration, String strDateFormat) {
		SimpleDateFormat formatter_01 = new SimpleDateFormat(strDateFormat);

		try {
			Date startDate = formatter_01.parse(str_startDate);
			return isExpired(startDate, durationType, duration);
		} catch (ParseException e) {
			logger.error("{}" + e);
			return false;
		}
	}

	@Override
	public Date addDate(Date startDate, int durationType, int duration) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(durationType, duration);
		return new Date(calendar.getTimeInMillis());
	}
	
	@Override
	public boolean isTimeBetweenTwoTime(String initialTime, String finalTime, String targetTime) {
		String reg = "^([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";
		if (initialTime.matches(reg) && finalTime.matches(reg) && targetTime.matches(reg)) {
			Date time1;
			try {
				time1 = new SimpleDateFormat(str_timeFormat_1).parse(initialTime);
			} catch (ParseException e) {
				logger.error("{}" + e);
				return false;
			}
			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(time1);

			Date checkTime;
			try {
				checkTime = new SimpleDateFormat(str_timeFormat_1).parse(targetTime);
			} catch (ParseException e) {
				logger.error("{}" + e);
				return false;
			}
			Calendar calendar3 = Calendar.getInstance();
			calendar3.setTime(checkTime);

			Date time2;
			try {
				time2 = new SimpleDateFormat(str_timeFormat_1).parse(finalTime);
			} catch (ParseException e) {
				logger.error("{}" + e);
				return false;
			}
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(time2);

			if (finalTime.compareTo(initialTime) < 0) {
				calendar2.add(Calendar.DATE, 1);
				calendar3.add(Calendar.DATE, 1);
			}

			Date actualTime = calendar3.getTime();
			if ((actualTime.after(calendar1.getTime()) || actualTime.compareTo(calendar1.getTime()) == 0) && actualTime.before(calendar2.getTime())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean isTimeBetweenTwoTime(String initialTime, String finalTime) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat(str_timeFormat_1);
		return isTimeBetweenTwoTime(initialTime, finalTime, dateFormatter.format(new Date()));
	}
}
