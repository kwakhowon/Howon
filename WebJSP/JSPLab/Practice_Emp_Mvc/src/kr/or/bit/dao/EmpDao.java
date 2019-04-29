package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.Emp;

public class EmpDao {
	DataSource ds = null;

	public EmpDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}

	// selectAll
	public List<Emp> empListAll() throws SQLException {
		PreparedStatement pstmt = null;
		String sql = "select empno , ename, job from copyemp";

		Connection conn = ds.getConnection();

		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		List<Emp> emplist = new ArrayList<Emp>();

		while (rs.next()) {
			Emp emp = new Emp();
			emp.setEmpno("empno");
			emp.setEname("ename");
			emp.setJob("job");

			emplist.add(emp);
		}
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		conn.close();
		return emplist;
	}
	// Read

	// insert
	public int insertEmp(String empno, String ename, String job) {
		int resultrow = 0;
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			String sql = "insert into copyemp(empno,ename,job) values(?,?,?)";

			conn = ds.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empno);
			pstmt.setString(2, ename);
			pstmt.setString(3, job);

			resultrow = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return resultrow;
	}
	// delete

	// update
	public int updateEmp(Emp emp){
		int resultrow = 0;
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
		String sql = "update copyemp set job = ?, ename = ? where empno = ?";
		conn = ds.getConnection();
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, emp.getEmpno());
		pstmt.setString(2, emp.getEname());
		pstmt.setString(3, emp.getJob());
		
		resultrow = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultrow;
	}
}
