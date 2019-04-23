package com.hdp.maven.control;



public class Control {
	private flowControl flowControl;
	public Control() {
		this.flowControl=new flowControl();
	}
	
	public void start() {
		flowControl.Login();
	}
	
}
