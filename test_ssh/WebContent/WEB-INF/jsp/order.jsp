<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<title>订单页面</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/xiaomi.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.animate-colors-min.js"></script>
</head>
<body>
<%@include file="menu.jsp" %>
<div class="container cart">
		<div class="span24">
		
			<div class="step step1">
				<ul>
					<li  class="current"></li>
					<li  >生成订单成功</li>
				</ul>
				<ul>
					<li  class="current"></li>
					<li  >订单号：${order.oid }</li>
				</ul>
			</div>
	
		
				<table>
					<tbody>
					<tr>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${order.orderItems }" var="orderItem">
						<tr>
							<td width="60">
								<input type="hidden" name="id" value="22"/>
								<img src="${ pageContext.request.contextPath }/${orderItem.product.image }"/>
							</td>
							<td>
								<a target="_blank">${orderItem.product.pname }</a>
							</td>
							<td>
								${orderItem.product.shop_price }
							</td>
							<td class="quantity" width="60">
								<input type="text" name="count" value="${orderItem.count }" maxlength="4" onpaste="return false;"/>
								<div>
									<span class="increase">&nbsp;</span>
									<span class="decrease">&nbsp;</span>
								</div>
							</td>
							<td width="140">
								<span class="subtotal">￥${orderItem.subtotal }</span>
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/cart_removeCart.action?pid=1" class="delete">删除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
				<div class="total">
					<em id="promotion"></em>
					商品金额: <strong id="effectivePrice">￥${order.total }</strong>
				</div>
			<form id="orderForm" action="${pageContext.request.contextPath }/order_updateOrder.action" method="post">
				<input type="hidden" name="order.oid" value="${order.oid }"/>
				<div class="span24">
					<p>
							收货地址：<input name="order.addr" type="text" value="${order.user.addr }" style="width:350px" />
								<br />
							收货人&nbsp;&nbsp;&nbsp;：<input name="order.userName" type="text" value="${order.user.userName }" style="width:150px" />
								<br /> 
							联系方式：<input name="order.phone" type="text" value="${order.user.phone }" style="width:150px" />

						</p>
						<p style="text-align:right">
							<a href="javascript:document.getElementById('orderForm').submit();">
								<img src="${pageContext.request.contextPath}/images/finalbutton.gif" width="204" height="51" border="0" />
							</a>
						</p>
				</div>
			</form>
		</div>
		
	</div>
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="image\r___________renleipic_01/footer.jpg" alt="我们的优势" title="我们的优势" height="52" width="950"/>
</div>
</div>
	<div class="span24">
		<ul class="bottomNav">
					<li>
						<a href="#">关于我们</a>
						|
					</li>
					<li>
						<a href="#">联系我们</a>
						|
					</li>
					<li>
						<a href="#">诚聘英才</a>
						|
					</li>
					<li>
						<a href="#">法律声明</a>
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
						<a target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a >SHOP++官网</a>
						|
					</li>
					<li>
						<a>SHOP++论坛</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2013 Mango商城 版权所有</div>
	</div>
</div>
</body>
</html>