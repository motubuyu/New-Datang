package pers.deng.DatangTelecom.data.dao.Impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pers.deng.DatangTelecom.data.bean.Plan;
import pers.deng.DatangTelecom.data.bean.Task;
import pers.deng.DatangTelecom.data.dao.IPlanDao;

import java.util.List;
@Repository("planDao")
public class PlanDaoImpl implements IPlanDao {
    @Override
    public int deletePlanById(Plan plan) {
        return 0;
    }

    @Override
    public int insertPlan(Plan plan) {
        return 0;
    }

    @Override
    public List<Plan> queryPlanByTaskIdByEmpId(Task task, Plan plan, int pageNo, int pageSize) {
        return null;
    }

    @Override
    public Plan queryPlanByPlanId(Plan plan) {
        return null;
    }

    @Override
    public int updatePlanStateByPlanId(Plan plan) {
        return 0;
    }
}
