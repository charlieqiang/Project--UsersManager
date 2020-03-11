<%@ page language="java" import="java.util.*,com.spe.domain.User" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 

        <script type='text/javascript' language='javascript'>");
		"
				+ "function gotoPage(){"
				+ "var pageNow=document.getElementById('pageNow').value;"
				+ "window.open('/UsersManager3.0/ManageUsers?pageNow='+pageNow,'_self');"
				+ "}"
				+ "function confirmDel(){"
				+ "return window.confirm('It will delete the user!');"
				+ "}"
				+ "</script>");
		<span>hello xx</span>");
		
		<a href='/UsersManager3.0/Login'>Sign out</a>");
		<hr/>");

 -->

		
		<h1>ManageUsers</h1>
<!-- 
		int pageNow=1;
		int pageSize=3;
		int pageCount=1;

		
		String pageNowString=request.getParameter("pageNow");
		if(pageNowString!=null) {
			pageNow=Integer.parseInt(pageNowString);
		}
		
		try {

			UserService userService=new UserService();
			
			pageCount = UserService.getPageCount(pageSize);
			

 -->

			

			

			<table border=1 width=500px>
			<tr><th>id</th>
					<th>username</th>
					<th>email</th>
					<th>grade</th>
					<th>change</th>
					<th>delete</th></tr>
								<%
				ArrayList<User> al =(ArrayList<User>)request.getAttribute("al");
				
				for(User u:al){
					%>
						<tr><td><%=u.getId() %>
						</td><td><%=u.getName() %>
						</td><td><%=u.getEmail() %>
						</td><td><%=u.getGrade() %>
						</td><td><a href="/UsersManager3.0/UserControllor?type=gotoUpdView&id=<%= u.getId() %>" >change</a>
						</td><td><a href="/UsersManager3.0/UserControllor?type=del&id=<%= u.getId() %>" >delete</a>
						</td></tr>
					<%
				}
			%>
<!-- 




			if(pageNow!=1) {
				<a href='/UsersManager3.0/ManageUsers?pageNow="+(pageNow-1)+"'>previous</a>");
				
			}
			
			for(int i=1;i<=pageCount;i++) {
				<a href='/UsersManager3.0/ManageUsers?pageNow="+i+"'><"+i+"></a>");
			}
			
			if(pageNow!=pageCount) {
				<a href='/UsersManager3.0/ManageUsers?pageNow="+(pageNow+1)+"'>next</a>");
				
			}
			
			&nbsp;&nbsp;&nbsp;"+pageNow+"/"+pageCount);
			<br/>jump to <input id='pageNow' type='text' name='pageNow'/><input type='button' onClick='gotoPage()' value='jump'>");

 -->
 
</body>
</html>