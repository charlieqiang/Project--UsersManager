<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// 解决中文乱码的问题
String info = new String(request.getParameter("info"));

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=info%><br/><br/>
<a href="/vdMa/ContentController?content=main">返回首页</a>
</body>
</html>