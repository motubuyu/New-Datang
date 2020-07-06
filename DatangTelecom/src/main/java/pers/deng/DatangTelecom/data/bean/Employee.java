package pers.deng.DatangTelecom.data.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
	  private int employee_Id;   //Ա����ţ���������
	  private String  employee_Name; //�û����ƣ�
	  private String password ;    //���룬
	  private String real_Name;   //��ʵ������
	  private String sex;   //�Ա�
	  @DateTimeFormat(pattern="yyyy-MM-dd")
	  private Date birthday;        //��������
	  private String duty;   //ְλ��Ϣ
	  @DateTimeFormat(pattern="yyyy-MM-dd")
	  private Date enrolldate;  //��ְʱ��
	  private String education;    //ѧ����Ϣ
	  private String  major;		//רҵ��Ϣ
	  private String  experience;		//��ҵ����
	  private Role role;	//�����������ɫ�����ý�ɫ���
	  private int parent_Id;//��������ܣ�����Ա�����
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employee(int employee_Id, String employee_Name, String password,
			String real_Name, String sex, Date birthday, String duty,
			Date enrolldate, String education, String major, String experience,
			Role role, int parent_Id) {
		super();
		this.employee_Id = employee_Id;
		this.employee_Name = employee_Name;
		this.password = password;
		this.real_Name = real_Name;
		this.sex = sex;
		this.birthday = birthday;
		this.duty = duty;
		this.enrolldate = enrolldate;
		this.education = education;
		this.major = major;
		this.experience = experience;
		this.role = role;
		this.parent_Id = parent_Id;
	}



	public int getEmployee_Id() {
		return employee_Id;
	}



	public void setEmployee_Id(int employee_Id) {
		this.employee_Id = employee_Id;
	}



	public String getEmployee_Name() {
		return employee_Name;
	}



	public void setEmployee_Name(String employee_Name) {
		this.employee_Name = employee_Name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getReal_Name() {
		return real_Name;
	}



	public void setReal_Name(String real_Name) {
		this.real_Name = real_Name;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	public String getDuty() {
		return duty;
	}



	public void setDuty(String duty) {
		this.duty = duty;
	}



	public Date getEnrolldate() {
		return enrolldate;
	}



	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}



	public String getEducation() {
		return education;
	}



	public void setEducation(String education) {
		this.education = education;
	}



	public String getMajor() {
		return major;
	}



	public void setMajor(String major) {
		this.major = major;
	}



	public String getExperience() {
		return experience;
	}



	public void setExperience(String experience) {
		this.experience = experience;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public int getParent_Id() {
		return parent_Id;
	}



	public void setParent_Id(int parent_Id) {
		this.parent_Id = parent_Id;
	}



	@Override
	public String toString() {
		return "Employee [employee_Id=" + employee_Id + ", employee_Name="
				+ employee_Name + ", password=" + password + ", real_Name="
				+ real_Name + ", sex=" + sex + ", birthday=" + birthday
				+ ", duty=" + duty + ", enrolldate=" + enrolldate
				+ ", education=" + education + ", major=" + major
				+ ", experience=" + experience + ", role=" + role
				+ ", parent_Id=" + parent_Id + "]";
	}

	

	
	
	
	
	
}
