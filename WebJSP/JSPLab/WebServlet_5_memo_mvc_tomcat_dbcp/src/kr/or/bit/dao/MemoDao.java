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

import kr.or.bit.dto.Memo;

// CRUD 작업
// DB서버 통신 > CRUD method 제공
// memo table > select, insert, update, delete 함수 제공
// select(다중, 단일), insert, update, delete 5개 함수가 기본

// CRUD 함수 생성 (parameter, return type) 고민
// parameter 객체 (DTO 타입)
// return 객체, 문자열 return

// public int insertMemo(String id, String email, String content) {}
// public int insertMemo(Memo memo) {}

// 단일 select
// public Memo selectByMemoID(String id) {}

// 다중 select
// public List<Memo> selectMemo() {}
// List<Memo> list = new ArrayList<>();
public class MemoDao {
  private Connection conn;
  private PreparedStatement pstmt;
  private ResultSet rs;
  private DataSource ds;

  public MemoDao() throws SQLException, NamingException {
    Context context = new InitialContext(); // 이름 기반 검색
    ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); // jdbc/oracle 이름의 pool을 찾음   
  }

  public List<Memo> selectAll() throws SQLException {
    List<Memo> list = new ArrayList<Memo>();
    String sql = "select * from memo";

    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        Memo memo = new Memo();
        memo.setId(rs.getString("id"));
        memo.setEmail(rs.getString("email"));
        memo.setContent(rs.getString("content"));
        list.add(memo);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      rs.close();
      pstmt.close();
      conn.close();
    }

    return list;
  }

  public Memo selectById(String id) throws SQLException {
    Memo memo = null;
    String sql = "select * from memo where id = ?";

    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        memo = new Memo();
        memo.setId(rs.getString("id"));
        memo.setEmail(rs.getString("email"));
        memo.setContent(rs.getString("content"));
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      rs.close();
      pstmt.close();
      conn.close();
    }

    return memo;
  }

  public int insertMemo(Memo memo) {
    Connection conn = null;
    int row = 0;
    String sql = "insert into memo (id, email, content) values (?, ?, ?)";

    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, memo.getId());
      pstmt.setString(2, memo.getEmail());
      pstmt.setString(3, memo.getContent());

      row = pstmt.executeUpdate();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        pstmt.close();
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    return row;
  }
  
  public String hasId(String id) {
    Connection conn = null;
    String hasId = "false";
    String sql = "select id from memo where id = ?";
    
    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      rs = pstmt.executeQuery();
      
      if (rs.next()) {
        hasId = "true";
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        rs.close();
        pstmt.close();
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    
    return hasId;
  }
}