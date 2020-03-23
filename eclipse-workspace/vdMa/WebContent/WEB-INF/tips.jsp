<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<%
// 解决中文乱码的问题
String id = new String(request.getParameter("id"));
String name = new String(request.getParameter("name"));
String vright = new String(request.getParameter("vright"));
String descp = new String(request.getParameter("descp"));
String watchVolume = new String(request.getParameter("watchVolume"));
String date = new String(request.getParameter("date"));
String url = new String(request.getParameter("url"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=id%><br/><br/>
<%=name%><br/><br/>
<%=vright%><br/><br/>
<%=descp%><br/><br/>
<%=watchVolume%><br/><br/>
<%=date%><br/><br/>
<%=url%><br/><br/>
</body>
</html>