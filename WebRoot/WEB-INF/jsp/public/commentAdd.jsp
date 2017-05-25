<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    

<title>在线留言</title>
<meta name="keywords" content="[!--pagekey--]" />
<meta name="description" content="[!--pagedes--]" />
<link href="css/master.css" type="text/css" rel="stylesheet" />
<link href="css/base1.css" type="text/css" rel="stylesheet" />
<link  rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/sinaFaceAndEffec.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
</head>


<body>
<!-- 头部 -->
<div class="head">
	<div class="block yh f13">
    	<p class="tright"><a onclick="SetHome(window.location)" href="javascript:void(0)" class="pl10 pr10">设为首页</a> | <a onclick="AddFavorite(window.location,document.title)" href="javascript:void(0)" class="pl10 pr10">加入收藏</a>
    	 | <a href="public/toBigdatalogin.do">登录</a></p>
    
    </div>
 </div>
<!--文字列表页主体-->
<div class="newsbox yh">
    	<div class="block">
        	<div class="navmenu"><span>您现在的位置: <a href="#">首页</a> > 在线留言</span></div>
            
            <div class="newsnr">
            	<div class="fleft leftmenu yh">
                	<ul>
                		<li><a href="public/toCommentAdd.do" class="select">在线留言</a></li>
                		<li><a target="Conframe" href="public/toCommentAdd.do">我要留言</a></li>
                		
                	</ul>
                </div>
            <div class="content yh fright" style="width:700px;">
            <form action="public/commentAdd.do" method="post">
                <table>
                <tr>
               	<td>留言</td>
               	<td bgcolor="ffffff">
               	<textarea name="content" cols="60" rows="12">
               	</textarea>
               	</td>
               	</tr>
               	<tr>
               	<td bgcolor="ffffff">
               	</td>
               
               	<td bgcolor="ffffff">
               	<input type="submit" name="submit" value="提交">
               	</td>
               	</tr>
             </table>
               </form>
                    
                </div>
                <div class="clearfix"></div>
          </div>
            

        </div>
    </div>	
    
    
    

        
        
<div class="foot clearfix">
	<div class="block">
        <div class="fleft">
            <p><a href="" class="a1">联系我们</a>|<a href="" class="a2">公司诚聘</a>|<a href="" class="a3">合作伙伴</a>|<a href="" class="a4">网站地图</a></p>
            <p>Copyright © 2016-2017 www.haiis.com,All Rights Reserved 来源:<a href="http://www.hao123.com/" target="_blank">开拓者</a></p>
            <p>版权所有  郑州航空大学蓝桥班第一小组</p>
        </div>
        
        <div class="fright">
        	<p class="p1">联系热线：15649012183</p>
            <p class="p2">邮箱：9813100705@qq.com</p>
        </div>
    </div>
</div>    

<script src="js/all.js" type="text/javascript"></script>
</body>
</html>