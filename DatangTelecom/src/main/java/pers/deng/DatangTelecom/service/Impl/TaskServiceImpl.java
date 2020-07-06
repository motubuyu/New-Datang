package pers.deng.DatangTelecom.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.deng.DatangTelecom.data.bean.Employee;
import pers.deng.DatangTelecom.data.bean.Plan;
import pers.deng.DatangTelecom.data.bean.Task;
import pers.deng.DatangTelecom.data.dao.ITaskDao;
import pers.deng.DatangTelecom.data.dao.Impl.TaskDaoImpl;
import pers.deng.DatangTelecom.service.ITaskService;

@Service("taskServ")
public class TaskServiceImpl implements ITaskService {
	
	@Resource(name="taskDao")
	ITaskDao taskDao=new TaskDaoImpl();
	
	@Override
	public List<Task> returnQueryTaskByEmpId(Employee emp,int pageNo,int pageSize) {
		return taskDao.queryAllTaskByEmpId(emp,pageNo,pageSize);
	}
	@Override
	public int queryPlanCountByTaskId(Task task) {
		return taskDao.queryPlanCountByTaskId(task);
	}
	@Override
	public List<Plan> returnPlanByTaskId(Task task,int pageNo,int pageSize) {
		return taskDao.queryPlanByTaskId(task,pageNo,pageSize);
	}

	@Override
	public Task returnQueryTaskById(Task task) {
		
		return taskDao.queryTaskById(task);
	}
	@Override
	public int returnQueryTaskCountByAssigner(Task task) {
		
		return taskDao.queryTaskCountByAssigner(task);
	}
	@Override
	public List<Task> returnQueryTaskByAssigner(Task task,int pageNo,int pageSize) {
		return taskDao.queryTaskByAssigner(task,pageNo,pageSize);
	}

	@Override
	public int returnManagerNewTask(Task task) {
		return taskDao.managerNewTask(task);
	}

	@Override
	public int returnManagerDeleteTask(String[] taskids) {
		return taskDao.managerDeleteTask(taskids);
	}

	@Override
	public int returnManagerUpdateTaskByid(Task task) {
		// TODO Auto-generated method stub
		return taskDao.managerUpdateTaskbyId(task);
	}

	@Override
	public int returnManagerUpdateStatus(Task task) {
		return taskDao.managerUpdateTaskStatus(task);
	}
	@Override
	public int queryTaskCountByEmpId(Employee emp) {
		// TODO Auto-generated method stub
		return taskDao.queryTaskCountByEmpId(emp);
	}
	@Override
	public int GroupQueryueryPlanCountByTaskId(Task task, Plan plan) {
		
		return taskDao.GroupQueryPlanCountByTaskId(task, plan);
	}
	
	

	

	
	
	

}
