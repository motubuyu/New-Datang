package pers.deng.DatangTelecom.service;

import java.util.List;

import pers.deng.DatangTelecom.data.bean.Plan;
import pers.deng.DatangTelecom.data.bean.Task;



public interface IPlanService {

	
	/**
	 * 用于返回按编号删除计划的结果
	 */
	public int returnDeletePlanById(Plan plan);
	
	/**
	 * 用于添加计划
	 */
	public int returnInsertPlan(Plan plan);
	
	/**
	 * 用于返回根据实施人查询的所有计划
	 */
	public List<Plan>returnQueryPlanByTaskIdByEmpId(Task task,Plan plan,int pageNo,int pageSize);
	
	/**
	 * 返回按计划编号查询的计划
	 */
	public Plan returnQueryPlanByPlanId(Plan plan);
	/**
	 * 返回修改计划状态的结果
	 */
	public int returnUpdatePlanStateByPlanId(Plan plan);
}
