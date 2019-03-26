package com.bit.three;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
	public static final Pattern EMAIL_REGEX = 
			Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public boolean validate(String emailAddress) {
		Matcher matcher = EMAIL_REGEX.matcher(emailAddress);
		return matcher.find();
	}
	
	public void emailCheck(String emailAddress) {
		if(true == validate(emailAddress)) {
			System.out.println(emailAddress + "로 이메일이 전송됩니다.\n");
		}else {
			System.out.println("올바르지 못한 이메일 주소입니다.\n");
		}
		
	}	
}