<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>销售报表</title>
   	 	<link href="<%=basePath%>css/style.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
		<script src="<%=basePath%>js/angular.min.js"></script>
		<script src="<%=basePath%>js/ui-bootstrap-tpls.min.js"></script>
		<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
		<!-- 分页引用的外部文件 -->
		<script src="<%=basePath%>js/jquery-1.4.4.min.js" type="text/javascript"></script>
    	<script src="<%=basePath%>js/smartpaginator.js" type="text/javascript"></script>
    	<link href="<%=basePath%>css/smartpaginator.css" rel="stylesheet" type="text/css" />
		
	
	<style type="text/css">
		.btn1{width:137px;height:35px; background:url(images/btnbg.png) no-repeat; font-size:14px;font-weight:bold;color:#fff; cursor:pointer;}
		.dfinput1{width:159px; height:90px; line-height:10px; border-top:solid 1px #a7b5bc; border-left:solid 1px #a7b5bc; border-right:solid 1px #ced9df; border-bottom:solid 1px #ced9df; background:url(../images/inputbg.gif) repeat-x; text-indent:20px;}
	</style>
	
	<script type="text/javascript">
	
	function lookInvoices(num) {
		document.getElementById("myFormLook" + num).submit();
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
  <% int count =1; %>
    	<div class="place">
			<span>位置：</span>
			<ul class="placeul">
				<li>
					<a href="<%=basePath%>public/toWelcome.do">首页</a>
				</li>
				<li>
					<a href="report/toListSale.do">销售报表</a>
				</li>
				
			</ul>
		</div>
    	<div class="rightinfo">

    	<div id="">
    	
    		<form action="report/toListSale.do" method="post">
    			<table class="tablelist">
    				<thead>
    					<tr>
    						<td colspan="6">
    							<h3>请输入查询条件</h3>	
    						</td>
    					</tr>
    				</thead>
    				<tbody>
    					<tr>
    						<td style="height: 50px;">
								部门
							</td>
							<td>
								<select size="1" name="dept_id" id="dept_id1" class="dfinput1" style="height:30px;">
									<option value="">
										请选择
									</option>
									<c:forEach items="${deptList}" var="d">
										<option value="${d.dept_id}">
											${d.name}
										</option>
									</c:forEach>
								</select>
							</td>
    						<td>
								客户
							</td>
							<td>
								<select size="1" name="customer_id" id="customer_id1"  class="dfinput1" style="height:30px;">
									<option value="">
										请选择
									</option>
									<c:forEach items="${customerList}" var="c">
										<option value="${c.id}">
											${c.company}
										</option>
									</c:forEach>
								</select>
							</td>
    						<td>
								所属机构
							</td>
							<td>
								<select size="1" name="organization_id" id="organization_id1"  class="dfinput1" style="height:30px;">
									<option value="">


										请选择
									</option>


									<c:forEach items="${organizationList}" var="o">


										<option value="${o.organization_id}">


											${o.name}
										</option>
									</c:forEach>
								</select>
							</td>
						</tr>	
						<tr>
    						<td>
								销售类型
							</td>
							<td>
								<select size="1" name="sale_type" id="sale_type1"  class="dfinput1" style="height:30px;">
									<option value="">
										请选择
									</option>
									<c:forEach items="${saleTypeList}" var="s">
										<option value="${s.key}">
											${s.value}
										</option>
									</c:forEach>
								</select>
							</td>
    						<td>
								销售员
							</td>
							<td>
								<select size="1" name="salesman_id" id="salesman_id1"  class="dfinput1" style="height:30px;">
									<option value="">
										请选择
									</option>
									<c:forEach items="${userList}" var="u">
										<option value="${u.id}">
											${u.name}
										</option>
									</c:forEach>
								</select>
							</td>
							<td>
								销售日期
							</td>
							<td>
								<input type="text" name="create_time" id="create_time" class="dfinput1" style="height:30px;"/>
							</td>
    					</tr>
    				
    				</tbody>
    			</table>
    			<input type="submit"  value="查询" class="btn1" />
    		</form>
    	</div>
    	<div style="height: 30px">
    		
    	
    	</div>
    	
    	<div id="green-contents" class="contents">
			<table  id="mt" class="tablelist">
			<thead  class="header">
				<tr>
						<th>
							<input id="selectAll" type="checkbox" onclick="selectAll()" />
						</th>
						<th>
							编号
						</th>
						<th>
							单据状态

						</th>
						<th>
							单据编号
						</th>
						<th>
							单据日期
						</th>
						<th>
							客户
						</th>
						<th>
							金额
						</th>
						<th>
							销售部门
						</th>
						<th>
							销售员
						</th>
						
						<th>
							所属机构
						</th>
						<th>
							支付方式
						</th>
						<th>
							货运方式
						</th>
						<th>
							销售类型
						</th>
						<th>
							操作
						</th>

					</tr>
				</thead>
			<tbody>
					<c:if test="${empty erpSaleList}">
						<tr>
							<td colspan="14">
								里面没有内容
							</td>
						</tr>
					</c:if>
					<c:if test="${!empty erpSaleList}">
						<c:forEach items="${erpSaleList}" var="p">
							<tr>
								<td>
									<input name="selectBox" type="checkbox" value="${p.sale_id }" />
									<input type="hidden" value="${p.invoices_state}"
										name="invoices_state1" id="istate<%=count%>" />
								</td>
								<td><%=count++%></td>
								<td>
									${p.stateVo}
								</td>
								<td>
									${p.sale_id}
								</td>
								<td>
									${p.create_time}
								</td>
								<td>
									${p.customer_name}
								</td>
								<td>
									${p.money}
								</td>
								<td>
									${p.dept_name}
								</td>
								<td>
									${p.salesman_name}
								</td>
								<td>
									${p.organization_name}
								</td>
								<td>
									${p.paymentMethodVo}
								</td>
								<td>
									${p.deliveryWayVo}
								</td>
								<td>
									${p.saleTypeVo}
								</td>
								<td>
									<form id="myFormLook<%=count%>"
										action="<%=basePath%>report/toLookSale.do" method="post">
										<input type="hidden" name="sale_id" value="${p.sale_id}" />
									</form>
									<a href="javascript:void(0)" onclick="lookInvoices(<%=count%>)">查看</a>&nbsp;&nbsp;
									
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
		</table>
	</div>
		 <div id="green" style="margin: auto;">
            </div>	
     </div>
  </body>
</html>
