<%@page import="exam.ibatis.dto.SearchParamEmp"%>
<%@ page import="exam.ibatis.dao.UserDao" %>
<%@ page import="exam.ibatis.dto.Emp" %>
<%@ page import="exam.ibatis.dto.SearchParam" %>
<%@ page import="com.ibatis.sqlmap.client.SqlMapClient" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%

    //select * from emp where ename='smith' and deptno=10
    
	UserDao dao = new UserDao();
	SearchParam sp = new SearchParam();
	//1. where ename='SMITH'
	//sp.setEname("SMITH");
	//sp.setDeptno(0);
	
	//2. where deptno=10
    //   sp.setDeptno(10);
	
	//3. select * from emp
	//   nothing
	//  sp.setDeptno(0);  //** null 데이터 확인하자
	
    
	//4. where ename='SMITH' and deptno=10  (null 아니고 0 아닌 경우)
    //sp.setEname("SMITH");
    //sp.setDeptno(20);
    
    //List<Emp> emp = dao.list(sp);
    
    
    
    //SELECT * FROM emp WHERE empno IN(7788,7902,7369)
	List<Emp> emp = dao.Emplist();

%>
Row Count : <%= emp.size() %><br>
 <%
		for(Emp row : emp){
			out.print("Empno : " + row.getEmpno() +" / ");
			out.print("Ename : " + row.getEname() + "<br>");
		}

 %> 
</body>
</html>