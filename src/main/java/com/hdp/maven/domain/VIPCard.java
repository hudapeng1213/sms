package com.hdp.maven.domain;

import java.io.Serializable;

public class VIPCard implements Serializable{
	private int vid;
	private String name;
	private String  vphone;
	private double money;
	private double discount;
	private int state;
	private int type;
	public VIPCard(int vid, String name, String vphone, double money, double discount, int state, int type) {
		super();
		this.vid = vid;
		this.name = name;
		this.vphone = vphone;
		this.money = money;
		this.discount = discount;
		this.state = state;
		this.type = type;
	}
	public VIPCard() {
		super();
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVphone() {
		return vphone;
	}
	public void setVphone(String vphone) {
		this.vphone = vphone;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
