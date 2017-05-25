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
			<li><a href="#">首页</a></li>
			<li><a href="<%=basePath%>customer/toCustomerList.do">客户管理</a></li>
			<li><a href="<%=basePath%>customer/toCustomerAdd.do">添加客户</a></li>
		</ul>
	</div>
	<form action="<%=basePath%>customer/customerAdd.do" method="post">
		<table border="0" class="table0">
			<tr>
				<td class="ftTd" align="left">客户姓名</td>
				<td width="50%">
					<input type="text" name="name" id="name1" class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">客户性别</td>
				<td width="50%">
					<c:forEach items="${sexList}" var="s">
						<input type="radio" name="sex" id="sex" value="${s.key}"/>${s.value}&nbsp;&nbsp;&nbsp;
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">客户年龄</td>
				<td width="50%">
					<input type="text" name="age" id="age1" class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">客户地址</td>
				<td width="50%">
					<input type="text" name="address" id="address1" class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">公司名称</td>
				<td width="50%">
					<input type="text" name="company" id="company1" class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">联系电话</td>
				<td width="50%">
					<input type="text" name="phone" id="phone1" class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">客户类别</td>
				<td width="50%">
					<c:forEach items="${c_typeList}" var="c">
						<input type="radio" name="c_type" id="c_type1" value="${c.key}"/>${c.value}&nbsp;&nbsp;&nbsp;
					</c:forEach>
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