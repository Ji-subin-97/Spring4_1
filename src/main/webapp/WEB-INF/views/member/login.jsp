<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login Page</title>
		<c:import url="../temp/header.jsp"></c:import>
	</head>
	<body>
		<c:import url="../temp/nav.jsp"></c:import>
		<h1>Login Page</h1>
		<div class="container-fluid">
			<form action="join" method="post" name="frm" onsubmit="return checkForm()">
			
			  <div class="col-md-6 mb-3 mx-auto">
			    <label for="exampleInputEmail1" class="form-label">아이디</label>
			    <input type="text" id="ids" name="id" class="form-control">
			  </div>
			  
			  <div class="col-md-6 mb-3 mx-auto">
			    <label for="exampleInputPassword1" class="form-label">비밀번호</label>
			    <input type="password" name="pw" class="form-control">
			  </div>
			  
			  <div class="col-md-6 mx-auto">
			  	<button id="btn" type="submit" class="btn btn-primary">Login</button>
			  </div>
			  
			</form>
		</div>
	</body>
</html>