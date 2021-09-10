<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>idCheck Page</title>
		<c:import url="../temp/header.jsp"></c:import>
	</head>
	<body>
		<h1>Id Check Page</h1>
		
		<div id="idCheck_Result">
			${param.id}는
			<c:if test="${empty IDCheck}">
				<font color="green">사용 가능한 ID 입니다.</font>
			</c:if>
			<c:if test="${not empty IDCheck}">
				<font color="red">사용 불가능한 ID 입니다.</font>
			</c:if>
		</div>
		
		<form action="idCheck" method="get" name="frm" onsubmit="return checkForm()">
		  <div class="col-md-6 mb-3 mx-auto">
		    <label for="exampleInputEmail1" class="form-label">아이디</label>
		    <input type="text" id="ids" name="id" value="${param.id}" class="form-control">
		    <button type="submit" id="idCheck">ID 중복확인</button>
		    <c:if test="${empty IDCheck}">
			    <button type="button" id="useId" onclick="useID()">ID 사용</button>
			</c:if>
		  </div>
		</form>
		
		<script type="text/javascript">
			function useID() {
				let id = window.document.getElementById("ids").value;
				opener.document.getElementById("ids").value= id;
				close();
			}
		</script>
	</body>
</html>