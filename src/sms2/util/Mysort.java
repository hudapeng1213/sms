package sms2.util;

import java.util.Comparator;

import sms2.domain.Student;

public class Mysort implements Comparator<Student>{
	private boolean flag;

	public Mysort(boolean flag) {
		super();
		this.flag = flag;
	}

	@Override
	public int compare(Student o1, Student o2) {
		if(flag){
			if(o1.getScore()>o2.getScore()){
				return 1;
			}else if (o1.getScore()<o2.getScore()) {
				return -1;
			}
		}else {
			if(o1.getScore()>o2.getScore()){
				return -1;
			}else if (o1.getScore()<o2.getScore()) {
				return 1;
			}
		}
		return 0;
	}
	
	
}
