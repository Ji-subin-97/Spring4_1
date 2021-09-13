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
		<h1>Join Page</h1>
		
		<!-- Form 시작 -->
		<div class="container-fluid">
			<form action="join" method="post" name="frm" onsubmit="return checkForm()">
			  <div class="col-md-6 mb-3 mx-auto">
			    <label for="exampleInputEmail1" class="form-label">아이디</label>
			    <input type="text" id="ids" name="id" class="form-control">
			    <button type="button" id="idCheck">ID 중복확인</button>
			    <div id="idResult"></div>
			  </div>
			  <div class="col-md-6 mb-3 mx-auto">
			    <label for="exampleInputPassword1" class="form-label">비밀번호</label>
			    <input type="password" name="pw" class="form-control">
			  </div>
			  <div class="col-md-6 mb-3 mx-auto">
			    <label for="exampleInputPassword1" class="form-label">비밀번호 확인</label>
			    <input type="password" name="pw_check" class="form-control">
			    <div id="pwResult" style=""></div>
			  </div>
			  <div class="col-md-6 mb-3 mx-auto">
			    <label for="exampleInputPassword1" class="form-label">이름</label>
			    <input type="text" name="name" class="form-control">
			  </div>
			  <div class="col-md-6 mb-3 mx-auto">
			    <label for="exampleInputPassword1" class="form-label">이메일</label>
			    <input type="email" name="email" class="form-control">
			  </div>
			  <div class="col-md-6 mb-3 mx-auto">
				<label for="exampleInputPassword1" class="form-label">휴대폰 번호</label>
				<input type="tel" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" name="phone" class="form-control">
			  </div>
			  <div class="col-md-6 mb-3 mx-auto form-check">
			    <input type="checkbox" class="form-check-input" id="exampleCheck1">
			    <label class="form-check-label" for="exampleCheck1">Check me out</label>
			  </div>
			  
			  <div class="col-md-6 mx-auto">
			  	<button type="submit" class="btn btn-primary">Submit</button>
			  </div>
			</form>
		</div>
		
		<!-- Form 끝 -->
		
		<script type="text/javascript" src="../resources/js/member_join.js"></script>
	</body>
</html>