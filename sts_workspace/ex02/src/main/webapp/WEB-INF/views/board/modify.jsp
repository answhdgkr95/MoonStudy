<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp" %> 
 
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시판 수정</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            등록한 글을 수정해 주세요
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="modify" method="post">
                                    	<input type="hidden" value="${board.bno}"  name="bno">
                                    
                                        <div class="form-group">
                                            <label>제목</label>
                                            <input class="form-control" name="title" value="${board.title}">
                                        </div>
                              			  <div class="form-group">
                                        
                                        </div>
                                  
                                        <div class="form-group">
                                            <label>내용</label>
                                            <textarea class="form-control" rows="3" name="content">${board.content}</textarea>
                                        </div>
                                       
                                        <div class="form-group has-success">
                                            <label class="control-label" for="inputSuccess">작성자
                                            <input type="text" class="form-control" id="inputSuccess" name="writer" value="${board.writer}">
                                        </div>




                                        <button type="submit" class="btn btn-default">글수정</button>
                                        <button class="btn btn-default"  id="remove">삭제</button>
                                    	<button type="button" class="btn btn-default" onclick='location.href="/board/list"'>글 목록보기</button>
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
 $(document).ready(function(){
	 $("#remove.btn").on("click",function(e){
		 e.preventDefault();  //기본동작 막고
		 var formObj=$("form");
		 formObj.attr("action","/board/remove"); //기존 form 액션url 변경해서
		 formObj.submit(); //submit 처리
	 })
	 
	 
// 	$("#list.btn").on("click",function(e){
// 		e.preventDefault();
// 		self.location="/board/list";
 	})
	
	
// })


</script>



<%@include file="../includes/footer.jsp" %> 
