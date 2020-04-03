<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<script src="/vdMa/js/hash.js"></script>
	<script src="/vdMa/js/jquery-1.9.0.min.js"></script>
	<script>
		$(function () { 
			$("body").html("<div id='fileinput'></div><div id='imageinfo'></div>");
		
			$("#fileinput").html("图片：<input id='imgupload' type='file' name='file' onchange='imgUpload(this)'/><br/><br/>"); });
			
			function imgUpload(obj) {
				var bucketname = "oklegend"; //服务名
				var username = "charlie";	  //操作员账号
				var password = "KVbDlyUZC9JnsvkLX1sO5n6ijehbZnXh";     //操作员密码
				var filename = Math.random().toString(36).substr(2).substring(0,5);
				var timestamp = (new Date()).valueOf();
				var filecode = timestamp+filename;
				var save_key = "/img/"+filecode;
				var url = "https://v0.api.upyun.com/" + bucketname;
				var file = $(obj).get(0).files[0];
				var imageinfo = document.getElementById("imageinfo");
				var form = "	<form action=\"/vdMa/ImgController?type=add\" method=\"POST\">" + 
				"		图片码：<input type=\"text\" name=\"url\" readonly value='"+filecode+"'/><br>" + 
				"		<input type=\"submit\" value=\"记得保存\">" + 
				"	    </form>";
				var policy = btoa(
					JSON.stringify(
						{ "bucket": bucketname, 
						"save-key": save_key, 
						"expiration": parseInt(Date.parse(new Date()) + 3600) }));
	
				var signature = "UPYUN " + username + ":" + b64hamcsha1(HexMD5.MD5(password).toString(HexMD5.enc.Hex), "POST&/" + bucketname + "&" + policy);
				imageinfo.innerHTML += "图片名称: " + file.name + "<br/>" + "图片大小: " + file.size + "<br/>" + "图片类型: " + file.type + "<br/><br/>" +
					"<div id='progress' style='width:300px;height:14px;border:1px solid #ddd;padding-top:0px;border-radius:4px;display:none'><div id='bar' style='float:left;background-color:#62BFFF; width:0%; height:14px; border-radius:3px;'></div><div id='percent' style='float:left;width:0px;display:inline-block; top:0px;font-size:10px;'></div>";
				var xhrOnProgress = function (fun) {
					xhrOnProgress.onprogress = fun;
					return function () {
						var xhr = $.ajaxSettings.xhr();
						if (typeof xhrOnProgress.onprogress !== 'function') {
							return xhr;
						}
						if (xhrOnProgress.onprogress && xhr.upload) {
							xhr.upload.onprogress = xhrOnProgress.onprogress;
						}
						return xhr;
					}
				}
				var formData = new FormData();
				formData.append("file", file);
				formData.append("policy", policy);
				formData.append("authorization", signature);
				$.ajax({
					url: url,
					type: "POST",
					data: formData,
					contentType: false,
					processData: false,
					xhr: xhrOnProgress(function (e) {
						var percent = Math.round(e.loaded * 100 / e.total);
						$("#progress").show();
						$("#percent").text(percent + "%");
						$("#bar").width(percent + '%');
					}),
					success: function (data, textStatus, xhr) {
						$("#progress").hide();
						imageinfo.innerHTML += "图片上传成功!<br/><br/>";
						// for (var key in JSON.parse(data)) {
						// 	fileinfo.innerHTML += key + ": " + JSON.parse(data)[key] + "<br/>";
						// }
						
						imageinfo.innerHTML += form;
					},
					error: function (xhr) {
						$("#progress").hide();
						imageinfo.innerHTML += "上传失败!<br/><br/>";
						for (var key in JSON.parse(xhr.responseText)) {
							fileinfo.innerHTML += key + ": " + JSON.parse(xhr.responseText)[key] + "<br/>";
						}
					}
				}
			);
		}
	</script>
</head>
<body>

</body>
</html>