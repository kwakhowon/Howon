package kr.or.bit;
/*
�츮ȸ��� ����⸦ �ֹ� ���� �Ǹ��ϴ� ȸ���Դϴ�
�츮ȸ��� ����⸦ �����ϴ� ���赵�� �ۼ� �Ϸ��� �մϴ�
 
������� �䱸����
1. ����⸦ �����ϸ� ����⸦ �̸��� ��ȣ�� �ο��ؾ� �մϴ�.
2. ����Ⱑ ����Ǹ� ������� �̸��� ��ȣ�� �°� �ο��Ǿ����� Ȯ�� ���(�������)
3. ����Ⱑ ��� �ɶ����� ������� ��������� Ȯ�� �� �� �ֽ��ϴ�.

����⸦ ����� (AirPlane air = new AirPlane())

���赵�� ���ݱ��� ��� �ڵ�� �ۼ� ..... (�ּ��� 3�� ...)���弼��
kr.or.bit.AirPlane �̸����� �ۼ� 
 
*/
public class AirPlane {
   	private int airnum;
   	private String airname;
   	private static int airtotalcount;
   	
   	public AirPlane(int airnum , String airname) {
   		this.airnum = airnum;
   		this.airname = airname;
   		airtotalcount++;
   	}
   	
   	public void airplaneInfo() {
   		System.out.printf("번호[%d] , 이름[%s] \n" , airnum, airname);
   	}
   	
   	public void airPlaneTotalCount() {
   		System.out.println("총 제작 비행기 수 : " + airtotalcount);
   	}
}
//������ ��� ������ �ڵ� �����մϴ� ^^







