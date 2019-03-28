import java.util.List;

import DAO.DeptDao;
import DTO.Dept;

/*
3-Tier 기반의 환경

APP 서버 구성 (MVC 패턴)
Model > DTO , DAO

View
controller
>> Program (화면 , 요청) main 에서 ......

Model >> [Service] >> DAO (DTO)
*/
public class Program {
	public static void main(String[] args) {

		// UI & 요청
		DeptDao dao = new DeptDao();
		System.out.println("[전체조회]");
		List<Dept> deptlist = dao.getDeptAllList();
		// 화면 구성
		if (deptlist != null) {
			for (Dept data : deptlist) {
				System.out.println(data.toString());
			}
		}
		System.out.println();
		System.out.println("[조건조회] dept = 30");
		Dept dept = dao.getDeptListByDeptno(30);
		if (dept != null) {
			System.out.println(dept.toString());
		} else {
			System.out.println("Select Fail");
		}
		System.out.println("[데이터 삽입]********");
		Dept insertdept = new Dept();
		insertdept.setDeptno(100);
		insertdept.setDname("IT");
		insertdept.setLoc("SEOUL");
		int insertrow = dao.insertDept(insertdept);
		if (insertrow > 0) {
			System.out.println("INSERT ROW : " + insertrow);
		} else {
			System.out.println("INSERT FAIL");
		}

		System.out.println("[방금전 INSERT 한 데이터 조회]********");
		deptlist = dao.getDeptAllList(); // 변경된 내용 다시 조회
		if (deptlist != null) {
			DeptPrint(deptlist);
		}

		System.out.println("[방금전 INSERT 한 데이터 수정하기]********");
		Dept updatedept = new Dept();
		updatedept.setDeptno(100);
		updatedept.setDname("IT_UP");
		updatedept.setLoc("SEOUL_UP");

		int updaterow = dao.updateDept(updatedept);
		if (updaterow > 0) {
			System.out.println("UPDATE ROW : " + updaterow);
		} else {
			System.out.println("UPDATE FAIL");
		}

		System.out.println("[방금전 UPDATE 한 데이터 조회]********");
		deptlist = dao.getDeptAllList(); // 변경된 내용 다시 조회
		if (deptlist != null) {
			DeptPrint(deptlist);
		}

		System.out.println("[방금전 UPDATE 한 데이터 삭제하기]********");
		int deleterow = dao.deleteDept(100);
		if (deleterow > 0) {
			System.out.println("DELETE ROW : " + deleterow);
		} else {
			System.out.println("DELETE FAIL");
		}

		System.out.println("[방금전 DELETE 한 데이터 조회]********");
		deptlist = dao.getDeptAllList(); // 변경된 내용 다시 조회
		if (deptlist != null) {
			DeptPrint(deptlist);
		}

	}

	public static void DeptPrint(Dept dept) {
		System.out.println(dept.toString());
	}

	public static void DeptPrint(List<Dept> list) {
		for (Dept data : list) {
			System.out.println(data.toString());
		}
	}

}