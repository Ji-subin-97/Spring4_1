<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert</title>
		<c:import url="../temp/header.jsp"></c:import>
	</head>
	<body>
	
		<c:import url="../temp/nav.jsp"></c:import>
		
		<h1>Insert Page 입니다.</h1>
		<form action="./insert" method="POST" class="col-md-4 mx-auto my-0">
			<div class="container-fluid">
					<table class="table table-dark table-striped" style="text-align:center">
						<tr>
							<td>제목</td><td><input type="text" name="title"></td>
						</tr>
						<tr>
							<td>내용</td>
							<td>
								<textarea rows="10" cols="50" name="contents">
								</textarea>
							</td>
						</tr>
						<tr>
							<td>작성자</td><td><input type="text" name="writer" value="${member.id}" readonly></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="작성하기"></td>
						</tr>
					</table>
			</div>
		</form>
		
	</body>
</html>