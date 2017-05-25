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
	  		
	  		var sArr = document.getElementById("sex1");
	  		for(var i=0;i<sArr.options.length;i++){
	  			if(sArr.options[i].value=="${customer.sex}"){
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
			<li><a href="#">员工管理</a></li>
			<li><a href="#">更新员工信息</a></li>
		</ul>
	</div>
	<form action="<%=basePath%>user/userUpdate.do" method="post">
		<input type="hidden" name="id" value="${user.id }"/>
		<table border="0" class="table0">
			<tr>
				<td class="ftTd" align="left">姓名</td>
				<td width="50%">
					<input type="text" name="name" value="${user.name }" id="name1"  class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">性别</td>
				<td width="50%">
					<c:forEach items="${sexList}" var="s">
						<input type="radio" name="sex" id="sex1" value="${s.key}"/>${s.value}&nbsp;&nbsp;&nbsp;
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">年龄</td>
				<td width="50%">
					<input type="text" name="age" value="${user.age }" id="age1"  class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">身份证号</td>
				<td width="50%">
					<input type="text" name="id_card" value="${user.id_card}" id="id_card1"  class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">部门</td>
				<td width="50%">
					<select size="1" name="dept_id" id="dept_id1">
						<c:forEach items="${deptList}" var="d">
							<option value="${d.dept_id}">${d.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">联系电话</td>
				<td width="50%">
					<input type="text" name="phone" value="${user.phone }" id="phone1"  class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">邮箱</td>
				<td width="50%">
					<input type="text" name="email" value="${user.email }" id="email1"  class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">备注</td>
				<td width="50%">
					<input type="text" name="remarks" value="${user.remarks }" id="remarks1"  class="dfinput" />
				</td>
			</tr>
			<tr>
				<td class="ftTd" align="left">职位</td>
				<td width="50%">
					<select size="1" name="job_id" id="job_id1">
						<c:forEach items="${jobList}" var="j">
							<option value="${j.job_id}">${j.job_name}</option>
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



















