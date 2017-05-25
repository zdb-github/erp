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
  
  <body>
  	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="<%=basePath%>public/toWelcome.do">首页</a></li>
			<li><a href="<%=basePath%>dept/toList.do">部门管理</a></li>
			<li><a href="<%=basePath%>dept/toAdd.do">添加部门</a></li>
		</ul>
	</div>
	<form action="<%=basePath%>dept/add.do" method="post">
		<table border="0" class="table0">
			<tr>
				<td class="ftTd" align="left">部门名称</td>
				<td width="50%">
					<input type="text" name="name" id="name1" class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd">所属机构</td>
				<td>
					<select name="subsidiary_organ" id="subsidiary_organ1" class="dfinput">
						<option>--请选择--</option>
						<c:forEach items="${organList}" var="o">
							<option value="${o.name}">${o.name}</option>
						</c:forEach>
					</select>	
				</td>
			</tr>
			<tr>
				<td class="ftTd">状态</td>
				<td>
					<select name="state" id="state1" class="dfinput">
						
						<c:forEach items="${codeList}" var="c">
							<option value="${c.key}">${c.value}</option>
						</c:forEach>
				</select>
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