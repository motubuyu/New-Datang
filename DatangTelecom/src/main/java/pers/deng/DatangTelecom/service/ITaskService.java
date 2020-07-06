package pers.deng.DatangTelecom.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pers.deng.DatangTelecom.data.bean.Employee;
import pers.deng.DatangTelecom.data.bean.Plan;
import pers.deng.DatangTelecom.data.bean.Task;


public interface ITaskService {

	
	
	public int queryTaskCountByEmpId(Employee emp);
	/**
	 * 用于返回主管为员工制定的任务
	 * @param emp
	 * @return
	 */
	public List<Task> returnQueryTaskByEmpId(Employee emp,int pageNo,int pageSize);
	
	
	
	public int GroupQueryueryPlanCountByTaskId(Task task,Plan plan);
	
	public int queryPlanCountByTaskId(Task task);
	
	/**
	 * 用于返回任务下所有计划
	 */
	public List<Plan> returnPlanByTaskId(Task task,int pageNo,int pageSize);
	
	
	/**
	 * 用于返回按编号查询的任务
	 */
	public Task returnQueryTaskById(Task task);
	
	/**
	 * 返回制定人任务总数
	 */
	public int returnQueryTaskCountByAssigner(Task task);
	
	/**
	 * 用于返回制定人的所有任务
	 */
	public List<Task> returnQueryTaskByAssigner(Task task,int pageNo,int pageSize);
	
	/**
	 * 用于返回新建任务的结果
	 */
	public int returnManagerNewTask(Task task);
	
	/**
	 * 用于返回批量删除任务的结果
	 */
	
	public int returnManagerDeleteTask(String[] taskids);
	
	/**
	 * 根据id改任务
	 */
	public int returnManagerUpdateTaskByid(Task task);
	
	/**
	 * 主管修改任务状态
	 */
	public int returnManagerUpdateStatus(Task task);
}
