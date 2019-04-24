package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.bit.dto.memo;
import kr.or.bit.utils.SingletonHelper;

//CRUD 작업
//DB서버 통신 > CURD 에 대한 method 제공
//memo table > select , insert , update , delete 함수 제공
//select > 다중행(select *  from memo) , 단일행 (where id=?)
//기본으로 5개 : + 알파(like , 다른 조건 조회)

//CURD 함수 생성 (paramter , return type) 고민
//parameter 객체(dto 타입) 
//return 객체 , 문자열 리턴

//public int insertmemo(String id, String email , String content){}

//public int insertmemo(memo m) { }  (0)

//단일 select
//public memo selectByMemoId(String id) {  .... where id=?}

//다중 select
//public List selectMemo(   select 한 데이터 >> 객체 담기  )
//List<memo> list = new ArrayList<>();
//return list
public class memodao {
	Connection conn = null;
	public memodao() {
		conn = SingletonHelper.getConnection("oracle");
	}
	
	//Read : 한건 데이터 (반드시 테이블에 primary key 컬럼 대상)
	public memo getMemoListById(String id) {
		//select id,email,content from memo where id=?
		//memo m = new memo();
		//m.setId(rs.getInt(1)); ....
		//return m;
		return null;
	}
	
	//Read : 여러건 데이터(where 조건이 없어요)
	public List<memo> getMemoList() throws SQLException{
		//select id,email,content from memo
		
		//Class.forName("oracle.jdbc.OracleDriver");
		//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","kosta","1004");
		//위 코드 생략
		
		PreparedStatement pstmt = null;
		String sql = "select id,email,content from memo";
		pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		List<memo> memolist = new ArrayList<>();
		//[] 
		while(rs.next()) {
			memo m = new memo();
			m.setId(rs.getString("id"));
			m.setEmail(rs.getString("email"));
			m.setContent(rs.getString("content"));
			memolist.add(m);
		}
		
		SingletonHelper.close(rs);
		SingletonHelper.close(pstmt);
		
		return memolist;
	}
	
	//parameter (memo m)
	//사실은 
	//public int insertMemo(memo m) {
	public int insertMemo(String id, String email, String content)  {
		//insert into memo(id,email,content) values(?,?,?)
		int resultrow=0;
		PreparedStatement pstmt = null;
		try {
			   
			   String sql="insert into memo(id,email,content) values(?,?,?)";
			   
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, id);
			   pstmt.setString(2, email);
			   pstmt.setString(3, content);
			   
			   resultrow = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("Insert :" + e.getMessage());
		}finally {
			SingletonHelper.close(pstmt);
		}
 
		return resultrow;
	}
	
	public int updateMemo(memo m) {
		//update memo set email=? , content=? where id=?
		return 0;
	}
	
	
	public int deleteMemo(String id) {
		//delete from memo where id=?
		return 0;
	}
	
	
	//추가함수 (비동기 통해서 ID 유무)
	public String isIdCheckById(String id) {
		String ismemoid= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
				String sql = "select id from memo where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					//do {
						//String id = rs.getString("id")
						ismemoid = "false";
						
					//}while(rs.next());
				}else {
						ismemoid = "true";
				}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		//System.out.println("ismemoid : " + ismemoid);
		return ismemoid;
	}
	
	//필요하다면 추가 구현 
	//Like 검색 함수  > 메일주소 like 검색 함수 
	//id,pwd 검사 함수 .... > id  , pwd 검증 하는 함수 .....
	
}
