<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/admin-all.css" />
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery-ui-1.8.22.custom.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/ui-lightness/jquery-ui-1.8.22.custom.css" />
    <script type="text/javascript" src="<%=basePath%>js/tip.js"></script>
    <script type="text/javascript">
    	function cx(){
			document.getElementById("myForm").submit();
		}
    	function jz(){
    		
    		var warehouse_idSelect = document.getElementById("warehouseId");
    		for(var i=0;i<warehouse_idSelect.options.length;i++){
    			if(warehouse_idSelect.options[i].value=="${warehouse_id}"){
    				warehouse_idSelect.options[i].selected = true;
    				break;
    			}
    			
    		}
    	}
		function pd(num){
			//alert(1);
			document.getElementById("myFormPd"+num).submit();
			//alert(12);
		}
		<%-- $(function(){
			 
			
            $('#pdID').click(function(){
            	
            	$('#alert-win').dialog({
            		width:650,
            		height:400,
            		buttons:{"关闭":function(){$(this).dialog("close");}}
            		
            	});
            	
            })
		 })--%>
    </script>
</head>
<body onload="jz()">
    <% 
    int count=1;
    %>
    <div class="alert alert-info">当前位置
    	<b class="tip"></b>库存相关查询
    	<b class="tip"></b>库存盘点
    </div>
    <form action="<%=basePath%>cashStatement/toBlitem.do" method="post" id="myForm">
    <table class="table table-striped table-bordered table-condensed">
        <thead>
            <tr>
                <td colspan="6" class="auto-style2">&nbsp;请填写查询条件 </td>
               
            </tr>
        </thead>
        <tbody>
            <tr>
              
                <td>仓库名称 </td>
                <td>
                    <select size="1" name="warehouse_id" id="warehouseId">
                       <option></option>
                       <c:forEach items="${EWlist}" var="EW">
                       	<option value="${EW.warehouse_id}">${EW.name}</option>
                       </c:forEach>
                    </select>
                </td>
                
            </tr>
            <tr>
                <td colspan="6" align="right">
                    <input class="btn btn-inverse" id="find" type="button" value="查询" onclick="cx()"/>
                    
            </tr>
        </tbody>
    </table>
</form>
	
    <table class="table table-striped table-bordered table-condensed" id="list">
        <thead>
            <tr class="tr_detail">
            	<td>仓库</td>
                <td>商品 </td>
                <td>盘点前的数量</td>
                <td>经手人</td>
                <td>操作</td>
                
            </tr>
        </thead>
        <tbody>
            <c:if test="${empty list}">
            	<tr>
            		<td colspan="6" style="text-align: center;">
            			没有数据
            		</td>
            	</tr>
            </c:if>
            <c:if test="${!empty list}">
            	<c:forEach items="${list}" var="Q">
            		<tr>
            			<td>
            				${Q.warehouse_name}
            			</td>
            			<td>
            				${Q.goods_name}
            			</td>
            			<td>
            				${Q.num}
            			</td>
            			<td>
            			
            				${Q.handler_name}
            			</td>
            			
            			 <td>
            			 
            			 <form id="myFormPd<%=count %>"    action="<%=basePath%>cashStatement/toUpdate.do" method="post">
            			 	<input type="hidden" name="id" id="hiddenId" value="${Q.blitem_id}"/>
            			 	
            			 	<input type="button" value="盘点" id="pdID" onclick="pd(<%=count++ %>)">
            			 </form>
                			
               			 </td>
               			  
			                
            		</tr>
            	</c:forEach>
            </c:if>
        </tbody>
    </table>
    <!-- <div id="alert-win" title="弹出窗口查询模式" style="display: none;">
        <iframe style="border: 0; width: 100%; height: 100%;" src="<%=basePath%>warehouse/toUpdate.do?"></iframe>
    </div> -->
</body>
</html>
