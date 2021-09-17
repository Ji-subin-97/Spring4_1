<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Select</title>
		<c:import url="../temp/header.jsp"></c:import>
	</head>
	<body>
		<c:import url="../temp/nav.jsp"></c:import>
		
		<!-- qna select 삭제시 table과 폴더에 있는 첨부파일도 삭제 notice delete qna delete -->
		
		<div class="container-fluid">
			<c:choose>
				<c:when test="${board eq 'notice'}">
					<h1>TITLE : ${dto.title}</h1>
					<div>${dto.contents}</div>
					<h1>WRITER : ${dto.writer}</h1>
					<h1>REGDATE : ${dto.regDate}</h1>
					<c:forEach items="${dto.files}" var="f">
						<h1>Files : <a href="./down?fileName=${f.fileName}">${f.oriName}</a></h1>
					</c:forEach>
					
					<hr>
					<div>
						<div>
							<label for="exampleInputPassword1" class="form-label">작성자</label>
							<input class="form-control" type="text" id="writer" name="writer" value="${member.id}" readonly>
						</div>
						<div>
							<label for="exampleInputPassword1" class="form-label">COMMENT</label>
							<textarea class="form-control" id="contents" rows="" cols=""></textarea>
						</div>
						<div>
							<input class="btn btn-info" id="comment" type="submit" value="작성하기">
						</div>
					</div>
					
					<c:if test="${dto.writer eq member.id}">
						<h1><a href="./delete?num=${dto.num}">삭제하기</a></h1>
						<h1><a href="./update?num=${dto.num}">수정하기</a></h1>
					</c:if>
				</c:when>
				<c:otherwise>
					<h1>TITLE : ${dto.title}</h1>
					<h1>CONTENTS : ${dto.contents}</h1>
					<h1>WRITER : ${dto.writer}</h1>
					<h1>REGDATE : ${dto.regDate}</h1>
					<c:forEach items="${dto.files}" var="f">
						<h1>Files : <img src="../resources/upload/${board}/${f.fileName}"></h1>
					</c:forEach>
					<c:if test="${dto.writer eq member.id}">
						<h1><a href="./delete?num=${dto.num}">삭제하기</a></h1>
						<h1><a href="./update?num=${dto.num}">수정하기</a></h1>
					</c:if>
					<h1><a href="./reply?num=${dto.num}">답글달기</a></h1>
				</c:otherwise>
			</c:choose>	
		</div>
		
		<script type="text/javascript">
			$('#comment').click(function () {
				//작성자, 내용을 콘솔에 출력
				let writer = $('#writer').val();
				let contents = $('#contents').val();
				$.post('./comment', {num:'${dto.num}', writer:writer, contents:contents}, function (result) {
					console.log(result.trim());
				});
			});
		</script>
	</body>
</html>