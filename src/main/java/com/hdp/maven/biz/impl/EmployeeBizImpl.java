package com.hdp.maven.biz.impl;

import java.sql.Date;
import java.util.List;
import com.hdp.maven.biz.EmployeeBiz;
import com.hdp.maven.dao.EmployeeDao;
import com.hdp.maven.dao.impl.EmployDaoImpl;
import com.hdp.maven.domain.Employee;
import com.hdp.maven.domain.Menu;
import com.hdp.maven.domain.Restaurant;
import com.hdp.maven.domain.VIPCard;

public class EmployeeBizImpl implements EmployeeBiz {
	private EmployeeDao empDao;
	
	
	public EmployeeBizImpl() {
		super();
		this.empDao = new EmployDaoImpl();
	}


	public String empLogin(String account, String passwd) {
		Employee emp = this.empDao.selectLogin(account, passwd);
		if(emp!=null){
			String job = this.empDao.selectJobByLogin(emp);
			return job;
		}else {
			System.out.println("输入的账户不存在或密码错误");
			return null;
		}
	}


	@Override
	public boolean addVIPCard(String name, String phone, double money, int type, double discount) {
		
		return this.empDao.insertCard(name, phone, money, type, discount);
	}


	@Override
	public String  setLoss(int id) {
		VIPCard card = this.empDao.selectCardById(id);
		System.out.println(card);
		if(card!=null){
			return this.empDao.updateState(id, 2)?"挂失成功":"挂失失败";
		}
		return "该会员卡不存在";
	}


	@Override
	public String setLoss(String vipname, String vippnone) {
		VIPCard card = this.empDao.selectCardByName(vipname, vippnone);
		System.out.println(card);
		if(card!=null){
			return this.empDao.updateState(card.getVid(), 2)?"挂失成功":"挂失失败";
		}
		return "该会员卡不存在";
		
	}


	@Override
	public String rechange(int id, double money) {
		VIPCard card = this.empDao.selectCardById(id);
		System.out.println(card);
		if(card!=null){
			return this.empDao.updatemoney(id, money+card.getMoney())?"充值成功":"充值失败";
		}
		return "该会员卡不存在";
	}

	@Override
	public List<Menu> findByType(int type) {
		List<Menu> list = this.empDao.selectByType(type);
		return list;
	}


	@Override
	public Menu findMenu(int id) {
		return this.empDao.selectByMid(id);
	}


	@Override
	public Restaurant findrestaurant(int id) {
		return this.empDao.selectByEid(id);
	}


	@Override
	public boolean addOrder(String uuid, Date time, int eid, int vipid, int rid) {
		return this.empDao.insertOrder(uuid, time, eid, vipid, rid);
	}


	@Override
	public Employee findEmpByAccount(String account, String passwd) {
		return this.empDao.selectLogin(account, passwd);
	}

	//查找会员卡
	@Override
	public VIPCard findVIPCard(int id) {
		return this.empDao.selectCardById(id);
	}


	@Override
	public int findOrderByUUID(String uuid) {
		return this.empDao.selectOrderByuuid(uuid);
	}


	@Override
	public int findMenuIdByID(String name) {
		return this.empDao.selectMenuByMname(name);
	}


	@Override
	public boolean addDetails(int count, int oid, int mid) {
		return this.empDao.insertDetails(count, oid, mid);
	}
	
	
}
