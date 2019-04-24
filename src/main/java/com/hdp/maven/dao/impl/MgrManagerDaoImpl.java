package com.hdp.maven.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hdp.maven.DB.DBUtil;
import com.hdp.maven.dao.MgrManageDao;
import com.hdp.maven.domain.Employee;
import com.hdp.maven.domain.Menu;
import com.hdp.maven.domain.VIPCard;

public class MgrManagerDaoImpl implements MgrManageDao{
	//创建dbutl变量
	private DBUtil db;
	//添加员工信息
	public boolean addEmp(String name,String account,String passwd,String phone,String job,int mgrid,int rid) {
		//实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
		String sql="insert into emp (ename,eaccount,epasswd,ephone,job,mgr,rid) values(?,?,?,?,?,?,?)";
		try {
			int i = this.db.update(sql,name,account,passwd,phone,job,mgrid,rid);
			return i>0;
		} catch (SQLException e1) {

			e1.printStackTrace();
			
		}finally{
			db.closed();
		}
		return false;
	}
	
	//修改员工信息
	public boolean updateEmp(int id,int rid) {
		//实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
		String sql="update emp set rid=? where eid=?";
		try {
			int i = this.db.update(sql,rid,id);
			return i>0;
		} catch (SQLException e1) {
	
			e1.printStackTrace();
			return false;
		}
		
	}
	
	//删除员工信息
	public boolean deleteEmp(int id) {
		//实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
		String sql="update emp set estate=0 where eid="+id;
		try {
			int i = this.db.update(sql);
			return i>0;
		} catch (SQLException e1) {
			
			e1.printStackTrace();
			return false;
		}
	}
	
	//查询员工所有信息
	public List<Employee> selectEmpAll() {
		//创建一个List集合用于存储所有 的员工信息
		List<Employee> list=new ArrayList<Employee>();
		//实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
		String sql="select * from emp";
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				list.add(new Employee(rs.getInt("eid"),
									  rs.getString("ename"),
									  rs.getString("eaccount"),
									  rs.getString("epasswd"),
									  rs.getString("job"),
									  rs.getInt("mgr"),
									  rs.getString("ephone"),
									  rs.getInt("rid")
									 ));
			}
			//返回List集合
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	//查询员工信息，根据id
	public Employee selectEmpById(int id) {
		//实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
		String sql="select * from emp where eid="+id;
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				return new Employee(rs.getInt("eid"),
									rs.getString("ename"),
									rs.getString("eaccount"),
									rs.getString("epasswd"),
									rs.getString("job"),
									rs.getInt("mgr"),
									rs.getString("ephone"),
									rs.getInt("rid")
									);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}
		
		
		
	//添加菜单信息
	public boolean addMenu(String name,double price,int type) {
		//实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
		String sql="insert into menu(mname,mprice,mtype) values(?,?,?)";
		try {
			int i = this.db.update(sql,name,price,type);
			return i>0;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			//System.out.println("出现了错误"+e1.getMessage());
			e1.printStackTrace();
			return false;
		}
	}
	
	//删除菜单信息
	public boolean deleteMenu(int id) {
		//实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
		//String sql="update menu set mstate=0 where mid="+id;
		String sql="update menu set mstate=0 where mid=?";
		try {
			int i = this.db.update(sql,id);
			return i>0;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	
	//查询菜单信息
	public List<Menu> selectMenuAll() {
		//创建一个List集合用于存储所有 的员工信息
		List<Menu> list=new ArrayList<Menu>();
		//实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
		String sql="select * from menu";
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				list.add(new Menu(rs.getInt("mid"),
								  rs.getString("mname"),
								  rs.getDouble("mprice")
								  ));
			}
			//返回List集合
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//查询菜单，根据id
	public Menu selectMenuById(int id) {
		//实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
		String sql="select * from menu where mid="+id;
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				return new Menu(rs.getInt("mid"),
						  rs.getString("mname"),
						  rs.getDouble("mprice")
						  );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public boolean updateMenu(int id,double price) {
		//实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
		String sql="update menu set mprice=? where mid="+id;
		try {
			int i = this.db.update(sql,price);
			return i>0;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
		

	//查询VIP卡的所有信息
	public List<VIPCard> selectVIPAll() {
		//实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
		String sql="select * from vip";
		try {
			ResultSet rs = this.db.query(sql);
			//创建一个list集合用于存储所有的VIP客户信息
			List<VIPCard> list=new ArrayList<VIPCard>();
			while(rs.next()){
				list.add(new VIPCard(rs.getInt("vipid"),
									 rs.getString("vipname"),
									 rs.getString("vipphone"),
									 rs.getDouble("vipmoney"),
									 rs.getDouble("vipdiscont"),
									 rs.getInt("viptype"),
									 rs.getInt("vipstate")
						));
			}
			//返回List集合
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//根据phone查询VIP信息
	public VIPCard selectByPhone(String phone) {
		//实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
		String sql="select * from vip where vipphone="+phone;
		try {
			ResultSet rs = this.db.query(sql);
			while(rs.next()){
				return new VIPCard(rs.getInt("vipid"),
									 rs.getString("vipname"),
									 rs.getString("vipphone"),
									 rs.getDouble("vipmoney"),
									 rs.getDouble("vipdiscount"),
									 rs.getInt("viptype"),
									 rs.getInt("vipstate") 
								);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//补办状态
	public boolean lostCard(String phone) {
		//实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
					/*String sql2="select * from vip where vipphone="+phone;
					String sql="insert into vip values(?)";*/
		String sql="update vip set vipstate=1 where vipphone="+phone;
		try {
			int i=this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//冻结状态
	public boolean freezeCard(String phone) {
		//实例化dbutil对象
		this.db=new DBUtil();
		//创建sql语句
		String sql="update vip set vipstate=3 where vipphone="+phone;
		try {
			int i=this.db.update(sql);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int selectMAX() {
		db=new DBUtil();
		String sql="select mid from (select sum(damount) sum,mid from details group by mid) where sum=(select max(sum) from (select sum(damount) sum,mid from details group by mid))";
		try {
			ResultSet rs = this.db.query(sql);
			if(rs.next()){
				return rs.getInt("mid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 2;
		}
		return 0;
		
	}



	

	
}
