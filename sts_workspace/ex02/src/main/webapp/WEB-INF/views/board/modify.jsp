<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시판 글수정</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">글 수정</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-lg-6">
						<form role="form" action="modify" method="post">


							<!-- 글번호 안보이게 -->
							<input type="hidden" value="${board.bno}" name="bno">

							<div class="form-group">
								<label>제목</label> <input class="form-control" name="title"
									value=${board.title }>
							</div>
							<div class="form-group"></div>

							<div class="form-group">
								<label>내용</label>
								<textarea class="form-control" rows="3" name="content">${board.content}</textarea>
							</div>

							<div class="form-group">
								<label>작성자</label> <input type="text" class="form-control"
									id="inputSuccess" name="writer" value=${board.writer }>
							</div>




							<button type="submit" class="btn btn-primary btn-xs">글수정 완료</button>

							<!-- POST -->
							<button class="btn btn-danger btn-xs" id="remove">글삭제</button>

							<button type="button" onclick="location.href='/board/list'"
								class="btn btn-primary btn-xs" id="list">글 목록</button>
						</form>
						
					</div>
				</div>
				<!-- /.row (nested) -->
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
</div>
<!-- /#page-wrapper -->

</div>

<script>
	$(document).ready(function() {
		$("#remove.btn").on("click", function(e) {
			e.preventDefault(); //기본 동작 막기
			var formObj = $("form"); //form이름 알려주기
			formObj.attr("action", "/board/remove"); //클릭되었을때 from액션 remove로 변경			
			formObj.submit(); //submit처리 

		})
	})

	//	self.location="/board/list";
</script>

<%@include file="../includes/footer.jsp"%>
