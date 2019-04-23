package com.hdp.maven.DB;

import java.sql.Statement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	public DBUtil() {
		try {
			Properties prop1=new Properties();
			prop1.load(new FileInputStream("prop.properties"));
			Class.forName(prop1.getProperty("classname")).newInstance();
			conn=DriverManager.getConnection(prop1.getProperty("url"),prop1.getProperty("username"),prop1.getProperty("password"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//创建增删改的方法
	//1.非预编译，无参数
	public int update(String sql) throws SQLException{
		 stmt= conn.createStatement();
		return stmt.executeUpdate(sql);
	}
	
	//2.预编译 需要参数进行？赋值
	public int update(String sql,Object...arr) throws SQLException{
		pstmt=conn.prepareStatement(sql);
		for(int i=0;i<arr.length;i++){
			pstmt.setObject((i+1), arr[i]);
		}
		return pstmt.executeUpdate();
	}
	
	//创建查询的方法
	//非预编译
	public ResultSet query(String sql) throws SQLException{
		stmt=conn.createStatement();
		return stmt.executeQuery(sql);
	} 
	//预编译
	public ResultSet query(String sql,Object...arr) throws SQLException{
		pstmt=conn.prepareStatement(sql);
		for(int i=0;i<arr.length;i++){
			pstmt.setObject((i+1), arr[i]);
		}
		return pstmt.executeQuery();
	}
	
	//创建一个关闭资源的方法
	public void closed(){
		try {
			if(pstmt!=null&&!pstmt.isClosed())pstmt.close();
			if(stmt!=null&&!stmt.isClosed())stmt.close();
			if(conn!=null&&!conn.isClosed())conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
