import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.bit.utils.SingletonHelper;

/*
create table trans_A(
  num number,
  name varchar2(20)
);

create table trans_B(
  num number constraint pk_trans_B_num primary key,
  name varchar2(20)
);

JDBC >> default(dml) >> autocommit

trans_A , trans_B 하나의 논리적인 단위 (transaction 처리)

JDBC >> autocommit >> false >> 개발자는 반드시 >> commit , rollback
*/
public class Ex08_Oracle_Transaction {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		conn = SingletonHelper.getConnection("oracle");
		
		String sql = "insert into trans_A(num,name) values(100,'A')";
		String sql2 = "insert into trans_B(num,name) values(100,'B')";
		
		try {
			conn.setAutoCommit(false); // APP commit , rollback 강제
			//begin tran
			pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
			
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.executeQuery();
			//end tran
			conn.commit(); // 둘다 정상적으로 실행되고 예외가 발생하지 않으면 .....
		}catch(Exception e) {
			//예외처리 부분
			System.out.println("문제 발생 : " +e.getMessage());
			conn.rollback();
		}finally {
			SingletonHelper.close(pstmt2);
			SingletonHelper.close(pstmt);
		}
	}
}
