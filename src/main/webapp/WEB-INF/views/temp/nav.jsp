<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav nav class="navbar navbar-expand-lg navbar-light" style="background-color: #E8D9FF;">
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
        
        
        <!-- <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a> -->
      </div>
    </div>
  </div>
</nav>