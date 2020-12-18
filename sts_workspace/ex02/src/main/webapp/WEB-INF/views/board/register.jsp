<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp" %> 
 
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시판 글등록</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            등록한 글을 작성해 주세요
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="register" method="post">
                                        <div class="form-group">
                                            <label>제목</label>
                                            <input class="form-control" name="title">
                                        </div>
                              			  <div class="form-group">
                                        
                                        </div>
                                  
                                        <div class="form-group">
                                            <label>내용</label>
                                            <textarea class="form-control" rows="3" name="content"></textarea>
                                        </div>
                                       
                                        <div class="form-group">
                                            <label>작성자</label>
                                            <input type="text" class="form-control" name="writer">
                                        </div>




                                        <button type="submit" class="btn btn-primary">글등록</button>
                                        <button type="reset" class="btn btn-default">다시쓰기</button>
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

<%@include file="../includes/footer.jsp" %> 
