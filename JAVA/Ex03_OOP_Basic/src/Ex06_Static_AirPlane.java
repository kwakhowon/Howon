import kr.or.bit.AirPlane;

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
public class Ex06_Static_AirPlane {
	public static void main(String[] args) {
		/*
		AirPlane air = new AirPlane();
		air.makeAirPlane(707, "�����װ�");
		air.airPlaneTotalCount();
		
		AirPlane air2 = new AirPlane();
		air.makeAirPlane(808, "�ƽþƳ�");
		air.airPlaneTotalCount();
		
		AirPlane air3 = new AirPlane();
		air.makeAirPlane(007, "������");
		air.airPlaneTotalCount();
		*/
		AirPlane air = new AirPlane(707, "대한항공");
		air.airplaneInfo();
		air.airPlaneTotalCount();
		
		AirPlane air2 = new AirPlane(808, "아시아나");
		air2.airplaneInfo();
		air2.airPlaneTotalCount();
		
	}

}
