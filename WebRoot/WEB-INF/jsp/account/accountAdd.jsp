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
		$(function(){
			$("#password1").click(function(){
				$.ajax({
					url:"<%=basePath%>account/toCheckTheSameUsername.do",
					type:"post",
					data:"username="+$("#username1").val(),
					success:function(data){
						if(data==true){
							$("#myForm1").submit();
						}else{
							alert("<-----该用户名已存在!!!------>");
						}
					}
				});
			})
			
		})
	</script>
	
  </head>
  
  <body>
  	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="<%=basePath%>public/toWelcome.do">首页</a></li>
			<li><a href="<%=basePath%>account/toAccountList.do">账户管理</a></li>
			<li><a href="<%=basePath%>account/toAccountAdd.do">添加账户</a></li>
		</ul>
	</div>
	<form action="<%=basePath%>account/accountAdd.do" method="post">
		<table border="0" class="table0">
			<tr>
				<td class="ftTd" align="left">用户名</td>
				<td width="50%">
					<input type="text" name="username" id="username1" class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">密码</td>
				<td width="50%">
					<input type="password" name="password" id="password1" class="dfinput" />
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























