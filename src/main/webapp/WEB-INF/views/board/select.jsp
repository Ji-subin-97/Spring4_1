<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Select</title>
		<c:import url="../temp/header.jsp"></c:import>
		<style type="text/css">
			.n{
				cursor: pointer;
			}
		</style>
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
					<!-- Comment List -->
					<div id="commentList" data-board-num="${dto.num}">
						
					</div>
					
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
			getCommentList(1);
			let content='';
			
			//cancel btn
			$("#commentList").on("click", "#cancel_btn", function() {
				$(this).parent().html(content);
			});
			
			//doupdate
			$("#commentList").on("click", "#doupdate_btn", function() {
				alert("!");
				let commentNum = $(this).attr("data-comment-doupdate");
				let contents = $("#contents").val();
				
				alert(commentNum);
				alert(contents);
				
				$.ajax({
					type: "POST",
					url: "./comment/updateComment",
					data:{
						commentNum: commentNum,
						contents: contents
					},
					success: function(result) {
						if(result>0){
							alert("업데이트성공");
							getCommentList(1);
						}else{
							alert("업데이트실패");
						}
					},
					error: function() {
						alert("error!");
					}
				});
			});
			
			//Update Click Event
			$("#commentList").on("click", "#update_btn", function() {
				let update_num = $(this).attr("data-comment-update");
				content = $("#"+update_num).html();
				$("#"+update_num).html('<textarea class="form-control" id="contents" rows="" cols="">'+ content +'</textarea><button id="doupdate_btn" data-comment-doupdate="'+ update_num +'">UPDATE</button><button id="cancel_btn">CANCEL</button>');
				
				
			});
			
			//Del Click Event
			$("#commentList").on("click", "#del_btn", function() {
				let del_num = $(this).attr("data-comment-del");
				console.log(del_num);
				
				$.ajax({
					type: "POST",
					url: "./comment/setCommentDelete",
					data: {commentNum: del_num},
					success: function(result) {
						result=result.trim();
						alert(result);
						if(result>0){
							alert("삭제성공");
							getCommentList(1);
						}else{
							alert("삭제실패");
						}
					},
					error: function(xhr, status, error) {
						alert("error!");
					}
				});
			});
			
			$("#commentList").on("click", ".n", function() {
				let pn = $(this).attr("data-comment-pn");
				getCommentList(pn);
			});
			
			function getCommentList(pageNumber) {
				let num = $("#commentList").attr("data-board-num");
				
				$.ajax({
					type: "GET",
					url: "./comment/getCommentList",
					data: {
						num: num,
						pn: pageNumber
					},
					success: function(result){
						result = result.trim();
						$('#commentList').html(result);
					},
					error: function(xhr, status, error) {
						console.log(error);
					}
				});
			}
			
			$('#comment').click(function () {
				//작성자, 내용을 콘솔에 출력
				let writer = $('#writer').val();
				let contents = $('#contents').val();
				$.post('./comment', {num:'${dto.num}', writer:writer, contents:contents}, function (result) {
					console.log(result.trim());
					
					$('#contents').val('');
					
					getCommentList();
				});
			});
		</script>
	</body>
</html>