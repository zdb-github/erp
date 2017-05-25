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

		<title>修改销售订单</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/admin-all.css" />
		<link rel="stylesheet" type="text/css" href="css/ui-lightness/jquery-ui-1.8.22.custom.css" />
		
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.8.22.custom.min.js"></script>
		<script type="text/javascript" src="js/tip.js"></script>
		<script type="text/javascript" src="js/alert.js"></script>
		<script type="text/javascript" src="js/dropdown.js"></script>
		
		
		<script type="text/javascript">
$(function() {
	$(".datepicker").datepicker();
	$('#po_id1').tooltip( {
		title : '单据号'
	});
	$('#date1').tooltip( {
		title : '单据日期'
	});
	$('#supplier_id1').tooltip( {
		title : '供应商'
	});
	$('#purchaser_id1').tooltip( {
		title : '采购员'
	});
	$('#dept_id1').tooltip( {
		title : '部门'
	});
	$('#po_amount1').tooltip( {
		title : '金额'
	});
	$('#organization_id1').tooltip( {
		title : '所属机构 '
	});
	$('#invoices_state').tooltip( {
		title : '单据状态'
	});
	
	$('#formid').dropdown();
	
	$('#updateGoods').click(function () {
                $('#alert-win').dialog({
                    width: 800,
                    height: 400,
                    buttons: { "关闭": function () { $(this).dialog("close"); } }
                });
                $( "#alert-win" ).dialog({
				   close: function(event, ui) {
                	
				    window.location.href="saleOrder/toUpdateSo.do?so_id=${erpSaleOrder.so_id}";
				   }
				});
            })
	
   	$("#backToList").click(function(){
		window.location.href="saleOrder/toListSo.do";
		
	});
});
</script>
<script type="text/javascript">
	function jz(){
		
		var supplierArr = document.getElementById("customer_id1");
	  		for(var i=0;i<supplierArr.options.length;i++){
	  			if(supplierArr.options[i].value=="${erpSaleOrder.customer_id}"){
	  				supplierArr.options[i].selected = true;
	  				break;
	  			}
	  		}
		
	  		var deptArr = document.getElementById("dept_id1");
	  		for(var i=0;i<deptArr.options.length;i++){
	  			if(deptArr.options[i].value=="${erpSaleOrder.dept_id}"){
	  				deptArr.options[i].selected = true;
	  				break;
	  			}
	  		}
	  		
	  		var organizationArr = document.getElementById("organization_id1");
	  		for(var i=0;i<organizationArr.options.length;i++){
	  			if(organizationArr.options[i].value=="${erpSaleOrder.organization_id}"){
	  				organizationArr.options[i].selected = true;
	  				break;
	  			}
	  		}
	  		
	  		var purchaserArr = document.getElementById("salesman_id1");
	  		for(var i=0;i<purchaserArr.options.length;i++){
	  			if(purchaserArr.options[i].value=="${erpSaleOrder.salesman_id}"){
	  				purchaserArr.options[i].selected = true;
	  				break;
	  			}
	  		}
	  		
	  		
	  		var stateArr = document.getElementById("invoices_state1");
	  		for(var i=0;i<stateArr.options.length;i++){
	  			if(stateArr.options[i].value=="${erpSaleOrder.invoices_state}"){
	  				stateArr.options[i].selected = true;
	  				break;
	  			}
	  		}
		
	  		var deliveryArr = document.getElementById("delivery_id1");
	  		for(var i=0;i<deliveryArr.options.length;i++){
	  			if(deliveryArr.options[i].value=="${erpSaleOrder.salesman_id}"){
	  				deliveryArr.options[i].selected = true;
	  				break;
	  			}
	  		}
	  		
	  		var paymentArr = document.getElementById("payment_method1");
	  		for(var i=0;i<warehouseArr.options.length;i++){
	  			if(warehouseArr.options[i].value=="${erpSaleOrder.payment_method}"){
	  				warehouseArr.options[i].selected = true;
	  				break;
	  			}
	  		}
	  		
	  		var saleTypeArr = document.getElementById("sale_type1");
	  		for(var i=0;i<saleTypeArr.options.length;i++){
	  			if(saleTypeArr.options[i].value=="${erpSaleOrder.sale_type}"){
	  				saleTypeArr.options[i].selected = true;
	  				break;
	  			}
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

	<body onload="jz()">
	<% int count=1; %>
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>销售订单管理
			<b class="tip"></b>修改销售订单
		</div>
		<div id="po">
		<form action="saleOrder/updateSo.do" method="post" id="myForm1"> 
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="6" class="auto-style2">
							&nbsp;请修改销售订单${erpSaleOrder.so_id}的信息
						</td>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td>
							单据号
						</td>
						<td >
							<input id="so_id1" name="so_id" style="width:220px; height:30px"  type="text" value="${erpSaleOrder.so_id}" readonly="readonly" />
						</td>
						<td>
							单据日期
						</td>
						<td>
							<input id="date1" class="span2 datepicker" style="width:220px; height:30px" type="text" name="create_time" value="${erpSaleOrder.create_time}" />
								<span class="add-on"><i class="icon-calendar"></i>
								</span>
						</td>
						<td>
							客户
						</td>
						<td>
							<select size="1" name="customer_id" id="customer_id1">
							<c:forEach items="${customerList}" var="c">
								<option value="${c.id}">${c.company}</option>
							</c:forEach>	
							</select>
						</td>
					</tr>
					<tr>
						<td>
							采购员
						</td>
						<td>
							<select size="1" name="salesman_id" id="salesman_id1">
								<c:forEach items="${userList}" var="u">
									<option value="${u.id}">${u.name}</option>
								</c:forEach>
							</select>
						</td>
						<td>
							部门
						</td>
						<td>
							<select size="1" name="dept_id" id="dept_id1">
								<c:forEach items="${deptList}" var="d">
									<option value="${d.dept_id}">${d.name}</option>
								</c:forEach>
							</select>
						</td>
						<td>
							单据状态
						</td>
						<td>
							<select size="1" name="invoices_state" id="invoices_state1">
								
								<option value="A">正常</option>
								<option value="B">作废</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							销售类型
						</td>
						<td>
							<select size="1" name="sale_type" id="sale_type1">
								<c:forEach items="${saleTypeList}" var="s">
									<option value="${s.key}">${s.value}</option>
								</c:forEach>
							</select>
						</td>
						<td>
							发运方式
						</td>
						<td>
							<select size="1" name="delivery_way" id="delivery_way1">
								<c:forEach items="${deliveryWayList}" var="d">
								
									<option value="${d.key}">${d.value}</option>
								</c:forEach>
							</select>
						</td>
						<td>
							支付方式
						</td>
						<td>
							<select size="1" name="payment_method" id="payment_method1">
								
								<c:forEach items="${paymentList}" var="p">
								
									<option value="${p.key}">${p.value}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						
						<td>
							所属机构
						</td>
						<td>
							<select size="1" name="organization_id" id="organization_id1">
								<c:forEach items="${organizationList}" var="o">
									<option value="${o.organization_id}">${o.name}</option>
								</c:forEach>
							</select>
						</td>
						
					</tr>
					<tr>
						<td colspan="6" align="right">
							<input class="btn btn-inverse" id="" type="submit" value="保存" />
							<input class="btn btn-inverse" id="updateGoods" type="button" value="修改销售商品" />
							<input class="btn btn-inverse" id="backToList" type="button" value="返回" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		</div>
		<!-- 销售订单中的商品列表 -->
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

				</tr>
				</thead>
				<tbody>
				<c:if test="${empty soGoodsList}">
					<tr>
						<td colspan="9">还没有添加商品！</td>
					</tr>
				
				</c:if>
				<c:if test="${!empty soGoodsList}">
					<c:forEach items="${soGoodsList}" var="gv">
						<tr>
							<td>
								<input name="selectBox" type="checkbox"/>
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
		
		
		
	<div id="alert-win" title="修改销售订单商品" style="display: none;">
        <iframe style="border: 0; width: 100%; height: 100%;" src="saleOrder/toListSoGoods.do?so_id=${erpSaleOrder.so_id}"></iframe>
    </div>


	</body>
</html>
