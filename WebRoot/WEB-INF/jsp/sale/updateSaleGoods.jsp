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
    
    <title>修改销售单的商品</title>
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


			var goodsArr = document.getElementById("goods_id1");
	  		for(var i=0;i<goodsArr.options.length;i++){
	  			if(goodsArr.options[i].value=="${erpCashStatement.statement_id}"){
	  				goodsArr.options[i].selected = true;
	  				break;
	  			}
	  		}



</script>

  </head>
  
  <body>
		<div id="poGoods">
		<form action="sale/updateSaleGoods.do" method="post" id="myForm1"> 
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="6" class="auto-style2">
							&nbsp;修改${erpSaleGoodsVo.sale_id}销售单的商品信息
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
									<option value="${g.statement_id}">${g.goods_name}---${g.goods_num}
									</option>								
								</c:forEach>
							</select>
						</td>
						<td>
							商品数量
						</td>
						<td>
							<input id="goods_num1" name="goods_num" style="width:220px; height:30px" value="${erpSaleGoodsVo.goods_num}" type="text" />
						</td>
						
						
					</tr>
					<tr>
						
						<td>
							销售单单据号
						</td>
						<td>
							<input id="sale_id1" name="sale_id" style="width:220px; height:30px"  type="text" value="${erpSaleGoodsVo.sale_id}" readonly="readonly"/>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							备注
						</td>
						<td>
							<input id="remark1" name="remark" style="width:220px; height:30px" value="${erpSaleGoodsVo.remark}"  type="text" />
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						
					</tr>
					<tr>
						<td colspan="6" align="right">
							<input type="hidden" id="id1" name="id" value="${erpSaleGoodsVo.id}"/>
							<input type="hidden" id="updateNum1" name="updateNum" value="${updateNum}"/>
							<input class="btn btn-inverse" id="addGoods" type="submit" value="确认修改" />
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		</div>
	
		
  </body>
</html>
