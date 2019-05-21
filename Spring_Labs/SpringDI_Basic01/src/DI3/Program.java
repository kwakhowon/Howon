package DI3;

public class Program {
  public static void main(String[] args) {
    //NewRecordView view = new NewRecordView(100,70,80);
    
    NewRecordView view = new NewRecordView();
    NewRecord record = new NewRecord();
    
    view.setRecord(record);
    view.input();
    view.print();
  }
}
