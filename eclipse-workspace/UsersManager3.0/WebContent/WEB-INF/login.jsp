<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr/>
<h1>hello world</h1>
<form action='/UsersManager3.0/LoginController' method='GET'>
UserId:<input type='text' name='id'/><br/>
Password:<input type='password' name='password'/><br/>
Checkcode:<input type='text' name='checkcode'/><img src='/UsersManager3.0/CreateCode'/><br/>
<input type='submit' value='Sign in' value='signIn'><br/>
</form>
</body>
</html>