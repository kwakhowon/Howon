import kr.or.bit.Pclass;

//접근자(제어자) : default , private , public , 상속관계에protected
//상속관계에서만 존재
//양면성 : default , public(상속관계에서)

//상속관계에서 protected (자식 클래스 안쪽 함수만......)

//why ?  class Car{ Protected void turn(){} }
//나를 상속하는 당신이 자원을 재정의 했으면 좋겠는데 ... (의도) 굳이 안해도 되고....

class Child2 extends Pclass{
	void method() {
		this.p = 1000; // 상속관계에서 Protected >> public
		System.out.println(this.p);
	}
}


public class Ex08_Inherit_Protected {
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public static void main(String[] args) {
		Pclass pc = new Pclass();
		System.out.println("다른 폴더에서는 public : " +pc.j);
		
		Child2 ch = new Child2();
		ch.method();
	}
}
