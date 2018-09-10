package com.jingsky.util.common;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * DATE 工具类。
 * @author 朱志杰 QQ：862990787
 * 创建于 May 29, 2013 9:52:51 AM
 * 最后修改于 2018-09-10
 */
public class DateUtilV2 {

	private Calendar calendar = Calendar.getInstance();

    /**
     * 获得当前对象的Date
     * @return Date
     */
    public Date getDate(){
        return calendar.getTime();
    }

	/**
	 * 功能：获得当前对象的Calendar。
	 * @author 朱志杰 QQ：695520848
	 * Aug 21, 2013 8:58:31 AM
	 * @return Calendar
	 */
	public Calendar getCalendar() {
        return calendar;
    }

	/**
	 * 设置时区
	 * @param timezone 时区
	 * @return DateUtilV2
	 */
	public DateUtilV2 setTimezone(TimeZone timezone){
		calendar.setTimeZone(timezone);
		return this;
	}

	/**
	 * 功能：判断日期是否和当前date对象在同一天。
	 * @author 朱志杰 QQ：695520848
	 * Aug 21, 2013 7:15:53 AM
	 * @param date 比较的日期
	 * @return boolean 如果在返回true，否则返回false。
	 */
	public  boolean isSameDay(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("日期不能为null");
        }
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date);
        return this.isSameDay(cal2);
    }

	/**
	 * 功能：判断日期是否和当前date对象在同一天。
	 * @author 朱志杰 QQ：695520848
	 * Aug 21, 2013 7:15:53 AM
	 * @param cal 比较的日期
	 * @return boolean 如果在返回true，否则返回false。
	 */
	public  boolean isSameDay(Calendar cal) {
        if (cal == null) {
            throw new IllegalArgumentException("日期不能为null");
        }
        //当前date对象的时间
        return (calendar.get(Calendar.ERA) == cal.get(Calendar.ERA) &&
				calendar.get(Calendar.YEAR) == cal.get(Calendar.YEAR) &&
				calendar.get(Calendar.DAY_OF_YEAR) == cal.get(Calendar.DAY_OF_YEAR));
    }

	/**
	 * 功能：将当前日期的秒数进行重新设置。
	 * @author 朱志杰 QQ：695520848
	 * Jul 31, 2013 2:42:36 PM
	 * @param second 秒数
	 * @return 设置后的日期
	 */
	public DateUtilV2 setSecondNew(int second){
		calendar.set(Calendar.SECOND,second);
		return this;
	}

	/**
	 * 功能：将当前日期的分钟进行重新设置。
	 * @author 朱志杰 QQ：695520848
	 * Jul 31, 2013 2:42:36 PM
	 * @param minute 分钟数
	 * @return 设置后的日期
	 */
	public DateUtilV2 setMinuteNew(int minute){
		calendar.set(Calendar.MINUTE,minute);
		return this;
	}

	/**
	 * 功能：将当前日期的小时进行重新设置。
	 * @author 朱志杰 QQ：695520848
	 * Jul 31, 2013 2:42:36 PM
	 * @param hour 小时数 (24小时制)
	 * @return 设置后的日期
	 */
	public DateUtilV2 setHourNew(int hour){
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		return this;
	}

	/**
	 * 功能：将当前日期的天进行重新设置。
	 * @author 朱志杰 QQ：695520848
	 * Jul 31, 2013 2:42:36 PM
	 * @param day 某一天
	 * @return 设置后的日期
	 */
	public DateUtilV2 setDayNew(int day){
		calendar.set(Calendar.DATE,day);
		return this;
	}

	/**
	 * 功能：将当前日期的月进行重新设置。
	 * @author 朱志杰 QQ：695520848
	 * Jul 31, 2013 2:42:36 PM
	 * @param month 某一月
	 * @return 设置后的日期
	 */
	public DateUtilV2 setMonthNew(int month){
		calendar.set(Calendar.MONTH, month-1);
		return this;
	}

	/**
	 * 功能：将当前日期的年进行重新设置。
	 * @author 朱志杰 QQ：695520848
	 * Jul 31, 2013 2:42:36 PM
	 * @param year 某一年
	 * @return 设置后的日期
	 */
	public DateUtilV2 setYearNew(int year){
		calendar.set(Calendar.YEAR, year);
		return this;
	}

	/**
	 * 功能：得到当月有多少天。
	 * @author 朱志杰 QQ：695520848
	 * Jul 2, 2013 4:59:41 PM
	 * @return int
	 */
	public int daysNumOfMonth(){
		return calendar.getActualMaximum(Calendar.DATE);
	}

	/**
	 * 功能：计算两个时间的时间差。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 2:34:08 PM
	 * @param time 另一个时间。
	 * @return Timespan 时间间隔
	 */
	public Timespan substract(Date time){
		return new Timespan(calendar.getTimeInMillis()-time.getTime());
	}

	/**
	 * 功能：当前时间增加毫秒数。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 11:26:27 AM
	 * @param milliseconds 正值时时间延后，负值时时间提前。
	 * @return Date
	 */
	public DateUtilV2 addMilliseconds(int milliseconds){
		calendar.set(Calendar.MILLISECOND, calendar.get(Calendar.MILLISECOND)+milliseconds);
		return this;
	}

	/**
	 * 功能：当前时间增加秒数。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 11:26:27 AM
	 * @param seconds 正值时时间延后，负值时时间提前。
	 * @return Date
	 */
	public DateUtilV2 addSeconds(int seconds){
		calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND)+seconds);
		return this;
	}

	/**
	 * 功能：当前时间增加分钟数。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 11:26:27 AM
	 * @param minutes 正值时时间延后，负值时时间提前。
	 * @return Date
	 */
	public DateUtilV2 addMinutes(int minutes){
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE)+minutes);
		return this;
	}

	/**
	 * 功能：当前时间增加小时数。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 11:26:27 AM
	 * @param hours 正值时时间延后，负值时时间提前。
	 * @return Date
	 */
	public DateUtilV2 addHours(int hours){
		calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR)+hours);
		return this;
	}

	/**
	 * 功能：当前时间增加天数。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 11:26:27 AM
	 * @param days 正值时时间延后，负值时时间提前。
	 * @return Date
	 */
	public DateUtilV2 addDays(int days){
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)+days);
		return this;
	}

	/**
	 * 功能：当前时间增加月数。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 11:26:27 AM
	 * @param months 正值时时间延后，负值时时间提前。
	 * @return Date
	 */
	public DateUtilV2 addMonths(int months){
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+months);
		return this;
	}

	/**
	 * 功能：当前时间增加年数。注意遇到2月29日情况，系统会自动延后或者减少一天。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 11:26:27 AM
	 * @param years 正值时时间延后，负值时时间提前。
	 * @return Date
	 */
	public DateUtilV2 addYears(int years){
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)+years);
		return this;
	}

	/**
	 * 得到秒。格式：56
	 * @return int
	 */
	public int secondInt() {
		return Integer.parseInt(toString("ss"));
	}

	/**
	 * 得到分钟。格式：56
	 * @return int
	 */
	public int minuteInt() {
		return Integer.parseInt(toString("mm"));
	}

	/**
	 * 得到小时。格式：23
	 * @return int
	 */
	public int hourInt() {
		return Integer.parseInt(toString("HH"));
	}

	/**
	 * 得到日。格式：26
	 * 注意：这里1日返回1,2日返回2。
	 * @return int
	 */
	public int dayInt() {
		return Integer.parseInt(toString("dd"));
	}

	/**
	 * 得到月。格式：5
	 * 注意：这里1月返回1,2月返回2。
	 * @return int
	 */
	public int monthInt() {
		return Integer.parseInt(toString("MM"));
	}

	/**
	 * 得到年。格式：2013
	 * @return int
	 */
	public int yearInt() {
		return Integer.parseInt(toString("yyyy"));
	}

	/**
	 * 得到短时间。格式：12:01
	 * @return String
	 */
	public String shortTime() {
		return toString("HH:mm");
	}

	/**
	 * 得到长时间。格式：12:01:01
	 * @return String
	 */
	public String longTime() {
		return toString("HH:mm:ss");
	}

	/**
	 * 得到今天的第一秒的时间。
	 * @return Date
	 */
	public DateUtilV2 dayStart() {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return this;
	}

    /**
     * 得到本周的第一秒的时间。(周一零点零分零秒)
     * @return Date
     */
    public DateUtilV2 weekdayStart() {
        calendar.set(Calendar.DAY_OF_WEEK, 2);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return this;
    }

    /**
     * 得到本周的最后一秒的时间。(周日23:59:59)
     * @return Date
     */
    public DateUtilV2 weekdayEnd() {
        //先计算出来周六
        calendar.set(Calendar.DAY_OF_WEEK, 7);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 59);
        addDays(1);
        return this;
    }

	/**
     * 得到当前所在自然月的第一天的开始,格式为长日期格式。例如：2012-03-01 00:00:00。
     * @return Date
     */
    public DateUtilV2 monthStart(){
    	String startStr= toString("yyyy-M-")+calendar.getActualMinimum(Calendar.DATE)+" 00:00:00";
    	return new DateUtilV2(startStr);
    }

	/**
     * 得到当前所在自然月的最后一天的结束,格式为长日期格式。例如：2012-03-01 00:00:00。
     * @return Date
     */
    public DateUtilV2 monthEnd(){
    	String startStr= toString("yyyy-M-")+calendar.getActualMaximum(Calendar.DAY_OF_MONTH)+" 23:59:59";
		return new DateUtilV2(startStr);
    }

	/**
	 * 得到今天的最后一秒的时间。
	 * @return Date
	 */
	public DateUtilV2 dayEnd() {
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 0);
		return this;
	}

	/**
	 * 根据日期得到星期几,得到数字。
	 * 7, 1, 2, 3, 4, 5, 6
	 * @return Integer 如：6
	 */
	public int dayOfWeekInt() {
		Integer dayNames[] = { 7, 1, 2, 3, 4, 5, 6 };
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayOfWeek < 0)
			dayOfWeek = 0;
		return dayNames[dayOfWeek];
	}

	/**
	 * 将日期转换成长日期字符串 例如：2009-09-09 01:01:01
	 * @return String
	 */
	public String toLongDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(calendar);
	}

	/**
	 * 将日期转换成中长日期字符串,不含秒 例如：2009-09-09 01:01
	 * @return String
	 */
	public String toMidDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return df.format(calendar);
	}

	/**
	 * 将日期按照一定的格式进行格式化为字符串。
	 * 例如想将时间格式化为2012-03-05 12:56 ,则只需要传入formate为yyyy-MM-dd HH:mm即可。
	 * @param formate 格式化格式，如：yyyy-MM-dd HH:mm
	 * @return String 格式后的日期字符串。如果当前对象为null，则直接返回null。
	 */
	public String toString(String formate) {
		DateFormat df = new SimpleDateFormat(formate);
		return df.format(calendar);
	}

	/**
	 * 得到某个时间的时间戳yyyyMMddHHmmss。
	 * @return String 如果当前对象为null，则直接返回null。
	 */
	public String toTimeStamp() {
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(calendar);
	}

	/**
	 * 将日期转换成短日期字符串,例如：2009-09-09。
	 * @return String ,如果当前对象为null，返回null。
	 */
	public String toShortDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(calendar);
	}


	/**
	 * 功能：用java.common.Date进行构造。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 10:59:05 AM
	 * @param  date
	 */
	public DateUtilV2(Date date) {
		calendar=Calendar.getInstance();
		calendar.setTime(date);
	}

    /**
     * 功能：用Timestamp进行构造。
     * @author 朱志杰 QQ：695520848
     * May 29, 2013 10:59:05 AM
     * @param  timestamp
     */
    public DateUtilV2(Timestamp timestamp) {
		calendar=Calendar.getInstance();
		calendar.setTime(timestamp);
    }

	/**
	 * 功能：用毫秒进行构造。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 10:59:05 AM
	 * @param timeInMillis
	 */
	public DateUtilV2(long timeInMillis) {
		calendar=Calendar.getInstance();
		calendar.setTimeInMillis(timeInMillis);
	}

    /**
	 * 功能：calendar进行构造。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 10:59:05 AM
	 * @param calendar
	 */
	public DateUtilV2(Calendar calendar) {
		this.calendar=calendar;
	}

	/**
	 * 功能：DateUtil进行构造。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 10:59:05 AM
	 * @param DateUtilV2
	 */
	public DateUtilV2(DateUtilV2 DateUtilV2) {
		this.calendar=DateUtilV2.getCalendar();
	}


	/**
	 * 功能：默认构造函数。
	 * @author 朱志杰 QQ：695520848
	 * May 29, 2013 11:00:05 AM
	 */
	public DateUtilV2() {
		this.calendar=Calendar.getInstance();
	}

	/**
	 * 功能：构造方法。
	 * @param source 时间字符串
	 * @param pattern 当前时间字符串的格式。
	 * @return Date 日期 ,转换异常时返回null。
	 */
	public DateUtilV2(String source,String pattern){
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			calendar.setTime(simpleDateFormat.parse(source));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("日期格式不正确");
		}
	}

	/**
	 * 功能：构造方法。
	 * @param source yyyy-MM-dd HH:mm:ss字符串
	 * @return Date 日期 ,转换异常时返回null。
	 */
	public DateUtilV2(String source){
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			calendar.setTime(simpleDateFormat.parse(source));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("日期格式不正确，需要：yyyy-MM-dd HH:mm:ss");
		}
	}
	
}
