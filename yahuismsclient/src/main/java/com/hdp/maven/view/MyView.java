package com.hdp.maven.view;

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
	
	//显示经理操作界面
	public void showMgrOperate(){
		System.out.println("********亚惠结算********");
		System.out.println("      1.员工管理");
		System.out.println("      2.菜单管理");
		System.out.println("      3.会员卡管理");
		System.out.println("      4.统计");
		System.out.println("      5.导出");
		System.out.println("**********************");
	}
	
	//显示菜单信息
	public void showMenuTable(){
		System.out.println("编号\t\t菜名\t\t单价");
	}
}
