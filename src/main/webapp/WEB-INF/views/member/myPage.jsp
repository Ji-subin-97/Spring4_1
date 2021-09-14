<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Mypage Page</title>
		<c:import url="../temp/header.jsp"></c:import>
	</head>
	<body>
		<c:import url="../temp/nav.jsp"></c:import>
		<h1>My Page</h1>
		<h1>ID : ${member.id}</h1>
		<h1>NAME : ${member.name}</h1>
		<h1>EMAIL : ${member.email}</h1>
		<h1>PHONE : ${member.phone}</h1>
		<div>
			<img src="../resources/upload/member/${files.fileName}">
		</div>
		
		<h1><a href="./update">정보수정</a></h1>
		<h1><a href="./delete?id=${member.id}" onclick="confirm();">회원탈퇴</a></h1><br>
		
		
		
		
		
		<!-- 학원 과제 -->
		<p>
		1. request : 메서드 공부
		2. session : 내장객체 메서드 공부
		3. 회원 가입 완성
		4. QnA 하고 Notice 에서 글쓰기 버튼을 로그인 한사람만 보일 수 있게
		5. 글쓰기 할때 작성자에 내 아이디가 미리 들어가있어야함
		6. 마이페이지 정보수정, 회원탈퇴
		</p>
		<!--  -->
		
		<script type="text/javascript">
			function confirm() {
				confirm("정말로 삭제하시겠습니까?");
			}
		</script>
	</body>
</html>