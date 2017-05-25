<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<%=basePath%>js/jquery.js">
	</script>
	<style type="text/css">
		.table0{
			
			margin:50px 100px;
		}
		.ftTd{
			font-size:15px;
			text-align:center;
			padding:8px 15px;
		}
	</style>
	
  </head>
  
  <body >
  	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="<%=basePath%>public/toWelcome.do">首页</a></li>
			<li><a href="#">资源管理</a></li>
			<li><a href="#">更新资源</a></li>
		</ul>
	</div>
	<form action="<%=basePath%>resource/update.do" method="post">
		<input type="hidden" name="id" value="${resource.id }"/>
		<table border="0" class="table0">
			<tr>
				<td class="ftTd" align="left">资源名称</td>
				<td width="50%">
					<input type="text" name="resource_name" value="${resource.resource_name }" id="name1"  class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd">资源路径</td>
				<td>
					<input type="text" name="do_path" value="${resource.do_path }" id="do_path1"  class="dfinput" />
				</td>
			</tr>	
			<tr>
				<td class="ftTd">对应角色</td>
				<td>
					<input type="text" name="role_type" value="${resource.role_type }" id="role_type1"  class="dfinput" />
				</td>
			</tr>	
			<tr>
				<td height="50px" align="right"></td>
				<td><input  type="submit" class="btn" value="提交" /></td>
			</tr>
		</table>
	</form>
</body>
</html>