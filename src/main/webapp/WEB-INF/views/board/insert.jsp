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
		<div class="container-fluid">
	
				<form id="frm" class="col-md-6 mx-auto" action="./insert" method="post" >
				  <div class="mb-3">
				    <label for="title" class="form-label">TITLE</label>
				    <input type="text" class="form-control" name="title" id="title" placeholder="Enter Title">
				    <div id="t_1" class="er"></div>
				  </div>
				  
				  <div class="mb-3">
				    <label for="writer" class="form-label">Writer</label>
				    <input type="text" class="form-control" name="writer" id="writer" placeholder="Enter Writer">
				    <div id="w_1" class="er"></div>
				  </div>
				  
				  <div class="mb-3">
				   <label for="exampleFormControlTextarea1" class="form-label">Contents</label>
		  			<textarea class="form-control" cols=""  name="contents" id="exampleFormControlTextarea1" rows="6"></textarea>
				  </div>
				 	
				  <button id="btn" type="button" class="btn btn-primary">ADD</button>
				</form>
			
		</div>
		<!-- <form id="frm" action="./insert" method="POST" class="col-md-6 mx-auto my-0" >
			<div class="container-fluid">
					<table class="table table-dark table-striped" style="text-align:center">
						<tr>
							<td>제목</td>
							<td>
								<input id="title" type="text" name="title">
								<div id="check_title" style="color:red; display:none;"></div>
							</td>
						</tr>
						<tr>
							<td>내용</td>
							<td>
								<textarea rows="10" cols="50" name="contents">
								</textarea>
							</td>
						</tr>
						<tr>
							<td>작성자</td><td><input id="writer" type="text" name="writer"></td>
						</tr>
						<tr>
							<td colspan="2"><button id="submit" type="button">작성하기</button></td>
						</tr>
					</table>
			</div>
		</form>
		 -->
	<script type="text/javascript" src="../resources/js/boardCheck.js"></script>
	</body>
</html>