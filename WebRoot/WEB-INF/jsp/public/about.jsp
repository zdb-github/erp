<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>联系我们</title>
    
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
        	<div class="navmenu"><span>您现在的位置: <a href="#">首页</a> >联系我们</span></div>
            
            <div class="newsnr">
            	<div class="fleft leftmenu yh">
                	<ul>
                		<li><a href="public/toNews.do" class="select">联系我们</a></li>
                		
                	</ul>
                </div>
                <br/>
                <br/>
                <h2 align="center">联系我们</h2>
                <h4>电话：0000-0000000</h4>
                <h4>邮&nbsp;&nbsp;箱：0000000@000.com</h4>
                <h4>公司官网：www.blazers.cn&nbsp</h4>
               


                
                
                
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
