package pers.deng.DatangTelecom.data.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import pers.deng.DatangTelecom.data.bean.Employee;
import pers.deng.DatangTelecom.data.bean.Plan;
import pers.deng.DatangTelecom.data.bean.Task;
import pers.deng.DatangTelecom.data.util.DBUtil;

public interface ITaskDao {
	
	/**
	 * 根据主管查询与员工的任务总数
	 */
	public int queryTaskCountByEmpId(Employee emp);
	/**
	 * 根据员工查询其主管为他定制的任务
	 * @param emp
	 * @return
	 */
	public List<Task> queryAllTaskByEmpId(Employee emp,int pageNo,int pageSize);
	
	/*
	 * 根据任务编号查询计划总数
	 */
	
	public int GroupQueryPlanCountByTaskId(Task task,Plan plan);
	public int queryPlanCountByTaskId(Task task);
	/**
	 * 查询任务下的所有计划
	 */
	public List<Plan> queryPlanByTaskId(Task task,int pageNo,int pageSize);
	
	/**
	 * 根据任务编号查询任务
	 */
	public Task queryTaskById(Task task);
	
	
	
	
	/**
	 * 根据制定人查任务总数
	 */
	public int queryTaskCountByAssigner(Task task);
	
	/**
	 * 根据制定人查询任务
	 */
	public List<Task> queryTaskByAssigner(Task task,int pageNo,int pageSize);
	
	/**
	 * 新建任务
	 */
	public int managerNewTask(Task task);
	/**
	 * 根据编号删除任务
	 */
	public int managerDeleteTask(String[] taskids);
	
	/**
	 * 按编号修改任务
	 */
	public int managerUpdateTaskbyId(Task task);
	
	/**
	 * 修改任务状态
	 */
	
	public int managerUpdateTaskStatus(Task task);
}
