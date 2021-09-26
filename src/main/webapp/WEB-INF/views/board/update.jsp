<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert</title>
		<c:import url="../temp/header.jsp"></c:import>
		
		<!-- include libraries(jQuery, bootstrap) -->
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		
		<!-- include summernote css/js -->
		<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
		
		<style type="text/css">
			.f{
				width: 90%;
			}
			#d1{
				width: 300px;
				height: 300px;
				background-color: yellow;
			}
		</style>
		<script type="text/javascript">
			$('document').ready(function () {
				$('#contents').summernote();
			});
		</script>
	</head>
	<body>
	
		<c:import url="../temp/nav.jsp"></c:import>
		
		<h1>Update Page 입니다.</h1>
		<form action="./update" method="POST" class="col-md-10 mx-auto my-0" enctype="multipart/form-data">
			<div class="container-fluid">
					<input type="hidden" name="num" value="${dto.num}">
					<table class="table table-dark table-striped" style="text-align:left">
						<tr>
							<td>제목</td><td><input type="text" name="title" value="${dto.title}"></td>
						</tr>
						<tr>
							<td>내용</td>
							<td>
								<textarea rows="10" cols="90" name="contents" id="contents">
								${dto.contents}
								</textarea>
								<div id="contents"></div>
							</td>
						</tr>
						<tr>
							<td>작성자</td><td><input type="text" name="writer" value="${dto.writer}" readonly></td>
						</tr>
						<!-- 버튼 추가 -->
						<tr>
							<td>파일</td>
							<td>
								<button id="add_file" type="button" class="btn btn-primary mb-3">파일추가</button>
								<div id="fileAddResult"></div>
								
								<hr>
								<hr>
								
								<div>
									<c:forEach items="${dto.files}" var="f">
										<%-- <input type="file" value="${f.fileName}"> <!-- input type file은 읽기 전용 --> --%>
										<div>
											${f.oriName}<span class="fileDelete" data-files-num="${f.fileNum}" data-files-name="${f.fileName}">X</span>
										</div>
									</c:forEach>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="수정하기"></td>
						</tr>
					</table>
			</div>
		</form>
		<div id="d1"></div>
		
		<script type="text/javascript" src="../resources/js/boardFile.js"></script>
		<script type="text/javascript">
			
			setCount('${dto.files.size()}');
			
			$(".fileDelete").click(function() {
				let fileNum = $(this).attr("data-files-num");
				let fileName = $(this).attr("data-files-name");
				let selector = $(this);
				
				$.ajax({
					type: "POST",
					url: "./fileDelete",
					data:{
						fileNum: fileNum,
						fileName: fileName
					},
					success: function(result) {
						console.log(result)
						selector.parent().remove();
						updateCount();
					}
				});
			});
		</script>
	</body>
</html>