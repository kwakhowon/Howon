package kr.or.bit;
//우리 교육 시스템에 사용되는 날짜 관련된 함수  ...

//그 함수가 자주 사용된다면 >> new 객체 생성 (x) >> 클래스이름.함수이름() static >> 
//다양한 날짜 형태가 필요하다면 >> 함수추가 (오버로딩)

import java.util.Calendar;

public class Edu_Date {
	public static String DateString(Calendar date) {
		return date.get(Calendar.YEAR) + "년" + (date.get(Calendar.MONTH) + 1) + "월" + date.get(Calendar.DATE) + "일";
	}

	public static String DateString(Calendar date, String opr) {
		return date.get(Calendar.YEAR) + opr + (date.get(Calendar.MONTH) + 1) + opr + date.get(Calendar.DATE);
	}
	// 년월일 : 월만 두자리 표기  (1~9)한자리 , 10,11,12 두자리
	//

	// 모두 2자리 표기 : 2018-02-12
	// 2018-01-01
	// 2019-12-12
	public static String monthFormat_DateString(Calendar date) {
		String month="";
		if((date.get(Calendar.MONTH)+1) < 10) {
			month = "0" + (date.get(Calendar.MONTH)+1);
		}else {
			month = String.valueOf((date.get(Calendar.MONTH)+1));
		}
		return date.get(Calendar.YEAR) + "년" 
		       + month + "월" 
		       + date.get(Calendar.DATE) + "일";
	}

}


