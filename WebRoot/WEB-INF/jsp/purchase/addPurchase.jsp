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

		<title>添加采购单</title>
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
	$('#create_time1').tooltip( {
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
	$('#invoices_state1').tooltip( {
		title : '单据状态'
	});
	
	$('#formid').dropdown();
	
	$('#addGoods').click(function () {
                $('#alert-win').dialog({
                    width: 800,
                    height: 400,
                    buttons: { "关闭": function () { $(this).dialog("close"); } }
                });
                $( "#alert-win" ).dialog({
				   close: function(event, ui) {
				    window.location.href="purchase/toAddPurchase.do?purchase_id=${purchase_id}";
				   }
				});
     });
	
	$("#backToList").click(function(){
		window.location.href="purchase/toListPurchase.do";
		
	});
	
});
</script>
	</head>

	<body>
	<% int count =1; %>
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>采购管理
			<b class="tip"></b>添加采购单
		</div>
		<div id="po">
		<form action="purchase/addPurchase.do" method="post" id="myForm1"> 
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="6" class="auto-style2">
							&nbsp;请填写采购单的主表内容
						</td>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td>
							单据号
						</td>
						<td >
							<input id="purchase_id1" name="purchase_id" style="width:220px; height:30px"  type="text" value="${purchase_id}" readonly="readonly" />
						</td>
						<td>
							单据日期
						</td>
						<td>
							<input id="create_time1" class="span2 datepicker" style="width:220px; height:30px" type="text" name="create_time"  />
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
								<option value="">
												请选择
										</option>
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
								<option value="">请选择</option>
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
								<option value="">请选择</option>
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
								<option value="">请选择</option>
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
								<option value="">请选择</option>
								<c:forEach items="${organizationList}" var="o">
									<option value="${o.organization_id}">${o.name}</option>
								</c:forEach>
							</select>
						</td>
						
					</tr>
					<tr>
						<td colspan="6" align="right">
							<input class="btn btn-inverse" id="addGoods" type="button" value="添加采购商品" />
							<input class="btn btn-inverse" id="" type="submit" value="保存" />
							<input class="btn btn-inverse" id="backToList" type="button" value="返回" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		</div>
		<!-- 采购单中的商品列表 -->
			<table class="table table-striped table-bordered table-condensed" id="list">
			<thead  class="header">
				<tr>
					<th>
						<input id="selectAll" type="checkbox" onclick="selectAll()" />
					</th>
					<th>
						编号
					</th>
					<td>
						商品编号
					</td>
					<td>
						商品名称
					</td>
					<td>
						商品数量
					</td>
					<td>
						商品单价
					</td>
					<td>
						商品类型
					</td>
					<td>
						商品单位
					</td>
					<td>
						商品所在仓库
					</td>
					
					<td>
						总金额
					</td>
					<td>
						备注
					</td>
				</tr>
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
				
				
			</table>
		
		
	<div id="alert-win" title="添加采购单商品" style="display: none;">
        <iframe style="border: 0; width: 100%; height: 100%;" src="purchase/toAddPurchaseGoods.do?purchase_id=${purchase_id}"></iframe>
    </div>


	</body>
</html>
