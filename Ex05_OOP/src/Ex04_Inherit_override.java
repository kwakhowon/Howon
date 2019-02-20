/*
Today Point : [상속관계]에서 override : 상속관계에서의 메서드 재정의
-상속관계에서 자식 클래스가 부모 클래스의 메서드의 재정의
-재정의 : 함수의 return과 parameter는 변화가 있으면 안된다. 내용만 변화
     : 틀의 변화가 아니라 내용의 변화 {함수의 실행 블럭 내용의 변화.}  

문법) 상속관계에서 ... 상속이 없으면 override는 없다.
1. 부모함수의 이름과 동일
2. 부모 함수의 parameter 동일
3. 부모함수의 return type 동일
4. 결국에는 { 괄호안의 내용 변화 }

*/
class Point2{
	int x = 4;
	int y = 5;
	String getPosition() {
		return "x : " +this.x + " y : " +this.y;
	}
}

//3개의 점이 필요하다
//2개의 점을 가지고 있는 설계도 ...
class Point3D extends Point2{
	int z = 6;	
	
	//String getPosition3d() { return null;}
	//또 하나의 이름을 가진 함수를 만들고 싶지 않아요
	//부모가 출력하는 함수를 가지고 있어요
	//부모가 출력하는 함수를 가지고 있어요
	//재정의....
	//재정의를 강제하는 방법
	//@Override 선언(Annotation)
	//Annotation : java code 만으로 전달할 수 없는 부가적인 정보
	//[컴파일러]나 [개발툴]에게 전달하는 기능
	
	//@Override : 재정의 검사 ... 컴파일러나 툴에게 정보 전달
	
	@Override 
	String getPosition() {
		return "x : " +this.x + " y : " +this.y + " z : " +this.z;
	}
}

public class Ex04_Inherit_override {
	public static void main(String[] args) {
		Point3D point = new Point3D();
		point.x = 3;
		point.y = 6;
		point.z = 9;
		String result = point.getPosition();
		System.out.println(result);
	}
}