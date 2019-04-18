package sms2.util;

import java.util.Scanner;

	public class UserInput {
//	接受用户输入
	public String getString(String msg) {
		System.out.println(msg);
		Scanner sc=new Scanner(System.in);
		return sc.next();
	}
	
	//接收整数
	public int  getInt(String msg) {
		while(true){
			try {
				System.out.println(msg);
				Scanner sc=new Scanner(System.in);
				return sc.nextInt();
			} catch (Exception e) {
				System.out.println("输入内容格式不正确，请输入整数类型！");
			}
		}
	}
	
	//接收小数
		public double  getDouble(String msg) {
			while(true){
				try {
					System.out.println(msg);
					Scanner sc=new Scanner(System.in);
					return sc.nextDouble();
				} catch (Exception e) {
					System.out.println("输入内容格式不正确，请输入浮点类型！");
				}
			}
		}
}
