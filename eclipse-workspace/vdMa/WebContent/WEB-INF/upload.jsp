<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<script src="/vdMa/js/hash.js"></script>
	<script src="/vdMa/js/jquery-1.9.0.min.js"></script>
	<script>
		$(function () { $("body").html("<div id='fileinput'></div><div id='imageinfo'></div><div id='fileinfo'></div>"); $("#fileinput").html("图片：<input id='imageupload' type='file' name='file' onchange='uiload(this)'/><br/><br/> 视频：<input id='videoupload' type='file' name='file' onchange='uvload(this)'/><br/><br/>"); });
		function uiload(obj) {
			var bucketname = "oklegend"; //服务名
			var username = "charlie";	  //操作员账号
			var password = "KVbDlyUZC9JnsvkLX1sO5n6ijehbZnXh";     //操作员密码
			var filename = Math.random().toString(36).substr(2).substring(0,5);
			var timestamp = (new Date()).valueOf();
			var filecode = timestamp+filename;
			var save_key = "/image/"+filecode+"{.suffix}";
			var url = "http://v0.api.upyun.com/" + bucketname;
			var file = $(obj).get(0).files[0];
			var imageinfo = document.getElementById("imageinfo");
			var policy = btoa(
				JSON.stringify(
					{ "bucket": bucketname, 
					"save-key": save_key, 
					"expiration": parseInt(Date.parse(new Date()) + 3600) }));

			var signature = "UPYUN " + username + ":" + b64hamcsha1(HexMD5.MD5(password).toString(HexMD5.enc.Hex), "POST&/" + bucketname + "&" + policy);
			//imageinfo.innerHTML = "文件名称: " + file.name + "<br/>" + "文件大小: " + file.size + "<br/>" + "文件类型: " + file.type + "<br/><br/>" +
			//	"<div id='progress' style='width:300px;height:14px;border:1px solid #ddd;padding-top:0px;border-radius:4px;display:none'><div id='bar' style='float:left;background-color:#62BFFF; width:0%; height:14px; border-radius:3px;'></div><div id='percent' style='float:left;width:0px;display:inline-block; top:0px;font-size:10px;'></div>";
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
					imageinfo.innerHTML += "上传成功!<br/><br/>";
					// for (var key in JSON.parse(data)) {
					// 	imageinfo.innerHTML += key + ": " + JSON.parse(data)[key] + "<br/>";
					// }
					imageinfo.innerHTML +="图片码: " + filecode + "<br/>";
				},
				error: function (xhr) {
					$("#progress").hide();
					imageinfo.innerHTML += "上传失败!<br/><br/>";
					for (var key in JSON.parse(xhr.responseText)) {
						imageinfo.innerHTML += key + ": " + JSON.parse(xhr.responseText)[key] + "<br/>";
					}
				}
			});
		}
		
		function uvload(obj) {
			var bucketname = "oklegend"; //服务名
			var username = "charlie";	  //操作员账号
			var password = "KVbDlyUZC9JnsvkLX1sO5n6ijehbZnXh";     //操作员密码
			var filename = Math.random().toString(36).substr(2).substring(0,5);
			var timestamp = (new Date()).valueOf();
			var filecode = timestamp+filename;
			var save_key = "/video/"+filecode+"{.suffix}";
			var url = "http://v0.api.upyun.com/" + bucketname;
			var file = $(obj).get(0).files[0];
			var fileinfo = document.getElementById("fileinfo");
			var form = "	<form action=\"/vdMa/VideoController\" method=\"POST\">" + 
			"		视频码：<input type=\"text\" name=\"id\" readonly value='"+filecode+"'/><br>" + 
			"		视频名称：<input type=\"text\" name=\"name\"/><br>" + 
			"		视频权限：<input type=\"text\" name=\"vright\"/><br>" + 
			"		视频描述：<textarea rows=\"4\" cols=\"50\" name=\"descp\">输入内容...</textarea><br>" + 
			"		视频访问量：<input type=\"text\" name=\"watchVolume\"/><br>" + 
			"		上传日期：<input type=\"text\" name=\"date\"/><br>" + 
			"		图片码：<input type=\"text\" name=\"url\"/><br>" + 
			"		<input type=\"submit\" value=\"保存\">" + 
			"	</form>";
			var policy = btoa(
				JSON.stringify(
					{ "bucket": bucketname, 
					"save-key": save_key, 
					"expiration": parseInt(Date.parse(new Date()) + 3600) }));

			var signature = "UPYUN " + username + ":" + b64hamcsha1(HexMD5.MD5(password).toString(HexMD5.enc.Hex), "POST&/" + bucketname + "&" + policy);
			//fileinfo.innerHTML = "文件名称: " + file.name + "<br/>" + "文件大小: " + file.size + "<br/>" + "文件类型: " + file.type + "<br/><br/>" +
			//	"<div id='progress' style='width:300px;height:14px;border:1px solid #ddd;padding-top:0px;border-radius:4px;display:none'><div id='bar' style='float:left;background-color:#62BFFF; width:0%; height:14px; border-radius:3px;'></div><div id='percent' style='float:left;width:0px;display:inline-block; top:0px;font-size:10px;'></div>";
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
					fileinfo.innerHTML += "上传成功!<br/><br/>";
					// for (var key in JSON.parse(data)) {
					// 	fileinfo.innerHTML += key + ": " + JSON.parse(data)[key] + "<br/>";
					// }
					
					fileinfo.innerHTML += form;
				},
				error: function (xhr) {
					$("#progress").hide();
					fileinfo.innerHTML += "上传失败!<br/><br/>";
					for (var key in JSON.parse(xhr.responseText)) {
						fileinfo.innerHTML += key + ": " + JSON.parse(xhr.responseText)[key] + "<br/>";
					}
				}
			});
		}
	</script>
</head>
<body>

</body>
</html>