package com.hdp.maven.biz.impl;

import java.util.List;
import com.hdp.maven.biz.MgrManagerBiz;
import com.hdp.maven.dao.MgrManageDao;
import com.hdp.maven.dao.impl.MgrManagerDaoImpl;
import com.hdp.maven.domain.Employee;
import com.hdp.maven.domain.Menu;
import com.hdp.maven.domain.Order;
import com.hdp.maven.domain.VIPCard;

public class MgrManagerBizImpl implements MgrManagerBiz {
	
	//调用dao层
	private MgrManageDao mDao;
	//创建无参构造方法
	public MgrManagerBizImpl() {
		super();
		this.mDao = new MgrManagerDaoImpl();
	}
	
	//添加员工
	public String addEmp(String name,String account,String passwd,String phone,String job,int mgr,int rid) {

		return this.mDao.addEmp(name, account, passwd, phone, job,mgr,rid)?"添加成功":"添加失败";
	}
	
	//修改员工信息
	public String updateEmp(int id,int rid) {
		//根据id查看员工是否存在
		Employee emp=this.mDao.selectEmpById(id);
		if(emp==null){
			return "不存在要修改的员工信息";
		}
		return this.mDao.updateEmp(id, rid)?"修改成功":"修改失败";
	}
	
	//删除员工信息
	public String removeEmp(int id) {
		//查询id是否已经存在
		Employee emp=this.mDao.selectEmpById(id);
		if(emp==null){
			return "要删除的员工id不存在";
		}
		return this.mDao.deleteEmp(id)?"删除成功":"删除失败";
	}
	
	//根据id查询员工信息
	public Employee selectEmpById(int id) {
		//查询id是否已经存在
		Employee emp=this.mDao.selectEmpById(id);
		if(emp==null){
			System.out.println("不存在要修改的员工");
		}
		return this.mDao.selectEmpById(id);
	}
	
	//查询员工所有信息
	public List<Employee> findEmpAll() {
		
		return this.mDao.selectEmpAll();
	}
	
	//添加菜单
	public String addMenu(String name, double price, int type) {
	
		return this.mDao.addMenu(name, price, type)?"添加成功":"添加失败";
	}
	
	//删除菜单
	public String removeMenu(int id) {
		//查询id是否已经存在
		Menu menu=this.mDao.selectMenuById(id);
		if(menu==null){
			return "要删除的菜单id不存在";
		}
		return this.mDao.deleteMenu(id)?"删除成功":"删除失败";
	}
	
	//查询所有菜单
	public List<Menu> findMenuAll() {
		
		return this.mDao.selectMenuAll();
	}
	
	//查询菜单，根据id
	public Menu selectMenuById(int id) {

		return this.mDao.selectMenuById(id);
	}
	
	//修改菜单信息
	public String updateMenu(int id,double price) {
		//查询id是否已经存在
		
		Menu menu=this.mDao.selectMenuById(id);
		if(menu==null){
			return "不存在要修改的菜单信息";
		}
		return this.mDao.updateMenu(id,price)?"修改成功":"修改失败";
	}

	
	//查询所有VIP信息
	public List<VIPCard> selectVIPAll() {
		
		return this.mDao.selectVIPAll();
	}

	
	//根据电话号码查询VIP客户
	public VIPCard selectVIPByPhone(String phone) {
		
		return this.mDao.selectByPhone(phone);
	}
	
	//挂失操作
	public boolean lostCard(String phone) {
		//查询phone是否已经存在
		VIPCard vipCard=this.mDao.selectByPhone(phone);
		if(vipCard==null){
			System.out.println("要挂失的VIP客户不存在");
		}
		return this.mDao.lostCard(phone);
	}
	
	//冻结操作
	public boolean freezeCard(String phone) {
		//查询phone是否已经存在
		VIPCard vipCard=this.mDao.selectByPhone(phone);
		if(vipCard==null){
			System.out.println("要挂失的VIP客户不存在");
		}
		return this.mDao.freezeCard(phone);
	}

	@Override
	public int findMAX() {
		return this.mDao.selectMAX();
	}
	
	/*//查看销量
	public Order showOrder() {
		
		return this.mDao.showOrder();
	}
	
	//导出excel表
	public void toExcel() {
		

	}
*/
	

}
