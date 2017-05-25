<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改成功</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript">
		var num=3;
		function redirect(){
			num--;
			document.getElementById("num").innerHTML=num;
			if(num<0){
				document.getElementById("num").innerHTML=0;
				this.parent.location.href="public/toBigdatalogin.do";
				}
			}
		setInterval("redirect()", 1000);
	</script>
	</head>

	<body>
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>
					<a href="<%=basePath%>public/toWelcome.do">首页</a>
				</li>
				<li>
					<a href="">修改成功</a>
				</li>
			</ul>
		</div>
    <h1 style="font-size: 40pt;" align="center">修改成功！</h1>
    <table align="center" width="95%">
    	<tr>
    		<td align ="center">
    		<a  style="background-color:red;font-size:10px;"id="num">3秒后重新登录</a>
    		</td>
    	</tr>
    </table>
   
  </body>
</html>
