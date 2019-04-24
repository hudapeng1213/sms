package com.hdp.maven.biz;

import java.util.List;

import com.hdp.maven.domain.Employee;
import com.hdp.maven.domain.Menu;
import com.hdp.maven.domain.Order;
import com.hdp.maven.domain.VIPCard;
public interface MgrManagerBiz {
	//对员工的操作
		//添加员工
		public String addEmp(String name,String account,String passwd,String phone,String job,int mgrid,int rid);
		//修改员工
		public String updateEmp(int id,int rid);
		//删除员工
		public String removeEmp(int id);
		//查询员工，根据id
		public Employee selectEmpById(int id);
		//查询所有员工信息
		public List<Employee> findEmpAll();
	//对菜单的操作
		//添加菜单
		public String addMenu(String name,double price,int type);
		//删除菜单
		public String removeMenu(int id);
		//查询所有菜单
		public List<Menu> findMenuAll();
		//查询菜单，根据id
		public Menu selectMenuById(int id);
		//修改菜单
		public String updateMenu(int id,double price);
	//对VIP的操作
		//查询VIP的所有信息
		public List<VIPCard> selectVIPAll();
		//根据手机号查询VIP的信息
		public VIPCard selectVIPByPhone(String phone);
		//补办操作
		public boolean lostCard(String phone);
		//冻结操作
		public boolean freezeCard(String phone);
	//统计销量
		//查询销量最高的菜品id
		public int findMAX();
	/*//导出excel表
		public void toExcel();*/
	
}
