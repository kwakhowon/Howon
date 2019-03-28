import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.or.bit.utils.SingletonHelper;

public class Ex07_Oracle_Prepare_DML {
	public static void main(String[] args) {
		//insert 
		//insert into dmlemp(empno, ename, deptno) values(?,?,?);
		
		//UPDATE
		//update dmlemp set ename=? , sal=? , job=? , deptno = ?
		//where empno = ?
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SingletonHelper.getConnection("oracle");
			//String sql = "insert into dmlemp(empno, ename, deptno) values(?,?,?)";
			String sql = "update dmlemp set ename=? , sal =? , job = ? ,deptno = ? where empno = ?";
			pstmt = conn.prepareStatement(sql);
			
			//parameter
			//pstmt.setInt(1, 5555);
			//pstmt.setString(2, "김유신");
			//pstmt.setInt(3, 10);
			
			pstmt.setString(1, "아무개");
			pstmt.setInt(2, 2000);
			pstmt.setString(3, "IT");
			pstmt.setInt(4, 3333);
			pstmt.setInt(5, 5555);
			//실행
			int row = pstmt.executeUpdate();
			if(row>0) {
				System.out.println("update row count : " +row);
			}else {
				System.out.println("반영된 행의 수가 없습니다." +row);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			SingletonHelper.close(pstmt);
			
		}
		
	}
}
