<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html>
<base href="<%=basePath%>">
<head>
<title>开拓者进销存管理系统门户</title>
<meta name="keywords" content="[!--pagekey--]" />
<meta name="description" content="[!--pagedes--]" />
<link href="css/master.css" type="text/css" rel="stylesheet" />
<link href="css/base1.css" type="text/css" rel="stylesheet" />
<link href="css/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
</head>


<body>

<!--头部-->
<div class="head">
	<div class="block yh f13">
    	<p class="tright"><a onclick="SetHome(window.location)" href="javascript:void(0)" class="pl10 pr10">设为首页</a> | <a onclick="AddFavorite(window.location,document.title)" href="javascript:void(0)" class="pl10 pr10">加入收藏</a>
    	 | <a href="public/toBigdatalogin.do">登录</a></p>
   <div class="box position_a clearfix">     
   <!--导航-->
   <div class="nav fleft ofHidden">
       <ul>
           <li><a href="">首页</a></li>
           <li><a href="public/toGroup.do">团队介绍</a></li>
           <li><a href="public/toNews.do">新闻中心</a></li>
           <li><a href="public/toProject.do">项目简介</a></li>
           <li><a href="public/toCommentAdd.do">在线留言</a></li>
           <li><a href="public/toAbout.do">联系我们</a></li>
       </ul>
   </div>
        
        <!--搜索-->
        <form name="searchform" method="post" action="/e/search/index.php" class="ss ofHidden">
        <input name='ecmsfrom' type='hidden' value='9'>
        <input type="hidden" name="show" value="title,newstext">
        <input class="index_srh" name="keyboard" placeholder="请输入关键字" >
        <input class="search" type="submit" name="submit" value="搜索">
        </form>
    </div>
    
    </div>
    
</div>

<!--幻灯片-->
<div class="fullSlide">
		<div class="bd">
			<ul>
			<li style="background:url(images/banner.jpg) #FFF center 0 no-repeat;"><a target="_blank"></a></li>
			<li style="background:url(images/zxyccccc.jpg) #FFF center 0 no-repeat;"><a target="_blank"></a></li>
			<li style="background:url(images/zxy_2.jpg) #FFF center 0 no-repeat;"><a target="_blank"></a></li>
			<li style="background:url(images/zxy_b.jpg) #FFF center 0 no-repeat;"><a target="_blank" ></a></li>
			<li style="background:url(images/banner.jpg) #FFF center 0 no-repeat;"><a target="_blank"></a></li>
			</ul>
		</div>

		<div class="hd"><ul></ul></div>
	</div>  


<!--首页主体-->
	<div class="xc_pic ofHidden clearfix">
    <div class="block clearfix ofHidden">
        <b></b>
        <ul>
        	<li><a href=""><img src="images/dianzi.png"></a></li>
            <li><a href=""><img src="images/team.png"></a></li>
            <li><a href=""><img src="images/case.png"></a></li>
            <li><a href=""><img src="images/kefu.png"></a></li>
        </ul>
    </div>    
	</div>
    <div class="clearfix ofHidden block yh pt20">
    </div>
   
    
    	<div class="contentOne">
    <h2 align="center">作为老板，需要什么样的ERP系统？</h2>
    <i></i>
    <ul>
        <li><img alt="" src="images/yuan1.png"></li>
        <li><img alt="" src="images/yuan2.png"></li>
        <li><img alt="" src="images/yuan3.png"></li>
        <li><img alt="" src="images/yuan4.png"></li>
        <li style="margin-right:0px;"><img alt="" src="images/yuan5.png"></li>
    </ul>
    <h2>您是否在苦恼，这些事一直在发生？</h2>
    <i></i>
    <dl>
        <dt><img alt="" src="images/tu1.jpg"><h3><ins>数据<span>暗箱</span></ins></h3></dt>
        <dd><p style="margin-top:70px;">采购、销售、仓库、财务、生产数据多而繁杂、不规范，从而影响企业决策高效性！</p><span><img alt="" src="images/jian.png"></span></dd>
        <dt><img alt="" src="images/tu2.jpg"><h3><ins>销售<span>暗箱</span></ins></h3></dt>
        <dd><p>销售额增加，利润却降低，钱何去何从？</p><span><img alt="" src="images/jian.png"></span></dd>
        <dt><img alt="" src="images/tu3.jpg"><h3><ins>仓库<span>暗箱</span></ins></h3></dt>
        <dd><p>账务不清晰，偏偏有做不完的帐，钱归何处？</p><span><img alt="" src="images/tou.png"></span></dd>
        <dt><img alt="" src="images/tu4.jpg"><h4><ins>财务<span>暗箱</span></ins></h4></dt>
        <dd><p>信息传递链长，不流畅 ，时间耗不起！</p><span><img alt="" src="images/tou.png"></span></dd>
        <dt><img alt="" src="images/tu4.jpg"><h4><ins>流程<span>暗箱</span></ins></h4></dt>
        <dd><p>花钱买物料，方到用时却缺料，料何去何从？</p><span><img alt="" src="images/tou.png"></span></dd>
    </dl>
</div>
    	
    				<h1 align="center">来这里！我们有强大的功能帮你解决这些烦恼</h1>
    	<div class="ydh-info-text">
				<dl>
					<dt><i class="ydh-info-text-icon manger-order"></i></dt>
					<dd class="info-title">管订单</dd>
					<dd>告别错单、漏单、拖单移动订货全程跟踪提升提货效率</dd>
				</dl>
				<dl>
					<dt><i class="ydh-info-text-icon manger-customer"></i></dt>
					<dd class="info-title">管客户</dd>
					<dd>客户信息了如指掌，订货价格灵活设置，支持分区分级管理。管好客户，就这么简单
				</dd>
				</dl>
				<dl>
					<dt><i class="ydh-info-text-icon manger-inventory"></i></dt>
					<dd class="info-title">管库存</dd>
					<dd>库存数量一目了然，库存明细实时查询，更有上下限实时预警库存管理更高效</dd>
				</dl>
				<dl>
					<dt><i class="ydh-info-text-icon manger-sales"></i></dt>
					<dd class="info-title">管销售</dd>
					<dd>灵活划分销售区域，销售数据实时呈现。拜访管理、业务员代下单，管好销售，有业绩</dd>
				</dl>
				
			</div>
<div class="team clearfix yh mt20">

<div class="block">
<div class="t1"><a href="" class="fright f12">Talk专业制定</a>精英团队</div>			
			<div class="bd">
				<ul class="picList">
					<li>
						<div class="pic"><a href="#" target="_blank"><img src="images/xx1.jpg" /></a></div>
						<div class="title"><a href="#" target="_blank">效果图1</a></div>
					</li>
					<li>
						<div class="pic"><a href="#" target="_blank"><img src="images/pic8.jpg" /></a></div>
						<div class="title"><a href="#" target="_blank">效果图2</a></div>
					</li>
					<li>
						<div class="pic"><a href="#" target="_blank"><img src="images/xx2.jpg" /></a></div>
						<div class="title"><a href="#" target="_blank">效果图3</a></div>
					</li>
					<li>
						<div class="pic"><a href="#" target="_blank"><img src="images/xx3.jpg" /></a></div>
						<div class="title"><a href="#" target="_blank">效果图4</a></div>
					</li>
					<li>
						<div class="pic"><a href="#" target="_blank"><img src="images/xx4.jpg" /></a></div>
						<div class="title"><a href="#" target="_blank">效果图5</a></div>
					</li>
					<li>
						<div class="pic"><a href="#" target="_blank"><img src="images/xx5.jpg" /></a></div>
						<div class="title"><a href="#" target="_blank">效果图6</a></div>
					</li>
				</ul>
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