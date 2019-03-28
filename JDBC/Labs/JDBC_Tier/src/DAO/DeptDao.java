package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.Dept;
import UTILS.SingletonHelper;

//DAO 
// 1. DB 연결
// 2. CRUD 작업 (함수)
// 3. method(select all , select where , insert, update, delete)
public class DeptDao {

	// 1. 전체조회 >> select 결과 >> return multi row
	public List<Dept> getDeptAllList() {
		// 여러건의 데이터 담는 클래스
		List<Dept> deptlist = new ArrayList<Dept>();
		// deptlist.add(new Dept());
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select deptno , dname, loc from dept";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Dept dept = new Dept(); // 하나의 row 담기 위한 객체
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				deptlist.add(dept); // 배열에 객체 담는 것

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}

		return deptlist;
	}

	// 2. 조건 조회 >> select 결과(where deptno=?) >> return single row
	public Dept getDeptListByDeptno(int deptno) {
		Dept dept = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select deptno , dname, loc from dept where deptno = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));

			}
			while (rs.next()) {
				System.out.println(dept.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
			SingletonHelper.close(rs);
		}

		return dept;

	}

	// 3. 데이터 삽입
	// public int insertDept(int deptno, String dname, String loc) ..(x)
	// insert into dept(deptno , dname, loc) values(?,?,?);
	public int insertDept(Dept dept) {
		int row = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "insert into dept(deptno , dname, loc) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			row = pstmt.executeUpdate();
			if (row > 0) {
				System.out.println("insert row count : " + row);
			} else {
				System.out.println("반영된 행의 수가 없습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
		return row;
	}

	// 4. 데이터 수정
	// update dept set dname=? loc=? where deptno=?;
	public int updateDept(Dept dept) {
		// update dept set dname=? , loc=? where deptno=?
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowcount = 0;

		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "update dept set dname=? , loc=? where deptno=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());

			rowcount = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}

		return rowcount;
	}

	// 5. 데이터 삭제
	public int deleteDept(int deptno) {
		// delete from dept where deptno=?
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowcount = 0;

		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "delete from dept where deptno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}

		return rowcount;

	}

}
