package com.hdp.maven.control;

import java.sql.Date;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.hdap.maven.biz.EmployeeBiz;
import com.hdp.maven.domain.Employee;
import com.hdp.maven.domain.Menu;
import com.hdp.maven.domain.Restaurant;
import com.hdp.maven.domain.ShopCart;
import com.hdp.maven.domain.VIPCard;
import com.hdp.maven.util.UserInput;
import com.hdp.maven.view.MyView;

public class flowControl {
	private MyView view;
	private UserInput uInput;
	//定义代理函数
	private EmployeeBiz empBiz;
	public static final String IP="10.10.49.35";
	public static final int port=9999;
	List<ShopCart> menu=new ArrayList<ShopCart>();
	Menu m=new Menu();
	private boolean flag=true;
	private double sum=0;
	
	//定义员工id
	int empid=0;
	//定义餐厅id
	int rid=0;
	public flowControl() {
		super();
		this.view=new MyView();
		this.uInput=new UserInput();
		//设置代理
		empBiz=ProxyClient.getClient(EmployeeBiz.class, IP, port);
	}
	//系统登录
	public void Login() {
		this.view.showLogin();
		int select=uInput.getInt("请选择");
		if(select==1){
			String account = uInput.getString("请输入账号");
			String passwd = uInput.getString("请输入密码 ");
		//获取员工工作
		String login = this.empBiz.empLogin(account, passwd);
		//获取员工信息
		Employee employee = this.empBiz.findEmpByAccount(account, passwd);
		//获取员工所在餐厅
		empid=employee.getEid();
		Restaurant res = this.empBiz.findrestaurant(empid);
		rid=res.getRid();
		if(login.equals("e")){
			this.empOperate();
		}else if(login.equals("m")){
			this.view.showMgrOperate();
		}
		}else{
			System.exit(0);
		}
	}
	//员工主操作功能
	public void  empOperate(){
			this.view.showEmpOperate();
			int select = this.uInput.getInt("请选择");
			if(select==1){
				//收银
				this.cashier();
			}else if(select==2){
				//会员卡办理
				this.addVIPCard();
			}else if(select==3){
				//会员卡挂失
				this.setloss();
			}else if(select==4){
				//会员卡充值
				this.rechange();
			}else if(select==5){
				//退出
				System.exit(0);
			}
	}
	//收银流程
	private void cashier() {
		System.out.println("请选择菜品类型");
		this.view.showMenu();
		//选择菜品类型
		this.selectMenuType();
	}
	private void selectMenuType() {
		int select = this.uInput.getInt("请选择菜品类型：");
		//显示子菜单
		if(select==6){
			this.empOperate();
		}else {
			this.view.showMenuTable();
			List<Menu> menu = this.empBiz.findByType(select);
			for (int i = 0; i < menu.size(); i++) {
				System.out.println(menu.get(i));
			}
			//进行点菜
			this.order();
		}
		
	}

	//点菜流程
	private double order() {
		int select=this.uInput.getInt("1.点餐 2.删除点餐 3.结算");
		if(select==1){
//			新建购物车
			while(flag){
				 m = this.empBiz.findMenu(this.uInput.getInt("输入菜品编号"));
				 int price = this.uInput.getInt("请输入数量");
				 menu.add(new ShopCart(m.getMname(), price,m.getPrice()*price));
				 System.out.println("当前已选择如下");
				 System.out.println("菜名\t\t数量\t\t小计");
					for (int i = 0; i < menu.size(); i++) {
						System.out.println(menu.get(i));
					}
				 if("y".equals(this.uInput.getString("是否点其他 菜品（y/n）"))){
					 this.selectMenuType();
					 this.order();
				 }else {
					 flag=false;
					 this.order();
				}
			}
		}else if (select==2) {
			//更改购物车
			 System.out.println("当前已选择如下");
			 System.out.println("菜名\t\t数量\t\t小计");
			 for (int i = 0; i < menu.size(); i++) {
				 System.out.println(menu.get(i));
			 }
			 String name = this.uInput.getString("输入要删除的菜品");
			 for (int i = 0; i < menu.size(); i++) {
				 if(menu.get(i).getSname().equals(name)){
					 System.out.println(menu.get(i));
					 if(menu.get(i).getScount()!=1){
						 String sname = menu.get(i).getSname();
						 int scount = menu.get(i).getScount();
						 double sprice = menu.get(i).getSprice();
						 double money=sprice/scount;
						 menu.remove(i);
						 menu.add(new ShopCart(sname, scount-1, sprice-money));
						 System.out.println("当前已选择如下");
						 System.out.println("菜名\t\t数量\t\t小计");
						 for (int j = 0; j < menu.size(); j++) {
							 System.out.println(menu.get(j));
						 }
						 this.order();
					 }else {
						menu.remove(i);
						System.out.println("当前已选择如下");
						 System.out.println("菜名\t\t数量\t\t小计");
						 for (int j = 0; j < menu.size(); j++) {
							 System.out.println(menu.get(j));
						 }
						this.order();
					}
				 }
			 }
		}else if (select==3) {
			//进行结算
			flag=false;
			this.settlement();
	}
		return sum;
}	
	//结算函数
	private void settlement() {
		for (int i = 0; i <menu.size(); i++) {
			double sprice = menu.get(i).getSprice();
			sum+=sprice;
		}
		System.out.println("共消费:￥"+sum);
		this.receipt();
	}
	private void receipt() {
		int num = 0;
		int select=this.uInput.getInt("请选择支付方式(1.现金支付2.会员卡支付):");
		if(select==1){
			int money=this.uInput.getInt("收入收入金额");
			System.out.println("实收"+money);
			System.out.println("找回"+(money-sum));
			//同步数据到订单表
			Date d = new Date(System.currentTimeMillis());
			String uuid = this.getUUID();
			this.empBiz.addOrder(uuid,d, empid,num, rid);
			System.out.println("同步成功");
		}else if (select==2) {
			num = this.uInput.getInt("请输入卡号");
			VIPCard card = this.empBiz.findVIPCard(num);
			double discount = card.getDiscount();
			this.empBiz.rechange(num, -(sum*discount));
			//同步数据到订单表
			Date d = new Date(System.currentTimeMillis());
			String uuid = this.getUUID();
			this.empBiz.addOrder(uuid,d, empid,num, rid);
			System.out.println("同步成功");
		}
		
	}
	//办卡的方法
	private void addVIPCard() {
		VIPCard vCard=new  VIPCard();
		vCard.setName(uInput.getString("请输入姓名"));
		vCard.setVphone(uInput.getString("请输入联系方式"));
		vCard.setMoney(uInput.getDouble("输入余额"));
		vCard.setType(uInput.getInt("选择类型"));
		vCard.setDiscount(uInput.getDouble("输入折扣"));
		this.empBiz.addVIPCard(vCard.getName(), vCard.getVphone(), vCard.getMoney(), vCard.getType(), vCard.getDiscount());
		this.empOperate();
	}
	//挂失的方法
	private void setloss() {
		int num = uInput.getInt("请选择（1.通过卡号挂失 2.通过姓名和联系方式挂失）");
		if(num==1){
			System.out.println(this.empBiz.setLoss(uInput.getInt("请输入卡号")));
			this.empOperate();
		}else if(num==2){
			System.out.println(this.empBiz.setLoss(uInput.getString("请输入姓名"), uInput.getString("请输入联系方式")));
			this.empOperate();
		}else {
			System.out.println("请输入指定的数字");
		}
	}
//	充值的方法
	private void rechange() {
		System.out.println(this.empBiz.rechange(uInput.getInt("输入卡号"), uInput.getDouble("输入充值金额")));
		this.empOperate();
	}
	//获取uuid
	public String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("\\-", "");
    }
}
