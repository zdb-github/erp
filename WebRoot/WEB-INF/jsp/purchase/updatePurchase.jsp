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

		<title>修改采购订单</title>
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
	$('#warehouse_id1').tooltip( {
		title : '仓库'
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
                	
				    window.location.href="purchase/toUpdatePurchase.do?purchase_id=${erpPurchase.purchase_id}";
				   }
				});
            })
	
   	$("#backToList").click(function(){
		window.location.href="purchase/toListPurchase.do";
		
	});
	
            
            
            
});
</script>
<script type="text/javascript">
	function jz(){
		
		var supplierArr = document.getElementById("supplier_id1");
	  		for(var i=0;i<supplierArr.options.length;i++){
	  			if(supplierArr.options[i].value=="${erpPurchase.supplier_id}"){
	  				supplierArr.options[i].selected = true;
	  				break;
	  			}
	  		}
		
	  		var deptArr = document.getElementById("dept_id1");
	  		for(var i=0;i<deptArr.options.length;i++){
	  			if(deptArr.options[i].value=="${erpPurchase.dept_id}"){
	  				deptArr.options[i].selected = true;
	  				break;
	  			}
	  		}
	  		
	  		var organizationArr = document.getElementById("organization_id1");
	  		for(var i=0;i<organizationArr.options.length;i++){
	  			if(organizationArr.options[i].value=="${erpPurchase.organization_id}"){
	  				organizationArr.options[i].selected = true;
	  				break;
	  			}
	  		}
	  		
	  		var purchaserArr = document.getElementById("purchaser_id1");
	  		for(var i=0;i<purchaserArr.options.length;i++){
	  			if(purchaserArr.options[i].value=="${erpPurchase.purchaser_id}"){
	  				purchaserArr.options[i].selected = true;
	  				break;
	  			}
	  		}
	  		
	  		var warehouseArr = document.getElementById("warehouse_id1");
	  		for(var i=0;i<warehouseArr.options.length;i++){
	  			if(warehouseArr.options[i].value=="${erpPurchase.warehouse_id}"){
	  				warehouseArr.options[i].selected = true;
	  				break;
	  			}
	  		}
	  		
	  		var stateArr = document.getElementById("invoices_state1");
	  		for(var i=0;i<stateArr.options.length;i++){
	  			if(stateArr.options[i].value=="${erpPurchase.invoices_state}"){
	  				stateArr.options[i].selected = true;
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
	<%int count = 1; %>
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>采购管理
			<b class="tip"></b>修改采购单
		</div>
		<div id="po">
		<form action="purchase/updatePurchase.do" method="post" id="myForm1"> 
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="6" class="auto-style2">
							&nbsp;请修改采购单${erpPurchase.purchase_id}的主表内容
						</td>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td>
							单据号
						</td>
						<td >
							<input id="purchase_id" name="purchase_id" style="width:220px; height:30px"  type="text" value="${erpPurchase.purchase_id}" readonly="readonly" />
						</td>
						<td>
							单据日期
						</td>
						<td>
							<input id="date1" class="span2 datepicker" style="width:220px; height:30px" type="text" name="create_time" value="${erpPurchase.create_time}" />
								<span class="add-on"><i class="icon-calendar"></i>
								</span>
						</td>
						<td>
							供应商
						</td>
						<td>
							<select size="1" name="supplier_id" id="supplier_id1">
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
							<select size="1" name="purchaser_id" id="purchaser_id1">
								<c:forEach items="${userList}" var="u">
									<option value="${u.id}">${u.name}</option>
								</c:forEach>
							</select>
						</td>
						<td>
							仓库
						</td>
						<td>
							<select size="1" name="warehouse_id" id="warehouse_id1">
								<c:forEach items="${warehouseList}" var="w">
								
									<option value="${w.warehouse_id}">${w.name}</option>
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
							<input class="btn btn-inverse" id="updateGoods" type="button" value="修改采购商品" />
							<input class="btn btn-inverse" id="backToList" type="button" value="返回" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		</div>
		<!-- 采购订单中的商品列表 -->
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
				<c:if test="${empty purchaseGoodsList}">
					<tr>
						<td colspan="9">还没有添加商品！</td>
					</tr>
				
				</c:if>
				<c:if test="${!empty purchaseGoodsList}">
					<c:forEach items="${purchaseGoodsList}" var="gv">
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

		
	<div id="alert-win" title="修改采购订单商品" style="display: none;">
        <iframe style="border: 0; width: 100%; height: 100%;" src="purchase/toListPurchaseGoods.do?purchase_id=${erpPurchase.purchase_id}"></iframe>
    </div>


	</body>
</html>
