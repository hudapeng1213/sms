package com.hdp.maven.control;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.hdap.maven.biz.yahuiService;
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
	private yahuiService service;
	public static final String IP="10.10.49.35";
	public static final int port=9999;
	//定义购物车
	List<ShopCart> menu=new ArrayList<ShopCart>();
	//建立菜品类
	Menu m=new Menu();
	private boolean flag=true;
	//定义订单总额
	private double sum=0;
	//定义员工id
	int empid=0;
	//定义餐厅id
	int rid=0;
	//定义餐厅类
	Employee employee=null;
	//定义员工类
	Restaurant res=null;
	public flowControl() {
		super();
		this.view=new MyView();
		this.uInput=new UserInput();
		//设置代理
		service=ProxyClient.getClient(yahuiService.class, IP, port);
	}
	//系统登录
	public void Login() {
		this.view.showLogin();
		int select=uInput.getInt("请选择");
		if(select==1){
			String account = uInput.getString("请输入账号");
			String passwd = uInput.getString("请输入密码 ");
		//获取员工工作
		String login = this.service.empLogin(account, passwd);
		//获取员工信息
		employee = this.service.findEmpByAccount(account, passwd);
		//获取员工所在餐厅
		empid=employee.getEid();
		res = this.service.findrestaurant(empid);
		rid=res.getRid();
		if(login.equals("e")){
			this.empOperate();
		}else if(login.equals("m")){
			this.mgrOperate();
		}
		}else{
			System.exit(0);
		}
	}
	
	//经理主操作功能
	private void mgrOperate() {
		this.view.showMgrOperate();
		int select =this.uInput.getInt("请选择");
		if(select==1){
			//员工管理
			this.mgremp();
		}else if(select==2){
			//菜单管理 
			this.mgrmenu();
		}else if(select==3){
			//会员卡管理
			this.vip();
		}else if(select==4){
			//业务统计
			this.census();
		}else if(select==5){
			//导出excal
			this.export();
		}else if (select==6) {
			//退出
			System.exit(0);
		}
	}
	
	//管理员工
	private void mgremp() {
		this.view.showManageEmp();
		int select = this.uInput.getInt("请选择");
		if(select==1){
			//添加员工
			String ename = this.uInput.getString("请输入员工名：");
			String eaccount = this.uInput.getString("请输入账号");
			String epasswd = this.uInput.getString("请输入密码");
			String ephone = this.uInput.getString("请输入联系方式");
			String job = this.uInput.getString("输入职务");
			int mgr=this.uInput.getInt("请输入上司 编号");
			int rid=this.uInput.getInt("请输入在职的餐厅编号");
			this.service.addEmp(ename, eaccount, epasswd, ephone, job, mgr, rid);
			System.out.println("添加完成");
			this.mgremp();
		}else if (select==2) {
			//删除员工
			this.service.removeEmp(this.uInput.getInt("请输入要删除的 员工id"));
			System.out.println("删除成功");
			this.mgremp();
		}else if (select==3) {
			//查询员工
			List<Employee> empAll = this.service.findEmpAll();
			System.out.println("员工编号\t姓名\t账号\t密码\t工作\t上司编号\t联系方式\t餐厅编号");
			for (Employee e : empAll) {
				System.out.println(e.getEid()+"\t"+e.getEname()+"\t"+e.getAccount()+"\t"+e.getPassword()+"\t"+e.getJob()+"\t"+
						e.getMgid()+"\t"+e.getPhone()+"\t"+e.getRid());
			}
			this.mgremp();
		}else if (select==4) {
			//员工调职
			int id = this.uInput.getInt("请输入要调职的员工编号");
			int rid =this.uInput.getInt("请输入餐厅id");
			this.service.updateEmp(id, rid);
			System.out.println("修改完成");
			this.mgremp();
		}else if (select==5) {
			this.mgrOperate();
		}
	}
	//管理菜单
	private void mgrmenu() {
		this.view.showManageMenu();
		int select =this.uInput.getInt("请选择");
		if(select==1){
			//添加菜品
			String mname = this.uInput.getString("请输入菜名");
			double price= this.uInput.getDouble("请输入价格");
			int type = this.uInput.getInt("请输入菜品类型");
			System.out.println(this.service.addMenu(mname, price, type));
			this.mgrmenu();
		}else if (select==2) {
			//删除菜品
			this.service.removeMenu(this.uInput.getInt("请输入要删除的 菜品编号"));
			System.out.println("删除完成");
			this.mgrmenu();
		}else if (select==3) {
			//查询菜品
			List<Menu> menuAll = this.service.findMenuAll();
			System.out.println("菜品编号\t\t菜品名\t\t菜品价格");
			for (Menu sm : menuAll) {
				System.out.println(sm.getMid()+"\t\t"+sm.getMname()+"\t\t"+sm.getPrice());
			}
			System.out.println();
			this.mgrmenu();
		}else if (select==4) {
			//设置特价菜
			this.service.updateMenu(this.uInput.getInt("输入要修改的菜品编号"), this.uInput.getDouble("输入修改后的价格 "));
			System.out.println("修改成功");
			this.mgrmenu();
		}else if (select==5) {
			//返回上一级菜单
			this.mgrOperate();
		}
	}
	//管理会员卡
	private void vip() {
		this.view.showManageVIP();
		int select = this.uInput.getInt("请选择");
		if(select==1){
			//补办会员卡
			String phone = this.uInput.getString("请输入手机号");
			VIPCard card = this.service.selectVIPByPhone(phone);
			System.out.println(card);
			this.service.lostCard(phone);
			System.out.println("操作成功");
			this.mgrOperate();
		}else if (select==2) {
			//冻结会员卡
			String phone = this.uInput.getString("请输入手机号");
			VIPCard card = this.service.selectVIPByPhone(phone);
			System.out.println(card);
			this.service.freezeCard(phone);
			System.out.println("操作成功");
			this.mgrOperate();
		}else if (select==3) {
			//返回上一级
			this.mgrOperate();
		}
	}
	//销售记录的统计
	private void census() {
		this.view.showCensos();
		int select = this.uInput.getInt("请选择");
		if(select==1){
			int id = this.service.findMAX();
			Menu menu2 = this.service.selectMenuById(id);
			System.out.println("最热销的菜品是："+menu2.getMname());
			this.census();
		}else if(select==2){
			
		}else if(select==3){
			this.mgrOperate();
		}
		
	}
	// 导出销售记录到excal
	private void export() {
		
		
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
			List<Menu> menu = this.service.findByType(select);
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
				 m = this.service.findMenu(this.uInput.getInt("输入菜品编号"));
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
		sum=0;
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
			double soul = this.uInput.getDouble("实收金额");
			double change=soul-sum;
			System.out.println("找零"+change);
			//同步数据到订单表
			Date d = new Date(System.currentTimeMillis());
			String uuid = this.getUUID();
			this.service.addOrder(uuid,d, empid,num, rid);
			System.out.println("上传到订单表成功");
			//同步数据到详情表
			for (int i = 0; i < menu.size(); i++) {
				
				//获取菜品编号
				int mid = this.service.findMenuIdByID(menu.get(i).getSname());
				//获取订单号
				int oid=this.service.findOrderByUUID(uuid);
				this.service.addDetails(menu.get(i).getScount(), oid, mid);
			}
			System.out.println("上传到详情表成功");
			//打印小票
			String address=res.getAddress();
			String rname=res.getRname();
			String name=employee.getEname();
			System.out.println();
			this.view.showTicket(address, name, d, uuid, menu, sum, rname, soul, change);
			menu.clear();
			System.out.println();
			this.empOperate();
		}else if (select==2) {
			num = this.uInput.getInt("请输入卡号");
			VIPCard card = this.service.findVIPCard(num);
			if(card.getState()==2){
				System.out.println("当前会员卡已挂失");
			}else if(card.getState()==3){
				System.out.println("当前会员卡已经冻结");
			}else if(card.getState()==1){
				double discount = card.getDiscount();
				this.service.rechange(num, -(sum*discount));
				//同步数据到订单表
				Date d = new Date(System.currentTimeMillis());
				String uuid = this.getUUID();
				this.service.addOrder(uuid,d, empid,num, rid);
				System.out.println("上传到订单表成功");
				//同步数据到详情表
				for (int i = 0; i < menu.size(); i++) {
					//获取菜品编号
					int mid = this.service.findMenuIdByID(menu.get(i).getSname());
					//获取订单号
					int oid=this.service.findOrderByUUID(uuid);
					this.service.addDetails(menu.get(i).getScount(), oid, mid);
				}
				System.out.println("上传到详情表成功");
				//打印小票
				String address=res.getAddress();
				String rname=res.getRname();
				String name=employee.getEname();
				System.out.println();
				this.view.showTicketByCard(address, name, d,uuid,menu ,sum, rname,num);
				menu.clear();
				System.out.println();
				this.empOperate();
			}
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
		this.service.addVIPCard(vCard.getName(), vCard.getVphone(), vCard.getMoney(), vCard.getType(), vCard.getDiscount());
		this.empOperate();
	}
	//挂失的方法
	private void setloss() {
		int num = uInput.getInt("请选择（1.通过卡号挂失 2.通过姓名和联系方式挂失）");
		if(num==1){
			System.out.println(this.service.setLoss(uInput.getInt("请输入卡号")));
			this.empOperate();
		}else if(num==2){
			System.out.println(this.service.setLoss(uInput.getString("请输入姓名"), uInput.getString("请输入联系方式")));
			this.empOperate();
		}else {
			System.out.println("请输入指定的数字");
		}
	}
//	充值的方法
	private void rechange() {
		System.out.println(this.service.rechange(uInput.getInt("输入卡号"), uInput.getDouble("输入充值金额")));
		this.empOperate();
	}
	//获取uuid
	public String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("\\-", "");
    }
}
