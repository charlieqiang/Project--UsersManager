<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<%
		String num1=request.getParameter("num1");
		String num2=request.getParameter("num2");
		String oper=request.getParameter("operator");
		double temp1=0;
		double temp2=0;
		double res=0;
		if(num1!=null&&num2!=null){
			temp1=Double.parseDouble(num1);
			temp2=Double.parseDouble(num2);
			if(oper.equals("+")){
				res=temp1+temp2;
			}else if(oper.equals("-")){
				res=temp1-temp2;
			}else if(oper.equals("*")){
				res=temp1*temp2;
			}else if(oper.equals("/")){
				res=temp1/temp2;
			}
		}
		
		
	%>
<body>
	<form action="/Calculation/demoCalculate.jsp" method="post">
		plz input:<input type="text" name="num1"/><br/>
		plz input:<input type="text" name="num2"/><br/>
		plz choose:<select name="operator"/>
		<option value="+">+</option>
		<option value="-">-</option>
		<option value="*">*</option>
		<option value="/">/</option>
		<br/>
		
		<input type="submit" value="count"/><br/>
	</form>
	res<%=res %>
</body>
</html>