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
	  			if(sArr.options[i].value=="${dept.state}"){
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
			<li><a href="<%=basePath%>code/toCodeList.do">码表管理</a></li>
			<li><a href="<%=basePath%>code/toCodeList.do">修改码表</a></li>
		</ul>
	</div>
	<form action="<%=basePath%>code/codeUpdate.do" method="post">
		<input type="hidden" name="id" value="${code.id }"/>
		<table border="0" class="table0">
			<tr>
				<td class="ftTd" align="left">码表键</td>
				<td width="50%">
					<input type="text" name="key" value="${code.key }" id="key1"  class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">码表值</td>
				<td width="50%">
					<input type="text" name="value" value="${code.value }" id="value1"  class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">类型</td>
				<td width="50%">
					<input type="text" name="type" value="${code.type }" id="type1"  class="dfinput" />
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