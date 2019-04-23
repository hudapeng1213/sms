package com.hdp.maven.domain;

import java.io.Serializable;

public class ShopCart implements Serializable{
	private String sname;
	private int scount;
	private double sprice;
	public ShopCart(String sname, int scount , double sprice) {
		super();
		this.sname = sname;
		this.scount = scount;
		this.sprice = sprice;
	}
	public ShopCart() {
		super();
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getScount() {
		return scount;
	}
	public void setScount(int scount) {
		this.scount = scount;
	}
	public double getSprice() {
		return sprice;
	}
	public void setSprice(double sprice) {
		this.sprice = sprice;
	}
	@Override
	public String toString() {
		return sname + "\t\t" + scount + "\t\t" + sprice;
	}
	
	
}
