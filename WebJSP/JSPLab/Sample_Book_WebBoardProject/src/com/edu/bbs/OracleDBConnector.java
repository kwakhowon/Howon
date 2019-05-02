package com.edu.bbs;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
/**
 * OracleDBConnector.java
 * Oracle Connection을 구현한 클래스
 * 여러 데이터베이스 사용을 위해 커넥션을 클래스로 분리한다.
 */
public class OracleDBConnector {
//  private static OracleDBConnector orclDbc = new OracleDBConnector();   // 1.바로 메모리 할당하는 방법
  private static OracleDBConnector orclDbc;
 
  // 외부에서의 인스턴스화를 막는다.
  private OracleDBConnector() {}
 
  // OracleDBConnector 인스턴스를 얻는 방법은 getInstance()메서드로 호출하는 방법뿐이다.
  public static OracleDBConnector getInstacne() {
    if (orclDbc == null) {
      orclDbc = new OracleDBConnector();    // 2.메모리에 할당되지 않았을 때 할당하는 방법
    }
    return orclDbc;
  }
 
  public Connection getConnection() throws ClassNotFoundException, SQLException {
    //Class.forName("oracle.jdbc.driver.OracleDriver");
    // core.log를 사용하게되면 쿼리 결과를 콘솔에 찍을 수 있다.
    Class.forName("core.log.jdbc.driver.OracleDriver");
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    Connection conn = DriverManager.getConnection(url, "bituser", "1004");
    return conn;
  }
}
