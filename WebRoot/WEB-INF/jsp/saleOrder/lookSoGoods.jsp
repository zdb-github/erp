<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看商品详细页</title>
    	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/admin-all.css" />
		<link rel="stylesheet" type="text/css" href="css/ui-lightness/jquery-ui-1.8.22.custom.css" />
		
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.8.22.custom.min.js"></script>
		<script type="text/javascript" src="js/tip.js"></script>
		<script type="text/javascript" src="js/alert.js"></script>
		<script type="text/javascript" src="js/dropdown.js"></script>

  </head>
  
  <body>
    <div>
    	<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="6" class="auto-style2">
							&nbsp;查看销售订单${erpSoGoodsVo.goods_id}的商品信息
						</td>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td>
							商品编号
						</td>
						<td >
							${erpSoGoodsVo.goods_id}
						</td>
						<td>
							商品名称
						</td>
						<td>
							${erpSoGoodsVo.goods_name}
						</td>
						<td>
							销售单据号
						</td>
						<td>
							${erpSoGoodsVo.so_id}
						</td>
					</tr>
					<tr>
						
						<td>
							商品单价
						</td>
						<td>
							${erpSoGoodsVo.goods_prices}
						</td>
						<td>
							商品数量
						</td>
						<td>
							${erpSoGoodsVo.goods_num}
						</td>
						<td>
							总额
						</td>
						<td>
							${erpSoGoodsVo.sumAmount}
						</td>
					</tr>
					<tr>
						<td>
							商品单位
						</td>
						<td>
							${erpSoGoodsVo.goods_unit}
						</td>
						
						<td>
							商品所在仓库
						</td>
						<td>
							${erpSoGoodsVo.warehouse_name}
						</td>
						<td>
							备注
						</td>
						<td>
							${erpSoGoodsVo.remark}
						</td>
					</tr>
					<tr>
						<td colspan="6" align="right">
						<form action="saleOrder/toListSoGoods.do" method="post">
							<input type="hidden" name="so_id" value="${erpSoGoodsVo.po_id}">
							<input class="btn btn-inverse" id="addGoods" type="submit" value="返回" />
						</form>
						</td>
					</tr>
				</tbody>
			</table>
    
    
    
    </div>
  </body>
</html>
