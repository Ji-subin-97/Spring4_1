<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Update</title>
		<c:import url="../temp/header.jsp"></c:import>
	</head>
	<body>
		<c:import url="../temp/nav.jsp"></c:import>
		<h1>Notice Update Page 입니다.</h1>
		
		<form action="./update" method="POST" class="col-md-8 mx-auto my-0">
			<div class="container-fluid">
					<input type="hidden" name="num" value="${dto.num}">
					<table class="table table-dark table-striped" style="text-align:center">
						<tr>
							<td>제목</td><td><input type="text" name="title" value="${dto.title}"></td>
						</tr>
						<tr>
							<td>내용</td><td><textarea rows="30" cols="100" name="contents"></textarea></td>
						</tr>
						<tr>
							<td>작성자</td><td><input type="text" name="writer" value="${dto.writer}" readonly="readonly"></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="수정하기"></td>
						</tr>
					</table>
			</div>
		</form>
		
	</body>
</html>