<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert</title>
		<c:import url="../temp/header.jsp"></c:import>
		<style type="text/css">
			.f{
				width: 90%;
			}
		</style>
	</head>
	<body>
	
		<c:import url="../temp/nav.jsp"></c:import>
		
		<h1>Insert Page 입니다.</h1>
		<form action="./insert" method="POST" class="col-md-10 mx-auto my-0">
			<div class="container-fluid">
					<table class="table table-dark table-striped" style="text-align:left">
						<tr>
							<td>제목</td><td><input type="text" name="title"></td>
						</tr>
						<tr>
							<td>내용</td>
							<td>
								<textarea rows="10" cols="90" name="contents">
								</textarea>
							</td>
						</tr>
						<tr>
							<td>작성자</td><td><input type="text" name="writer" value="${member.id}" readonly></td>
						</tr>
						<!-- 버튼 추가 -->
						<tr>
							<td>파일</td>
							<td>
								<button id="add_file" type="button" class="btn btn-primary mb-3">파일추가</button>
								<div id="fileAddResult"></div>
							</td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="작성하기"></td>
						</tr>
					</table>
			</div>
		</form>
		
		<script type="text/javascript" src="../resources/js/boardFile.js"></script>
	</body>
</html>