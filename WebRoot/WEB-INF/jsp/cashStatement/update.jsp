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
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/admin-all.css" />
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.8.22.custom.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/ui-lightness/jquery-ui-1.8.22.custom.css" />
    <script type="text/javascript">
        $(function () {
            $('.modal').show();
        })
        function xg(){
        	var a = document.getElementById("pd").value;
        	var b = document.getElementById("pdq").value;
        	document.getElementById("yk").value=a-b;
        	
        }
    </script>
	

  </head>
  	
  <body>
    
      <div class="alert alert-info">当前位置
      	<b class="tip"></b>库存相关查询
      		<b class="tip"></b>修改盘点
      </div>
	<form action="cashStatement/update.do" method="post">
	<input type="hidden" name="blitem_id" value="${eb.blitem_id }"/>
    <table class="table table-striped table-bordered table-condensed list">
        <thead>
            <tr >
                <td colspan="4"><b>仓库货物盘点</b></td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td >仓库编号</td>
                <td colspan="3">
                <input style="width:220px; height:30px"
                	type="text" name="warehouse_name"   value="${eb.warehouse_name}" readonly="readonly">
                <input type="hidden" name="warehouse_id"   value="${eb.warehouse_id}" readonly="readonly"></td>
            </tr>
            <tr>
                <td width="15%">商品名称<font color="FF0000">*</font></td>
                <td width="500">
                	<input style="width:220px; height:30px" name="goods_name" value="${eb.goods_name}" readonly="readonly"/>	
                    <input  type="hidden" name="goods_id" value="${eb.goods_id}"/>
                </td>
            </tr>
            <tr>
                <td width="15%">盘点前的数量<font color="FF0000">*</font></td>
                <td width="500">
                   <input id="pdq" style="width:220px; height:30px" type="text" name="num"  value="${eb.num}" readonly="readonly"></td>
                	
            </tr>
            
            <tr>
                <td width="15%">盘点数量<font color="FF0000">*</font></td>
                <td width="500">
                  <input id="pd" style="width:220px; height:30px"type="text" name="check_num" value="${eb.check_num}" onblur="xg()" >
                   </td>
            </tr>
            <tr>
                <td width="15%">盈亏数量<font color="FF0000">*</font></td>
                <td width="500">
                  <input id="yk" style="width:220px; height:30px" type="text" name="profit_and_loss" readonly="readonly" />
                   </td>
            </tr>
            
            <tr>
                <td width="15%">经办人<font color="FF0000">*</font></td>
                <td width="500">
                  <input style="width:220px; height:30px" type="text" name="handler_name" value="${eb.handler_name}" readonly="readonly"/>
                  <input type="hidden" name="handler_id" value="${eb.handler_id}" />
                  
                  
                 </td>
                
            </tr>
            <tr>
                <td width="15%">操作<font color="FF0000">*</font></td>
                <td width="500">
                  <input type="submit" value="提交"/>
                   </td>
            </tr>
    </table>
    </form>
  </body>
</html>
