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
  	 
	<link rel="stylesheet" type="text/css" href="css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="css/H-ui.admin.css" />
	<script type="text/javascript" src="js/jquery.min.js"></script> 
	<style type="text/css">
		.dfinput{width:345px; height:32px; line-height:32px; border-top:solid 1px #a7b5bc; border-left:solid 1px #a7b5bc; border-right:solid 1px #ced9df; border-bottom:solid 1px #ced9df; background:url(../img/inputbg.gif) repeat-x; text-indent:10px;}
	</style>
	</head>
	
	<body>
		<div class="row cl">
			<div>
			&nbsp;
			</div>
			&nbsp;
		</div>
		<form action="job/add.do" method="post">
		<div class="row cl">
			<label class="form-label col-xs-1 col-sm-2"><span ></span>职位名称：</label>
			<div class="formControls col-xs-3 col-sm-2">
				<input type="text" class="dfinput"   name="job_name" id="job_name1" >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-1 col-sm-2">状态：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<select name="state" id="formtype" class="dfinput">
	 				<c:forEach items="${codeList}" var="c">
							<option value="${c.key}">${c.value}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="row cl">
			<div class="formControls col-xs-8 col-sm-9">
				<dl class="permission-list">
					<dt>
						<label> <input type="checkbox" value="" >基本档案管理</label>
					</dt>
					<dd>
						<dl class="cl permission-list2" >
							<dt>
								<label class=""> <input type="checkbox" value="">仓库管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${warehouseList}" var="ware">
										<input name="resource" type="checkbox" value="${ware.id}" id="r<=count>" />${ware.resource_name}
									</c:forEach>
								</label> 
							</dd>
						</dl>
						<dl class="cl permission-list2">
							<dt>
								<label class=""> <input type="checkbox" value="">商品管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${goodsList}" var="g">
										<input name="resource" type="checkbox" value="${g.id}" id="r<=count>" />${g.resource_name}
									</c:forEach>
								</label> 
							</dd>
						</dl>
						<dl class="cl permission-list2">
							<dt>
								<label class=""> <input type="checkbox" value="">码表管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${erpCodeList}" var="code">
										<input name="resource" type="checkbox" value="${code.id}" id="r<=count>" />${code.resource_name}
									</c:forEach>
								</label> 
							</dd>
						</dl>
						<dl class="cl permission-list2">
							<dt>
								<label class=""> <input type="checkbox" value="">用户信息管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${customerList}" var="customers">
										<input name="resource" type="checkbox" value="${customers.id}" id="r<=count>" />${customers.resource_name}
									</c:forEach>
								</label> 
							</dd>
						</dl>
						<dl class="cl permission-list2">
							<dt>
								<label class=""> <input type="checkbox" value="">账号信息管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${myAccountList}" var="myAccount">
										<input name="resource" type="checkbox" value="${myAccount.id}" id="r<=count>" />${myAccount.resource_name}
									</c:forEach>
								</label> 
							</dd>
						</dl>
						<dl class="cl permission-list2">
							<dt>
								<label class=""> <input type="checkbox" value="">员工信息管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${userList}" var="us">
										<input name="resource" type="checkbox" value="${us.id}" id="r<=count>" />${us.resource_name}
									</c:forEach>
								</label> 
							</dd>
						</dl>
						<dl class="cl permission-list2">
							<dt>
								<label class=""> <input type="checkbox" value="">机构管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${organizationList}" var="organization">
										<input name="resource" type="checkbox" value="${organization.id}" id="r<=count>" />${organization.resource_name}
									</c:forEach>
								</label> 
							</dd>
						</dl>
						<dl class="cl permission-list2">
							<dt>
								<label class=""> <input type="checkbox" value="">部门管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${deptList}" var="dept">
										<input name="resource" type="checkbox" value="${dept.id}" id="r<=count>" />${dept.resource_name}
									</c:forEach>
								</label> 
							</dd>
						</dl>
					</dd>
				</dl>
				<dl class="permission-list">
					<dt>
						<label class=""> <input type="checkbox" value="" >采购管理</label>
					</dt>
					<dd>
						<dl class="cl permission-list2">
							<dt>
								<label class=""> <input type="hidden" value=""></label>
							</dt>
							<dd>
								
							</dd>
						</dl>
						<dl class="permission-list">
							<dt>
								<label class=""> <input type="checkbox" value="">采购订单管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${purchaseOrderList}" var="purchaseOrder">
										<input name="resource" type="checkbox" value="${purchaseOrder.id}" id="r<=count>" />${purchaseOrder.resource_name}
									</c:forEach>
								</label> 
							</dd>
						</dl>
						<dl class="permission-list">
							<dt>
								<label class=""> <input type="checkbox" value="">订单商品管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${purchaseOrderGoodsList}" var="purchaseOrderGoods">
										<input name="resource" type="checkbox" value="${purchaseOrderGoods.id}" id="r<=count>" />${purchaseOrderGoods.resource_name}
									</c:forEach>
								</label> 
							</dd>
						</dl>
						<dl class="permission-list">
							<dt>
								<label class=""> <input type="checkbox" value="">采购单管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${purchaseList}" var="purchase">
										<input name="resource" type="checkbox" value="${purchase.id}" id="r<=count>" />${purchase.resource_name}
									</c:forEach>
								</label> 
							</dd>
						</dl>
						<dl class="permission-list">
							<dt>
								<label class=""> <input type="checkbox" value="">采购单商品管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${purchaseGoodsList}" var="purchaseGoods">
										<input name="resource" type="checkbox" value="${purchaseGoods.id}" id="r<=count>" />${purchaseGoods.resource_name}
									</c:forEach>
								</label> 
							</dd>
						</dl>
					</dd>
				</dl>
				<dl class="permission-list">
					<dt>
						<label> <input type="checkbox" value="" >销售管理</label>
					</dt>
					<dd>
						<dl class="cl permission-list2">
							<dt>
								<label class=""> <input type="hidden" value=""></label>
							</dt>
							<dd>
								
							</dd>
						</dl>
						<dl class="permission-list">
							<dt>
								<label class=""> <input type="checkbox" value="">销售订单管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${saleOrderList}" var="saleOrder">
										<input name="resource" type="checkbox" value="${saleOrder.id}" id="r<=count>" />${saleOrder.resource_name}
									</c:forEach>
								</label> 
							</dd>
						</dl>
						<dl class="permission-list">
							<dt>
								<label class=""> <input type="checkbox" value="">订单商品管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${saleOrderGoodsList}" var="saleOrderGoods">
										<input name="resource" type="checkbox" value="${saleOrderGoods.id}" id="r<=count>" />${saleOrderGoods.resource_name}
									</c:forEach>
								</label> 
							</dd>
						</dl>
						<dl class="permission-list">
							<dt>
								<label class=""> <input type="checkbox" value="">销售单管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${saleList}" var="sale">
										<input name="resource" type="checkbox" value="${sale.id}" id="r<=count>" />${sale.resource_name}
									</c:forEach>
								</label> 
							</dd>
						</dl>
						<dl class="permission-list">
							<dt>
								<label class=""> <input type="checkbox" value="">销售单商品管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${saleGoodsList}" var="saleGoods">
										<input name="resource" type="checkbox" value="${saleGoods.id}" id="r<=count>" />${saleGoods.resource_name}
									</c:forEach>
								</label> 
							</dd>
						</dl>
						<dl class="permission-list">
							<dt>
								<label class=""> <input type="checkbox" value="">销售退货单管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${saleReturnList}" var="saleReturn">
										<input name="resource" type="checkbox" value="${saleReturn.id}" id="r<=count>" />${saleReturn.resource_name}
									</c:forEach>
								</label> 
							</dd>
						</dl>
						<dl class="permission-list">
							<dt>
								<label class=""> <input type="checkbox" value="">退货单商品管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${saleReturnGoodsList}" var="saleReturnGoods">
										<input name="resource" type="checkbox" value="${saleReturnGoods.id}" id="r<=count>" />${saleReturnGoods.resource_name}
									</c:forEach>
								</label> 
							</dd>
						</dl>
					</dd>
				</dl>
				<dl class="permission-list">
					<dt>
						<label class=""> <input type="checkbox" value="" >库存管理</label>
					</dt>
					<dd>
						<dl class="cl permission-list2">
							<dt>
								<label class=""> <input type="hidden" value=""></label>
							</dt>
							<dd>
								
							</dd>
						</dl>
						<dl class="permission-list" >
						
							<dt>
								<label class=""> <input type="checkbox" value="">库存余量管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${cashStatementList}" var="cashStatement">
										<input name="resource" type="checkbox" value="${cashStatement.id}" id="r<=count>" />${cashStatement.resource_name}
									</c:forEach>
								</label>
							</dd>
						</dl>
						
					</dd>
				</dl>
				
				<dl class="permission-list">
					<dt>
						<label class=""> <input type="checkbox" value="" >系统管理</label>
					</dt>
					<dd>
						<dl class="cl permission-list2">
							<dt>
								<label class=""> <input type="hidden" value=""></label>
							</dt>
							<dd>
								
							</dd>
						</dl>
						<dl class="permission-list" >
						
							<dt>
								<label class=""> <input type="checkbox" value="">职位管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${jobList}" var="jo">
										<input name="resource" type="checkbox" value="${jo.id}" id="r<=count>" />${jo.resource_name}
									</c:forEach>
								</label>
							</dd>
						</dl>
						<dl class="permission-list" >
						
							<dt>
								<label class=""> <input type="checkbox" value="">资源管理</label>
							</dt>
							<dd>
								<label class=""> 
									<c:forEach items="${resourceList}" var="resource">
										<input name="resource" type="checkbox" value="${resource.id}" id="r<=count>" />${resource.resource_name}
									</c:forEach>
								</label>
							</dd>
						</dl>
						
					</dd>
				</dl>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<button type="submit" class="btn btn-success radius" id="admin-role-save" name="admin-role-save"><i class="icon-ok"></i> 确定</button>
			</div>
		</div>
		</form>
	</body>
</html>
