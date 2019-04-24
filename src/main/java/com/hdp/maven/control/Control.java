package com.hdp.maven.control;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import com.hdp.maven.biz.yahuiService;
import com.hdp.maven.biz.impl.yahuiServiceImpl;

public class Control {
	private ServerSocket server;
	public static final int port=9999;
	//创建线程池变量
	private ExecutorService es;
	//创建代理对象
	private yahuiService service;
	public Control() {
		try {
			System.out.println("服务器正在开启......");
			this.server=new ServerSocket(port);
			Thread.sleep(1000);
			System.out.println("服务器已经开启");
			/*list=new ArrayList<ControlThread>();
			watch=new ThreadWatch(list);
			watch.start();*/
			es=Executors.newCachedThreadPool();
			this.service=new yahuiServiceImpl();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void start() {
		while(true){
			try {
				//等待用户连接
				Socket client=this.server.accept();
				System.out.println("用户"+client.getInetAddress().getHostAddress()+"已连接");
				//创建线程对象 
				ControlThread ct=new ControlThread(client,service);
				//将线程交给线程池管理
				es.submit(ct);
				//返回现在处于活跃状态的线程数量
				int activeCount=((ThreadPoolExecutor)es).getActiveCount();
				System.out.println("当前活跃用户数："+activeCount);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}