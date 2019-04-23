package com.hdp.maven.domain;

import java.io.Serializable;

public class Employee implements Serializable{
	//创建员工实体类
	private int eid;
	private String ename;
	private String account;
	private String password;
	private String job;
	private int mgid;
	private String  phone;
	private int rid;
	public Employee(int eid, String ename, String account, String password, String job, int mgid, String phone, int rid) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.account = account;
		this.password = password;
		this.job = job;
		this.mgid = mgid;
		this.phone = phone;
		this.rid = rid;
	}
	public Employee() {
		super();
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgid() {
		return mgid;
	}
	public void setMgid(int mgid) {
		this.mgid = mgid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	
}
