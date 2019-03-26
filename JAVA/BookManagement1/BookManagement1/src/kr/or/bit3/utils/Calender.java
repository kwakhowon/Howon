package kr.or.bit3.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calender { // 날짜
	public static SimpleDateFormat date; // 연도,월,일
	public static SimpleDateFormat format;
	public static Calendar cal;
//	private static 
	
	static {
		date = new SimpleDateFormat("yyyy/MM/dd");
	}
	
	public static String currentDateTime() { //2019/03/16 포맷으로 출력
		cal = Calendar.getInstance();
		Date temp = cal.getTime();
		return date.format(temp);
	}
	public static String returnDateTime() {
		cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 3);
		Date temp = cal.getTime();
//		return (cal.get(Calendar.YEAR)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.DATE));
		return (date.format(temp));
	}
	
	public static String currentDateTime(String simpledateformat) {//yyyy/MM/dd HH:mm:ss
		cal = Calendar.getInstance();
		date = new SimpleDateFormat(simpledateformat);
		Date temp = cal.getTime();
		return date.format(temp);
	}
}
