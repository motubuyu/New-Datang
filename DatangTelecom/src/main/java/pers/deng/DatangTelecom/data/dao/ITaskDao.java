package pers.deng.DatangTelecom.data.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import pers.deng.DatangTelecom.data.bean.Employee;
import pers.deng.DatangTelecom.data.bean.Plan;
import pers.deng.DatangTelecom.data.bean.Task;
import pers.deng.DatangTelecom.data.util.DBUtil;

public interface ITaskDao {
	
	/**
	 * �������ܲ�ѯ��Ա������������
	 */
	public int queryTaskCountByEmpId(Employee emp);
	/**
	 * ����Ա����ѯ������Ϊ�����Ƶ�����
	 * @param emp
	 * @return
	 */
	public List<Task> queryAllTaskByEmpId(Employee emp,int pageNo,int pageSize);
	
	/*
	 * ���������Ų�ѯ�ƻ�����
	 */
	
	public int GroupQueryPlanCountByTaskId(Task task,Plan plan);
	public int queryPlanCountByTaskId(Task task);
	/**
	 * ��ѯ�����µ����мƻ�
	 */
	public List<Plan> queryPlanByTaskId(Task task,int pageNo,int pageSize);
	
	/**
	 * ���������Ų�ѯ����
	 */
	public Task queryTaskById(Task task);
	
	
	
	
	/**
	 * �����ƶ��˲���������
	 */
	public int queryTaskCountByAssigner(Task task);
	
	/**
	 * �����ƶ��˲�ѯ����
	 */
	public List<Task> queryTaskByAssigner(Task task,int pageNo,int pageSize);
	
	/**
	 * �½�����
	 */
	public int managerNewTask(Task task);
	/**
	 * ���ݱ��ɾ������
	 */
	public int managerDeleteTask(String[] taskids);
	
	/**
	 * ������޸�����
	 */
	public int managerUpdateTaskbyId(Task task);
	
	/**
	 * �޸�����״̬
	 */
	
	public int managerUpdateTaskStatus(Task task);
}
