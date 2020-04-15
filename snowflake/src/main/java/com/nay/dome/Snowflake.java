package com.nay.dome;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Title: demo</p>
 * Description：
 * date：2020/4/15 22:36
 */
public class Snowflake {
	public static void main(String[] args) {
		System.out.println("11111111111111111111111111111111111111111".length());
		long time = 2199023255551L;
		Date date = new Date();
		date.setTime(time);
//		时间戳到 2039-09-07
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(date));
		System.out.println(2039-1970);
	}
}
