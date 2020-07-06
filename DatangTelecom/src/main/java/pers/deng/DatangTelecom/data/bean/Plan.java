package pers.deng.DatangTelecom.data.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Plan {
	private int plan_Id;		//�ƻ���ţ���������
	private String plan_Name;	//�ƻ�����
	private String status;		//�ƻ�״̬
	private String is_Feedback;	//�Ƿ���
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date begin_Date;			//��ʼʱ��
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date begin_Date1;			//��ʼʱ��
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date end_Date;			//����ʱ��
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date end_Date1;			//����ʱ��
	private int task_Id;	//�����������������������
	private String feedback_Info;	//������Ϣ
	private String plan_Desc;		//�ƻ�����
	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Plan(int plan_Id, String plan_Name, String status,
			String is_Feedback, Date begin_Date, Date begin_Date1,
			Date end_Date, Date end_Date1, int task_Id, String feedback_Info,
			String plan_Desc) {
		super();
		this.plan_Id = plan_Id;
		this.plan_Name = plan_Name;
		this.status = status;
		this.is_Feedback = is_Feedback;
		this.begin_Date = begin_Date;
		this.begin_Date1 = begin_Date1;
		this.end_Date = end_Date;
		this.end_Date1 = end_Date1;
		this.task_Id = task_Id;
		this.feedback_Info = feedback_Info;
		this.plan_Desc = plan_Desc;
	}
	public int getPlan_Id() {
		return plan_Id;
	}
	public void setPlan_Id(int plan_Id) {
		this.plan_Id = plan_Id;
	}
	public String getPlan_Name() {
		return plan_Name;
	}
	public void setPlan_Name(String plan_Name) {
		this.plan_Name = plan_Name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIs_Feedback() {
		return is_Feedback;
	}
	public void setIs_Feedback(String is_Feedback) {
		this.is_Feedback = is_Feedback;
	}
	public Date getBegin_Date() {
		return begin_Date;
	}
	public void setBegin_Date(Date begin_Date) {
		this.begin_Date = begin_Date;
	}
	public Date getBegin_Date1() {
		return begin_Date1;
	}
	public void setBegin_Date1(Date begin_Date1) {
		this.begin_Date1 = begin_Date1;
	}
	public Date getEnd_Date() {
		return end_Date;
	}
	public void setEnd_Date(Date end_Date) {
		this.end_Date = end_Date;
	}
	public Date getEnd_Date1() {
		return end_Date1;
	}
	public void setEnd_Date1(Date end_Date1) {
		this.end_Date1 = end_Date1;
	}
	public int getTask_Id() {
		return task_Id;
	}
	public void setTask_Id(int task_Id) {
		this.task_Id = task_Id;
	}
	public String getFeedback_Info() {
		return feedback_Info;
	}
	public void setFeedback_Info(String feedback_Info) {
		this.feedback_Info = feedback_Info;
	}
	public String getPlan_Desc() {
		return plan_Desc;
	}
	public void setPlan_Desc(String plan_Desc) {
		this.plan_Desc = plan_Desc;
	}
	
	
	
	
	
}
