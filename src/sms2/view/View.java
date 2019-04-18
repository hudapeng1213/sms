package sms2.view;

import java.util.List;

import sms2.domain.Student;

public class View {
	public void welcome() {
		System.out.println("\t简易学生成绩处理系统");
		System.out.println("==========================");
		System.out.println("1.录入学生成绩  ");
		System.out.println("2.查询学生成绩");
		System.out.println("3.学生成绩排序");
		System.out.println("4.删除学生信息");
		System.out.println("5.退出系统");
		System.out.println("==========================");
	}
	
	public void sortView() {
		System.out.println(">>>学生成绩排序：");
		System.out.println("学生成绩排序");
		System.out.println("--------------------------");
		System.out.println("1.升序");
		System.out.println("2.降序");
		System.out.println("--------------------------");
	}
	
	public void showArray(List<Student> arr) {
		System.out.println("学号\t姓名\t成绩");
		for (Student student : arr) {
			System.out.println(student);
		}
	}

	public void println(String string) {
		System.out.println(string);
		
	}

	
}
