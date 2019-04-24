package com.hdp.maven.view;

import java.sql.Date;
import java.util.List;

import com.hdp.maven.domain.ShopCart;

public class MyView {
	//显示登录界面
	public void showLogin(){
		System.out.println("********登录********");
		System.out.println("      1.登录");
		System.out.println("      2.退出系统");
		System.out.println("*******************");
	}
	//显示员工的操作界面
	public void showEmpOperate(){
		System.out.println("********亚惠结算********");
		System.out.println("      1.收银");
		System.out.println("      2.办卡");
		System.out.println("      3.挂失");
		System.out.println("      4.充值");
		System.out.println("      5.退出");
		System.out.println("**********************");
	}
	//显示点餐界面 
	public void showMenu(){
		System.out.println("********亚惠菜单********");
		System.out.println("      1.肉类");
		System.out.println("      2.素类");
		System.out.println("      3.汤类");
		System.out.println("      4.主食");
		System.out.println("      5.海鲜");
		System.out.println("      6.退出");
		System.out.println("**********************");
	}
	//显示菜单信息
	public void showMenuTable(){
		System.out.println("编号\t\t菜名\t\t单价");
	}
	//打印小票-普通结账
	public void showTicket(String address,String name,Date time,String orderid,List<ShopCart> list,double sum,String rname,double money,double change){
		System.out.println("\t"+rname);
		System.out.println("**********************");
		System.out.println("订单号："+orderid);
		System.out.println("时间："+time);
		System.out.println("收银员："+name);
		System.out.println("**********************");
		System.out.println("菜品\t\t数量\t\t小计");
		for (ShopCart shopCart : list) {
			System.out.println(shopCart);
		}
		System.out.println("**********************");
		System.out.println("合计："+sum);
		System.out.println("实收："+money);
		System.out.println("找回："+change);
		System.out.println();
		System.out.println("地址"+address);
		System.out.println("\t谢谢惠顾");
	}
	//打印小票-会员卡结账
	public void showTicketByCard(String address,String name,Date time,String orderid,List<ShopCart> list,double sum,String rname,int cid){
		System.out.println("\t"+rname);
		System.out.println("**********************");
		System.out.println("订单号："+orderid);
		System.out.println("时间："+time);
		System.out.println("收银员："+name);
		System.out.println("**********************");
		System.out.println("菜品\t\t数量\t\t小计");
		for (ShopCart shopCart : list) {
			System.out.println(shopCart);
		}
		System.out.println("**********************");
		System.out.println("合计："+sum);
		System.out.println("由会员卡"+cid+"支付");
		System.out.println();
		System.out.println("地址"+address);
		System.out.println("\t谢谢惠顾");
	}
	
	//显示经理操作界面
		public void showMgrOperate(){
			System.out.println("********亚惠结算********");
			System.out.println("      1.员工管理");
			System.out.println("      2.菜单管理");
			System.out.println("      3.会员卡管理");
			System.out.println("      4.统计");
			System.out.println("      5.导出");
			System.out.println("      6.退出经理管理系统");
			System.out.println("**********************");
		}
	
		//经理对员工的具体操作
		public void showManageEmp(){
			System.out.println("********亚惠结算********");
			System.out.println("      1.添加员工");
			System.out.println("      2.删除员工");
			System.out.println("      3.查询员工");
			System.out.println("      4.员工调职");
			System.out.println("      5.退出员工操作");
			System.out.println("**********************");
		}
		
		//经理对菜单的具体操作
		public void showManageMenu(){
			System.out.println("********亚惠结算********");
			System.out.println("      1.添加菜单");
			System.out.println("      2.删除菜单");
			System.out.println("      3.查询菜单");
			System.out.println("      4.设特价菜");
			System.out.println("      5.退出菜单操作");
			System.out.println("**********************");
		}
		
		//经理对VIP的具体操作
		public void showManageVIP(){
			System.out.println("********亚惠结算********");
			System.out.println("      1.补卡");
			System.out.println("      2.冻结");
			System.out.println("      3.退出VIP卡操作");
			System.out.println("**********************");
		}
		
		//经理统计销售情况
		public void showCensos(){
			System.out.println("********亚惠结算********");
			System.out.println("      1.统计热销菜");
			System.out.println("      2.统计收益");
			System.out.println("      3.退出统计");
			System.out.println("**********************");
		}
}
