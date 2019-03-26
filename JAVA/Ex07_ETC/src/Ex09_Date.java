import java.text.SimpleDateFormat;
import java.util.Date;

 

public class Ex09_Date
{
  public static void main(String[] args) throws Exception
  {
     
    String reqDateStr = "201812121212"; //현재시간 
    Date curDate = new Date(); 
    
    //SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMddHHmm"); //요청시간을 Date로 parsing 후 time가져오기 
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm"); //요청시간을 Date로 parsing 후 time가져오기
    System.out.println(dateFormat.format(curDate));
    
    
    
    Date reqDate = dateFormat.parse(reqDateStr); 
    System.out.println("reqDateStr : " + reqDateStr);
    System.out.println("reqDate : " + reqDate);
    
    long reqDateTime = reqDate.getTime(); 
    //현재시간을 요청시간의 형태로 format 후 time 가져오기 
    
    curDate = dateFormat.parse(dateFormat.format(curDate)); 
    
    long curDateTime = curDate.getTime(); //분으로 표현 
    long minute = (curDateTime - reqDateTime) / 60000; 
    System.out.println("요청시간 : " + reqDate); 
    System.out.println("현재시간 : " + curDate); 
    System.out.println(minute+"분 차이");

 
    System.out.println(diffOfDate("20180101", "20180110"));
  }

 

  public static long diffOfDate(String begin, String end) throws Exception
  {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

 

    Date beginDate = formatter.parse(begin);
    Date endDate = formatter.parse(end);
    System.out.println("beginDate : " + beginDate);
 
    long diff = endDate.getTime() - beginDate.getTime();
    long diffDays = diff / (24 * 60 * 60 * 1000);

 

    return diffDays;
  }
}

