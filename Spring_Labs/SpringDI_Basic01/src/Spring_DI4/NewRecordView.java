package Spring_DI4;

import java.util.Scanner;

public class NewRecordView implements RecordView{
  //점수 출력하기 위해서 ( NewRecord 객체를 필요)
  
  private NewRecord record;
  
  //1. [생성자]를 통해서 필요한 객체를 생성 or 주입 >> DI
  //2. 함수([setter])를 통해서 필요한 객체 주입 >> DI2
 
  //핵심 POINT
  //객체 참조할때 다형성 (인터페이스)
  public void setRecord(Record record) { //parameter Type : 인터페이스 
    //함수의 parameter를 통해서 NewRecord 객체의 주소
    this.record = (NewRecord) record;
  }
  @Override
  public void print() {
    System.out.println(record.total()+ " / " +record.avg());
  }
  @Override
  public void input() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Kor : ");
    record.setKor(scan.nextInt());
    
    System.out.println("Eng : ");
    record.setKor(scan.nextInt());
    
    System.out.println("Math : ");
    record.setKor(scan.nextInt());
    
  }
  
}
