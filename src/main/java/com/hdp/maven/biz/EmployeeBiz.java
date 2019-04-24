package com.hdp.maven.biz;

import java.sql.Date;
import java.util.List;

import com.hdp.maven.domain.Employee;
import com.hdp.maven.domain.Menu;
import com.hdp.maven.domain.Restaurant;
import com.hdp.maven.domain.VIPCard;


public interface EmployeeBiz {	
	//员工登录
	public String empLogin(String account,String passwd);
	//员工办理新卡
	public boolean addVIPCard(String name, String  phone, double money, int type,double discount);
	//会员卡挂失
	public String  setLoss(int id);
	public String  setLoss(String vipname,String vippnone);
	//会员卡充值
	public String rechange(int id,double money);
	//点菜-选择菜品类型
	public List<Menu> findByType(int type);
	//点菜选择菜品
	public Menu findMenu(int id);
	//获取员工信息
	public Employee findEmpByAccount(String account,String passwd);
	//获取会员卡信息
	public VIPCard findVIPCard(int id);
	//获取餐厅信息
	public Restaurant findrestaurant(int id);
	//添加信息到 订单表
	public boolean addOrder(String uuid, Date time, int eid, int vipid, int rid);
	//通过uuid查找订单号
	public int findOrderByUUID(String uuid);
	//通过菜名查找菜id
	public int findMenuIdByID(String name);
	//添加信息到 订单详情表
	public boolean addDetails(int count,int oid,int mid);
}
