<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<div id="header">
			<div class="top-wrapper">
				<h1 id="logo"><a href="${pageContext.request.contextPath}/index.htm"><img src="" alt="로고" /></a></h1>
				<h2 class="hidden">메인메뉴</h2>
				<ul id="mainmenu" class="block_hlist">
					<li>
						<a href="">kosta가이드</a>
					</li>
					<li>
						<a href="" >kosta과정</a>
					</li>
					<li>
						<a href="" >kosta</a>
					</li>
				</ul>
				<form id="searchform" action="" method="get">
					<fieldset>
						<legend class="hidden">
							과정검색폼
						</legend>
						<label for="query">과정검색</label>
						<input type="text" name="query" />
						<input type="submit" class="button" value="검색" />
					</fieldset>
				</form>
				<h3 class="hidden">로그인메뉴</h3>
				<ul id="loginmenu" class="block_hlist">
					<li>
						<a href="${pageContext.request.contextPath}/index.htm">HOME</a>
					</li>
					<%-- 
					<li>
						<a href="${pageContext.request.contextPath}/joinus/login.htm">로그인</a>
					</li> 
					--%>
					
					<%-- 
					<c:if test="${empty pageContext.request.userPrincipal}">
						<li><a href="${pageContext.request.contextPath}/joinus/login.htm">로그인</a></li>
					</c:if> 
					<c:if test="${not empty pageContext.request.userPrincipal}">
						<li>
							<a href="${pageContext.request.contextPath}/logout">
									(${pageContext.request.userPrincipal.name})로그아웃
							</a>
						</li>
					</c:if> 
					--%>
		
					<%-- 
					3.x.x
					<se:authorize ifNotGranted="ROLE_USER">
						<li><a href="${pageContext.request.contextPath}/joinus/login.htm">로그인</a></li>
					</se:authorize>
					<se:authentication property="name" var="LoginUser" />
					<se:authorize ifAnyGranted="ROLE_USER,ROLE_ADMIN">
						<li><a href="${pageContext.request.contextPath}/logout">(${LoginUser})로그아웃</a></li>
					</se:authorize> 
					--%>
					
					<se:authorize access="!hasRole('ROLE_USER')">
						<li><a href="${pageContext.request.contextPath}/joinus/login.htm">로그인</a></li>
					</se:authorize>
					<se:authentication property="name" var="LoginUser" />
					<se:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
						<li><a href="${pageContext.request.contextPath}/logout">(${LoginUser})로그아웃</a></li>
					</se:authorize>
					
					<se:authorize access="!hasRole('ROLE_USER')">
					<li>
						<a href="${pageContext.request.contextPath}/joinus/join.htm">회원가입</a>
					</li>
					</se:authorize>
				</ul>
				<h3 class="hidden">회원메뉴</h3>
				<ul id="membermenu" class="clear">
				<se:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
					<li>
						<a href="${pageContext.request.contextPath}/joinus/memberconfirm.htm"><img src="${pageContext.request.contextPath}/images/menuMyPage.png" alt="마이페이지" /></a>
					</li>
				</se:authorize>
					<li>
						<a href="${pageContext.request.contextPath}/customer/notice.htm">
						<img src="${pageContext.request.contextPath}/images/menuCustomer.png" alt="고객센터" /></a>
					</li>
				</ul>
			</div>
</div>