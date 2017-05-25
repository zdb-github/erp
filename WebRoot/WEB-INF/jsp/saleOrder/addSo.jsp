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

		<title>添加销售订单</title>
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
	$('#so_id1').tooltip( {
		title : '单据号'
	});
	$('#create_time').tooltip( {
		title : '单据日期'
	});
	$('#customer_id1').tooltip( {
		title : '客户'
	});
	$('#salesman').tooltip( {
		title : '销售员'
	});
	$('#dept_id1').tooltip( {
		title : '部门'
	});
	$('#delivery_way1').tooltip( {
		title : '货运方式'
	});
	$('#organization_id1').tooltip( {
		title : '所属机构 '
	});
	$('#invoices_state1').tooltip( {
		title : '单据状态'
	});
	$('#payment_method1').tooltip( {
		title : '支付方式'
	});
	$('#sale_type1').tooltip( {
		title : '销售类型'
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
                	
				    window.location.href="saleOrder/toAddSo.do?so_id=${so_id}";
				   }
				});
     });
	
	$("#backToList").click(function(){
		window.location.href="saleOrder/toListSo.do";
		
	});
	
});
</script>
<script type="text/javascript">

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
	<% int count =1; %>
		<div class="alert alert-info">
			当前位置
			<b class="tip"></b>销售管理
			<b class="tip"></b>添加销售订单
		</div>
		<div id="po">
		<form action="saleOrder/addSo.do" method="post" id="myForm1"> 
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="6" class="auto-style2">
							&nbsp;请填写销售订单的主表内容
						</td>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td>
							单据号
						</td>
						<td >
							<input id="so_id1" name="so_id" style="width:220px; height:30px"  type="text" value="${so_id}" readonly="readonly" />
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
							客户
						</td>
						<td>
							<select size="1" name="customer_id" id="customer_id1">
								<option value="">请选择</option>
								<c:forEach items="${customerList}" var="c">
									<option value="${c.id}">${c.company}</option>
								</c:forEach>	
							</select>
						</td>
					</tr>
					<tr>
						<td>
							销售员
						</td>
						<td>
							<select size="1" name="salesman_id" id="salesman_id1">
								<option value="">请选择</option>
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
								<option value="">请选择</option>
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
								<option value="">请选择</option>
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
								<option value="">请选择</option>
								<c:forEach items="${deliveryWayList}" var="d">
									<option value="${d.key}">${d.value}</option>
								</c:forEach>
							</select>
						</td>
						<td>
							支付方式
						</td>
						<td>
							<select size="1" name="payment_method" id="payment_way1">
								<option value="">请选择</option>
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
								<option value="">请选择</option>
								<c:forEach items="${organizationList}" var="o">
									<option value="${o.organization_id}">${o.name}</option>
								</c:forEach>
							</select>
						</td>
						
					</tr>
					<tr>
						<td colspan="6" align="right">
							<input class="btn btn-inverse" id="addGoods" type="button" value="添加销售订单的商品" />
							<input class="btn btn-inverse" id="" type="submit" value="保存" />
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
						<td colspan="11">还没有添加商品！</td>
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
		
		
	<div id="alert-win" title="添加销售订单商品" style="display: none;">
        <iframe style="border: 0; width: 100%; height: 100%;" src="saleOrder/toAddSoGoods.do?so_id=${so_id}"></iframe>
    </div>


	</body>
</html>
