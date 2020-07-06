package pers.deng.DatangTelecom.data.dao;

import java.util.List;

import pers.deng.DatangTelecom.data.bean.Employee;
import pers.deng.DatangTelecom.data.bean.Plan;
import pers.deng.DatangTelecom.data.bean.Task;

public interface IPlanDao {

	
	/**
	 * 根据计划编号删除计划
	 */
	public int deletePlanById(Plan plan);
	
	/**
	 * 插入计划
	 */
	public int insertPlan(Plan plan);
	
	/**
	 *根据实施人查询任务再根据任务编号查询所有计划
	 */
	public List<Plan>queryPlanByTaskIdByEmpId(Task task,Plan plan,int pageNo,int pageSize);
	
	/**
	 * 根据计划编号查询计划
	 */
	public Plan queryPlanByPlanId(Plan plan);
	
	/**
	 * 根据计划编号修改计划状态
	 */
	public int updatePlanStateByPlanId(Plan plan);
}
