<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> --%>




<html>
	<head>
		<title>Index Page</title>
	</head>
	<c:import url="./temp/header.jsp"></c:import>
	<body>
		<script type="text/javascript">
			console.log('body Script');
		</script>
		<c:import url="./temp/nav.jsp"></c:import>
		<h1>Home Page 입니다.</h1>
		<h1>Member Branch</h1>
	</body>
</html>
