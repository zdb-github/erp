<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>添加采购订单</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/admin-all.css" />
		<link rel="stylesheet" type="text/css" href="css/ui-lightness/jquery-ui-1.8.22.custom.css" />
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.8.22.custom.min.js"></script>
		<script type="text/javascript" src="js/tip.js"></script>
		<script type="text/javascript" src="js/alert.js"></script>
		<script type="text/javascript" src="js/dropdown.js"></script>

<script type="text/javascript">

function backList(){
	window.location.href="<%=basePath%>purchase/toListPurchase.do";
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
	<% int count = 1; %>
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>采购管理
			<b class="tip"></b>查看采购单
		</div>
		<div id="po">
		 
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="6" class="auto-style2">
							&nbsp;${erpPurchase.purchase_id}采购单的详细内容
						</td>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td>
							单据号
						</td>
						<td >
							${erpPurchase.purchase_id}
						</td>
						<td>
							单据日期
						</td>
						<td>
							${erpPurchase.create_time}
						</td>
						<td>
							单据状态
						</td>
						<td>
							${erpPurchase.stateVo}
						</td>
						
					</tr>
					<tr>
						<td>
							采购员
						</td>
						<td>
							${erpPurchase.purchaser_name}
						</td>
						<td>
							仓库
						</td>
						<td>
							${erpPurchase.warehouse_name}
						</td>
						<td>
							供应商
						</td>
						<td>
							${erpPurchase.supplier_name}
						</td>
						
					</tr>
					<tr>
						<td>
							金额
						</td>
						<td>
							${erpPurchase.purchase_amount}
						</td>
						<td>
							部门
						</td>
						<td>
							${erpPurchase.dept_name}
						</td>
						<td>
							所属机构
						</td>
						<td>
							${erpPurchase.organization_name}
						</td>
						
						
					</tr>
					<tr>
						<td>
							制单人
						</td>
						<td>
							${erpPurchase.originator_name}
						</td>
						<td>
							作废人
						</td>
						<td>
							${erpPurchase.invalid_name}
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						
						
					</tr>
					<tr>
						<td colspan="6" align="right">
							<input class="btn btn-inverse" id="backToList" type="button" value="返回" onclick="backList()"/>
							
						</td>
					</tr>
				</tbody>
			</table>
	
		</div>
		<!-- 采购订单中的商品列表 -->
			<table class="table table-striped table-bordered table-condensed" id="list">
			<thead  class="header">
				<tr>
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
				</tr>
				</thead>
				<c:if test="${empty purchaseGoodsList}">
					<tr>
						<td colspan="9">还没有添加商品！</td>
					</tr>
				
				</c:if>
				<c:if test="${!empty purchaseGoodsList}">
					<c:forEach items="${purchaseGoodsList}" var="gv">
						<tr>
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
						</tr>
					</c:forEach>
				</c:if>
				
				
			</table>
		
		
	


	</body>
</html>
