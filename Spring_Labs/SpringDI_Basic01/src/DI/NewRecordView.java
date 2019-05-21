package DI;

public class NewRecordView {
  //점수 출력하는 클래스
  private NewRecord record;
  public NewRecordView(int kor, int eng, int math) {
    record = new NewRecord(kor, eng, math);
  }
  public void print() {
    System.out.println(record.total()+ " / " +record.avg());
  }
}
