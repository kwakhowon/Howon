package DI_Annotation_04;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
public class MonitorViewer {
  /*
  1단계 xml 설정 기반으로 DI 작업 
  private Recorder recorder;

  public Recorder getRecorder() {
    return recorder;
  }

  public void setRecorder(Recorder recorder) {
    this.recorder = recorder;
  }
  */
  
  //2단계 : Annotation 기반 DI 작업(injection : 생성자 주입 , setter 주입)
  //cnrkwjrdmfh member field 도 injection 가능하다
  
  //Autowired : IOC 컨데이너 안에 Recorder 타입을 가진 객체가 있다면
  //자동으로 그 객체의 주소를 받겠다.
  //Recorder r = new Recorder(); 
  //recorder = r;
  
  //property name="recorder">
  //<ref bean="recorder"/>
  //</property>
  
  private Recorder recorder;

  public Recorder getRecorder() {
    return recorder;
  }

  //@Autowired 예외 (같은 타입의 객체 여러개)
  @Resource(name="zz") //by name (같은 타입이 여러개 있더라도 name 하나 선택)
  public void setRecorder(Recorder recorder) {
    this.recorder = recorder;
    System.out.println("setter 주입 성공 : "+recorder);
  }




  
}
