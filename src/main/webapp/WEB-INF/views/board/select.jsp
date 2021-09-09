<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Select</title>
		<c:import url="../temp/header.jsp"></c:import>
	</head>
	<body>
		<c:import url="../temp/nav.jsp"></c:import>
		
		<div class="container-fluid">
			<c:choose>
				<c:when test="${board eq 'NOTICE'}">
					<h1>TITLE : ${dto.title}</h1>
					<h1>CONTENTS : ${dto.contents}</h1>
					<h1>WRITER : ${dto.writer}</h1>
					<h1>REGDATE : ${dto.regDate}</h1>
					<h1>HITS : ${dto.hits}</h1>
					<h1><a href="./delete?num=${dto.num}">삭제하기</a></h1>
					<h1><a href="./update?num=${dto.num}">수정하기</a></h1>
				</c:when>
				<c:otherwise>
					<h1>TITLE : ${dto.title}</h1>
					<h1>CONTENTS : ${dto.contents}</h1>
					<h1>WRITER : ${dto.writer}</h1>
					<h1>REGDATE : ${dto.regDate}</h1>
					<h1>HITS : ${dto.hits}</h1>
					<h1><a href="./delete?num=${dto.num}">삭제하기</a></h1>
					<h1><a href="./update?num=${dto.num}">수정하기</a></h1>
					<h1><a href="./reply?num=${dto.num}">답글달기</a></h1>
				</c:otherwise>
			</c:choose>	
		</div>
		
		<div>
			<input type="checkbox" class="c1" value="1">
			<input type="checkbox" class="c1" value="2">
			<input type="checkbox" class="c1" value="3">
			<input type="checkbox" class="c1" value="4">
		</div>
		
		<button id="btn">CHECK</button>
		
		<script type="text/javascript" src="../resources/js/select.js"></script>
	</body>
</html>