package com.hdp.maven.biz.impl;

import java.sql.Date;
import java.util.List;

import com.hdp.maven.biz.EmployeeBiz;
import com.hdp.maven.biz.MgrManagerBiz;
import com.hdp.maven.biz.yahuiService;
import com.hdp.maven.domain.Employee;
import com.hdp.maven.domain.Menu;
import com.hdp.maven.domain.Restaurant;
import com.hdp.maven.domain.VIPCard;

public class yahuiServiceImpl implements yahuiService {
	private EmployeeBiz empDao;
	private MgrManagerBiz MgrDao;
	public yahuiServiceImpl() {
		super();
		this.empDao = new EmployeeBizImpl();
		this.MgrDao = new MgrManagerBizImpl();
	}
	@Override
	public String empLogin(String account, String passwd) {
		return this.empDao.empLogin(account, passwd);
	}
	@Override
	public boolean addVIPCard(String name, String phone, double money, int type, double discount) {
		
		return this.empDao.addVIPCard(name, phone, money, type, discount);
	}
	@Override
	public String setLoss(int id) {
		
		return this.empDao.setLoss(id);
	}
	@Override
	public String setLoss(String vipname, String vippnone) {
		
		return this.empDao.setLoss(vipname, vippnone);
	}
	@Override
	public String rechange(int id, double money) {
		
		return this.empDao.rechange(id, money);
	}
	@Override
	public List<Menu> findByType(int type) {
		
		return this.empDao.findByType(type);
	}
	@Override
	public Menu findMenu(int id) {
		
		return this.empDao.findMenu(id);
	}
	@Override
	public Employee findEmpByAccount(String account, String passwd) {
		
		return this.empDao.findEmpByAccount(account, passwd);
	}
	@Override
	public VIPCard findVIPCard(int id) {
		
		return this.empDao.findVIPCard(id);
	}
	@Override
	public Restaurant findrestaurant(int id) {
		
		return this.empDao.findrestaurant(id);
	}
	@Override
	public boolean addOrder(String uuid, Date time, int eid, int vipid, int rid) {
		
		return this.empDao.addOrder(uuid, time, eid, vipid, rid);
	}
	@Override
	public int findOrderByUUID(String uuid) {
		
		return this.empDao.findOrderByUUID(uuid);
	}
	@Override
	public int findMenuIdByID(String name) {
	
		return this.empDao.findMenuIdByID(name);
	}
	@Override
	public boolean addDetails(int count, int oid, int mid) {
		
		return this.empDao.addDetails(count, oid, mid);
	}
	@Override
	public String addEmp(String name, String account, String passwd, String phone, String job, int mgrid, int rid) {
		
		return this.MgrDao.addEmp(name, account, passwd, phone, job, mgrid, rid);
	}
	@Override
	public String updateEmp(int id, int rid) {
		return this.MgrDao.updateEmp(id, rid);
	}
	@Override
	public String removeEmp(int id) {
		
		return this.MgrDao.removeEmp(id);
	}
	@Override
	public Employee selectEmpById(int id) {
		
		return this.MgrDao.selectEmpById(id);
	}
	@Override
	public List<Employee> findEmpAll() {
		
		return this.MgrDao.findEmpAll();
	}
	@Override
	public String addMenu(String name, double price, int type) {
		
		return this.MgrDao.addMenu(name, price, type);
	}
	@Override
	public String removeMenu(int id) {
		
		return this.MgrDao.removeMenu(id);
	}
	@Override
	public List<Menu> findMenuAll() {
		
		return this.MgrDao.findMenuAll();
	}
	@Override
	public Menu selectMenuById(int id) {
		
		return this.MgrDao.selectMenuById(id);
	}
	@Override
	public String updateMenu(int id, double price) {
		
		return this.MgrDao.updateMenu(id, price);
	}
	@Override
	public List<VIPCard> selectVIPAll() {
		
		return this.MgrDao.selectVIPAll();
	}
	@Override
	public VIPCard selectVIPByPhone(String phone) {
		
		return this.MgrDao.selectVIPByPhone(phone);
	}
	@Override
	public boolean lostCard(String phone) {
		
		return this.MgrDao.lostCard(phone);
	}
	@Override
	public boolean freezeCard(String phone) {
		
		return this.MgrDao.freezeCard(phone);
	}
	@Override
	public int findMAX() {
		return this.MgrDao.findMAX();
	}
	
	
	
}
