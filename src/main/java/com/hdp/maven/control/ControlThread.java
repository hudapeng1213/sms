package com.hdp.maven.control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

public class ControlThread implements Runnable {
	private Socket client;
	private Object o;
	public ControlThread(Socket client, Object o) {
		super();
		this.client = client;
		this.o = o;
	}
	
	public void run() {
		try {
			ObjectInputStream ois=new ObjectInputStream(client.getInputStream());
			String methodNum=ois.readUTF();
			Class<?>[] methodType=(Class<?>[])ois.readObject();
			Object[] methodParams=(Object[])ois.readObject();
			Method method=o.getClass().getMethod(methodNum, methodType);
			Object result = method.invoke(o, methodParams);
			ObjectOutputStream oos=new ObjectOutputStream(client.getOutputStream());
			oos.writeObject(result);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
