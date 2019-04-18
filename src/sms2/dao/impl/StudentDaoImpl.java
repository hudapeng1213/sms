package sms2.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import sms2.dao.StudentDao;
import sms2.domain.Student;


public class StudentDaoImpl implements StudentDao {
	private BufferedReader in;
	private PrintWriter out;
	public static final String URL="data/student.txt";
	@Override
	public boolean insertStudent(Student stu) {
		try {
			out=new PrintWriter(new OutputStreamWriter(new FileOutputStream(URL,true),"UTF-8"));
			out.println(stu.show());
			out.flush();
			return true;
		} catch (UnsupportedEncodingException e) {
			return false;
		} catch (FileNotFoundException e) {
			return false;
		}finally {
			if(out!=null)out.close();
		}
		
		
	}

	@Override
	public List<Student> selsectAllStudent() {
		List<Student> list=new ArrayList<Student>();
		
		try {
			in=new BufferedReader(new InputStreamReader(new FileInputStream(URL), "UTF-8"));
			
			String s="";
			try {
				while((s=in.readLine())!=null){
					String[] arr = s.split("#");
					list.add(new Student(Integer.parseInt(arr[0]),arr[1],Double.parseDouble(arr[2])));
				}
				return list;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					if(in!=null)in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return null;
	}

	@Override
	public Student selectById(int id) {
		List<Student> list=selsectAllStudent();
		for (Student student : list) {
			if(id==student.getId()){
				return student;
			}
		}
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		List<Student> list=selsectAllStudent();
		Iterator<Student> it = list.iterator();
		while(it.hasNext()){
			Student s=it.next();
			if(id==s.getId()){
				it.remove();
			}
		}
		
		File file=new File(URL);
		if(file.exists()){
			file.delete();
		}
		
		for (Student student : list) {
			insertStudent(student);
		}
		return true;
	}

}
