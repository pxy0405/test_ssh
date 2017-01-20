<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0080)http://localhost:8080/mango/login.jhtml?redirectUrl=%2Fmango%2Fcart%2Flist.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>会员登录</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/xiaomi.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.animate-colors-min.js"></script>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.css" />
<link href="${pageContext.request.contextPath}/css/dlstyle.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@include file="menu.jsp" %>
		<div class="login-banner">
			<div class="login-main">
				<div class="login-banner-bg"><span></span><img src="${pageContext.request.contextPath}/images/big.jpg" /></div>
				<div class="login-box">

							<h3 class="title">登录商城</h3>

							<div class="clear"></div>
						
						<div class="login-form">
						 <form id="loginForm" action="User_userLogin.action"  method="post" novalidate="novalidate">
							   <div class="user-name">
								    <label for="user">姓名</label>
								    <input type="text" id="username" name="user.userName" placeholder="邮箱/手机/用户名"/>
				                 </div>
				                 <div class="user-pass">
								    <label for="password">密码</label>
								    <input type="password" id="password" name="user.passWord" placeholder="请输入密码"/>
                 				</div>
                 				<div class="user-name">
								    <label for="user">身份</label>
								    <input type="text" id="status" name="user.status" placeholder="普通用户请输入1"/>
				                 </div>
				                 <!-- <div class="login-links">
					                <label for="remember-me"><input id="remember-me" type="checkbox"/>记住密码</label>
													<a href="#" class="am-fr">忘记密码</a>
					            </div> -->
								<div class="am-cf">
									<input type="submit" value="登 录" class="am-btn am-btn-primary am-btn-sm"/>
								</div>
			              </form>
			           </div>
            
					            
						<div class="partner">		
								<h3>合作账号</h3>
								<h3>&nbsp;&nbsp;</h3>
							<div class="am-btn-group">
								<li><a href="#"><span>QQ登录</span></a></li>
								<li><a href="#"><span>微博登录</span> </a></li>
								<li><a href="#"><span>微信登录</span> </a></li>
							</div>
						</div>	

				</div>
			</div>
		</div>

<div class="container footer">
	<div class="span24">
	  <div class="footerAd"><img src="${pageContext.request.contextPath}/img/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势" /></div>	
	</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a >关于我们</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					<li>
						<a>招贤纳士</a>
						|
					</li>
					<li>
						<a>法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					<li>
						<a  target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a>服务声明</a>
						|
					</li>
					<li>
						<a>广告声明</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
	</div>
</div>
<script type="text/javascript" src="js/xiaomi.js"></script>
</body></html>