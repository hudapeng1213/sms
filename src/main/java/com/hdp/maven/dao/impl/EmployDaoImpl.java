package com.hdp.maven.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hdp.maven.DB.DBUtil;
import com.hdp.maven.dao.EmployeeDao;
import com.hdp.maven.domain.Employee;
import com.hdp.maven.domain.Menu;
import com.hdp.maven.domain.Restaurant;
import com.hdp.maven.domain.VIPCard;


public class EmployDaoImpl implements EmployeeDao {
	//创建数据库对象 
	private DBUtil db;
	public Employee selectLogin(String account, String password) {
		// 实例化数据库对象
		db=new DBUtil();
		//在数据库中查找当前员工信息
		String sql="select * from emp where estate=1 and eaccount=? and epasswd=?";
		try {
			ResultSet rs = this.db.query(sql,account,password);
			if(rs.next()){
				//返回查找到的信息
				return new Employee(rs.getInt("eid"), rs.getString("ename"), rs.getString("eaccount"), rs.getString("epasswd"), rs.getString("job"), rs.getInt("mgr"), rs.getString("ephone"), rs.getInt("rid"));
			}
		} catch (SQLException e) {
			System.out.println("当前用户不存在");
			e.printStackTrace();
		}finally {
			db.closed();
		}
		return null;
	}
	//通过菜单的类型进行查找
	public List<Menu> selectByType(int type) {
		//初始化返回数组
		List<Menu> list=new ArrayList<Menu>();
		//初始化数据库对象
		db=new DBUtil();
		//通过类型进行查找
		String sql="select * from menu where mstate=1 and mtype=?";
		//获取查询的结果
		try {
			ResultSet rs = this.db.query(sql,type);
			while(rs.next()){
				//将查询到的结果保存到list
				list.add(new Menu(rs.getInt("mid"), rs.getString("mname"), rs.getDouble("mprice")));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closed();
		}
		return null;
	}

	public Menu selectByMid(int id) {
		//初始化数据库对象
		db=new DBUtil();
		//查询指定的菜品
		String sql="select * from menu where mstate=1 and mid=?";
		try {
			//获取查询对象
			ResultSet rs = this.db.query(sql,id);
			//返回获取的菜品
			if(rs.next()){
				return new Menu(rs.getInt("mid"),rs.getString("mname"),rs.getDouble("mprice"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insertOrder() {
		
		
	}

	public boolean insertCard(String name, String  phone, double money, int type,double discount) {
		//初始化数据库对象
		db=new DBUtil();
		String sql="insert into vip(vipname,vipphone,vipmoney,viptype,vipdiscount) values(?,?,?,?,?)";
		try {
			int i = this.db.update(sql, name,phone,money,type,discount);
			return i>0;
		} catch (SQLException e) {
			System.out.println("插入失败");
			e.printStackTrace();
			return false;
		}finally {
			db.closed();
		}
		
	}
	public VIPCard selectCardById(int id) {
		//初始化数据库对象
		db=new DBUtil();
		String sql="select * from vip where vipid="+id;
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				//返回查询的会员卡信息
				return new VIPCard(rs.getInt("vipid"), rs.getString("vipname"), rs.getString("vipphone"), rs.getDouble("vipmoney"), rs.getDouble("vipdiscount"), rs.getInt("vipstate"), rs.getInt("viptype"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.closed();
		}
		return null;
	}
	
	@Override
	public VIPCard selectCardByName(String name, String phone) {
		db=new DBUtil();
		String sql="select * from vip where vipname=? and vipphone=?";
		try {
			ResultSet rs = this.db.query(sql,name,phone);
			if(rs.next()){
				//返回查询的会员卡信息
				return new VIPCard(rs.getInt("vipid"), rs.getString("vipname"), rs.getString("vipphone"), rs.getDouble("vipmoney"), rs.getDouble("vipdiscount"), rs.getInt("vipstate"), rs.getInt("viptype"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			db.closed();
		}
		return null;
	}
	
	public boolean updatemoney(int id,double money) {
		db=new DBUtil();
		String sql="update vip set vipmoney=? where vipid="+id;
		try {
			int i = this.db.update(sql,money);
			return i>0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			db.closed();
		}
		
	}

	public boolean updateState(int id,int state) {
		db=new DBUtil();
		String sql="update vip set vipstate=? where vipid="+id;
		try {
			int i = this.db.update(sql,state);
			return i>0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			db.closed();
		}
	}
	//获取当前登录的员工工作
	public String selectJobByLogin(Employee e) {
		db=new DBUtil();
		String sql="select job from emp where eid="+e.getEid();
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				return rs.getString("job");
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}finally {
			db.closed();
		}
		return null;
	}
	@Override
	public Restaurant selectByEid(int id) {
		db=new DBUtil();
		String sql="select * from restaurant where restaurant.rid=(select rid from emp where eid=?)";
		try {
			ResultSet rs = this.db.query(sql,id);
			if(rs.next()){
				return new Restaurant(rs.getInt("rid"), rs.getString("rname"), rs.getString("rplace"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean insertOrder(String uuid, Date time, int eid, int vipid, int rid) {
		db=new DBUtil();
		String sql="insert into myorder(ouuid,odate,eid,vipid,rid) values(?,?,?,?,?)";
		try {
			int i = this.db.update(sql, uuid,time,eid,vipid,rid);
			return i>0;
		} catch (SQLException e) {
			return false;
		}
		
	}
	@Override
	public boolean insertDetails(int count, int oid, int mid) {
		db=new DBUtil();
		String sql="insert into details(damount,oid,mid) values(?,?,?)";
		try {
			int i = this.db.update(sql, count,oid,mid);
			return i>0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public int selectOrderByuuid(String uuid) {
		db=new DBUtil();
		String sql="select oid from myorder where ouuid=?";
		try {
			ResultSet rs = this.db.query(sql, uuid);
			if(rs.next()){
				return  rs.getInt("oid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int selectMenuByMname(String name) {
		db=new DBUtil();
		String sql="select mid from menu where mname=?";
		try {
			ResultSet rs = this.db.query(sql, name);
			if(rs.next()){
				return rs.getInt("mid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
