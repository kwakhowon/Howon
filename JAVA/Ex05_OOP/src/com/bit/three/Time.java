package com.bit.three;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Time {
	private DateTimeFormatter dateTimePattern;
	private LocalDateTime now;
	private String pattern;
	private SimpleDateFormat dateformat;
	
	public Time(){
		this.pattern = "yyyy/MM/dd HH:mm:ss";
		this.dateTimePattern = DateTimeFormatter.ofPattern(pattern);
		this.now = LocalDateTime.now();
		this.dateformat = new SimpleDateFormat(pattern);
	}
	
	public String currentDateTime() {	
		return dateTimePattern.format(this.now);
	}
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	public long diffDateTime(String dateTime1, String dateTime2) {
		try {
			Date d1 = dateformat.parse(dateTime1);
			Date d2 = dateformat.parse(dateTime2);
			long diff = d2.getTime()-d1.getTime();
			long result = TimeUnit.MILLISECONDS.toSeconds(diff); 
			return result;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("오류발생");
			return 0;
		}
	}

	
}