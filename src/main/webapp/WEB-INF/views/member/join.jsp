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
			<form action="join" method="post" enctype="multipart/form-data">
			  <div class="col-md-6 mb-3 mx-auto">
			    <label for="exampleInputEmail1" class="form-label">아이디</label>
			    <input type="text" id="id" name="id" class="form-control put">
			    <button type="button" id="idCheck">ID 중복확인</button>
			    <div id="idResult"></div>
			  </div>
			  <div class="col-md-6 mb-3 mx-auto">
			    <label for="exampleInputPassword1" class="form-label">비밀번호</label>
			    <input type="password" id="pw" name="pw" class="form-control put">
			  </div>
			  <div class="col-md-6 mb-3 mx-auto">
			    <label for="exampleInputPassword1" class="form-label">비밀번호 확인</label>
			    <input type="password" id="pw_check" name="pw_check" class="form-control put">
			    <div id="pwResult" style=""></div>
			  </div>
			  <div class="col-md-6 mb-3 mx-auto">
			    <label for="exampleInputPassword1" class="form-label">이름</label>
			    <input type="text" id="name" name="name" class="form-control put">
			  </div>
			  <div class="col-md-6 mb-3 mx-auto">
			    <label for="exampleInputPassword1" class="form-label">이메일</label>
			    <input type="email" id="email" name="email" class="form-control put">
			  </div>
			  <div class="col-md-6 mb-3 mx-auto">
				<label for="exampleInputPassword1" class="form-label">휴대폰 번호</label>
				<input type="tel" id="phone" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" name="phone" class="form-control put">
			  </div>
			  
			  <div class="col-md-6 mb-3 mx-auto" id="files">
			  	<button type="button" id="add" class="btn btn-info mb-3">File Add</button>
			  	<div class="col-md-12 mb-3 mx-auto">
					<input type="file" name="photo" class="form-control">
				</div>
			  	
			  	<!-- input file 추가 영역 -->
			  	<div id="addResult"></div>
			  	
			  </div>
			  
			  <div class="col-md-6 mx-auto">
			  	<button type="submit" id="btn" class="btn btn-primary">Submit</button>
			  </div>
			</form>
		</div>
		
		<!-- Form 끝 -->
		<!-- C:\Users\qls12\Desktop\STS\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Spring4_1\resources\upload\member\ -->
		
		<!-- <script type="text/javascript" src="../resources/js/member_join.js"></script>
		<script type="text/javascript" src="../resources/js/file.js"></script> -->
	</body>
</html>