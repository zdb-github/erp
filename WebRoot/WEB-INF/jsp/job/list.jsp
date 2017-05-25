<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="<%=basePath%>css/style.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="<%=basePath%>js/jquery.js">
</script>
		<script type="text/javascript">
$(document).ready(function() {
	$(".click").click(function() {
		$(".tip").fadeIn(200);
	});

	$(".tiptop a").click(function() {
		$(".tip").fadeOut(200);
	});

	$(".sure").click(function() {
		$(".tip").fadeOut(100);
	});

	$(".cancel").click(function() {
		$(".tip").fadeOut(100);
	});

});
</script>
		<script type="text/javascript">
function toAdd() {
	window.location.href = "<%=basePath%>job/toAdd.do";
}
function toList() {
	window.location.href = "<%=basePath%>job/toList.do";
}

function update(num) {
	document.getElementById("myFormUpdate" + num).submit();
}
function deleteJob(num) {
	if (confirm("是否要删除该信息!")) {
		document.getElementById("myFormDelete" + num).submit();
	} else {
		alert("删除操作已取消！ ");
	}
}

function cx() {
	document.getElementById("myForm1").submit();

}

function deleteAlls() {
	var m = 0;
	var str = "";
	var selectList = document.getElementsByName("select");

	for ( var i = 0; i < selectList.length; i++) {

		if (selectList[i].checked == true) {

			m++;
			str += selectList[i].value + ",";
		}
	}
	str = str.substring(0, str.length - 1);
	document.getElementById("deleteB").value = str;
	if (m > 0) {
		if (confirm("是否要删除所选信息？")) {
			document.getElementById("deleteAlls").submit();
		} else {
			alert("已取消操作！");
		}
	} else {
		alert("请至少选择一条数据");
	}
}

function selectAll() {

	var selectList = document.getElementsByName("select");
	if (document.getElementById("selectAll").checked == true) {
		for ( var i = 0; i < selectList.length; i++) {
			selectList[i].checked = true;
		}
	} else {
		for ( var i = 0; i < selectList.length; i++) {
			selectList[i].checked = false;
		}
	}

}
function fuzzySearch() {
	var str = document.getElementById("searchALl1").value;
	document.getElementById("searchId").value = str;
	document.getElementById("searchAll").submit();
}
</script>

	</head>

	<body>
	<%
		int count = 1;
		%>
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>
					<a href="<%=basePath%>public/toWelcome.do">首页</a>
				</li>
				<li>
					<a href="#">职位管理</a>
				</li>
				<li>
					<a href="#">职位列表</a>
				</li>
			</ul>
		</div>
		<div class="rightinfo">

			<div class="tools">

				<ul class="toolbar">
					<li onclick="toAdd()">
						<span><img src="<%=basePath%>img/t01.png" /> </span>添加
					</li>
					<li id="deleteAll" onclick="deleteAlls()">
						<span><img src="<%=basePath%>img/t03.png" /> </span>批量删除
					</li>
					<li id="listMy" onclick="toList()">
						<span><img src="<%=basePath%>img/t04.png" /> </span>列表
					</li>
				</ul>
				输入查询条件
				<input type="text" class="dfinput" name="str" id="searchALl1"
					height="100%" />
				&nbsp;
				<input class="btn" type="button" value="查询" onclick="fuzzySearch()" />
				<form id="deleteAlls" action="<%=basePath%>job/toDelete.do"
					method="post">
					<input type="hidden" id="deleteB" name="job_id" />
				</form>
				<form id="searchAll" action="<%=basePath%>job/toList.do"
					method="post">
					<input type="hidden" id="searchId" name="con" />
				</form>

			</div>

			<table class="tablelist">
			<thead>
				<tr>
					<th><input id="selectAll" type="checkbox" onclick="selectAll()" />
					</th>
					<th>编号</th>
					<th>职位名称</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty jobList}">
					<tr>
						<td colspan="5" align="center">里面没有内容</td>
					</tr>
				</c:if>
				<c:if test="${!empty jobList}">
					<c:forEach items="${jobList}" var="jo">
						<tr>
							<td><input name="select" type="checkbox" value="${jo.job_id }" />
							</td>
							<td><%=count%></td>
							<td>${jo.job_name}</td>
							<td>${jo.stateVo}</td>
							<td>
								<form id="myFormDelete<%=count%>" action="<%=basePath%>job/toDelete.do"
									method="post">
									<input type="hidden" name="job_id" value="${jo.job_id}" />
								</form>
								<form id="myFormUpdate<%=count%>" action="<%=basePath%>job/toUpdate.do"
									method="post">
									<input type="hidden" name="job_id" value="${jo.job_id}" />
								</form> 
								<a href="javascript:void(0)" onclick="update(<%=count%>)">修改</a>&nbsp;&nbsp; 
								<a href="javascript:void(0)" onclick="deleteJob(<%=count++%>)">删除</a>&nbsp;
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>

			

		</div>

		<script type="text/javascript">
$('.tablelist tbody tr:odd').addClass('odd');
</script>

	</body>

</html>