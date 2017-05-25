<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/admin-all.css" />
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery-ui-1.8.22.custom.min.js"></script>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>cs/ui-lightness/jquery-ui-1.8.22.custom.css" />
    <script type="text/javascript" src="<%=basePath%>js/tip.js"></script>
    <script type="text/javascript">
         $(function () {
             $(".datepicker").datepicker();
             $('.modal').hide();
            $('#find').click(function () { 
                $.dialog({
                    title: '查询结果',
                    content: 'url:Template/griddatalist.html', 
					width:650,
					height:450
            			})
			})
			$('#findid').click(function () { 
                 $.dialog({
                    title: '单据编号',
                    content:'url:Template/Iddatalist.html',
					width:350,
					height:250
            			})
			})
         })
        
    </script>
  </head>
  
  <body>
    
    <div class="alert alert-info">当前位置
    	<b class="tip"></b>库存管理
    	<b class="tip"></b>货物调拨
    </div>
    <form action="<%=basePath%>cashStatement/list.do" method="post">
    	
    	<table class="table table-striped table-bordered table-condensed">
        <thead>
            <tr>
                <td colspan="6" class="auto-style2">&nbsp;请填写查询条件 </td>
            </tr>
        </thead>
        <tbody>
            <tr>
                
                
                <td>调出仓库 </td>
                <td>
                    <select size="1" name="Out_warehouse_id" id="Out_warehouseId">
                       <option></option>
                       <c:forEach items="${EWlist}" var="EW">
                       	<option value="${EW.warehouse_id}">${EW.name}</option>
                       </c:forEach>
                    </select>
                </td>
                 <td>调入仓库 </td>
                <td>
                    <select size="1" name="in_warehouse_id" id="In_warehouseId">
                       <option></option>
                       <c:forEach items="${EWlist}" var="EW">
                       	<option value="${EW.warehouse_id}">${EW.name}</option>
                       </c:forEach>
                    </select>
                </td> 
                    
            </tr>
            <tr>
               <td>货物的名称</td>
                <td>
                	<select name="goods_id" id="goodId" name="goods_id">
                		<option></option>
                		<c:forEach items="${EGlist}" var="EG">
                			<option value="${EG.goods_id}">${EG.goods_name}</option>
                		</c:forEach>
                	</select>
                </td>
                
                <td>数量</td>
                <td class="detail">
                    <input type="text" name="num" style="width:50%;height:140%;"/>
                </td>
            </tr>
			<tr>
			 <td>单据状态</td>
			 
                <td>
                    <select size="1" name="re_state" id="bumen">
                    	<option></option>
                    	<c:forEach items="${codeList}" var="C">
                    		<option value="${C.key}">${C.value}</option>
                    	</c:forEach>
                        <option></option>
                    </select>
                </td>
			
			 <td>提交日期起 </td>
              <td>
					<input id="create_time1" class="span2 datepicker" style="width:220px; height:30px" type="text" name="time"  />
					<span class="add-on"><i class="icon-calendar"></i>
					</span>
				</td>
			</tr>
			<tr>
				<td>描述</td>
				<td colspan="3">
					<textarea rows="3" cols="300" name="describe"></textarea>
				</td>
			</tr>
            <tr>
                <td colspan="4" align="right">
                    <input class="btn btn-inverse" id="find" type="submit" value="提交" />
                    
            </tr>
        </tbody>
    </table>
</form>

   
  </body>
</html>
