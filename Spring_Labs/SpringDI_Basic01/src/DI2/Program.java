package DI2;

import DI2.NewRecordView;

public class Program {
  public static void main(String[] args) {
    //NewRecordView view = new NewRecordView(100, 70, 80);
    
    NewRecordView view = new NewRecordView();
    
    //필요하다면
    NewRecord record = new NewRecord(100,60,80);
    
    view.setRecord(record); //필요한 객체의 주소 주입
    view.print();
  }
}
