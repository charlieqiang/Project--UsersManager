<%@ page contentType="text/html;charset=utf-8"%>
<% 
	
	String seter=request.getParameter("seter");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/lib.js"></script>
<script type="text/javascript">
    function change(val,obj){
        if(val=='over'){
            obj.style.color="red";
            
        }else if(val=='out'){
            obj.style.color="black";
        }
    }

    function openChatRoom(obj){
        window.open("chatRoom.jsp?getter="+obj.innerText+"&seter=<%=seter %>","_blank");

    }
</script>
<body>
<h1>Friend List</h1>
<ul>
    <li onclick="openChatRoom(this)" style="width: fit-content;" onmouseover="change('over',this)" onmouseout="change('out',this)">Lili</li>
    <li onclick="openChatRoom(this)" style="width: fit-content;" onmouseover="change('over',this)" onmouseout="change('out',this)">Charlie</li>
    <li onclick="openChatRoom(this)" style="width: fit-content;" onmouseover="change('over',this)" onmouseout="change('out',this)">Bob</li>
</ul>
</body>
</html>