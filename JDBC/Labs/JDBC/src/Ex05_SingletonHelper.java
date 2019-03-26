import java.sql.Connection;
import java.sql.SQLException;

import kr.or.bit.utils.ConnectionHelper;
import kr.or.bit.utils.SingletonHelper;

public class Ex05_SingletonHelper {

    public static void main(String[] args) throws SQLException {
        //Singleton 사용
        //객체간 공유 자원 (conn 객체)
        //공유자원값에 변화에 다른 모든 놈도 변화 ...
        
        //conn.close(); 연결 해제
        //conn 객체의 주소값을 null값으로 만든 것은 아니다
        //APP 종료될떄까지 singleton >> conn 은 연결해제 하지 않는다
        
        Connection conn = null;
        conn = SingletonHelper.getConnection("oracle");
        System.out.println(conn.toString());
        System.out.println(conn.getMetaData().getDatabaseProductName());
        System.out.println(conn.getMetaData().getDatabaseProductVersion());
        System.out.println(conn.isClosed());
        //ConnectionHelper.close(conn);
        //System.out.println(“연결여부 : ” + conn.isClosed());
        
        //다시 연결
        Connection conn2 = null;
        conn2 = SingletonHelper.getConnection("oracle");
        System.out.println(conn2.toString());
        System.out.println(conn2.getMetaData().getDatabaseProductName());
        System.out.println(conn2.getMetaData().getDatabaseProductVersion());
        System.out.println(conn2.isClosed());
        //ConnectionHelper.close(conn2);
        //System.out.println(“연결여부 : ” + conn2.isClosed());
    
        /*
         검증 싱글톤 ...
         oracle.jdbc.driver.T4CConnection@4aa8f0b4
         oracle.jdbc.driver.T4CConnection@4aa8f0b4
         */
        SingletonHelper.dbClose();
        Connection myconn = null;
        myconn = SingletonHelper.getConnection("mysql");
        System.out.println(myconn.toString());
        System.out.println(myconn.getMetaData().getDatabaseProductName());
        System.out.println(myconn.getMetaData().getDatabaseProductVersion());
        System.out.println(myconn.isClosed());

    }

}