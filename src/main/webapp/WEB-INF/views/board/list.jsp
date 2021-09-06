<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>List</title>
	<c:import url="../temp/header.jsp"></c:import>
</head>
<body>
	<c:import url="../temp/nav.jsp"></c:import>
	<h1>${board} Board List Page</h1>
	
	<div class="col-md-7 my-2 mx-auto">	
		<table class="table table-dark table-striped">
		  <thead>
		    <tr>
		      <th scope="col">NUM</th>
		      <th scope="col">TITLE</th>
		      <th scope="col">WRITER</th>
		      <th scope="col">REGDATE</th>
		      <th scope="col">HITS</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${list}" var="dto">
			    <tr>
			      <th scope="row">${dto.num}</th>
			      <td><a href="./select?num=${dto.num}">${dto.title}</a></td>
			      <td>${dto.writer}</td>
			      <td>${dto.regDate}</td>
			      <td>${dto.hits}</td>
			    </tr>
		   </c:forEach>
		  </tbody>
		</table>
		<!-- Paging -->
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			    <li class="page-item">
			      <a class="page-link" href="./list" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    
			    <li class="page-item">
			      <a class="page-link" href="./list?pn=${pager.startNum - 1}" aria-label="Previous">
			        <span aria-hidden="true">&lt;</span>
			      </a>
			    </li>
			    
			    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="n">
			    	<li class="page-item"><a class="page-link" href="./list?pn=${n}">${n}</a></li>
			    </c:forEach>
			    
			   	<li class="page-item">
			      <a class="page-link" href="./list?pn=${pager.lastNum + 1}" aria-label="Next">
			        <span aria-hidden="true">&gt;</span>
			      </a>
			    </li>
			    
			    <li class="page-item">
			      <a class="page-link" href="./list?pn=${pager.totalPage}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
	</div>
	
	

</body>
</html>