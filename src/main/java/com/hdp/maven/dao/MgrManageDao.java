package com.hdp.maven.dao;

import java.util.List;

import com.hdp.maven.domain.Employee;
import com.hdp.maven.domain.Menu;
import com.hdp.maven.domain.Order;
import com.hdp.maven.domain.VIPCard;


public interface MgrManageDao {
	//对员工的操作
		//增加员工信息
		public boolean addEmp(String name,String account,String passwd,String phone,String job,int mgrid,int rid);
		//修改员工信息,姓名，密码，电话
		public boolean updateEmp(int id,int rid);
		//删除员工信息，根据id删除,将员工的状态从1改成0
		public boolean deleteEmp(int id);
		//查询员工的所有信息
		public List<Employee> selectEmpAll();
		//查询员工信息，根据id查询
		public Employee selectEmpById(int id);
	//对菜单的操作
		//添加菜单
		public boolean addMenu(String name,double price,int type);
		//删除菜单
		public boolean deleteMenu(int id);
		//查询菜单详情
		public List<Menu> selectMenuAll();
		//查询菜单，根据id
		public Menu selectMenuById(int id);
		//修改菜单信息,设置特价菜，改价格和状态(2)
		public boolean updateMenu(int id,double price);
	//对VIP的操作
		//查询VIP的所有信息
		public List<VIPCard> selectVIPAll();
		//根据手机号查询VIP的信息
		public VIPCard selectByPhone(String phone);
		//挂失操作，就是将该用户的信息复制，重新添加在数据库中
		public boolean lostCard(String phone);
		//冻结操作，就是信息固定不变，且金额不能有变化
		public boolean freezeCard(String phone);
	//统计销量
		//查询热销菜
		public int selectMAX();
		
	//导出excel表
		
}
