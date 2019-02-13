package kr.or.bit;
/*
우리회사는 비행기를 주문 제작 판매하는 회사입니다
우리회사는 비행기를 생산하는 설계도를 작성 하려고 합니다
 
사장님의 요구사항
1. 비행기를 생산하면 비행기를 이름과 번호를 부여해야 합니다.
2. 비행기가 생산되면 비행기의 이름과 번호가 맞게 부여되었는지 확인 기능(정보출력)
3. 비행기가 출고 될때마다 비행기의 누적대수를 확인 할 수 있습니다.

비행기를 만든다 (AirPlane air = new AirPlane())

설계도는 지금까지 배운 코드로 작성 ..... (최소한 3대 ...)만드세요
kr.or.bit.AirPlane 이름으로 작성 
 
*/
public class AirPlane {
   	private int airnum;
   	private String airname;
   	private static int airtotalcount;
   	
   	public void makeAirPlane(int num , String name) {
   		airnum = num;
   		airname = name;
   		airtotalcount++;
   		System.out.printf("번호[%d] , 이름[%s] \n" ,airnum,airname);
   	}
   	
   	public void airPlaneTotalCount() {
   		System.out.println("총 제작 비행기 수 : " + airtotalcount);
   	}
}
//생성자 배운 다음에 코드 수정합니다 ^^







