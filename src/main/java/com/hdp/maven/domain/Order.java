package com.hdp.maven.domain;

import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable{
	private int oid;
	private int uuid;
	private int eid;
	private int vid;
	private Date time;
	private int rid;
	private int mid;
	private int count;
	public Order(int oid, int eid, int vid, Date time, int rid) {
		super();
		this.oid = oid;
		this.eid = eid;
		this.vid = vid;
		this.time = time;
		this.rid = rid;
	}
	public Order() {
		super();
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
	
}
