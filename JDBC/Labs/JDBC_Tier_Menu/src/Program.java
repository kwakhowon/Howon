import java.util.List;
import java.util.Scanner;

import DAO.DepartmentDAO;
import DTO.Department;

public class Program {
	public static DepartmentDAO dao = new DepartmentDAO();
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		while(true) {
		menu();
		}
	}
	
	private static String menu(){
		while(true) {
		DepartmentDAO dao = new DepartmentDAO();
		System.out.println("1. 부서목록 조회");
		System.out.println("2. 부서등록");
		System.out.println("3. 부서변경");
		System.out.println("4. 부서 삭제");
		System.out.println("5. 부서검색");
		System.out.println("6. 종료");
		Scanner sc = new Scanner(System.in);
		System.out.print("선택 : ");
		String choice = sc.nextLine();
		
		 switch (choice) {
		case "1":
		selectAllDepartment();
			break;
		case "2" :
			insertDepartment();
			break;
			
		case "3" :
			updateDepartment();
			break;
		case "4" :
			deleteDepartment();
			break;
		case "5" :
			searchDepartment();
			break;
		case "6" :
			System.exit(0);
			break;
		default:
			System.exit(0);
			break;
		}
		 return choice;
		}
	}
	
	private static void selectAllDepartment() {
		System.out.println("[전체 조회]");
		List<Department> departlist = dao.getDepartmentAllList();
		if(departlist != null) {
			for(Department data : departlist) {
				System.out.println(data.toString());
			}
		}
	}
	
	private static void insertDepartment() {
		System.out.println("데이터 삽입");
		Department insertdepart = new Department();
		System.out.println("부서 번호 :");
		int deptno = Integer.parseInt(sc.nextLine());
		insertdepart.setDeptno(deptno);
		System.out.println("부서 이름 : ");
		String dname = sc.nextLine();
		insertdepart.setDname(dname);
		int insertrow = dao.insertDepart(insertdepart);
		if(insertrow > 0) {
			System.out.println("Insertrow : " +insertrow);
		}else {
			System.out.println("Insert Fail");
		}
	}
	
	private static void updateDepartment() {
		System.out.print("변경할 부서명 : ");
		String dname2 = sc.nextLine();
		System.out.println(dao.getDepartListByDname(dname2));
		Department updatedepert = new Department();
		System.out.println("[변경할 부서 정보 입력]");
		System.out.println("부서 코드");
		int upDeptno = Integer.parseInt(sc.nextLine());
		System.out.print("부서 이름 : ");
		String upDname = sc.nextLine();
		updatedepert.setDeptno(upDeptno);
		updatedepert.setDname(upDname);
		int updaterow = dao.updateDepart(dname2, updatedepert);
		if(updaterow>0) {
			System.out.println("UPDATE ROW : " +updaterow);
		}else {
			System.out.println("UPDATE FAIL");
		}
	}
	
	private static void deleteDepartment() {
		System.out.print("삭제할 부서번호 : ");
		int deletedeptno = 0;
		deletedeptno = Integer.parseInt(sc.nextLine());
		int deleterow = dao.deleteDepart(deletedeptno);
		if(deletedeptno >0) {
			System.out.println("Delete row : " +deleterow);
		}else {
			System.out.println("Delete Fail");
		}
	}
	
	private static void searchDepartment() {
		System.out.print("검색할 부서명 입력 : ");
		String searchdname = sc.nextLine().toUpperCase();
		
		List<Department> dList = dao.getDepartListByString(searchdname);
		System.out.println("번호   부서명");
		for (Department d : dList) {
			System.out.println(d.getDeptno() + "  |  "  + d.getDname());
		}
	}
	
}
