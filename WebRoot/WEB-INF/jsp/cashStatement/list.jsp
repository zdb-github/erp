<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/admin-all.css" />
 
  </head>
  
  <body>
  	 <div class="alert alert-info">当前位置
    	<b class="tip"></b>库存相关查询
    	<b class="tip"></b>货物调拨
    </div>
   <table class="table table-striped table-bordered table-condensed" id="list">
        <thead>
            <tr class="tr_detail">
                <td>商品 </td>
                <td>调出仓库</td>
                <td>调入仓库</td>
                <td>数量</td>
                <td>提交时间 </td>
                <td>状态</td>
                <td>描述</td>
            </tr>
        </thead>
        <tbody>
        	<tr>
        		<td>${er.goods_name }</td>
        		<td>${er.out_warehouse_name }</td>
        		<td>${er.in_warehouse_name }</td>
        		<td>${er.num }</td>
        		<td>${er.out_time }</td>
        		<td>${er.requision_stateVo }</td>
        		<td>${er.describe }</td>
        	</tr>
        </tbody>
    </table>
  </body>
</html>
