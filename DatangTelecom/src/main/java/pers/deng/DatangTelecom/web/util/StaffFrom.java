package pers.deng.DatangTelecom.web.util;

import java.util.List;

import pers.deng.DatangTelecom.data.bean.Employee;
import pers.deng.DatangTelecom.data.bean.Plan;
import pers.deng.DatangTelecom.data.bean.Task;

public class StaffFrom {
	private Employee emp;//�ڶ������������еķ�����ID��ѯ��������Ϣ
	
	private Task task;//��һ�����ʵʩ�˵�һ������
	
	private List<Plan> plans;//���������������е�����ID��ѯ�����µ����мƻ�
	
	
	
	public StaffFrom() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StaffFrom(Employee emp, Task task, List<Plan> plans) {
		super();
		this.emp = emp;
		this.task = task;
		this.plans = plans;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public List<Plan> getPlans() {
		return plans;
	}
	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}
	
	
	
	
	
	
}
