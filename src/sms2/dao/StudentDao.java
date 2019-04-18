package sms2.dao;

import java.util.List;

import sms2.domain.Student;

public interface StudentDao {
	//创建一个添加学生的方法
	public boolean insertStudent(Student stu);
	//创建一个查找所有学生的方法
	public List<Student> selsectAllStudent();
	//创建一个通过id查找学生的方法
	public Student selectById(int id);
//	创建一个删除学生的方法
	public boolean deleteById(int id);
	
}
