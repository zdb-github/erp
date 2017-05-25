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
		function validate(){
	  	var pwd1 = document.getElementById("pwd1").value;	
			if(pwd1 == ""){
				alert("密码不能为空！");
				return false;
			}
			if(pwd1.length < 6){
				alert("密码长度必须达到6个字符！");
				return false;
			}
			var pwd2 = document.getElementById("pwd2").value	;	
			if(pwd1 != pwd2){
				alert("两次输入密码不一致\n请重新输入！");
				return false;
			}
	  	}
	  </script>
  </head>
  
  <body onload="csh()">
  	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">修改密码</a></li>
		</ul>
	</div>
	<form action="<%=basePath%>public/updatePw.do" method="post"  onsubmit="return validate()">
		<input type="hidden" name="id" value="${account.id}"/>
		<table border="0" class="table0">
			<tr>
				<td class="ftTd" align="left">请输入新密码</td>
				<td width="50%">
					<input type="password" name="password"  id="pwd1"  class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">请再次输入密码</td>
				<td width="50%">
					<input type="password" name="password"  id="pwd2"  class="dfinput" />
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