import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
 
public class TEST {
       
        public static void main(String args[]) throws ParseException{
               
                //string containing date
        		String strDate = "2018-04-12 00:00:00";
       
                /*
                 * To convert String to java.sql.Date, use
                 * Date (long date) constructor.
                 *
                 * It creates java.sql.Date object from the milliseconds provided.
                 */
       
                //first convert string to java.util.Date object using SimpleDateFormat
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                java.util.Date date = sdf.parse(strDate);
                System.out.println("date : " + date );
                
                java.sql.Date sqlDate = new Date(date.getTime());
                java.sql.Timestamp sqlTDate = new Timestamp(date.getTime());
                System.out.println("String converted to java.sql.Date :" + sqlDate);
                System.out.println("String converted to java.sql.Timestamp :" + sqlTDate);
        }
       
}
