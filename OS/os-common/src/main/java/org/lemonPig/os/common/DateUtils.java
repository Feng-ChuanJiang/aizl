package org.lemonPig.os.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils extends Date {
	private static final long serialVersionUID = 1L;

	public DateUtils() {
		super();
	}

	public static String getCurrentTime(String format) {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.format(date);
	}
	/**
	 * 当前时间的下一天时间
	 * 
	 * @return
	 */
	public static Date nextDate() {
		return nextDate(new DateUtils(), 1);
	}

	/**
	 * 得到当前时间的毫秒数
	 * 
	 * @return
	 */
	public static Long getCurrentTimeMillis() {
		return System.currentTimeMillis();
	}
	
	/**
	 * 获取任意时间后num天的时间
	 * 
	 * @param date
	 *            java.util.Date
	 * @param num
	 * @return
	 */
	public static Date nextDate(Date date, int num) {
		Calendar cla = Calendar.getInstance();
		cla.setTime(date);
		cla.add(Calendar.DAY_OF_YEAR, num);
		return cla.getTime();
	}

	/**
	 * 获取任意时间后num天的时间
	 * 
	 * @param date
	 *            String; <br>
	 *            格式支持： <br>
	 *            &nbsp;&nbsp; yyyy-MM-dd HH:mm:ss <br>
	 *            &nbsp;&nbsp; yyyy年MM月dd日HH时mm分ss秒 <br>
	 *            &nbsp;&nbsp; yyyy/MM/dd HH:mm:ss <br>
	 *            &nbsp;&nbsp; 默认时间格式
	 * @param num
	 *            int
	 * @return java.util.Date
	 * @throws ParseException
	 */
	public static Date nextDate(String date, int num) throws ParseException {
		if (date == null)
			return null;
		SimpleDateFormat sdf = null;
		if (date.indexOf("-") != -1)
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		else if (date.indexOf("月") != -1)
			sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
		else if (date.indexOf("/") != -1)
			sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		else if (date.indexOf("CST") != -1)
			sdf = new SimpleDateFormat();
		else
			System.out.println("no match format:");
		return nextDate(sdf.parse(date), num);
	}

	/**
	 * 获取当天时间num天后的时间<br>
	 * 如果num小于0则返回当前时间的前num天的时间<br>
	 * &nbsp;&nbsp;&nbsp;，否则返回当天时间后num天的时间
	 * 
	 * @param num
	 *            int;
	 * @return java.util.Date
	 */
	public static Date nextDate(int num) {
		return nextDate(new Date(), num);
	}

	/**
	 * 取得当前日期是多少周
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekOfYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		/**
		 * 设置一年中第一个星期所需的最少天数，例如，如果定义第一个星期包含一年第一个月的第一天，则使用值 1 调用此方法。
		 * 如果最少天数必须是一整个星期，则使用值 7 调用此方法。
		 **/
		c.setMinimalDaysInFirstWeek(1);
		c.setTime(date);
		return c.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 得到某一年周的总数
	 * 
	 * @param year
	 * @return
	 */
	public static int getMaxWeekNumOfYear(int year) {
		Calendar c = Calendar.getInstance();
		c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
		return getWeekOfYear(c.getTime());
	}

	/**
	 * 得到某年某周的第一天
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getFirstDayOfWeek(int year, int week) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.WEEK_OF_YEAR, week);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);// 设置周一
		c.setFirstDayOfWeek(Calendar.MONDAY);
		return c.getTime();
	}

	/**
	 * 获得某年某月某周的第一天
	 */
	public static Date getFirstDayOfWeek(int year, int month, int week) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.WEEK_OF_MONTH, week);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);// 设置周一
		c.setFirstDayOfWeek(Calendar.MONDAY);
		return c.getTime();
	}

	/**
	 * 得到当周的第一天
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getFirstDayOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		c.setFirstDayOfWeek(Calendar.MONDAY);
		return c.getTime();
	}

	/**
	 * 得到某年某周的最后一天
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getLastDayOfWeek(int year, int week) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.WEEK_OF_YEAR, week);
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
		return c.getTime();
	}

	/**
	 * 获得某年某月某周的第一天
	 */
	public static Date getLastDayOfWeek(int year, int month, int week) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.WEEK_OF_MONTH, week);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
		c.setFirstDayOfWeek(Calendar.MONDAY);
		return c.getTime();
	}

	/**
	 * 得到当前周的周的最后一天
	 * 
	 * @param year
	 * @param week
	 * @return
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
		return c.getTime();
	}

	/**
	 * 得到某年某月的第一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getFirstDayOfMonth(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	/**
	 * 获得当前月的第一天
	 * 
	 * @param year
	 * @param date
	 * @return
	 */
	public static Date getFirstDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	/**
	 * 得到某年某月的最后一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date getLastDayOfMonth(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	/**
	 * 获得当前月的最后一天
	 * 
	 * @param year
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	/**
	 * 得到某年某季度第一天
	 * 
	 * @param year
	 * @param quarter
	 * @return
	 */
	public static Date getFirstDayOfQuarter(int year, int quarter) {
		int month = 0;
		if (quarter > 4) {
			return null;
		} else {
			month = (quarter - 1) * 3 + 1;
		}
		return getFirstDayOfMonth(year, month);
	}

	/**
	 * 得到某年某季度最后一天
	 * 
	 * @param year
	 * @param quarter
	 * @return
	 */
	public static Date getLastDayOfQuarter(int year, int quarter) {
		int month = 0;
		if (quarter > 4) {
			return null;
		} else {
			month = quarter * 3;
		}
		return getLastDayOfMonth(year, month);
	}

	/**
	 * 得到某年第一天
	 * 
	 * @param year
	 * @return
	 */
	public static Date getFirstDayOfYear(int year) {
		return getFirstDayOfQuarter(year, 1);
	}

	/**
	 * 得到当年第一天
	 * 
	 * @param year
	 * @return
	 */
	public static Date getFirstDayOfYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int year = c.get(Calendar.YEAR);
		return getFirstDayOfYear(year);
	}

	/**
	 * 得到某年最后一天
	 * 
	 * @param year
	 * @return
	 */
	public static Date getLastDayOfYear(int year) {
		return getLastDayOfQuarter(year, 4);
	}

	/**
	 * 得到当年最后一天
	 * 
	 * @param year
	 * @return
	 */
	public static Date getLastDayOfYear(Date date) {
		int year = getThisYear(date);
		return getLastDayOfYear(year);
	}

	/**
	 * 获得当前年
	 * 
	 * @param date
	 * @return
	 */
	public static int getThisYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int year = c.get(Calendar.YEAR);
		return year;
	}

	/**
	 * 获得当前月
	 * 
	 * @param date
	 * @return
	 */
	public static int getThisMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;
		return month;
	}
	 /**
     * 获取当前日期是星期几<br>
     * 
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return weekDays[w];
    }
}
