<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName

()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>查看销售单</title>
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
	window.location.href="<%=basePath%>sale/toListSale.do";
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
			<b class="tip"></b>销售管理管理
			<b class="tip"></b>查看销售单
		</div>
		<div id="po">
		 
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="6" class="auto-style2">
							&nbsp;${erpSale.sale_id}销售单的详细内容
						</td>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td>
							单据号
						</td>
						<td >
							${erpSale.sale_id}
						</td>
						<td>
							单据日期
						</td>
						<td>
							${erpSale.create_time}
						</td>
						<td>
							单据状态
						</td>
						<td>
							${erpSale.stateVo}
						</td>
						
					</tr>
					<tr>
						<td>
							采购员
						</td>
						<td>
							${erpSale.salesman_name}
						</td>
						<td>
							部门
						</td>
						<td>
							${erpSale.dept_name}
						</td>
						<td>
							供应商
						</td>
						<td>
							${erpSale.customer_name}
						</td>
						
					</tr>
					<tr>
						<td>
							金额
						</td>
						<td>
							${erpSale.money}
						</td>
						<td>
							制单人
						</td>
						<td>
							${erpSale.originator_name}
						</td>
						<td>
							所属机构
						</td>
						<td>
							${erpSale.organization_name}
						</td>
						
						
					</tr>
					<tr>
						<td>
							销售类型
						</td>
						<td>
							${erpSale.saleTypeVo}
						</td>
						<td>
							发运方式
						</td>
						<td>
							${erpSale.deliveryWayVo}
						</td>
						<td>
							支付方式
						</td>
						<td>
							${erpSale.paymentMethodVo}
						</td>
						
						
					</tr>
					<tr>
						<td>
							制单人
						</td>
						<td>
							${erpSale.originator_name}
						</td>
						<td>
							作废人
						</td>
						<td>
							${erpSale.invalid_name}
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
		<!-- 销售单中的商品列表 -->
			<table class="table table-striped table-bordered table-condensed" id="list">
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
						<td colspan="9">还没有添加商品！</td>
					</tr>
				
				</c:if>
				<c:if test="${!empty saleGoodsList}">
					<c:forEach items="${saleGoodsList}" var="gv">
						<tr>
							<td>
								<input name="selectBox" type="checkbox" />
							</td>
							<td>
								<%=count++%>	
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
				
				</tbody>
			</table>
		
	


	</body>
</html>
