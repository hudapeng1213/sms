package com.hdp.maven.dao;

import java.sql.Date;
import java.util.List;
import com.hdp.maven.domain.Employee;
import com.hdp.maven.domain.Menu;
import com.hdp.maven.domain.Restaurant;
import com.hdp.maven.domain.VIPCard;

public interface EmployeeDao {
	//查找登录用户
	public Employee selectLogin(String account,String password);
	//根据菜品类型查找菜品
	public List<Menu> selectByType(int type);
	//通过菜品id查找菜品
	public Menu selectByMid(int mid);
	//订单的新建
	public boolean insertOrder(String uuid,Date time,int eid,int vipid,int rid);
	//订单详情新建
	public boolean insertDetails();
	//新添会员卡
	public boolean insertCard(String name,String phone,double money,int type,double vipdiscount);
	//查找会员卡信息
	public VIPCard selectCardById(int id);
	public VIPCard selectCardByName(String name,String phone);
	//修改会员卡余额
	public boolean updatemoney(int id,double money);
	//修改卡的状态
	public boolean updateState(int id,int state);
	//获取登录员工的工作
	public String selectJobByLogin(Employee e);
	//获取员工所在餐厅
	public Restaurant selectByEid(int id);
	
}
