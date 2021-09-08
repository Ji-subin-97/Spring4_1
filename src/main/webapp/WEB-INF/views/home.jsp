<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> --%>




<html>
	<head>
		<title>Index Page</title>
		<link href="./resources/css/home.css" rel="stylesheet">
	</head>
	<c:import url="./temp/header.jsp"></c:import>
	<body>
		
		<c:import url="./temp/nav.jsp"></c:import>
		
		<h1 class="c1">Home Page 입니다.</h1>
		
		<h1 id="d1">Other Home Page 입니다.</h1>
		
		<div id="d2">
			<h3>In Div</h3>
		</div>
	
		
		<img id ="d3" alt="" src="./resources/images/01.jpg" class="c1" width="200px" height="300px">
		
		<div>
			<button onclick="fn1()">Click</button>
		</div>
		
		<script type="text/javascript" src="./resources/js/home.js"></script>
		<script type="text/javascript" src="./resources/js/function_1.js"></script>
	</body>
</html>
