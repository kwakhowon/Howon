import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
1. 드라이버 참조 (jar 추가)
2. 드라이버 로딩 (JVM : Class.forName())
3. 연결객체 생성 -> DriverManager 클래스
4. 명령객체 생성 -> CRUD 작업 준비 (Statement)
5. 명령실행 -> DQL(select 1건, select multi row) -> return ResultSet 객체
			DML(insert, update, delete) -> 결과 집합(ResultSet(X)) -> 성공유무
6. 명령처리 (2가지) : DQL(화면출력) . DML(결과에 따른 처리 (성공, 실패))
7. 자원해제

JDBC API (인터페이스) : 표준화된 코드 사용 (다형성기반)
Connection
Statement
PrepareStatement
ResultSet
 */
public class Ex02_MariaDB_Connection {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// 2. 드라이버 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("MariaDB");

			// 3. 연결객체 생성
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sampledb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=true",
					"root", "1004");
			System.out.println(conn.isClosed());

			// 4. 명령객체 생성
			stmt = conn.createStatement();

			// 4.1 실행문장
			String job = "";
			Scanner sc = new Scanner(System.in);
			System.out.println("직종 입력 : ");
			job = sc.nextLine();
			// where job = 'CLERK'
			String sql = "select empno, ename, job from emp where job='" + job + "'";

			// 5 . 명령 실행
			// DQL (select) > stmt.executeQuery(sql) > return ResultSet 객체의 주소
			// DML (insert , delete, update) > 결과집합(x) > 반영결과 (반영된 행의 수)
			// stmt.executeUpdate() >> return 반영된 행의 수
			// delete from emp; >> 14리턴

			rs = stmt.executeQuery(sql);
			// 6. 명령처리
			// DQL : 1. 결과가 없는 경우 (where empno = 9999)
			// 2. 결과가 1건인 경우 (PK , Unique 걸려 있는 컬럼 : where empno = 7788)
			// 3. 결과가 여러개의 경우 >> select * from emp where deptno = 20
			// while(rs.next()) {
			// System.out.println(rs.getInt("empno") + "," + rs.getString("ename") + "," +
			// rs.getString("job"));
			// }
			// 1. 간단하다(단순)
			// 2. 결과 집합이 없는 경우 로직에 대한 처리가 안되요
//			if(rs.next()) {
//                System.out.println(rs.getInt("empno") + "," + rs.getString("ename") + "," + rs.getString("job"));
//            } else {
//                System.out.println("조회된 데이터가 없습니다");
//            }
			// 두개의 정점 로직 만들어 보세요 (공식같이 쓰이는 로직)
			// 1. 결과 집합이 없는 경우 처리 가능
			// 2. Single row Read
			// 3. Multi row Read
			// 위 3가지를 만족하는 코드 생성
			if (rs.next()) {
				// 강제 do~while
				do {
					System.out.println(rs.getInt("empno") + "," 
									 + rs.getString("ename") + "," 
									 + rs.getString("job"));
				} while (rs.next());
			} else {
				System.out.println("데이터가 없습니다.");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			/*
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			*/
			if(rs != null) try {rs.close();} catch(Exception e) { e.printStackTrace();}
			if(stmt != null) try {stmt.close();} catch(Exception e) { e.printStackTrace();}
			if(conn != null) try {conn.close();} catch(Exception e) { e.printStackTrace();}
		}

	}

}