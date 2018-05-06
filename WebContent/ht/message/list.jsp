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
<title></title>
<link href="${path }ht/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${path }ht/js/jquery.js"></script>
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">信息列表</a></li>
    </ul>
    </div>    
    <div class="rightinfo">    
    <div class="tools">    
    	<ul class="toolbar">
        <li class="click"><a href="${path }ht/message/add.jsp"><span><img src="images/t01.png" /></span>添加信息</a></li>
        </ul>
       </div>
   		 <table style="width:700px;" class="tablelist">
	    	<thead>
	    	<tr>
	        <th style="width:100px;">信息编号</th>
	        <th>信息标题</th>
	          <th>信息内容</th>
	            <th>信息时间</th>
	        <th style="width:160px;">操作</th>
	        </tr>
	        </thead>
				<tbody>	
					<s:iterator value="list" id="message">	
						<tr>
							<td><s:property value="#message.id" /></td>
							<td><s:property value="#message.title1" /></td>
							<td><s:property value="#message.content" /></td>
							<td><s:property value="#message.time" /></td>
							<td><a
								href='${path}ht/editMessage.action?id=<s:property value="#message.id"/>'
								class="tablelink">更新</a> <a href='#'
								onclick="del(<s:property value="#message.id"/>)"
								class="tablelink">删除</a></td>
						</tr>	
					</s:iterator>	
				</tbody>
		</table>
	    <script type="text/javascript">
			function del(id){
				if(window.confirm("您确定要删除吗？"))
				{
				   location.href="${path}ht/delMessage.action?id="+id;
				 }
			}
		</script>
    </div>
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>


