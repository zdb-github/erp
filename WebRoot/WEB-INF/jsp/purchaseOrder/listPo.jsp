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
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css"/>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/admin-all.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>css/ui-lightness/jquery-ui-1.8.22.custom.css" />

		<script type="text/javascript" src="<%=basePath%>js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/jquery-ui-1.8.22.custom.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/tip.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
		
		<!-- 分页引用的样式 -->
    	<script src="<%=basePath%>js/jquery-1.4.4.min.js" type="text/javascript"></script>
    	<script src="<%=basePath%>js/smartpaginator.js" type="text/javascript"></script>
    	<link href="<%=basePath%>css/smartpaginator.css" rel="stylesheet" type="text/css" />
		

		<script type="text/javascript">

function addInvoices() {
	window.location.href = "<%=basePath%>purchaseOrder/toAddPo.do";
}
function toListInvoices() {
	window.location.href = "<%=basePath%>purchaseOrder/toListPo.do";
}

function updateInvoices(num) {
	document.getElementById("myFormUpdate" + num).submit();
}
function lookInvoices(num) {
	document.getElementById("myFormLook" + num).submit();
}
function deleteInvoices(num) {
	if (confirm("是否要删除该信息!")) {
		document.getElementById("myFormDelete" + num).submit();
	} else {
		alert("取消删除！ ");
	}
}

function cx() {
	document.getElementById("myForm1").submit();

}

function deleteAllInvoices() {
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
	if (m > 1) {
		alert("每次只能删除一条数据，请重新选择！");
	} else if (m == 1) {
		if (confirm("是否要删除所选信息？")) {
			document.getElementById("deleteAllInvoices").submit();
		} else {
			alert("已取消操作！");
		}
	} else {

		alert("请至少选择一条数据");
	}
}
function updateInvoices2() {
	
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
		alert("每次只能修改一条数据，请重新选择！");
	} else if (m == 1) {
		
		document.getElementById("updateInvoices").submit();

	} else {
		alert("请选择一条数据");
	}
}

function toChangeInvoices() {
	
	var m = 0;
	var str = "";
	var indexNum;
	var selectList = document.getElementsByName("selectBox");
	for ( var i = 0; i < selectList.length; i++) {
		
		if (selectList[i].checked == true) {
			m++;
			str += selectList[i].value + ",";
			indexNum = i;
		}
	}
	indexNum +=1;
	str = str.substring(0, str.length - 1);
	var istate = document.getElementById("istate"+indexNum).value;
	
	document.getElementById("changeMy").value = str;
	if (m > 1) {
		alert("每次只能生成一条个采购单，请重新选择！");
	} else if (m == 1) {
		if(istate=="B"){
			
			alert("该订单已作废，不可生成采购单！");
		}else if(istate=="C"){
			
			alert("该订单已生成采购单，不可重复生成采购单！");
		}else{
			document.getElementById("changeInvoices").submit();
		}
		

	} else {
		alert("请选择一条数据");
	}
}
function toChangeState() {
	var m = 0;
	var str = "";
	var indexNum;
	var selectList = document.getElementsByName("selectBox");
	for ( var i = 0; i < selectList.length; i++) {
		
		if (selectList[i].checked == true) {
			m++;
			str += selectList[i].value + ",";
			indexNum = i;
		}
	}
	indexNum +=1;
	str = str.substring(0, str.length - 1);
	var istate = document.getElementById("istate"+indexNum).value;
	
	document.getElementById("changeMy2").value = str;
	if (m > 1) {
		alert("每次只能作废 一个采购订单，请重新选择！");
	} else if (m == 1) {
		if(istate=="B"){
			alert("该订单已经是作废状态，不可再次作废！");
		}else{
			if(confirm("是否要作废所选信息？")){
				document.getElementById("changeStateForm").submit();
			}else{
				alert("取消作废！");
			}
		}
		
	} else {
		alert("请选择一条数据");
	}
}
function toChangeState2() {
	var m = 0;
	var str = "";
	var indexNum;
	var selectList = document.getElementsByName("selectBox");
	for ( var i = 0; i < selectList.length; i++) {
		
		if (selectList[i].checked == true) {
			m++;
			str += selectList[i].value + ",";
			indexNum = i;
		}
	}
	indexNum +=1;
	str = str.substring(0, str.length - 1);
	var istate = document.getElementById("istate"+indexNum).value;
	
	document.getElementById("changeMy3").value = str;
	if (m > 1) {
		alert("每次只能作废 一个采购订单，请重新选择！");
	} else if (m == 1) {
		if(istate=="A"||istate=="C"){
			alert("该订单不是作废状态，无法取消作废！");
		}else{
			if(confirm("是否要取消作废所选信息？")){
				document.getElementById("changeStateForm2").submit();
			}else{
				alert("取消操作！");
			}
		}
		
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
<script type="text/javascript">
        $(document).ready(function () {
            $('#green').smartpaginator({ totalrecords: ${totalRecode}, recordsperpage: 10, datacontainer: 'mt', dataelement: 'tr', initval: 0, next: 'Next', prev: 'Prev', first: 'First', last: 'Last', theme: 'green' });

        });
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
					<a href="<%=basePath%>purchaseOrder/toListPo.do">采购订单列表</a>
				</li>
				
			</ul>
		</div>
		
			<!-- 查询采购订单 -->
			<div>
				<form action="<%=basePath%>purchaseOrder/toListPo.do" method="post">
					<table class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<td colspan="6" class="auto-style2">
									&nbsp;请填写查询条件
								</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									单据号
								</td>
								<td>
									<input id="po_id1" name="po_id"
										style="width: 220px; height: 30px" type="text" />
								</td>
								<td>
									单据日期
								</td>
								<td>
									<input id="date1" class="span2 datepicker" style="width:220px; height:30px" type="text" name="create_time"  />
									<span class="add-on"><i class="icon-calendar"></i>
									</span>
								</td>
								<td>
									供应商
								</td>
								<td>
									<select size="1" name="supplier_id" id="supplier_id1">
										<option value="">
												请选择
										</option>
										<c:forEach items="${customerList}" var="c">
											<option value="${c.id}">
												${c.company}
											</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									采购员
								</td>
								<td>
									<select size="1" name="purchaser_id" id="purchaser_id1">
										<option value="">
												请选择
										</option>
										<c:forEach items="${userList}" var="u">
											<option value="${u.id}">
												${u.name}
											</option>
										</c:forEach>
									</select>
								</td>
								<td>
									仓库
								</td>
								<td>
									<select size="1" name="warehouse_id" id="warehouse_id1">
										<option value="">
												请选择
										</option>
										<c:forEach items="${warehouseList}" var="w">

											<option value="${w.warehouse_id}">
												${w.name}
											</option>
										</c:forEach>
									</select>
								</td>
								<td>
									单据状态
								</td>
								<td>
									<select size="1" name="invoices_state" id="invoices_state1">
										<option value="">
												请选择
										</option>
										<option value="A">
											正常
										</option>
										<option value="B">
											作废
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									部门
								</td>
								<td>
									<select size="1" name="dept_id" id="dept_id1">
										<option value="">
												请选择
										</option>
										<c:forEach items="${deptList}" var="d">
											<option value="${d.dept_id}">
												${d.name}
											</option>
										</c:forEach>
									</select>
								</td>
								<td>
									所属机构
								</td>
								<td>
									<select size="1" name="organization_id" id="organization_id1">
										<option value="">
												请选择
										</option>
										<c:forEach items="${organizationList}" var="o">
											<option value="${o.organization_id}">
												${o.name}
											</option>
										</c:forEach>
									</select>
								</td>
								<td>
									制单人
								</td>
								<td>
									<select size="1" name="originatior_id" id="originatior_id1">
										<option value="">
												请选择
										</option>
										<c:forEach items="${userList}" var="u">
											<option value="${u.id}">
												${u.name}
											</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td colspan="6" align="right">
									
									<input class="btn btn-inverse" type="submit" value="查询" />
									<input class="btn btn-inverse" id="clearDate" type="button"
										value="清空" />
								</td>
							</tr>
						</tbody>
					</table>
				</form>

			</div>
			<div class="rightinfo">
			<div class="tools">
	<!-- 工具栏 -->
				<ul class="toolbar">
					<li onclick="addInvoices()">
						<span><img src="<%=basePath%>img/t01.png" /> </span>添加
					</li>
					<li id="updateM" onclick="updateInvoices2()">
						<span><img src="<%=basePath%>img/t02.png" /> </span>修改
					</li>
					<li id="deleteAll" onclick="deleteAllInvoices()">
						<span><img src="<%=basePath%>img/t03.png" /> </span>删除
					</li>

					<li id="listMy" onclick="toListInvoices()">
						<span><img src="<%=basePath%>img/t04.png" /> </span>列表
					</li>
					<li id="changeToP" onclick="toChangeInvoices()">
						<span><img src="<%=basePath%>img/t01.png" /> </span>生成采购单
					</li>
					
					<li id="changeState" onclick="toChangeState()">
						<span><img src="<%=basePath%>img/t03.png" /> </span>作废
					</li>
					
					<li id="changeState2" onclick="toChangeState2()">
						<span><img src="<%=basePath%>img/t02.png" /> </span>取消作废
					</li>
				</ul>
				<form id="deleteAllInvoices"
					action="<%=basePath%>purchaseOrder/deletePo.do" method="post">
					<input type="hidden" id="deleteMy" name="po_id" />
				</form>
				<form id="updateInvoices"
					action="<%=basePath%>purchaseOrder/toUpdatePo.do" method="post">
					<input type="hidden" id="updateMy" name="po_id" />
				</form>
				<form id="changeInvoices"
					action="<%=basePath%>purchase/addPurchase2.do" method="post">
					<input type="hidden" id="changeMy" name="po_id" />
				</form>
				<form id="changeStateForm"
					action="<%=basePath%>purchaseOrder/updatePo.do" method="post">
					<input type="hidden" id="changeMy2" name="po_id" />
					<input type="hidden" name="invoices_state" value="B"/>
				</form>
				<form id="changeStateForm2"
					action="<%=basePath%>purchaseOrder/updatePo.do" method="post">
					<input type="hidden" id="changeMy3" name="po_id" />
					<input type="hidden" name="invoices_state" value="A"/>
				</form>
			</div>
			<!-- 采购订单列表主体 -->
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
							单据状态
							
						</th>
						<th>
							单据编号
						</th>
						<th>
							单据日期
						</th>
						<th>
							供应商
						</th>
						<th>
							采购金额
						</th>
						<th>
							采购部门
						</th>
						<th>
							采购员
						</th>
						<th>
							仓库
						</th>
						<th>
							所属机构
						</th>

						<th>
							操作
						</th>

					</tr>
				</thead>
				<tbody>
					<c:if test="${empty erpPurchaseOrderList}">
						<tr>
							<td colspan="12">
								里面没有内容
							</td>
						</tr>
					</c:if>
					<c:if test="${!empty erpPurchaseOrderList}">
						<c:forEach items="${erpPurchaseOrderList}" var="p">
							<tr>
								<td>
									<input name="selectBox" type="checkbox" value="${p.po_id }" />
									<input type="hidden" value="${p.invoices_state}" name="invoices_state1" id="istate<%=count%>"/>
								</td>
								<td><%=count%></td>
								<td>
									${p.stateVo}
								</td>
								<td>
									${p.po_id}
								</td>
								<td>
									${p.create_time}
								</td>
								<td>
									${p.supplier_name}
								</td>
								<td>
									${p.po_amount}
								</td>
								<td>
									${p.dept_name}
								</td>
								<td>
									${p.purchaser_name}
								</td>
								<td>
									${p.warehouse_name}
								</td>
								<td>
									${p.organization_name}
								</td>
								<td>
									<form id="myFormLook<%=count%>"
										action="<%=basePath%>purchaseOrder/toLookPo.do" method="post">
										<input type="hidden" name="po_id" value="${p.po_id}" />
									</form>
									<form id="myFormDelete<%=count%>"
										action="<%=basePath%>purchaseOrder/deletePo.do" method="post">
										<input type="hidden" name="po_id" value="${p.po_id}" />
									</form>
									<form id="myFormUpdate<%=count%>"
										action="<%=basePath%>purchaseOrder/toUpdatePo.do"
										method="post">
										<input type="hidden" name="po_id" value="${p.po_id}" />
									</form>
									<a href="javascript:void(0)" onclick="lookInvoices(<%=count%>)">查看</a>&nbsp;&nbsp;
									<a href="javascript:void(0)"
										onclick="updateInvoices(<%=count%>)">修改</a>&nbsp;&nbsp;
									<a href="javascript:void(0)"
										onclick="deleteInvoices(<%=count++%>)">删除</a>&nbsp;
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

