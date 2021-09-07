<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		<h1>List</h1>
		<table>
			<thead>
				<tr>
					<th>번호</th><th>제목</th><th>내용</th><th>작성자</th><th>작성일</th><th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="list" var="dto">
				<tr>
					<td>${dto.num}</td>
					<td>${dto.title}</td>
					<td>${dto.contents}</td>
					<td>${dto.writer}</td>
					<td>${dto.regdate}</td>
					<td>${dto.hits}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
	</html>