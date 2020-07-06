package pers.deng.DatangTelecom.data.dao;

import java.util.List;

import pers.deng.DatangTelecom.data.bean.Employee;
import pers.deng.DatangTelecom.data.bean.Plan;
import pers.deng.DatangTelecom.data.bean.Task;

public interface IPlanDao {

	
	/**
	 * ���ݼƻ����ɾ���ƻ�
	 */
	public int deletePlanById(Plan plan);
	
	/**
	 * ����ƻ�
	 */
	public int insertPlan(Plan plan);
	
	/**
	 *����ʵʩ�˲�ѯ�����ٸ��������Ų�ѯ���мƻ�
	 */
	public List<Plan>queryPlanByTaskIdByEmpId(Task task,Plan plan,int pageNo,int pageSize);
	
	/**
	 * ���ݼƻ���Ų�ѯ�ƻ�
	 */
	public Plan queryPlanByPlanId(Plan plan);
	
	/**
	 * ���ݼƻ�����޸ļƻ�״̬
	 */
	public int updatePlanStateByPlanId(Plan plan);
}
