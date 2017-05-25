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
    
    <title>添加销售订单的商品</title>
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
	$('#sale_id1').tooltip( {
		title : '销售单号'
	});
	$('#remark1').tooltip( {
		title : '备注 '
	});
	
		
	});


</script>
<script type="text/javascript">
        $(document).ready(function () {
            

            $('#green').smartpaginator({ totalrecords: ${totalRecode}, recordsperpage: 10, datacontainer: 'mt', dataelement: 'tr', initval: 0, next: 'Next', prev: 'Prev', first: 'First', last: 'Last', theme: 'green' });

        });
    </script>
  </head>
  
  <body>
		<div id="saleGoods">
		<form action="sale/addSaleGoods.do" method="post" id="myForm1"> 
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="6" class="auto-style2">
							&nbsp;请填写销售单商品的信息
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
							<input id="sale_id1" name="sale_id" style="width:220px; height:30px"  type="text" value="${sale_id}" readonly="readonly"/>
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
							<input class="btn btn-inverse" id="addGoods" type="submit" value="添加销售单商品" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		</div>
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
