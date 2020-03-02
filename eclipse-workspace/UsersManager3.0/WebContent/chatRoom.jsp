<%@ page contentType="text/html;charset=utf-8"%>
<% 
	String getter=request.getParameter("getter");
	String seter=request.getParameter("seter");
	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

</head>
<body>
    <h1>Welcome chat room(<%=seter %> chat with <%=getter  %>)</h1>
    <textarea name="" id="dialogBox" cols="50" rows="25"></textarea><br>
    <input type="text" id="content"/>
    <input type="button" onclick="sendMessage()" value="send"/>
</body>
<script type="text/javascript" src="js/lib.js"></script>
<script>
    function sendMessage(){
        //load
        var myReq=loadAjax();
        if(myReq){
            var url="SendMessage";
            var data="content="+$('content').value+"&getter=<%=getter  %>&sender=<%=seter %>";
            alert(data);
            myReq.open("post",url,true);
            myReq.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
            myReq.onreadystatechange = function callBack(){
            
                if(myReq.readyState == 4 && req02.status == 200) {  
                    //alert('ok');
                }
            }  
        myReq.send(data);
        }
    }
</script>


</html>