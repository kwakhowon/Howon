package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.Department;
import UTILS.SingletonHelper;

public class DepartmentDAO {
	public List<Department> getDepartmentAllList(){
		List<Department> departlist = new ArrayList<Department>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select deptno , dname from department";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Department depart = new Department();
				depart.setDeptno(rs.getInt("deptno"));
				depart.setDname(rs.getString("dname"));
				departlist.add(depart);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		return departlist;
	}
	public int insertDepart(Department depart) {
		int row = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "insert into department(deptno, dname) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, depart.getDeptno());
			pstmt.setString(2, depart.getDname());
			row = pstmt.executeUpdate();
			if(row > 0) {
				System.out.println("insert Complete");
			}else {
				System.out.println("반영되지 않았습니다.");
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(pstmt);
		}
		return row;
	}
	public int updateDepart(String dname, Department depart) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowcount = 0;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "update department set deptno = ? ,dname = ? where dname = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, depart.getDeptno());
			pstmt.setString(2,  depart.getDname());
			pstmt.setString(3, dname);
			
			rowcount = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(pstmt);
		}
		return rowcount;
	}
	
	public Department getDepartListByDname(String dname) {
		Department depart = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select deptno, dname from department where dname = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				depart = new Department();
				depart.setDeptno(rs.getInt("deptno"));
				depart.setDname(rs.getString("dname"));
			}
			while(rs.next()) {
				System.out.println(depart.toString());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(pstmt);
			SingletonHelper.close(rs);
		}
		return depart;
	}
	public int deleteDepart(int deptno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowcount = 0;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "delete from department where deptno =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rowcount = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(pstmt);
		}
		return rowcount;
	}
	public List<Department> getDepartListByString(String dname){
		List<Department> departList = new ArrayList<Department>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select deptno, dname from department where dname like ?";
			pstmt = conn.prepareStatement(sql);
			String str = "%" + dname + "%";
			pstmt.setString(1, str);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Department dept = new Department();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				departList.add(dept);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
			
		}
		return departList;
	}
}
