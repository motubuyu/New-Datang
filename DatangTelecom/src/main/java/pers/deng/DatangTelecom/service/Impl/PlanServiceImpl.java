package pers.deng.DatangTelecom.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.deng.DatangTelecom.data.bean.Plan;
import pers.deng.DatangTelecom.data.bean.Task;
import pers.deng.DatangTelecom.data.dao.IPlanDao;
import pers.deng.DatangTelecom.service.IPlanService;
@Service("planService")
public class PlanServiceImpl implements IPlanService {
	@Resource(name="planDao")
	IPlanDao planDao;
	@Override
	public int returnDeletePlanById(Plan plan) {
		return planDao.deletePlanById(plan);
	}
	@Override
	public int returnInsertPlan(Plan plan) {
		return planDao.insertPlan(plan);
	}
	@Override
	public List<Plan> returnQueryPlanByTaskIdByEmpId(Task task,Plan plan,int pageNo,int pageSize) {
		return planDao.queryPlanByTaskIdByEmpId(task,plan,pageNo,pageSize);
	}
	@Override
	public Plan returnQueryPlanByPlanId(Plan plan) {
		return planDao.queryPlanByPlanId(plan);
	}
	@Override
	public int returnUpdatePlanStateByPlanId(Plan plan) {
		// TODO Auto-generated method stub
		return planDao.updatePlanStateByPlanId(plan);
	}

}
