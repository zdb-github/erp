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
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/admin-all.css" />
		<link rel="stylesheet" type="text/css" href="css/base.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css"
			href="css/ui-lightness/jquery-ui-1.8.22.custom.css" />
		<script type="text/javascript" src="js/jquery-1.7.2.js">
		</script>
		<script type="text/javascript" src="js/jquery-ui-1.8.22.custom.min.js">
		</script>
		<script type="text/javascript" src="js/index.js">
		</script>
		<script type="text/javascript">
			function changeMenu(num) {
	
				for(var i=1;i<7;i++){
					if(num==i){
						document.getElementById("menu"+num).style.display = "block";
					}else{
						document.getElementById("menu"+i).style.display = "none";
					}
				}
			}
		</script>

	</head>
	<body>
		<div class="warp">
			<!--头部开始-->
			<div class="top_c">
				<div class="top-menu">
				<%int num=0; %>
					<ul class="top-menu-nav">
						<li>
							<a href="#">首页</a>
						</li>
						<li>
							<a href="javascript:void(0)" onclick="changeMenu(1)">基本档案管理<i
								class="tip-up"></i> </a>

						</li>
						
						<li>
							<a href="javascript:void(0)" onclick="changeMenu(2)">采购管理<i
								class="tip-up"></i> </a>

						</li>
						<li>
							<a href="javascript:void(0)" onclick="changeMenu(3)">销售管理<i
								class="tip-up"></i> </a>

						</li>
						<li>
							<a href="javascript:void(0)" onclick="changeMenu(4)">库存管理<i
								class="tip-up"></i> </a>

						</li>
						<li>
							<a href="javascript:void(0)" onclick="changeMenu(5)">报表管理<i
								class="tip-up"></i> </a>
						</li>
						<li>
							<a href="javascript:void(0)" onclick="changeMenu(6)">系统管理<i
								class="tip-up"></i> </a>
						</li>
					</ul>
				</div>
				<div class="top-nav">
					上午好，欢迎您，邱秋！&nbsp;&nbsp;
					<a href="#">修改密码</a> |
					<a href="#">安全退出</a>
				</div>
			</div>

			<!--头部结束-->
			<!--左边菜单开始-->
			<div class="left_c left" id="menu1">
				<h1>
					基本档案管理
				</h1>
				<div class="acc">
					<div>
					<a class="one">仓库管理</a>
					<c:forEach items="${myDoPathList}" var="m">	
						
						<ul class="kid">
							<c:if test="${m=='/warehouse/toList.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="warehouse/toList.do">仓库列表</a>
							</li></c:if>
							<c:if test="${m=='/warehouse/toAdd.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="warehouse/toAdd.do">添加仓库</a>
							</li></c:if>
							<c:if test="${m=='/warehouse/toUpdate.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="warehouse/toList.do">修改仓库</a>
							</li></c:if>
							<c:if test="${m=='/warehouse/toDelete.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="warehouse/toList.do">删除仓库</a>
							</li></c:if>
						</ul>
  						</c:forEach>
					</div>
					
					<div>
					<a class="one">商品管理</a>
					<c:forEach items="${myDoPathList}" var="m">
						
						<ul class="kid">
							<c:if test="${m=='/goods/toList.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="goods/toList.do">商品列表</a>
							</li></c:if>
							<c:if test="${m=='/goods/toAdd.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="goods/toList.do">商品添加</a>
							</li></c:if>
							<c:if test="${m=='/goods/toUpdate.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="goods/toList.do">商品修改</a>
							</li></c:if>
							<c:if test="${m=='/goods/toDelete.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="goods/toList.do">商品删除</a>
							</li></c:if>
						</ul></c:forEach>
					</div>
					<div>
					<a class="one">码表管理</a>
					<c:forEach items="${myDoPathList}" var="m">
						
						<ul class="kid">
							<c:if test="${m=='/code/toCodeList.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="code/toCodeList.do">码表列表</a>
							</li></c:if>
							<c:if test="${m=='/code/toCodeAdd.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="code/toCodeAdd.do">添加码表</a>
							</li></c:if>
							<c:if test="${m=='/code/toCodeUpdate.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="code/toCodeList.do">修改码表</a>
							</li></c:if>
							<c:if test="${m=='/code/toCodeDelete.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="code/toCodeList.do">删除码表</a>
							</li></c:if>
							
						</ul></c:forEach>
					</div>
					<div>
					<a class="one">客户信息管理</a>
					<c:forEach items="${myDoPathList}" var="m">
						
						<ul class="kid">
							<c:if test="${m=='/customer/toCustomerList.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="customer/toCustomerList.do">客户信息列表</a>
							</li></c:if>
							<c:if test="${m=='/customer/toCustomerAdd.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="customer/toCustomerAdd.do">添加客户</a>
							</li></c:if>
							<c:if test="${m=='/customer/toCustomerUpate.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="customer/toCustomerList.do">修改客户</a>
							</li></c:if>
							<c:if test="${m=='/customer/toCustomerDelete.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="customer/toCustomerList.do">删除客户</a>
							</li></c:if>
						</ul></c:forEach>
					</div>
					<div>
					<a class="one">账号信息管理</a>
					<c:forEach items="${myDoPathList}" var="m">
						
						<ul class="kid">
							<c:if test="${m=='/account/toAccountList.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="account/toAccountList.do">账户列表</a>
							</li></c:if>
							<c:if test="${m=='/account/toAccountAdd.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="account/toAccountAdd.do">添加账户</a>
							</li></c:if>
							<c:if test="${m=='/account/toAccountUpdate.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="account/toAccountList.do">修改账户</a>
							</li></c:if>
							<c:if test="${m=='/account/toAccountDelete.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="account/toAccountList.do">删除账户</a>
							</li></c:if>

						</ul></c:forEach>
					</div>
					<div>
					<a class="one">员工信息管理</a>
					<c:forEach items="${myDoPathList}" var="m">
						
						<ul class="kid">
							<c:if test="${m=='/user/toUserList.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="user/toUserList.do">员工列表</a>
							</li></c:if>
							<c:if test="${m=='/user/toUserAdd.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="user/toUserAdd.do">添加员工信息</a>
							</li></c:if>
							<c:if test="${m=='/user/toUserUpdate.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="user/toUserList.do">修改员工信息</a>
							</li></c:if>
							<c:if test="${m=='/user/toUserDelete.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="user/toUserList.do">删除员工信息</a>
							</li></c:if>

						</ul></c:forEach>
					</div>
					<div>
					<a class="one">机构管理</a>
					<c:forEach items="${myDoPathList}" var="m">
						
						<ul class="kid">
							<c:if test="${m=='/organization/toList.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="organization/toList.do">机构列表</a>
							</li></c:if>
							<c:if test="${m=='/organization/toAdd.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="organization/toAdd.do">机构添加</a>
							</li></c:if>
							<c:if test="${m=='/organization/toUpdate.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="organization/toList.do">机构修改</a>
							</li></c:if>
							<c:if test="${m=='/organization/toDelete.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="organization/toList.do">机构删除</a>
							</li></c:if>

						</ul></c:forEach>
					</div>
					
					<div>
					<a class="one">部门管理</a>
					<c:forEach items="${myDoPathList}" var="m">
						
						<ul class="kid">
							<c:if test="${m=='/dept/toList.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="dept/toList.do">部门列表</a>
							</li></c:if>
							<c:if test="${m=='/dept/toAdd.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="dept/toAdd.do">添加部门</a>
							</li></c:if>
							<c:if test="${m=='/dept/toUpdate.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="dept/toList.do">修改部门</a>
							</li></c:if>
							<c:if test="${m=='/dept/toDelete.do'}">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="dept/toList.do">删除部门</a>
							</li></c:if>

						</ul></c:forEach>
					</div>
					<div class="datepicker"></div>
				</div>
			</div>
		</div>
		<div class="left_c left" id="menu2">
			<h1>
				采购管理
			</h1>
			
			<div class="acc">
			
				<div>
				<a class="one">采购订单管理</a>
				<c:forEach items="${myDoPathList}" var="m">
					<ul class="kid">
						<c:if test="${m=='/purchaseOrder/toListPo.do'}">
						<li>
							<b class="tip"></b><a target="Conframe"
								href="purchaseOrder/toListPo.do">采购订单列表</a>
						</li></c:if>
						<c:if test="${m=='/purchaseOrder/toAddPo.do'}">
						<li>
							<b class="tip"></b><a target="Conframe"
								href="purchaseOrder/toAddPo.do">添加采购订单</a>
						</li></c:if>
						<c:if test="${m=='/purchaseOrder/toUpdatePo.do'}">
						<li>
							<b class="tip"></b><a target="Conframe"
								href="purchaseOrder/toListPo.do">修改采购订单</a>
						</li></c:if>
						
					</ul></c:forEach>
				</div>

				<div>
					<a class="one">采购单管理</a>
					<c:forEach items="${myDoPathList}" var="m">
					<ul class="kid">
						<c:if test="${m=='/purchase/toListPurchase.do'}">
						<li>
							<b class="tip"></b><a target="Conframe"
								href="purchase/toListPurchase.do">采购单列表</a>
						</li></c:if>
						<c:if test="${m=='/purchase/toAddPurchase.do'}">
						<li>
							<b class="tip"></b><a target="Conframe"
								href="purchase/toAddPurchase.do">添加采购单</a>
						</li></c:if>
						<c:if test="${m=='/purchase/toUpdatePurchase.do'}">
						<li>
							<b class="tip"></b><a target="Conframe"
								href="purchase/toListPurchase.do">修改采购单</a>
						</li></c:if>
						
					</ul></c:forEach>
				</div>
				
				<div class="datepicker"></div>
			</div>
		</div>
		<div class="left_c left" id="menu3">
		
			<h1>
				销售管理
			</h1>
			<div class="acc">
			
				<div>
					<a class="one">销售订单管理</a>
					<c:forEach items="${myDoPathList}" var="m">
					<ul class="kid">
						<c:if test="${m=='/saleOrder/toListSo.do'}">
						<li>
							<b class="tip"></b><a target="Conframe"
								href="saleOrder/toListSo.do">销售订单列表</a>
						</li></c:if>
						<c:if test="${m=='/saleOrder/toAddSo.do'}">
						<li>
							<b class="tip"></b><a target="Conframe"
								href="saleOrder/toAddSo.do">添加销售订单</a>
						</li></c:if>
						<c:if test="${m=='/saleOrder/toUpdateSo.do'}">
						<li>
							<b class="tip"></b><a target="Conframe"
								href="saleOrder/toListSo.do">修改销售订单</a>
						</li></c:if>
						
					</ul></c:forEach>
				</div>

				<div>
					<a class="one">销售单管理</a>
					<c:forEach items="${myDoPathList}" var="m">
					<ul class="kid">
						<c:if test="${m=='/sale/toListSale.do'}">
						<li>
							<b class="tip"></b><a target="Conframe"
								href="sale/toListSale.do">销售单列表</a>
						</li></c:if>
						<c:if test="${m=='/sale/toAddSale.do'}">
						<li>
							<b class="tip"></b><a target="Conframe"
								href="sale/toAddSale.do">添加销售单</a>
						</li></c:if>
						<c:if test="${m=='/sale/toUpdateSale.do'}">
						<li>
							<b class="tip"></b><a target="Conframe"
								href="sale/toListSale.do">修改销售单</a>
						</li></c:if>
						<c:if test="${m=='/sale/toListsSr.do'}">
						<li>
							<b class="tip"></b><a target="Conframe"
								href="saleReturn/toListSr.do">销售退货单</a>
						</li></c:if>
						
					</ul></c:forEach>
				</div>
				
				<div class="datepicker"></div>
			</div>
		</div>
		<div class="left_c left" id="menu4">
		
			<h1>
				库存管理
			</h1>
			
			<div class="acc">
			
				<div>
					<a class="one">库存余量查询</a>
					<c:forEach items="${myDoPathList}" var="m">
					<ul class="kid">
						<c:if test="${m=='/cashStatement/toBalance.do'}">
						<li>
							<b class="tip"></b><a target="Conframe"
								href="cashStatement/toBalance.do">库存余量</a>
						</li></c:if>
						<c:if test="${m=='/cashStatement/toBlitem.do'}">
						<li>
							<b class="tip"></b><a target="Conframe"
								href="cashStatement/toBlitem.do">货物盘点</a>
						</li></c:if>
						<c:if test="${m=='/cashStatement/toRequisition.do'}">
						<li>
							<b class="tip"></b><a target="Conframe"
								href="cashStatement/toRequisition.do">货物调拨</a>
						</li></c:if>
					</ul></c:forEach>
				</div>
				
				<div class="datepicker"></div>
			</div>
		</div>
		<div class="left_c left" id="menu5">
			<h1>
				报表管理
			</h1>
			
			<div class="acc">
			
				<div>
					<a class="one">销售报表</a>
					<ul class="kid">
						<li>
							<b class="tip"></b><a target="Conframe"
								href="report/toListSale.do">销售列表</a>
						</li>
					</ul>
				</div>

				<div>
					<a class="one">采购报表</a>
					<ul class="kid">
						<li>
							<b class="tip"></b><a target="Conframe"
								href="report/toListPurchase.do">采购列表</a>
						</li>
					</ul>
				</div>
				
				<div class="datepicker"></div>
			</div>
		</div>
		<div class="left_c left" id="menu6">
		 	<h1>
				系统管理
			</h1>
			
			<div class="acc">
			
				<div>
					<a class="one">职位管理</a>
					<c:forEach items="${myDoPathList}" var="m">
				
					<ul class="kid">
						<c:if test="${m=='/job/toList.do'}" >
						<li>
							<b class="tip"></b><a target="Conframe"
								href="job/toList.do">职位列表</a>
						</li></c:if>
						<c:if test="${m=='/job/toAdd.do'}" >
						<li>
							<b class="tip"></b><a target="Conframe"
								href="job/toAdd.do">添加职位</a>
						</li></c:if>
						<c:if test="${m=='/job/toUpdate.do'}" >
						<li>
							<b class="tip"></b><a target="Conframe"
								href="job/toList.do">修改职位</a>
						</li></c:if>
						<c:if test="${m=='/job/toDelete.do'}" >
						<li>
							<b class="tip"></b><a target="Conframe"
								href="job/toList.do">删除职位</a>
						</li></c:if>
						
					</ul></c:forEach>
				</div>
				<div>
					
					<a class="one">资源管理</a>
					<c:forEach items="${myDoPathList}" var="m">
				
					<ul class="kid">
						<c:if test="${m=='/resource/toList.do'}" >
						<li>
							<b class="tip"></b><a target="Conframe"
								href="resource/toList.do">资源列表</a>
						</li></c:if>
						<c:if test="${m=='/resource/toAdd.do'}" >
						<li>
							<b class="tip"></b><a target="Conframe"
								href="resource/toAdd.do">添加资源</a>
						</li></c:if>
						<c:if test="${m=='/resource/toUpdate.do'}" >
						<li>
							<b class="tip"></b><a target="Conframe"
								href="resource/toList.do">修改资源</a>
						</li></c:if>
						<c:if test="${m=='/resource/toDelete.do'}" >
						<li>
							<b class="tip"></b><a target="Conframe"
								href="resource/toList.do">删除资源</a>
						</li></c:if>
					</ul></c:forEach>
				</div>
				
				<div class="datepicker"></div>
			</div>
		</div>
		<!--左边菜单结束-->
		<!--右边框架开始-->
		<div class="right_c">
			<div class="nav-tip" onclick="javascript:void(0)">
				&nbsp;
			</div>

		</div>
		<div class="Conframe">
			<iframe name="Conframe" id="Conframe"></iframe>
		</div>
		<!--右边框架结束-->

		<!--底部开始-->
		<div class="bottom_c">
			Copyright &copy;2005-2011 深圳艺谷发展科技有限公司 版权所有
		</div>
		<!--底部结束-->

	</body>
</html>