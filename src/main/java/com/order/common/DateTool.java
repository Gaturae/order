package com.order.common;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @classDesc: 功能描述:(Dae工具类)
 * @author: 王浩
 * @createTime: 2017年5月10日 上午11:23:29
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
public class DateTool {

	public static final Date parseoDate(String strDate, String format) throws ParseException {
		SimpleDateFormat df = null;
		Date date = null;
		df = new SimpleDateFormat(format);

		try {
			date = df.parse(strDate);
		} catch (ParseException pe) {
			throw new ParseException(pe.getMessage(), pe.getErrorOffset());
		}

		return (date);
	}

	public static final String formatDate(Date aDate, String aMask) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
			System.out.println("时间入参为空");
		} else {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	public static final String formatDate(Timestamp aDate, String aMask) {
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
			System.out.println("时间入参为空");
		} else {
			df = new SimpleDateFormat(aMask);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	public static final String reFormatDate(String dateStr, String srcFormat, String targetFormat)
			throws ParseException {

		Date aDate = DateTool.parseoDate(dateStr, srcFormat);
		SimpleDateFormat df = null;
		String returnValue = "";

		if (aDate == null) {
			System.out.println("时间入参为空");
		} else {
			df = new SimpleDateFormat(targetFormat);
			returnValue = df.format(aDate);
		}

		return (returnValue);
	}

	public static String getNowTimestamp() {
		return String.valueOf(new Date().getTime());
	}

	/**
	 * 获取年龄
	 * 
	 * @param birthDay
	 * @return
	 * @throws Exception
	 */
	public static int getAge(Date birthDay) throws Exception {
		Calendar cal = Calendar.getInstance();
		if (cal.before(birthDay)) {
			throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
		}
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH);
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
		cal.setTime(birthDay);

		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH);
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				if (dayOfMonthNow < dayOfMonthBirth)
					age--;
			} else {
				age--;
			}
		}
		return age;
	}

	/**
	 * 计算生日还剩多少天
	 * 
	 * @param birthday
	 * @return
	 * @throws ParseException
	 */
	public static int getLeftDays(Date birthday) throws ParseException {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyyMMdd");
		String clidate = formatDate(birthday, "yyyyMMdd");
		Calendar cToday = Calendar.getInstance(); // 存今天
		Calendar cBirth = Calendar.getInstance(); // 存生日
		cBirth.setTime(myFormatter.parse(clidate)); // 设置生日
		cBirth.set(Calendar.YEAR, cToday.get(Calendar.YEAR)); // 修改为本年
		int days;
		if (cBirth.get(Calendar.DAY_OF_YEAR) < cToday.get(Calendar.DAY_OF_YEAR)) {
			// 生日已经过了，要算明年的了
			days = cToday.getActualMaximum(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
			days += cBirth.get(Calendar.DAY_OF_YEAR);
		} else {
			// 生日还没过
			days = cBirth.get(Calendar.DAY_OF_YEAR) - cToday.get(Calendar.DAY_OF_YEAR);
		}
		return days;
	}
}
