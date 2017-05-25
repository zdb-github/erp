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
			<li><a href="<%=basePath%>goods/toList.do">商品管理</a></li>
			<li><a href="<%=basePath%>goods/toAdd.do">添加商品</a></li>
		</ul>
	</div>
	<form action="<%=basePath%>goods/add.do" method="post">
		<table border="0" class="table0">
			<tr>
				<td class="ftTd" align="left">商品名称</td>
				<td width="50%">
					<input type="text" name="goods_name" id="name1" class="dfinput" />
				</td>
			</tr>
			
			<tr>
				<td class="ftTd" align="left">商品价格</td>
				<td width="50%">
					<input type="text" name="goods_prices" id="goods_prices1" class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd">商品类型</td>
				<td>
					<select name="goods_type" id="goods_type1" class="dfinput">
						<option>---请选择---</option>
						<c:forEach items="${codeList}" var="c">
							<option value="${c.key}">${c.value}</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">商品单位</td>
				<td width="50%">
					<input type="text" name="goods_unit" id="goods_unit1" class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd">所在仓库</td>
				<td>
					<select name="warehouse_id" id="warehouse_id1" class="dfinput">
						<option>--请选择--</option>
						<c:forEach items="${EWList}" var="ew">
							<option value="${ew.warehouse_id}">${ew.name}</option>
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