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
	<script type="text/javascript">
	  	
	  	function csh(){
	  		
	  		var sArr = document.getElementById("state1");
	  		for(var i=0;i<sArr.options.length;i++){
	  			if(sArr.options[i].value=="${goods.goods_type}"){
	  				sArr.options[i].selected = true;
	  				break;
	  			}
	  		}
	  		var ewArr = document.getElementById("warehouse_id1");
	  		
	  		for(var i=0;i<ewArr.options.length;i++){
	  		
	  			if(ewArr.options[i].value=="${goods.warehouse_id}"){
	  				
	  				ewArr.options[i].selected = true;
	  				break;
	  			}
	  		}
	  	}
	  </script>
  </head>
  
  <body onload="csh()">
  	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="<%=basePath%>public/toWelcome.do">首页</a></li>
			<li><a href="goods/toList.do">商品管理</a></li>
			<li><a href="goods/toUpdate.do?goods_id=${goods.goods_id }">修改商品信息</a></li>
		</ul>
	</div>
	<form action="<%=basePath%>goods/update.do" method="post">
		<input type="hidden" name="goods_id" value="${goods.goods_id }"/>
		<table border="0" class="table0">
			<tr>
				<td class="ftTd" align="left">商品名称</td>
				<td width="50%">
					<input type="text" name="goods_name" value="${goods.goods_name }" id="name1" class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">商品数量</td>
				<td width="50%">
					<input type="text" name="goods_num" value="${goods.goods_num }" id="goods_num1" class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">商品价格</td>
				<td width="50%">
					<input type="text" name="goods_prices" value="${goods.goods_prices }" id="goods_prices1" class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd">商品类型</td>
				<td>
					<select name="goods_type" id="goods_type1" class="dfinput">
						
						<c:forEach items="${codeList}" var="c">
							<option value="${c.key}">${c.value}</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">商品单位</td>
				<td width="50%">
					<input type="text" name="goods_unit" value="${goods.goods_unit}" id="goods_unit1" class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd">所在仓库</td>
				<td>
					<select name="warehouse_id" id="warehouse_id1" class="dfinput">
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