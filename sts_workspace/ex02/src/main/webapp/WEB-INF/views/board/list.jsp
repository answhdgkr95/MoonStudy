<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="../includes/header.jsp" %> 
 
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시판</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            게시판 목록 보기
                        <button id="regBtn" type="button" class="btn btn-xs pull-right">글쓰기</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" >
                                <thead>
                                    <tr>
                                        <th>번호</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                    </tr>
                                </thead>
                                <tbody>
							         <c:forEach items="${list}" var="board">
							             <tr class="odd gradeX">
							                 <td><c:out value="${board.bno }"/></td>
							                 <td><a href="/board/get?bno=${board.bno}"><c:out value="${board.title }"/></a></td>
							                 <td><c:out value="${board.writer }"/></td>
							                 <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate }"/></td>
							                 <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate }"/></td>
							             </tr>
							         </c:forEach>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>

                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">처리완료</h4>
                                        </div>
                                        <div class="modal-body">
                                            삭제가 완료되었습니다.                            </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->



<script>
$(document).ready(function(){
	var result ='${result}'; //result 값을 읽고 get타입으로 보내온
	var bno='${bno}';
	console.log("값찍기"+result+bno);  //크롬F12 console 클릭

	console.log("전"+history.state);
	checkModal(result);
	
	history.replaceState({},null,null);
	console.log("후"+history.state);
	
	//교재>리스트만 요청하거나(result가 빈값('') 이거나 뒤로가기 로 이용해서(history가 있거나) 접근하거나
    //이때는 모달창을 띄우지 않는다
    
    //현재>history가 없으면서 result가 있으면 모달창 열자

    
	function checkModal(result){
    	if(!(history.state)){ //뒤로 가기가 아닐때
    		if(result == 'modify'){
    			$(".modal-body").html(bno +"번이 정상적으로 수정 되었습니다.");
    			$("#myModal").modal("show");
    		}else if(result == 'remove'){
    			$(".modal-body").html(bno +"번이 정상적으로 삭제 되었습니다.");
    			$("#myModal").modal("show");
    		}else if(result =='register'){  //글번호 (글등록)
    			$(".modal-body").html("게시글 " + bno + "번이 등록되었습니다.");
    			$("#myModal").modal("show");
    		}
	   	}
 	}
	

	$("#regBtn").on("click",function(){
		self.location="/board/register";
	})
})


</script>


<%@include file="../includes/footer.jsp" %> 










