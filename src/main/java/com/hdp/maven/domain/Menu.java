package com.hdp.maven.domain;

import java.io.Serializable;

public class Menu implements Serializable{
	private int mid;
	private String mname;
	private double price;
	private int type;
	public Menu(int mid, String mname, double price) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.price = price;
	}
	public Menu() {
		super();
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return mid + "\t\t" + mname + "\t\t" + price;
	}
	
	
}
