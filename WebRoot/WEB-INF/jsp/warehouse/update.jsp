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
	  		var bTypeArr = document.getElementById("subsidiary_organ1");
	  		
	  		for(var i=0;i<bTypeArr.options.length;i++){
	  		
	  			if(bTypeArr.options[i].value=="${Warehouse.subsidiary_organ}"){
	  				
	  				bTypeArr.options[i].selected = true;
	  				break;
	  			}
	  		}
	  		var sArr = document.getElementById("state1");
	  		for(var i=0;i<sArr.options.length;i++){
	  			if(sArr.options[i].value=="${Warehouse.state}"){
	  				sArr.options[i].selected = true;
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
			<li><a href="#">仓库管理</a></li>
			<li><a href="#">更新仓库信息</a></li>
		</ul>
	</div>
	<form action="<%=basePath%>warehouse/update.do" method="post">
		<input type="hidden" name="warehouse_id" value="${Warehouse.warehouse_id }"/>
		<table border="0" class="table0">
			<tr>
				<td class="ftTd" align="left">仓库名</td>
				<td width="50%">
					<input type="text" name="name" value="${Warehouse.name }" id="name1"  class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd">所属机构</td>
				<td>
					<select name="subsidiary_organ" id="subsidiary_organ1" class="dfinput">
						<option>${Warehouse.subsidiary_organ }</option>
						<c:forEach items="${organList}" var="o">
							<option value="${o.name}">${o.name}</option>
						</c:forEach>
					</select>	
				</td>
			</tr>
			<tr>
				<td class="ftTd">负责人</td>
				<td>
					<input type="text" name="principal" value="${Warehouse.principal }" id="principal"class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd">联系电话</td>
				<td>
					<input type="text" name="phone" value="${Warehouse.phone }" id="phone1"class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd">创建时间</td>
				<td>
					<input type="text" name="create_time" value="${Warehouse.create_time }" id="create_time1"class="dfinput" />
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