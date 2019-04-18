package sms2.biz;

import java.util.List;

import sms2.domain.Student;

public interface StudentBiz {
//	添加学生的业务
	public String addStudent(int id,String name,double score);
//	查询学生的业务
	public List<Student> findAll();
//	排序查询
	public List<Student> sort(boolean b);
//	根据id查询学生
	public Student findById(int id);
//	删除学生的业务
	public String removeStudent(int id);
}
