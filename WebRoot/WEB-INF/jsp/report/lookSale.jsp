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
		<link href="<%=basePath%>css/style.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
		<script src="<%=basePath%>js/angular.min.js"></script>
		<script src="<%=basePath%>js/ui-bootstrap-tpls.min.js"></script>
		<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
		<!-- 分页引用的外部文件 -->
		<script src="<%=basePath%>js/jquery-1.4.4.min.js" type="text/javascript"></script>
    	<script src="<%=basePath%>js/smartpaginator.js" type="text/javascript"></script>
    	<link href="<%=basePath%>css/smartpaginator.css" rel="stylesheet" type="text/css" />
	
	
	
	<style type="text/css">
		.btn1{width:137px;height:35px; background:url(images/btnbg.png) no-repeat; font-size:14px;font-weight:bold;color:#fff; cursor:pointer;}
		.dfinput1{width:159px; height:90px; line-height:10px; border-top:solid 1px #a7b5bc; border-left:solid 1px #a7b5bc; border-right:solid 1px #ced9df; border-bottom:solid 1px #ced9df; background:url(../images/inputbg.gif) repeat-x; text-indent:20px;}
	</style>
		
		<script type="text/javascript">
function backList(){
		window.location.href="report/toListSale.do";
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
		<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>
					<a href="<%=basePath%>public/toWelcome.do">首页</a>
				</li>
				<li>
					<a href="report/toListSale.do">销售报表</a>
				</li>
				<li>
					<a href="report/toLookSale.do?sale_id=${erpSale.sale_id}">查看详细报表</a>
				</li>
			</ul>
		</div>
		<div id="po">
		 
			<table class="tablelist">
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
							<input class="btn1" id="backToList" type="button" value="返回"  onclick="backList()"/>
							
						</td>
					</tr>
				</tbody>
			</table>
	
		</div>
		<!-- 销售单中的商品列表 -->
		<div id="green-contents" class="contents">
			<table  id="mt" class="tablelist">
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
								<input name="selectBox" type="checkbox"  />
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
		</div>
		 <div id="green" style="margin: auto;">
            </div>	
	


	</body>
</html>
