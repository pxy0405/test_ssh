package com.pxy.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;






import com.opensymphony.xwork2.ActionContext;
import com.pxy.model.Cart;
import com.pxy.model.CartItem;
import com.pxy.model.Order;
import com.pxy.model.OrderItem;
import com.pxy.model.User;
import com.pxy.service.OrderService;
import com.pxy.service.impl.OrderServiceImpl;
import com.pxy.utils.PaymentUtil;
import com.uwantsoft.goeasy.client.goeasyclient.GoEasy;

/**
 * 订单的Action
 */
public class OrderAction extends SuperAction {
	private Order order;
	private String pd_FrpId;
	// 付款成功后的需要的参数:
	private String r3_Amt;
	private String r6_Order;
	// 
	private Integer oid;
	
	// 注入OrderService
	private OrderService orderService = new OrderServiceImpl();
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}

	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}

	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	

	// 保存订单执行的方法;
	public String saveOrder(){

		order = new Order();
		/****************封装订单的数据*********/
		order.setOrdertime(new Date());
		order.setState(1); // 1 未付款   2 未发货.  3.未确认发货   4 订单完成.
		// 有些数据需要从购物车中获取:
		// 获得购物车:
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null){
			this.addActionMessage("您还没有购物!请先去购物!");
			return "msg";
		}
		//将购物车总额赋值给订单
		order.setTotal(cart.getTotal());
		// 订单所属的用户:
		User loginUser = (User) session.getAttribute("loginUser");
		if(loginUser == null){
			this.addActionMessage("您还没有登录!请先去登录!");
			return "msg";
		}
		System.out.println(loginUser.getAddr());
		System.out.println(loginUser.getPhone());
		order.setUser(loginUser);
		System.out.println(order.getAddr());
		System.out.println(order.getPhone());
		/********************封装订单项数据*************/
		// 订单项数据从 购物项的数据获得.
		for (CartItem cartItem : cart.getCartItems()) {
			//每一个订单项
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setOrder(order);
			//订单将每一个订单项装进来
			order.getOrderItems().add(orderItem);
		}
		// 清空购物车.
		cart.clearCart();
		
		// 保存订单:
		Integer oid = orderService.save(order);
		order.setOid(oid);
		//session.setAttribute("order", order);
		return "saveOrderSuccess";
	}
	
	
	//更新订单的方法:
	public String updateOrder() throws IOException{
		// 修改订单:
		// 查询这个id的订单:
		Order currOrder = orderService.findByOid(order.getOid());
		System.out.println("getaddreess");
		System.out.println(order.getAddr());
		currOrder.setAddr(order.getAddr());
		currOrder.setUserName(order.getUserName());
		currOrder.setPhone(order.getPhone());
		
		orderService.update(currOrder);
		return "payOrderSuccess";
	}
	
	//用户付款确认
	public String pay(){
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setState(2);// 修改订单状态.状态2为待发货
		orderService.update(currOrder);
		return "paySuccess";
	}
	//后台对订单进行发货
	public String fahuo(){
		Integer oid=Integer.parseInt(request.getParameter("oid"));
		//System.out.println(order.getOid());
		Order currOrder = orderService.findByOid(oid);
		currOrder.setState(3);// 修改订单状态.，状态3为待收货
		orderService.update(currOrder);
		GoEasy goEasy = new GoEasy("bac4091d-b42f-495f-8c83-bcd877758047");
		goEasy.publish("Sakura_first","商家已经发货");
		return "fahuoSuccess";
	}
	//确认已经发货的方法
	public String updateState(){
		Integer oid=Integer.parseInt(request.getParameter("oid"));
		Order currOrder = orderService.findByOid(oid);
		currOrder.setState(4);// 修改订单状态.状态1为待付款
		orderService.update(currOrder);
		return "updateStateSuccess";
	}
	//按用户id查询用户所有的订单:
	public String findByUid(){
		// 获得用户对象:
		User loginUser = (User)session.getAttribute("loginUser");
		List<Order> oList = orderService.findByUid(loginUser);
		// 压栈
		ActionContext.getContext().getValueStack().set("oList", oList);
		return "findByUidSuccess";
	}
	
	//查询订单:
	public String findByOid(){
		order = orderService.findByOid(oid);
		return "findByOidSuccess";
	}
	
	//后台查询所有的订单
	public String findAllOrder(){
		List<Order> allOrder = orderService.findAllOrder();
		// 压栈
		ActionContext.getContext().getValueStack().set("allOrder", allOrder);
		return "findAllOrderSuccess";
	}
	public String myOrder(){
		return "myOrder";
	}
}
