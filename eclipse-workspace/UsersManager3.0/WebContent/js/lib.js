//get id
function $(id){
    return document.getElementById(id);
}

//load
function loadAjax() {  
    //获取表单提交的内容  
    var myReq;
                
    //创建一个XMLHttpRequest对象req  
    if(window.XMLHttpRequest) {  
        //IE7, Firefox, Opera支持  
        myReq = new XMLHttpRequest();  
    }else if(window.ActiveXObject) {  
        //IE5,IE6支持  
        myReq = new ActiveXObject("Microsoft.XMLHTTP");  
    }  

    return myReq;
                
}  