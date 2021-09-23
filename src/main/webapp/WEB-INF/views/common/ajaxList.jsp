<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<table class="table table-dark table-striped">
	<c:forEach items="${comments}" var="comment">
		<tr>
			<td>${comment.commentNum}</td>
			<td>${comment.contents}</td>
			<td>${comment.writer}</td>
			<td>${comment.regDate}</td>
		</tr>
	</c:forEach>
</table>

<!-- Paging -->
<nav aria-label="Page navigation example">
  <ul class="pagination">    
    <li class="page-item">
      <span class="page-link n" data-comment-pn="1" aria-label="Previous">
        <span aria-hidden="true">&lt;</span>
      </span>
    </li>
    
    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="n">
    	<li class="page-item"><span class="page-link n" data-comment-pn="${n}">${n}</span></li>
    </c:forEach>
    
   	<li class="page-item">
      <span class="page-link n" data-comment-pn="${pager.lastNum+1}" aria-label="Next">
        <span aria-hidden="true">&gt;</span>
      </span>
    </li>
  </ul>
</nav>