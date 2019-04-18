package sms2.dao.control;
import sms2.biz.StudentBiz;
import sms2.biz.impl.StudentBizImpl;
import sms2.util.UserInput;
import sms2.view.View;
import sms2.domain.*;


public class Control {
	private View v;
	private UserInput uInput;	
	private StudentBiz stuBiz;

	public Control() {
		this.v=new View();
		this.uInput=new UserInput();
		this.stuBiz=new StudentBizImpl();
	}



	public void start() {
		while(true){
			this.v.welcome();
			int select=this.uInput.getInt("请选择：");
			if(select==0){
				this.v.println("系统终止");
			}else if (select==1) {
				String info=this.addStudent();
				this.v.println(info);
			}else if (select==2) {
				this.showStudent();
			}else if (select==3) {
				v.sortView();
				this.sortStudent();
			}else if(select==4){
				this.deleteStudent();
			}else {
				this.v.println("指令有误");
			}
		}
	}



	private void deleteStudent() {
		v.println(">>>学生信息删除");
		Student stu=this.stuBiz.findById(this.uInput.getInt("请输入要删除的学生学号:"));
		if(stu==null){
			this.v.println("学生不存在");
			return ;
		}
		this.v.println("学生信息如下");
		this.v.println(stu.toString());
		
		if(!"y".equals(this.uInput.getString("是否删除（y/n）"))){
			this.v.println("删除学生");
			return;
		}
		String s=this.stuBiz.removeStudent(stu.getId());
		this.v.println(s);
	}



	private void sortStudent() {
		v.showArray(this.stuBiz.sort(uInput.getInt("请选择：")==1));
		
	}



	private void showStudent() {
		v.showArray(this.stuBiz.findAll());
		
	}



	private String addStudent() {
		this.v.println(">>>学生信息录入");
		this.v.println("请输入学生信息");
		int id=this.uInput.getInt("请输入学生学号");
		
		Student stu=this.stuBiz.findById(id);
		if(stu!=null){
			return "学号重复录入";
		}
		String name=uInput.getString("请输入学生姓名");
		double score=uInput.getDouble("请输入学生成绩");
		
		return this.stuBiz.addStudent(id, name, score);
		
	}
}
