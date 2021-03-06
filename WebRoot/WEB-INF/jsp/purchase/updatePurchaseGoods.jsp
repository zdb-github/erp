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
    
    <title>添加采购订单的商品</title>
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
	$('#purchase_id1').tooltip( {
		title : '采购单号'
	});
	$('#remark1').tooltip( {
		title : '备注 '
	});
	
		
	});


</script>
<script type="text/javascript">
	function jz(){
		
			var goodsArr = document.getElementById("goods_id1");
	  		for(var i=0;i<goodsArr.options.length;i++){
	  			if(goodsArr.options[i].value=="${erpPurchaseGoodsVo.goods_id}"){
	  				goodsArr.options[i].selected = true;
	  				break;
	  			}
	  		}
		
	}


</script>

  </head>
  
  <body onload="jz()">
		<div id="poGoods">
		<form action="purchase/updatePurchaseGoods.do" method="post" id="myForm1"> 
			<table class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<td colspan="6" class="auto-style2">
							&nbsp;修改采购商品的信息
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
									<option value="${g.goods_id}">${g.goods_name}</option>
								</c:forEach>
							</select>
						</td>
						<td>
							商品数量
						</td>
						<td>
							<input id="goods_num1" name="goods_num" style="width:220px; height:30px" value="${erpPurchaseGoodsVo.goods_num}" type="text" />
						</td>
						
						
					</tr>
					<tr>
						
						<td>
							采购单据号
						</td>
						<td>
							<input id="purchase_id1" name="purchase_id" style="width:220px; height:30px"  type="text" value="${erpPurchaseGoodsVo.purchase_id}" readonly="readonly"/>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							备注
						</td>
						<td>
							<input id="remark1" name="remark" style="width:220px; height:30px" value="${erpPurchaseGoodsVo.remark}"  type="text" />
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						
					</tr>
					<tr>
						<td colspan="6" align="right">
							<input type="hidden" id="id1" name="id" value="${erpPurchaseGoodsVo.id}"/>
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
