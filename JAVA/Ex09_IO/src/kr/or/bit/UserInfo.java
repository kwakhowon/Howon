package kr.or.bit;

import java.io.Serializable;
/*
객체를 주고 받는 방법 (객체 통신)
파일간에 ... (파일에다 객체를 write , 그 파일을 read)

직렬화 (객체를 ㅂ문해해서 줄을 세워 보내는 과정)

실습) 
대상 : 퍄일(txt)

객체를 파일에다 write (직렬화)
파일을 read(역직렬화)

*/
//조건 (객체 통신) 설계도는 반드시 implements Serializable 구현
public class UserInfo implements Serializable{
	public String name;
	public String pwd;
	public int age;
	
	public UserInfo() {}
	public UserInfo(String name, String pwd, int age) {
		this.name = name;
		this.pwd = pwd;
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", pwd=" + pwd + ", age=" + age + "]";
	}
	
}
