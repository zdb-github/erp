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
    		
    		var warehouse_id=document.getElementById("bumen");
    		//alert(3);
    		for(var i=0;i<warehouse_id.options.length;i++){
    		//	alert(4);
    			if(warehouse_id.options[i].value=="${id}"){
    		//	alert(5);	
    				warehouse_id.options[i].selected = true;
    			//	alert(6);
					break;
    			}
    			
    		}
    		
    		var goods_id = document.getElementById("goodId");
    		for(var i=0;i<goods_id.options.length;i++){
    			if(goods_id.options[i].value=="${goods_id}"){
    				goods_id.options[i].selected = true;
    				break;
    			}
    			
    		}
    	}
		
    </script>
</head>
<body onload="jz()">
   
    <div class="alert alert-info">当前位置
    	<b class="tip"></b>库存相关查询
    	<b class="tip"></b>库存余量查询
    </div>
    <form action="<%=basePath%>cashStatement/toBalance.do" method="post" id="myForm">
   	
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
                    <select size="1" name="warehouse_id" id="bumen">
                    	<option></option>
                       <c:forEach items="${EWlist}" var="EW">
                       	<option value="${EW.warehouse_id}">${EW.name}</option>
                       </c:forEach>
                    </select>
                </td>
                <td>货物的名称</td>
                <td>
                	<select name="goods_id" id="goodId">
                		<option></option>
                		<c:forEach items="${EGlist}" var="EG">
                			<option value="${EG.goods_id}">${EG.goods_name}</option>
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
                <td>商品的编号 </td>
                <td>名称</td>
                <td>所在仓库</td>
                <td>数量 </td>
                <td>单价</td>
                <td>单位</td>
                <td>商品类型 </td>
            </tr>
        </thead>
        <tbody>
            	<c:if test="${empty cashStatementList}">
            		<tr>
            			<td colspan="2" style="text-align: center;">
            				没有数据
            			</td>
            		</tr>
            	</c:if>
            <c:if test="${!empty cashStatementList}">
            	<c:forEach items="${cashStatementList}" var="c">
            		<tr>
            			<td>
            				${c.goods_id}
            			</td>
            			<td>${c.goods_name}</td>
            			<td>
            				${c.warehouse_name}
            			</td>
            			<td>
            				${c.goods_num}
            			</td>
            			<td>${c.goods_prices}</td>
            			<td>
            				${c.goods_unit}
            			</td>
            			<td>
            				${c.goods_type}
            			</td>
            			
            		</tr>
            	</c:forEach>
            </c:if>
        </tbody>
    </table>
</body>
</html>
