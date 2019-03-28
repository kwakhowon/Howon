package practice_0328;
/*
21.성적처리프로그램을 작성하시오

==================================================================================
번호    이름      국어    영어    수학    총점    평균    학점    재수강    순위
----------------------------------------------------------------------------------
   1      소서노     90       95       100
   2      주  몽     75       55        65
   3      모팔모     100     100       100
----------------------------------------------------------------------------------

< 처리조건 >
1. 변수
     String []name ={"소서노","주몽","모팔모"};
     int [][]score = {{90,95,100,0},{75,55,65,0},{100,100,100,0}};
     double []avg = {0.0, 0.0, 0.0};
     char []grade = new char[3];
     String []pass = new String[3];
     int []rank ={1,1,1};
2. 총점 = 국어 + 영어 + 수학
    평균 = 총점/3;
    학점 = 90이상 'A' / 80이상 'B' / 70이상 'C' / 60이상 'D' / 나머지는 'F'
               (if ~ else if문 이용)
    재수강 = 60이상이면 "pass"  60미만이면 "nopass"
               (if~else문)
    순위구하기      
 */
public class Example21 {
	public static void main(String[] args) {
		String []name ={"소서노","주몽","모팔모"};
	     int [][]score = {{90,95,100,0},{75,55,65,0},{100,100,100,0}};
	     double []avg = {0.0, 0.0, 0.0};
	     char []grade = new char[3];
	     String []pass = new String[3];
	     int []rank ={1,1,1};
	    avg[0] = (score[0][0] + score[0][1] + score[0][2])/3;
	    avg[1] = (score[1][0] + score[1][1] + score[1][2])/3;
	    avg[2] = (score[2][0] + score[2][1] + score[2][2])/3;
	    for(int i=0; i<avg.length; i++) {
	    	if(avg[i]>=60) {
	    		System.out.println("pass");
	    	}else {
	    		System.out.println("nopass");
	    	}
	    	if(avg[i]>=90) {
	    		System.out.println("A");
	    	}else if(avg[i]>=80) {
	    		System.out.println("B");
	    	}else if(avg[i]>=70) {
	    		System.out.println("C");
	    	}else if(avg[i]>=60) {
	    		System.out.println("D");
	    	}else
	    		System.out.println("F");
	    }
	    
	}
}
