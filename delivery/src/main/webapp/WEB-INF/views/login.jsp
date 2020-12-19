<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인 테스트
<form action="/login" method="post"> 
아이디 <input type="text" name="username" /> <br />
비밀번호 <input type="password" name="password" /> <br />
<input type="checkbox" name="remember-me"> 자동로그인
<input type="submit" value="로그인" />
<input type="hidden" name="${_csrf.parameterName }"value="${_csrf.token }" />

</form>
</body>
</html>