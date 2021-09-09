<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>List</title>
	<c:import url="../temp/header.jsp"></c:import>
	<style>
		.block:first-child{
			display: inline-block;
			width: 29.5%;
		}
		.block:nth-child(2){
			display: inline-block;
			width: 69.5%;
		}
	</style>
</head>
<body>
	<c:import url="../temp/nav.jsp"></c:import>
	<h1>${board} Board List Page</h1>
	
	<div class="col-md-7 my-2 mx-auto">	
	
		<!-- 검색 -->
			
			<div class="row">
				<form action="./list" method="get">
					<div class="block">
						<select class="form-select input-group mb-3" name="kind" aria-label="Default select example">
						  <option selected>==선택==</option>
						  <option value="num">Num</option>
						  <option value="title">Title</option>
						  <option value="contents">Contents</option>
						</select>
					</div>
					
					<div class="block">
						<div class="input-group mb-3">
						  <input type="text" name="search" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2">
						  <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Search</button>
						</div>
					</div>
				</form>
			</div>
			
		<!-- 검색 끝 -->
		
		<table class="table table-dark table-striped">
		  <thead>
		    <tr>
		    	<c:choose>
		    		<c:when test="${board eq 'NOTICE'}">
	    			  <th scope="col">NUM</th>
				      <th scope="col">TITLE</th>
				      <th scope="col">WRITER</th>
				      <th scope="col">REGDATE</th>
				      <th scope="col">HITS</th>
		    		</c:when>
		    		<c:otherwise>
		    		  <th scope="col">NUM</th>
				      <th scope="col">TITLE</th>
				      <th scope="col">WRITER</th>
				      <th scope="col">REGDATE</th>
				      <th scope="col">HITS</th>
				      <th scope="col">REF</th>
				      <th scope="col">STEP</th>
				      <th scope="col">DEPTH</th>
		    		</c:otherwise>
		    	</c:choose>
		    </tr>
		  </thead>
		  <tbody>
	  		<c:forEach items="${list}" var="dto">
			    <tr>
			      <th scope="row">${dto.num}</th>
			      <td><a class="c1" href="./select?num=${dto.num}">${dto.title}</a></td>
			      <td>${dto.writer}</td>
			      <td>${dto.regDate}</td>
			      <td>${dto.hits}</td>
			      <c:if test="${board eq 'QNA'}">
			      	<td>${dto.ref}</td>
			      	<td>${dto.step}</td>
			      	<td>${dto.depth}</td>
			      </c:if>
			    </tr>
			</c:forEach>
		  </tbody>
		</table>
		<!-- Paging -->
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
			    <li class="page-item">
			      <a class="page-link" href="./list?kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    
			    <li class="page-item">
			      <a class="page-link" href="./list?pn=${pager.startNum - 1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
			        <span aria-hidden="true">&lt;</span>
			      </a>
			    </li>
			    
			    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="n">
			    	<li class="page-item"><a class="page-link" href="./list?pn=${n}&kind=${pager.kind}&search=${pager.search}">${n}</a></li>
			    </c:forEach>
			    
			   	<li class="page-item">
			      <a class="page-link" href="./list?pn=${pager.lastNum + 1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
			        <span aria-hidden="true">&gt;</span>
			      </a>
			    </li>
			    
			    <li class="page-item">
			      <a class="page-link" href="./list?pn=${pager.totalPage}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
		
		<a href="./insert" class="btn btn-outline-primary">글 작성하기</a>
		<button id="btn">CLICK</button>
	</div>
	
	
	<script type="text/javascript" src="../resources/js/list.js"></script>
</body>
</html>