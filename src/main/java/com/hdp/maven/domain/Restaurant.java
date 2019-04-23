package com.hdp.maven.domain;

import java.io.Serializable;

public class Restaurant implements Serializable{
	private int rid;
	private String rname;
	private String address;
	public Restaurant(int rid, String rname, String address) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.address = address;
	}
	public Restaurant() {
		super();
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
