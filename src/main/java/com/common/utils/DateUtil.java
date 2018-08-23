package com.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.ValidationException;

/**
 * DateUtil 日期时间处理类
 * 
 * @author Administrator
 * 
 */
public class DateUtil {
	public static final String DEFAULT_TIME_FORMAT = "yyyyMMddHHmmss";

	/**
	 * 获取现在时间
	 * 
	 * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
	 */
	public static Date getNowDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return返回短时间格式 yyyy-MM-dd
	 */
	public static Date getNowDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		ParsePosition pos = new ParsePosition(8);
		Date currentTime_2 = formatter.parse(dateString, pos);
		return currentTime_2;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String getStringDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取现在时间
	 * 
	 * @return 返回短时间字符串格式yyyy-MM-dd
	 */
	public static String getStringDateShort() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * @Title: getCurrentDateString
	 * @Description: 得到当前日期字符串:yyyymmdd
	 * @return String:yyyyMMdd
	 * @throws
	 */
	public static String getCurrentDateString() {
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH) + 1;
		int date = calendar.get(Calendar.DATE);
		return "" + calendar.get(Calendar.YEAR)
				+ (month < 10 ? "0" + month : "" + month)
				+ (date < 10 ? "0" + date : "" + date);
	}

	/**
	 * 得到当前日期字符串String:yyyyMMddHHmmss
	 * @return yyyyMMddHHmmss
	 */
	public static String getCurrentDateTimeString() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * @Title: getCurrentDate
	 * @Description: 得到当前日期字符串,适用于数据库为Date类型，yyyyMMddHHmmss
	 * @return Date:yyyyMMddHHmmss
	 * @throws
	 */
	public static java.util.Date getCurrentDate() {
		return new java.util.Date();
	}

	// 判断两日期格式是否相等
	public static boolean isDateEqual(java.util.Date date1, java.util.Date date2) {

		java.util.Calendar cal1 = java.util.Calendar.getInstance();
		cal1.setTime(date1);
		java.util.Calendar cal2 = java.util.Calendar.getInstance();
		cal2.setTime(date2);

		return (cal1.get(java.util.Calendar.YEAR) == cal2
				.get(java.util.Calendar.YEAR)
				&& cal1.get(java.util.Calendar.MONTH) == cal2
						.get(java.util.Calendar.MONTH) && cal1
					.get(java.util.Calendar.DAY_OF_MONTH) == cal2
				.get(java.util.Calendar.DAY_OF_MONTH));

	}

	// 将格式为“20060302”形式的字符串转换成日期类型yyyy-MM-dd
	public static java.util.Date getToDate(String s) {
		StringBuffer sb = new StringBuffer();
		sb.append(s.substring(0, 4)).append("-").append(s.substring(4, 6))
				.append("-").append(s.substring(6, 8));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date obj = null;
		try {
			obj = sdf.parse(sb.toString());
		} catch (ParseException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
			System.err.println("change date type error");
		}
		return obj;
	}

	// 将格式为“2006-02-23”的日期字符串转化为日期类型
	/**
	 * 将格式为“2006-02-23”的日期字符串转化为日期类型 格式为"2004-10-10" --> Date
	 * <p>
	 * <code> checkStartEndDate </code>
	 * </p>
	 * 
	 * @param context
	 * @throws ValidationException
	 * @author Songyi 2004-12-15
	 * @since 1.1
	 */
	public static java.util.Date getString2Date(String sDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date obj = null;

		try {
			obj = sdf.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
			System.err.println("change date type error");
		}

		return obj;
	}

	// 判断当前的字符串是否为当前日期
	public static boolean isCurrentDate(String strDate) {
		return strDate == null || !strDate.equals(getCurrentDateString()) ? false
				: true;
	}

	// 取当前日期前一天或后一天，up传true表示取当前的前一天，up传false表示取当前日期的后一天
	public static String rollDate(java.util.Date date, boolean up) {

		if (date == null)
			return null;

		GregorianCalendar beforeCalendar = new GregorianCalendar();
		beforeCalendar.setTime(date);
		beforeCalendar.add(Calendar.DATE, up ? +1 : -1);
		int beforeDate = beforeCalendar.get(Calendar.DATE);
		int beforeMonth = beforeCalendar.get(Calendar.MONTH) + 1;
		int beforeYear = beforeCalendar.get(Calendar.YEAR);

		return "" + beforeYear
				+ (beforeMonth < 10 ? "0" + beforeMonth : "" + beforeMonth)
				+ (beforeDate < 10 ? "0" + beforeDate : "" + beforeDate);

	}

	// 返回年月日方式或者年月日时分方式对应的日期时间
	/**
	 * @param str
	 * @return
	 */
	public static Date String2Date(String str) {
		try {
			SimpleDateFormat s1 = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat s2 = new SimpleDateFormat("yyyyMMddHHmm");

			if (str.length() == 8) {
				return s1.parse(str);
			} else if (str.length() == 12) {
				return s2.parse(str);
			} else {
				throw new RuntimeException("validation.date.parse_error");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("adsasd");
		}

	}

	// 比较2个日期：返回－1，1，0
	/**
	 * @param StartDate
	 * @param EndDate
	 * @return
	 */
	public static int DateCompare(String StartDate, String EndDate) {

		Date start = String2Date(StartDate);
		Date end = String2Date(EndDate);

		if (start.before(end)) {
			return -1;
		} else if (start.after(end)) {
			return 1;
		} else
			return 0;

	}

	// 比较2个时间：返回－1，1，0
	/**
	 * @param StartTime
	 * @param EndTime
	 * @return
	 */
	public static int TimeCompare(String StartTime, String EndTime) {

		if ((StartTime.length() != 4) || (EndTime.length() != 4)) {
			throw new RuntimeException("validation.time.parse_error");
		}
		int startHour = Integer.parseInt(StartTime.substring(0, 2));
		int startMin = Integer.parseInt(StartTime.substring(2, 4));
		int endHour = Integer.parseInt(EndTime.substring(0, 2));
		int endMin = Integer.parseInt(EndTime.substring(2, 4));

		if (startHour < endHour) {
			return -1;
		} else if (startHour > endHour) {
			return 1;
		} else {
			if (startMin < endMin) {
				return -1;
			} else if (startMin > endMin) {
				return 1;
			} else
				return 0;
		}

	}

	// 获得从now开始iMonth个月前的一天
	/**
	 * @param now
	 * @param iMonth
	 * @return
	 */
	public static Date getDateBefore(Date now, int iMonth) {

		Calendar c = Calendar.getInstance();
		c.setTime(now);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);

		month = month - iMonth;
		if (month < 1) {
			month = month + 12;
			year = year - 1;
		}

		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);

		return c.getTime();
	}

	// 获得从now开始iMonth个月后的一天
	/**
	 * @param now
	 * @param iMonth
	 * @return
	 */
	public static Date getDateAfter(Date now, int iMonth) {

		Calendar c = Calendar.getInstance();
		c.setTime(now);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);

		month = month + iMonth;
		if (month > 12) {
			month = month - 12;
			year = year + 1;
		}

		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DAY_OF_MONTH, day);

		return c.getTime();
	}

	public static Date getLastDay(Date now) {

		Calendar c = Calendar.getInstance();
		c.setTime(now);
		int day = c.get(Calendar.DAY_OF_MONTH);
		c.set(Calendar.DAY_OF_MONTH, day - 1);

		return c.getTime();
	}

	// 得到当前日期的开始时间
	/**
	 * 得到当前日期的开始时间
	 * 
	 * @param now
	 * @return
	 */
	public static Date getDayStart(Date now) {

		Calendar c = Calendar.getInstance();
		c.setTime(now);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);

		return c.getTime();
	}

	// 得到当前日期的结束时间
	/**
	 * 得到当前日期的结束时间
	 * 
	 * @param now
	 * @return
	 */
	public static Date getDayEnd(Date now) {

		Calendar c = Calendar.getInstance();
		c.setTime(now);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);

		return c.getTime();
	}

	// 判断输入的日期是否符合要求，1、3、5、7、8、10、12月日期不能大于31日，4、6、9、11月不能日期不能大于30日，2月平年不能大于28日，润年不能大于29日
	public static boolean isDateValid(String inStr) {
		int year, month, day;
		year = Integer.parseInt(inStr.substring(0, 4));
		if (inStr.indexOf(4) == '0') {
			month = Integer.parseInt(inStr.substring(5, 6));
		} else {
			month = Integer.parseInt(inStr.substring(4, 6));
		}
		if (inStr.indexOf(6) == '0') {
			day = Integer.parseInt(inStr.substring(7, 8));
		} else {
			day = Integer.parseInt(inStr.substring(6, 8));
		}

		if (month > 12 || day > 31 || month < 1 || day < 1)
			return false;

		if (month == 4 || month == 6 || month == 9 || month == 11) {
			if (day > 30)
				return false;
		}

		if (month == 2) {
			if (year % 4 == 0) {
				if (day > 29)
					return false;
			} else {
				if (day > 28)
					return false;
			}
		}

		return true;
	}

	/**
	 * 取得指定时间间隔后的系统时间
	 * 
	 * @param hour
	 *            小时
	 * @return String
	 */
	public static String getDifferentTime(int hour) {
		GregorianCalendar calendar = (GregorianCalendar) Calendar.getInstance();
		calendar.add(Calendar.HOUR, hour);
		SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
		return formatter.format(calendar.getTime());
	}

	/**
	 * 取得指定时间间隔后的系统时间
	 * 
	 * @param second
	 *            秒
	 * @return String
	 */
	public static String getDifferentTimeSecond(int second) {
		GregorianCalendar calendar = (GregorianCalendar) Calendar.getInstance();
		calendar.add(Calendar.SECOND, second);
		SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
		return formatter.format(calendar.getTime());
	}

	/**
	 * 取得指定时间间隔后的系统时间
	 * 
	 * @param hour
	 *            小时
	 * @return Date
	 */
	public static Date getDifferentDateTimeSecond(int second) {
		GregorianCalendar calendar = (GregorianCalendar) Calendar.getInstance();
		calendar.add(Calendar.SECOND, second);
		SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
		return calendar.getTime();
	}

	/**
	 * 取得指定时间间隔后的系统时间
	 * 
	 * @param minutes
	 * 
	 * @return String
	 */
	public static String getDifferentTimeByMinute(int minutes) {
		GregorianCalendar calendar = (GregorianCalendar) Calendar.getInstance();
		calendar.add(Calendar.MINUTE, minutes);
		SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
		return formatter.format(calendar.getTime());
	}

	/**
	 * 取得若干天前/后的系统日期
	 * 
	 * @param days
	 *            与现在相隔的日数，正数为当前日期之后，负数为当前日期之前
	 * @return String
	 */
	public static String getDifferentDate(int days) {
		return getDifferentTime(24 * days);
	}
	
	/**
	 * 取得若干天前/后的系统时间yyyyMMddHHmmss
	 * 
	 * @param days
	 *            与现在相隔的日数，正数为当前日期之后，负数为当前日期之前
	 * @return String
	 */
	public static String getDifferentDateTime(int days) {
		return getDifferentTime(3600 * 24 * days);
	}

	/**
	 * 比较日期时间
	 * 
	 * 
	 */
	public static int dateTimeCompare(String date1, String date2) {

		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(DEFAULT_TIME_FORMAT);
		try {
			cal1.setTime(formatter.parse(date1));
			cal2.setTime(formatter.parse(date2));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int result = cal1.compareTo(cal2);
		return result;
	}

	// 主函数
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 公共函数测试
		Date date1 = new Date();
		Date date2 = new Date();
		System.out.println("date1=" + date1 + " date2=" + date2);
		System.out.println("isDateEqual(date1,date2)="
				+ isDateEqual(date1, date2));
		System.out.println(dateTimeCompare("20131009090910", "20131009090909"));
		System.out.println(dateTimeCompare("20131109090909", "20131009090909"));
		// System.out.println("getCurrentDateString()=" +
		// getCurrentDateString());
		//
		// System.out.println("rollDate()=" + rollDate(new Date(), false));
		//
		// String StartDate = "20060489";
		// String EndDate = "20060403";
		// Date start = String2Date(StartDate);
		// Date end = String2Date(EndDate);
		//
		// System.out.println("start=" + start + " end=" + end);
		//
		// // 查询截止时间应在当天前的测试
		// Date now = new Date(System.currentTimeMillis());
		// String yestodayStr = rollDate(now, false);
		// System.out.println(yestodayStr);
		// Date yestoday = String2Date(yestodayStr);
		// System.out.println(yestoday);
		//
		// System.out.println("start=" + start + ";end=" + end + "now="
		// + getDayStart(now));
		// if (start.after(getDayStart(now)) || isDateEqual(start, now))
		// System.out.println("a");
		// if ((!start.before(now)) || (!end.before(now))
		// || (isDateEqual(start, now)) || (isDateEqual(end, now))) {
		// System.out.println("adsadfa");
		// }
		//
		// // 字符串匹配的测试
		// Pattern p = Pattern
		// .compile("([1-9]{1}[0-9]{3})(([0]{1}[1-9]{1})|([1]{1}[0-2]{1}))(([0]{1}[1-9]{1})|([1-2]{1}[0-9]{1})|([3]{1}[0-1]{1}))");
		// Matcher m = p.matcher("19990131");
		// boolean b = m.matches();
		// System.out.println(b);
		//
		// String bankSeqAndinputCode = "|adsfadsfa";
		// System.out.println(bankSeqAndinputCode.indexOf('|'));
		// String bankSeq = bankSeqAndinputCode.substring(0,
		// bankSeqAndinputCode.indexOf('|'));
		// String inputCode = bankSeqAndinputCode.substring(
		// bankSeqAndinputCode.indexOf('|') + 1,
		// bankSeqAndinputCode.length());
		// System.out.println("bankSeq=" + bankSeq + " inputCode=" + inputCode);
		//
		// Map map = new HashMap();
		// map.put("name", "ldl");
		// map.put("sex", "mail");
		// map.put("age", "26");
		//
		// // method1
		// Iterator keyValuePairs1 = map.entrySet().iterator();
		// for (int i = 0; i < map.size(); i++) {
		// Map.Entry entry = (Map.Entry) keyValuePairs1.next();
		// Object key = entry.getKey();
		// Object value = entry.getValue();
		// System.out.println("key[" + i + "]=" + key + " value[" + i + "]="
		// + value);
		// }
		// System.out.println();
		//
		// // method2
		// Object[] keyValuePairs2 = map.entrySet().toArray();
		// for (int i = 0; i < map.size(); i++) {
		// Map.Entry entry = (Map.Entry) keyValuePairs2[i];
		// Object key = entry.getKey();
		// Object value = entry.getValue();
		// System.out.println("key[" + i + "]=" + key + " value[" + i + "]="
		// + value);
		// }
		// System.out.println();
		//
		// // method3
		// Iterator keyValuePairs3 = map.entrySet().iterator();
		// int i = 0;
		// while (keyValuePairs3.hasNext()) {
		// i++;
		// Map.Entry entry = (Map.Entry) keyValuePairs3.next();
		// Object key = entry.getKey();
		// Object value = entry.getValue();
		// System.out.println("key[" + i + "]=" + key + " value[" + i + "]="
		// + value);
		// }
		// System.out.println();
		//
		// // method4:error
		// Iterator keyValuePairs4 = map.entrySet().iterator();
		// for (Map.Entry entry = (Map.Entry) keyValuePairs4.next();
		// keyValuePairs4
		// .hasNext(); entry = (Map.Entry) keyValuePairs4.next()) {
		// Object key = entry.getKey();
		// Object value = entry.getValue();
		// System.out.println("key[" + i + "]=" + key + " value[" + i + "]="
		// + value);
		// }
		// System.out.println();
		//
		// // 日期格式判断的测试
		// System.out.println(isDateValid("20040229"));
		// Properties p1 = new Properties();
		// p1.setProperty("1", "2");
		// System.out.println(p1.toString());
	}

	/**
	 * 
	 * @Title: parseDate
	 * @Description: 把字符串解析为日期
	 * @param dateStr
	 * @param format
	 * @return Date
	 */
	public static Date parseDate(String dateStr, String format) {

		Date date = null;
		try {
			DateFormat df = new SimpleDateFormat(format);
			date = (Date) df.parse(dateStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * @Title: format
	 * @Description: 把日期格式化输出为字符串
	 * @param date
	 * @param format
	 * @return String
	 */
	public static String format(Date date, String format) {
		String result = "";
		try {
			if (date != null) {
				DateFormat df = new SimpleDateFormat(format);
				result = df.format(date);
			}
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 
	 * @Title: getMillis
	 * @Description: 返回当前毫秒
	 * @param date
	 * @return
	 */
	public static long getMillis(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * @Title: diffDate
	 * @Description: 两个日期相差几天
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public static int diffDate(java.util.Date dateStart, java.util.Date dateEnd) {
		return (int) ((getMillis(dateStart) - getMillis(dateEnd)) / (24 * 3600 * 1000));
	}

	/**
	 * 昨天
	 * 
	 * @param c
	 * @return
	 */
	public static Calendar yesterday(Calendar c) {
		long offset = 1 * 24 * 60 * 60 * 1000;
		Calendar calendar = null;
		if (c != null) {
			calendar = c;
		} else {
			calendar = Calendar.getInstance();
		}

		calendar.setTimeInMillis(calendar.getTimeInMillis() - offset);
		return calendar;
	}

	/**
	 * 明天
	 * 
	 * @param c
	 * @return
	 */
	public static Calendar tomorrow(Calendar c) {
		long offset = 1 * 24 * 60 * 60 * 1000;
		Calendar calendar = null;
		if (c != null) {
			calendar = c;
		} else {
			calendar = Calendar.getInstance();
		}

		calendar.setTimeInMillis(calendar.getTimeInMillis() + offset);
		return calendar;
	}
}
