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

		<title>查看退货单</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/admin-all.css" />
		<link rel="stylesheet" type="text/css" href="css/ui-lightness/jquery-ui-1.8.22.custom.css" />
		
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.8.22.custom.min.js"></script>
		<script type="text/javascript" src="js/tip.js"></script>
		<script type="text/javascript" src="js/alert.js"></script>
		<script type="text/javascript" src="js/dropdown.js"></script>
		
		<!-- 分页引用的样式 -->
    	<script src="<%=basePath%>js/jquery-1.4.4.min.js" type="text/javascript"></script>
    	<script src="<%=basePath%>js/smartpaginator.js" type="text/javascript"></script>
    	<link href="<%=basePath%>css/smartpaginator.css" rel="stylesheet" type="text/css" />
	
<script type="text/javascript">
function backList(){
	window.location.href="saleReturn/toListSr.do";
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
	<% int count = 1; %>
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>销售管理
			<b class="tip"></b>查看销售退货单
		</div>
		<div id="po">
		 
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="6" class="auto-style2">
							&nbsp;销售退货单${erpSaleReturn.sr_id}的详细信息
						</td>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td>
							单据号
						</td>
						<td >
							${erpSaleReturn.sr_id}
						</td>
						<td>
							单据日期
						</td>
						<td>
							${erpSaleReturn.create_time}
						</td>
						<td>
							单据状态
						</td>
						<td>
							${erpSaleReturn.stateVo}
						</td>
						
					</tr>
					<tr>
						<td>
							经手人
						</td>
						<td>
							${erpSaleReturn.employee_name}
						</td>
						<td>
							金额
						</td>
						<td>
							${erpSaleReturn.money}
						</td>
						<td>
							客户
						</td>
						<td>
							${erpSaleReturn.customer_name}
						</td>
						
					</tr>
					<tr>
						<td>
							金额
						</td>
						<td>
							${erpSaleReturn.money}
						</td>
						<td>
							支付方式
						</td>
						<td>
							${erpSaleReturn.paymentMethodVo}
						</td>
						<td>
							所属机构
						</td>
						<td>
							${erpSaleReturn.organization_name}
						</td>
						
						
					</tr>
					
					<tr>
						<td>
							制单人
						</td>
						<td>
							${erpSaleReturn.originator_name}
						</td>
						<td>
							作废人
						</td>
						<td>
							${erpSaleReturn.invalid_name}
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
		<!-- 销售退货单中的商品列表 -->
	<div id="green-contents" class="contents">
			<table id="mt" class="table table-striped table-bordered table-condensed">
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
				<c:if test="${empty srGoodsList}">
					<tr>
						<td colspan="11">还没有添加商品！</td>
					</tr>
				
				</c:if>
				<c:if test="${!empty srGoodsList}">
					<c:forEach items="${srGoodsList}" var="gv">
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
		
		</div>
			<div id="green" style="margin: auto;">
            </div>	
	


	</body>
</html>
