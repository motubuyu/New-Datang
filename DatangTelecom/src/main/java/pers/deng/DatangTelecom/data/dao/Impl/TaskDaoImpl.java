package pers.deng.DatangTelecom.data.dao.Impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pers.deng.DatangTelecom.data.bean.Employee;
import pers.deng.DatangTelecom.data.bean.Plan;
import pers.deng.DatangTelecom.data.bean.Task;
import pers.deng.DatangTelecom.data.dao.ITaskDao;

import java.util.List;
@Repository("taskDao")
public class TaskDaoImpl implements ITaskDao {
    @Override
    public int queryTaskCountByEmpId(Employee emp) {
        return 0;
    }

    @Override
    public List<Task> queryAllTaskByEmpId(Employee emp, int pageNo, int pageSize) {
        return null;
    }

    @Override
    public int GroupQueryPlanCountByTaskId(Task task, Plan plan) {
        return 0;
    }

    @Override
    public int queryPlanCountByTaskId(Task task) {
        return 0;
    }

    @Override
    public List<Plan> queryPlanByTaskId(Task task, int pageNo, int pageSize) {
        return null;
    }

    @Override
    public Task queryTaskById(Task task) {
        return null;
    }

    @Override
    public int queryTaskCountByAssigner(Task task) {
        return 0;
    }

    @Override
    public List<Task> queryTaskByAssigner(Task task, int pageNo, int pageSize) {
        return null;
    }

    @Override
    public int managerNewTask(Task task) {
        return 0;
    }

    @Override
    public int managerDeleteTask(String[] taskids) {
        return 0;
    }

    @Override
    public int managerUpdateTaskbyId(Task task) {
        return 0;
    }

    @Override
    public int managerUpdateTaskStatus(Task task) {
        return 0;
    }
}
