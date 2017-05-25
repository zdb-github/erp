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
	  		
	  		var sArr = document.getElementById("uType1");
	  		for(var i=0;i<sArr.options.length;i++){
	  			if(sArr.options[i].value=="${account.uType}"){
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
			<li><a href="<%=basePath%>account/toAccountList.do">账户管理</a></li>
			<li><a href="<%=basePath%>account/toAccountUpdate?id=${account.id}">修改账户</a></li>
		</ul>
	</div>
	<form action="<%=basePath%>account/accountUpdate.do" method="post">
		<input type="hidden" name="id" value="${account.id }"/>
		<table border="0" class="table0">
			<tr>
				<td class="ftTd" align="left">用户名</td>
				<td width="50%">
					<input type="text" name="username" value="${account.username }" id="username1"  class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">密码</td>
				<td width="50%">
					<input type="password" name="password" value="${account.password }" id="password1"  class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd">用户类型</td>
				<td>
					<select name="uType" id="uType1" class="dfinput">
						
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