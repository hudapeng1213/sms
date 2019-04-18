package sms2.biz.impl;

import java.util.Collections;
import java.util.List;

import sms2.biz.StudentBiz;
import sms2.dao.StudentDao;
import sms2.dao.impl.StudentDaoImpl;
import sms2.domain.Student;
import sms2.util.Mysort;

public class StudentBizImpl implements StudentBiz {
	private StudentDao stuDao;
	
	public StudentBizImpl() {
		super();
		this.stuDao = new StudentDaoImpl();
	}

	@Override
	public String addStudent(int id, String name, double score) {
		
		return this.stuDao.insertStudent(new Student(id,name,score))?"添加成功！":"添加失败！";
		
	}

	@Override
	public List<Student> findAll() {
		
		return this.stuDao.selsectAllStudent();
	}

	@Override
	public List<Student> sort(boolean b) {
		//查询所有学生
		List<Student> list=this.stuDao.selsectAllStudent();
		//进行排序
		Collections.sort(list,new Mysort(b));
		return list;
	}

	@Override
	public Student findById(int id) {
		
		return this.stuDao.selectById(id);
	}

	@Override
	public String removeStudent(int id) {
		
		return this.stuDao.deleteById(id)?"删除成功！":"删除失败！";
	}

}
