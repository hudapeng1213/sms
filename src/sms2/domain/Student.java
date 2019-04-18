package sms2.domain;

public class Student {
	private int id;
	private String name;
	private double score;
	public Student(int id, String name, double score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}
	public Student() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return id+"\t"+name+"\t"+score;
	
	}
	
	public String show(){
		return id+"#"+name+"#"+score;
	}
	
}
