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
		<c:import url="./temp/nav.jsp"></c:import>
		<h1>Home Page 입니다.</h1>
		
		<c:if test="${not empty member}">
		
			<h3><font color="green">Login이 성공 했을때 보이는 문장</font></h3>
		
		</c:if>
		
		<c:if test="${empty member}">
		
			<h3><font color="black">Login을 하기전 보이는 문장</font></h3>
		
		</c:if>
		
		<div>
			<table id="r" class="table table-hover">
				<tr>
					<td>ID</td>
					<td>TITLE</td>
					<td>USERID</td>
				</tr>
			</table>
		</div>
		<button id="btn">CLICK</button>
		
		<script type="text/javascript">
			$("#btn").click(function() {
				$.ajax({
					type: "GET",
					url: "http://jsonplaceholder.typicode.com/posts",
					success: function(result) {
						console.log(result);
						console.log(result[0]);
						console.log(result[0].title);
						
						for(v1 of result){
							$("#r").append("<tr><td>"+ v1.id +"</td><td>"+ v1.title +"</td><td>"+ v1.userId +"</td></tr>");
						}
					}
					
				});
			});
		</script>
	</body>
</html>
