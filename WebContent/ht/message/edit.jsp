<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
request.setAttribute("path", basePath);  
%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改信息类别</title>
<link href="${path }ht/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="${path }ht/findAllMessage">信息类别列表</a></li>
    </ul>
    </div>    
    <div class="formbody">    
    <div class="formtitle"><span>修改信息</span></div>
    <form action="${path }ht/updateMessage" name="ff" method="post"  onsubmit="return checkValue()">     
    <ul class="forminfo">
   
    <li><label style="width:120px;">类别id：</label><input id="id" name="id" value="${message.id}" type="text" class="dfinput" readonly="true"/><i>类别id为纯数字</i></li>
    <li><label style="width:120px;">信息标题（<font style="color:Red;font-weight:bolder;">*</font>）：</label><input id="title1" name="title1" value="${message.title1}" type="text" class="dfinput" /><i>标题名称</i></li>
    <li><label style="width:120px;">信息内容（<font style="color:Red;font-weight:bolder;">*</font>）：</label><input id="content" name="content" value="${message.content}" type="text" class="dfinput" /><i>内容概要</i></li>
   <li><label style="width:120px;">信息时间（<font style="color:Red;font-weight:bolder;">*</font>）：</label><input id="time" name="time" value="${message.time}" type="date" class="dfinput" /><i>准确时间</i></li> 
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/>
    &nbsp;&nbsp;<input name="" type="button" onclick="goback();"class="btn" value="返回列表"/>

    </li>
    
    </ul>
    </form>  
    </div>
    <script>
    function goback(){
    	window.location.href="${path }ht/findAllMessage";    	
    }
    
    function checkValue() {		
		var str = document.getElementById("id").value;
		if (str.length < 1) {
			alert("请输入类别id");
			document.getElementById("id").focus();
			return false;
		}		
		if (isNaN(str)) {
	        alert("类别id应为数字");
	        document.getElementById("id").value = "";
	        document.getElementById("id").focus();
	        return false;
        }
		str = document.getElementById("title").value;
		if (str.length < 1) {
			alert("请输入类别名称");
			document.getElementById("title").focus();
			return false;
		}
		if (str.length > 10) {
			alert("类别名称长度应小于等于10");
			document.getElementById("title").focus();
			return false;
		}
		
		return true;
	}
    </script>
</body>
</html>
