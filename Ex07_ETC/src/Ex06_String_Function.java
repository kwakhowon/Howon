import java.util.StringTokenizer;

//String 클래스 (다양한 함수)
//개발에서 많이 사용 (우리가 사용하는 데이터는 대부분 문자열 데이터)
public class Ex06_String_Function {
	public static void main(String[] args) {
		String str = ""; // 문자열 초기화

		String[] strarr = { "aaa", "bbb", "ccc" };
		for (String s : strarr) {
			System.out.println(s);
		}
		//String 클래스 (함수)
		String ss = "hello";
		String concatstr = ss.concat("world");
		System.out.println(concatstr);
		boolean bo = ss.contains("ele");
		System.out.println(bo);
		
		String ss2 = "a b c d"; //[a][ ][b][ ][c][ ] [d]
		System.out.println(ss2.length());
		
		String filename="hello java, world";
		System.out.println(filename.indexOf(","));
		System.out.println(filename.indexOf("java")); //시작위치 index
		System.out.println(filename.indexOf("javv")); //없으면 -1 return
		
		//활용 : 문장내에서 내가 원하는 단어가 포함 되어있는지를 검증
		//0보다 큰값 .. 최소한 하나의 단어는 포함
		System.out.println(filename.lastIndexOf("a"));
		System.out.println(filename.lastIndexOf("kglim"));
		//배열에 값이 없다 >> -1
		//return -1;
		
		//주로 많이 쓰는 함수
		//length() , indexof() , substring() << 중간에서 자르기 , replace() << 치환 , ... split() << 나누기
		String result = "superman";
		System.out.println(result.substring(5)); //시작값부터 문자열 자른다.
		System.out.println(result.substring(0, 0));
		System.out.println(result.substring(1, 1));
		System.out.println(result.substring(2, 3));
		//at index endIndex-1
		//Quiz
		String filename2 = "홍길동.jpg"; //파일명은 바꾸어 질 수 있다.
		//파일명 >>홍길동 
		//확장자 >>jpg
		
		int position = filename2.indexOf(".");
		String file = filename2.substring(0,position);
		String extention = filename2.substring(position+1);
		String extention2 = filename2.substring(position+1, filename2.length());
		System.out.println(file);
		System.out.println(extention);
		System.out.println(extention2);
		
		//replace
		String s2 = "ABCD";
		String result4 = s2.replace("A", "안녕");
		System.out.println(result4);
		System.out.println(s2.charAt(0));
		System.out.println(s2.charAt(3));
		System.out.println(s2.endsWith("CD"));
		System.out.println(s2.equalsIgnoreCase("aBcD"));
		
		//POINT
		//split
		String s6 ="슈퍼맨,팬티,노랑색,우하하,우하하";
		String[] namearr = s6.split(",");
		for(String s : namearr) {
			System.out.println(s);
		}
		
		String filename3 = "bit.hwp";
		String[] arry = filename3.split("\\."); //정규 표현 문자열
		for(String s3 : arry) {
			System.out.println(s3);
		}
		//java , javascript , DB >> 정규 표현식 
		//000-{\d4}-0000
		//000-1111-0000 : true
		//000-11-0000 : false
		
		//과제 (정규표현식 5개 만들어오기) 조별당
		//주로 많이 쓰이는거 email , 주민번호 , 우편번호 , 전화번호 , ........
		//추후 과제 다음주 월요일
		
		String s7 ="a/b,c.d-f";
		StringTokenizer sto = new StringTokenizer(s7,"/,.-");
		while(sto.hasMoreTokens()) {
			System.out.println(sto.nextToken());
		}
		//넌센스 quiz
		String s8 ="홍                    길                          동";
		
		System.out.println(s8.replace(" ","")); //공백을 null값으로
		String s9 = "                 홍길동               ";
		System.out.println(s9.trim());
		String s10 = "        홍      길       동            ";
		System.out.println(s10.replace(" ", ""));
		
		//여러개의 함수를 적용할 경우 (method chain)
		System.out.println(s10.trim().replace(" ", ""));
		
		//Quiz-1
		int sum = 0;
		String[] numarr = {"1","2","3","4","5"};
		//문제: 배열에 있는 문자값들의 합을 sum에 담아서 출력
		for(String s : numarr) {
			sum += Integer.parseInt(s);
		}
		System.out.println(sum);
		
		//Quiz-2
		String jumin ="123456-1234567";
		//위 주민번호의 합을 구하세요
		int sum2 = 0;
		String s11 = jumin.replace("-", "");
		for(int i=0; i<s11.length(); i++) {
			int su = s11.charAt(i)-48;
			sum2+= su;
		}
		System.out.println(sum2);
		sum2 = 0;
		for(int i=0; i<jumin.length()-1; i++) {
			sum2+= Integer.parseInt(jumin.replace("-", "").substring(i,i+1));
		}
		System.out.println(sum2);
		
		int sum3 =0;
        for(int i=0; i<jumin.length()-1;i++){
            sum3+= Integer.parseInt(jumin.replace("-","").substring(i,i+1));
        } System.out.println(sum3);
	}
}
