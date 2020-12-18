<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp" %> 
 
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시판 글상세보기</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            게시글 상세보기 페이지 입니다
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                       <div class="form-group">
                                            <label>제목</label>
                                            <input class="form-control" name="title" readonly="readonly" value="${board.title}">
                                        </div>
                              			  <div class="form-group">
                                        
                                        </div>
                                  
                                        <div class="form-group">
                                            <label>내용</label>
                                            <textarea class="form-control" rows="3" name="content" readonly="readonly" >${board.content}</textarea>
                                        </div>
                                       
                                        <div class="form-group has-success">
                                            <label class="control-label" for="inputSuccess">작성자
                                            <input type="text" class="form-control" id="inputSuccess" name="writer" readonly="readonly" value="${board.writer}">
                                        </div>




                                        <button class="btn btn-default" onclick="location.href='/board/modify?bno=${board.bno}'">수정</button>
                                        <button class="btn btn-default" onclick='location.href="/board/list"'>글 목록보기</button>
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

<%@include file="../includes/footer.jsp" %> 
