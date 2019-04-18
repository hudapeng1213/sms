package sms2.test;

import org.junit.Test;

import sms2.biz.StudentBiz;
import sms2.biz.impl.StudentBizImpl;

public class Mytest {
	@Test
	public void add(){
		StudentBiz sb=new StudentBizImpl();
		String mString=sb.addStudent(10, "李浩明", 87);
		System.out.println(mString);
	}
}
