<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	#header{
		position: fixed;
		top:0;
		left:0;
		right:0;
	}
</style>
<div id="header">
	<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #E8D9FF;">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">SUBIN HOME</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
	      <div class="navbar-nav">
	        <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}">Home</a>
	        <a class="nav-link" href="${pageContext.request.contextPath}/notice/list">Notice</a>
	        <a class="nav-link" href="${pageContext.request.contextPath}/qna/list">QNA</a>
	        
	        <c:choose>
	        	<c:when test="${not empty member}">
	        		<a class="nav-link" href="${pageContext.request.contextPath}/member/myPage">MyPage</a>
	       			<a class="nav-link" href="${pageContext.request.contextPath}/member/logout">LogOut</a>
	        	</c:when>
	        	<c:otherwise>
	        		 <a class="nav-link" href="${pageContext.request.contextPath}/member/check">Join</a>
	        		 <a class="nav-link" href="${pageContext.request.contextPath}/member/login">Login</a>
	        	</c:otherwise>
	        </c:choose>
	        
	        <!-- <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a> -->
	      </div>
	    </div>
	  </div>
	</nav>
</div>
