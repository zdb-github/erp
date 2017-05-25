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
    
    <title>添加退货单的商品</title>
   		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/admin-all.css" />
		<link rel="stylesheet" type="text/css" href="css/ui-lightness/jquery-ui-1.8.22.custom.css" />
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.8.22.custom.min.js"></script>
		<script type="text/javascript" src="js/tip.js"></script>
		<script type="text/javascript" src="js/alert.js"></script>
		<script type="text/javascript" src="js/dropdown.js"></script>
		
		
<script type="text/javascript">
	$(function(){
		
	$('#goods_id1').tooltip( {
		title : '商品名称'
	});
	$('#goods_num1').tooltip( {
		title : '商品数量'
	});
	$('#po_id1').tooltip( {
		title : '采购订单号'
	});
	$('#remark1').tooltip( {
		title : '备注 '
	});
	
		
	});


</script>
  </head>
  
  <body>
		<div id="srGoods">
		<form action="saleReturn/addSrGoods.do" method="post" id="myForm1"> 
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="6" class="auto-style2">
							&nbsp;请填写销售退货单${sr_id}的商品的信息
						</td>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td>
							商品名称
						</td>
						<td >
							<select size="1" name="goods_id" id="goods_id1">
								<c:forEach items="${goodsList}" var="g">
									<option value="${g.statement_id}">${g.goods_name}---${g.goods_num}</option>
								</c:forEach>
							</select>
						</td>
						<td>
							商品数量
						</td>
						<td>
							<input id="goods_num1" name="goods_num" style="width:220px; height:30px"  type="text" />
						</td>
						
						
					</tr>
					<tr>
						
						<td>
							采购单据号
						</td>
						<td>
							<input id="sr_id1" name="sr_id" style="width:220px; height:30px"  type="text" value="${sr_id}" readonly="readonly"/>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							备注
						</td>
						<td>
							<input id="remark1" name="remark" style="width:220px; height:30px"  type="text" />
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						
					</tr>
					<tr>
						<td colspan="6" align="right">
							<input class="btn btn-inverse" id="addGoods" type="submit" value="添加退货商品" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		</div>
			<table class="table table-striped table-bordered table-condensed" id="list">
			<thead  class="header">
				<tr>
					<td>
						编号
					</td>
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
				<c:if test="${empty srGoodsList}">
					<tr>
						<td colspan="9">还没有添加商品！</td>
					</tr>
				
				</c:if>
				<c:if test="${!empty srGoodsList}">
					<c:forEach items="${srGoodsList}" var="gv">
						<tr>
							<td>
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
