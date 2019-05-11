<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="emp" value="${requestScope.emp}" />
<c:set var="mgrList" value="${requestScope.mgrList}" />
<c:set var="jobList" value="${requestScope.jobList}" />
<c:set var="deptList" value="${requestScope.deptList}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 수정</title>
<link rel="stylesheet" href="../css/update.css">
</head>
<body>
  <nav>
    <div class = "wrap">
    <a href = "list.do">
    <img src = "../picture/icon/groot.png" class = "logo"></a>
    <h1>(주)GROOT</h1>
    <ul>
      <li><a href="regInput.do">사원 등록</a></li>
      <li><a href="chart.do">사원 통계</a></li>
    </ul>
    <ul>
  		<li class="user"><%= session.getAttribute("id") %>님</li>
  		<li><a class="user" href="logout.do">로그아웃</a> </li>
  	</ul>
  </div>
  </nav>
  <form action="update.do" method="POST">
    <span class="label">사번</span><input type="text" name="empno" value="${emp.empno}" class="text" readonly><br>
    <span class="label">이름</span><input type="text" name="ename" value="${emp.ename}" class="text"><br>
    <span class="label">직종</span>
    <select name="job" class="select">
      <c:forEach var="job" items="${jobList}">
      <option value="${job}">${job}</option>
      </c:forEach>
    </select><br>
    <span class="label">관리자 사번</span>
    <select name="mgr" class="select">
      <option value="0">관리자 없음</option>
      <c:forEach var="mgr" items="${mgrList}">
      <option value="${mgr}">${mgr}</option>
      </c:forEach>
    </select><br>
    <span class="label">입사일</span><input type="text" name="hiredate" value="${emp.hiredate}" class="text" readonly><br> 
    <span class="label">월급</span><input type="text" name="sal" value="${emp.sal}" class="text"><br> 
    <span class="label">커미션</span><input type="text" name="comm" value="${emp.comm}" class="text"><br> 
    <span class="label">부서 번호</span>
    <select name="deptno" class="select">
      <c:forEach var="deptno" items="${deptList}">
      <option value="${deptno}">${deptno}</option>
      </c:forEach>
    </select><br>
   <input type="submit" value="수정하기" class="button"><br> 
   <a class="emplink" href="list.do">&lt; 취소하고 돌아가기</a><br>
  </form>
</body>
</html>