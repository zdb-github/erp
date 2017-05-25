<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>项目简介</title>
    
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
        	<div class="navmenu"><span>您现在的位置: <a href="#">首页</a>>项目简介</span></div>
            
            <div class="newsnr">
            	<div class="fleft leftmenu yh">
                	<ul>
                		<li><a href="public/toProject.do" class="select">项目简介</a></li>
                		
                	</ul>
                </div>
                <br/>
                <br/>
                <h1 align="center">项目简介</h1>
                <h3>项目背景：中小企业在我国经济发展中具有重要地位，目前我国的中小企业数量较多、地区分布广泛、行业分布跨度大，随着全球经济一体化的发展及中国加入WTO，中小企业将面临外资企业和国外产品和服务的严峻挑战。比较而言，外资企业具有更为雄厚的资金实力、丰富的管理经验和先进的技术手段，因此，如果我国的中小企业不借助先进的管理思想转变经营理念，使用信息化手段提高企业的管理水平和工作效率，将很难在今后的国际竞争中取胜。企业管理在很多方面、很大程度上都必须借助信息化的工具来完成，采用电脑管理进货、库存和销售等诸多环节也已成为必然趋势。
     本系统的开发适用于多个行业，可以帮助企业快速有效管理进货、销售、库存等各项业务，合理控制进销存各个环节，提高资金利用率，实现管理高效率和实时性。
                </h3>
                <h3>项目目标：</h3>
<h3>1.系统采用人机对话方式，界面美观友好、信息查询灵活、方便、快捷、准确、数据存储 安全可靠</h3>
<h3>2.键盘操作，快速响应</h3>
<h3>强大的采购入库功能</h3>
<h3>4.全面的销售出库功能</h3>
<h3>5.实现各种查询，如多条件查询、模糊查询等 </h3>  
<h3>6.管理员可以设置操作员的权限 </h3>
<h3>7.对用户输入的数据，系统进行严格的数据检验，尽可能排除人为的错误</h3>
<h3>8.数据保密性强，为每个用户设置权限级别</h3>
<h3>9.系统运行稳定、安全可靠</h3>
                
                
                
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
