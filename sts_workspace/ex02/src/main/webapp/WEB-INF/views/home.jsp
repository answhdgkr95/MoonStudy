<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
	<a href="/board/register">글등록</a>
	<a href="/board/list">글목록보기</a>
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
