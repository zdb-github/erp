<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.java.bean.Page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="<%=basePath%>css/style.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
		
		<!-- 分页引用的样式 -->
    <script src="<%=basePath%>js/jquery-1.4.4.min.js" type="text/javascript"></script>
    	<script src="<%=basePath%>js/smartpaginator.js" type="text/javascript"></script>
    	<link href="<%=basePath%>css/smartpaginator.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
        $(document).ready(function () {
            

            $('#green').smartpaginator({ totalrecords: ${totalRecode}, recordsperpage: 10, datacontainer: 'mt', dataelement: 'tr', initval: 0, next: 'Next', prev: 'Prev', first: 'First', last: 'Last', theme: 'green' });

        });
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

function addGoods() {
	document.getElementById("myFormAdd").submit();
}
function toListGoods() {
	document.getElementById("myFormList").submit();
}

function updateGoods(num) {
	document.getElementById("myFormUpdate" + num).submit();
}
function lookGoods(num) {
	document.getElementById("myFormLook" + num).submit();
}
function deleteGoods(num) {
	if (confirm("是否要删除该信息!")) {
		document.getElementById("myFormDelete" + num).submit();
	} else {
		alert("取消删除！ ");
	}
}

function cx() {
	document.getElementById("myForm1").submit();

}

function deleteAllGoods() {
	var m = 0;
	var str = "";
	var selectList = document.getElementsByName("selectBox");

	for ( var i = 0; i < selectList.length; i++) {

		if (selectList[i].checked == true) {

			m++;
			str += selectList[i].value + ",";
		}
	}
	str = str.substring(0, str.length - 1);
	document.getElementById("deleteMy").value = str;
	if (m > 0) {
		if (confirm("是否要删除所选信息？")) {
			document.getElementById("deleteAllGoods").submit();
		} else {
			alert("已取消操作！");
		}
	} else {
		alert("请至少选择一条数据");
	}
}
function updateGoods2() {
	var m = 0;
	var str = "";
	var selectList = document.getElementsByName("selectBox");
	for ( var i = 0; i < selectList.length; i++) {
		if (selectList[i].checked == true) {
			m++;
			str += selectList[i].value + ",";
		}
	}
	str = str.substring(0, str.length - 1);
	document.getElementById("updateMy").value = str;
	if (m > 1) {
		alert("每次只能修改一个用户，请重新选择！");
	} else if (m == 1) {
		document.getElementById("updateGoods").submit();

	} else {
		alert("请选择一条数据");
	}
}
function selectAll() {

	var selectList = document.getElementsByName("selectBox");
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
					<a href="<%=basePath%>sale/toListSaleGoods.do">销售单商品列表</a>
				</li>
				
			</ul>
		</div>
		<div class="rightinfo">
			<div class="tools">

				<ul class="toolbar">
					<li onclick="addGoods()">
						<span><img src="<%=basePath%>img/t01.png" /> </span>添加
					</li>
					<li id="updateM" onclick="updateGoods2()">
						<span><img src="<%=basePath%>img/t02.png" /> </span>修改
					</li>
					<li id="deleteAll" onclick="deleteAllGoods()">
						<span><img src="<%=basePath%>img/t03.png" /> </span>批量删除
					</li>

					<li id="listMy" onclick="toListGoods()">
						<span><img src="<%=basePath%>img/t04.png" /> </span>列表
					</li>

				</ul>
				
				
				<form id="myFormAdd" action="<%=basePath%>sale/toAddSaleGoods.do"
					method="post">
					<input type="hidden" name="sale_id" value="${sale_id}" />
				</form>
									
				<form id="myFormList" action="<%=basePath%>sale/toListSaleGoods.do"
					method="post">
					<input type="hidden" name="sale_id" value="${sale_id}" />
				</form>
				
				
				<form id="deleteAllGoods" action="<%=basePath%>sale/deleteSaleGoods.do"
					method="post">
					<input type="hidden" id="deleteAllGoods" name="id" />
				</form>
				<form id="updateGoods" action="<%=basePath%>sale/toUpdateSaleGoods.do"
					method="post">
					<input type="hidden" name="updateNum" value="${updateNum}" />
					<input type="hidden" id="updateMy" name="id" />
				</form>
				

			</div>


			<div id="green-contents" class="contents">
			<table id="mt" class="tablelist">
			<thead  class="header">
					<tr>
						<th>
							<input id="selectAll" type="checkbox" onclick="selectAll()" />
						</th>
						<th>
							编号
						</th>
						<th>
							商品编号
						</th>
						<th>
							商品名称
						</th>
						<th>
							商品数量
						</th>
						<th>
							商品单价
						</th>
						<th>
							商品类型
						</th>
						<th>
							商品单位
						</th>
						<th>
							商品所在仓库
						</th>
						<th>
							总金额
						</th>
						<th>
							备注
						</th>

						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
				
					<c:if test="${empty saleGoodsList}">
						<tr>
							<td colspan="12">还没有添加商品！</td>
						</tr>
				
					</c:if>
					<c:if test="${!empty saleGoodsList}">
					<c:forEach items="${saleGoodsList}" var="gv">
						<tr>
							<td>
								<input name="selectBox" type="checkbox"  value="${gv.id}"/>
							</td>
							<td>
								<%=count%>
							</td>
							<td>
								${gv.goods_id}
							</td>
							<td>
								${gv.goods_name}
							</td>
							<td>
								${gv.goods_num}
							</td>
							<td>
								${gv.goods_prices}
							</td>
							<td>
								${gv.goods_type}
							</td>
							<td>
								${gv.goods_unit}
							</td>
							<td>
								${gv.warehouse_name}
							</td>
							<td>
								${gv.sumAmount}
							</td>
							<td>
								${gv.remark}
							</td>
								<td>
									
									
									<form id="myFormLook<%=count%>" action="<%=basePath%>sale/toLookSaleGoods.do"
										method="post">
										<input type="hidden" name="sale_id" value="${gv.sale_id}" />
										<input type="hidden" name="id" value="${gv.id}" />
									</form>
									<form id="myFormDelete<%=count%>" action="<%=basePath%>sale/deleteSaleGoods.do"
										method="post">
										<input type="hidden" name="id" value="${gv.id}" />
									</form>
									<form id="myFormUpdate<%=count%>" action="<%=basePath%>sale/toUpdateSaleGoods.do" method="post">
										<input type="hidden" name="id" value="${gv.id}" />
										<input type="hidden" name="updateNum" value="${updateNum}" />
									</form>
									
									<a href="javascript:void(0)" onclick="lookGoods(<%=count%>)">查看</a>&nbsp;&nbsp;
									<a href="javascript:void(0)" onclick="updateGoods(<%=count%>)">修改</a>&nbsp;&nbsp;
									<a href="javascript:void(0)" onclick="deleteGoods(<%=count++%>)">删除</a>&nbsp;
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>

			</div>
			<div id="green" style="margin: auto;">
            </div>	

		</div>
	</body>
</html>

