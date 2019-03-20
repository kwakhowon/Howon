package practice_0320;
/*
 기본급(pay) : 1500000
시간수당(o_time) : 55000
세금(tax) : 기본급의 10%

일때  실수령액(t_pay)를 구하시오.
(실수령액 = 기본급 + 시간수당 - 세금)
--출력--
실수령액 : 1405000원
 */
public class example2 {
	public static void main(String[] args) {
		int pay = 1500000;
		int o_time = 55000;
		int tax = pay/10;
		
		int t_pay = pay+o_time - tax;
		System.out.println(t_pay);
	}
}
