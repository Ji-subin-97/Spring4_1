<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<c:import url="../temp/header.jsp"></c:import>
	</head>
	<body>
		<c:import url="../temp/nav.jsp"></c:import>
		<h1>Check Page</h1>
		
		<div class="container-fluid">
			<div class="form-check">
			  <input class="chk" type="checkbox" id="all">
			  <label class="form-check-label" for="all">
			    Check ALL
			  </label>
			</div>
			<div class="form-check">
			  <input class="checks" type="checkbox" id="flexCheckDefault">
			  <label class="form-check-label" for="flexCheckDefault">
			    약관 1
			  </label>
			</div>
			<div class="form-check">
			  <input class="checks" type="checkbox" id="flexCheckDefault">
			  <label class="form-check-label" for="flexCheckDefault">
			    약관 2
			  </label>
			</div>
			  <div class="form-check">
			  <input class="checks" type="checkbox" id="flexCheckDefault">
			  <label class="form-check-label" for="flexCheckDefault">
			    약관 3
			  </label>
			</div>
			<div class="form-check">
			  <input class="checks" type="checkbox" id="flexCheckDefault">
			  <label class="form-check-label" for="flexCheckDefault">
			    약관 4
			  </label>
			</div>
			
			<button id="btn">동의 하기</button>
			
		</div>
		
		<!-- 자바 스크립트 선언 부분 -->
		<script type="text/javascript" src="../resources/js/member_check.js"></script>
	</body>
</html>