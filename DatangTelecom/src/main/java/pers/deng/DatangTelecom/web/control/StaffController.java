package pers.deng.DatangTelecom.web.control;

import java.awt.Panel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pers.deng.DatangTelecom.data.bean.Employee;
import pers.deng.DatangTelecom.data.bean.Plan;
import pers.deng.DatangTelecom.data.bean.Task;
import pers.deng.DatangTelecom.service.IEmployeeService;
import pers.deng.DatangTelecom.service.IPlanService;
import pers.deng.DatangTelecom.service.Impl.TaskServiceImpl;
import pers.deng.DatangTelecom.web.util.PageBean;
import pers.deng.DatangTelecom.web.util.StaffFrom;

@Controller
public class StaffController {
	
	@Resource(name="taskServ")
	TaskServiceImpl taskServ;
	@Resource(name="empServ")
	IEmployeeService empServ;
	@Resource(name="planService")
	IPlanService planServ;
	
	
	@RequestMapping("queryTaskByEmpId.do")//根据用户查询他对应的任务
	public ModelAndView queryTaskByEmpId(HttpSession session,HttpServletRequest request,@ModelAttribute("emp")Employee emp){
		ModelAndView mv=new ModelAndView();
		
		
		
		String No=request.getParameter("pageNo");
		PageBean<StaffFrom>pb=new PageBean<StaffFrom>();
		int pageNo=1;//页码
		int pageSize=4;//页大小
		if(No!=null){
			pageNo=Integer.parseInt(No);//如果传递了页码
		}
		List<Task>tas=taskServ.returnQueryTaskByEmpId(emp,pageNo,pageSize);//查询对应的任务
		List<StaffFrom> sffs=new ArrayList<StaffFrom>();//任务对应计划
		if(tas.size()>0){
			for (int i = 0; i < tas.size(); i++) {
				StaffFrom sff=new StaffFrom();//页面工具类
				
				sff.setTask(tas.get(i));
				Employee queryDes=new Employee();
				queryDes.setEmployee_Id(tas.get(i).getAssigner_Id());
				Employee designer=empServ.returnAdminQueryByid(queryDes);//根据分配人id查询分配人
				Task task=new Task();
				task.setTask_Id(tas.get(i).getTask_Id());
				List<Plan> plans=taskServ.returnPlanByTaskId(task,pageNo,9999);
				sff.setEmp(designer);
				sff.setPlans(plans);//设置该任务下的所有计划
				sffs.add(sff);
			}
			mv.setViewName("redirect:person/task.jsp");//返回我的任务
		}else{
			session.setAttribute("mess", "该员工没有任务");
			mv.setViewName("redirect:error.jsp");
		}
		pb.setData(sffs);
		pb.setRecordCount(taskServ.queryTaskCountByEmpId(emp));
		pb.setPageNo(pageNo);
		pb.setPageSize(pageSize);
		session.setAttribute("pb", pb);
		
		
		return mv;
	}
	
	@RequestMapping("queryTaskById.do")//根据id查询任务
	public ModelAndView queryTaskById(HttpSession session,HttpServletRequest request,@ModelAttribute("task")Task task){
		ModelAndView mv=new ModelAndView();
		
		String No=request.getParameter("pageNo");
		PageBean<StaffFrom>pb=new PageBean<StaffFrom>();
		int pageNo=1;//页码
		int pageSize=4;//页大小
		if(No!=null){
			pageNo=Integer.parseInt(No);//如果传递了页码
		}
		
		StaffFrom sff=new StaffFrom();
		Task ta=taskServ.returnQueryTaskById(task);
		sff.setTask(ta);//查询对应的任务
		Employee emp=new Employee();
		emp.setEmployee_Id(ta.getImplementor_Id());//设置实施人id
		sff.setEmp(empServ.returnAdminQueryByid(emp));//查询保存实施人
		sff.setPlans(taskServ.returnPlanByTaskId(task,pageNo,pageSize));//查询任务下的所有计划
		mv.setViewName("redirect:person/taskview.jsp");//返回计划管理
		
		pb.setData1(sff);
		pb.setRecordCount(taskServ.queryPlanCountByTaskId(task));
		pb.setPageNo(pageNo);
		pb.setPageSize(pageSize);
		
		session.setAttribute("pb", pb);
		return mv;
	}
	
	
	@RequestMapping("deletePlanById.do")//删除计划
	public ModelAndView deletePlanById(HttpSession session,@ModelAttribute("plan")Plan plan){
		ModelAndView mv=new ModelAndView();
		int count=planServ.returnDeletePlanById(plan);
		if(count>0){
			StaffFrom sff=(StaffFrom) session.getAttribute("sff");
			Task ta=new Task();
			ta.setTask_Id(plan.getTask_Id());
			sff.setPlans(taskServ.returnPlanByTaskId(ta,1,9999));
			session.setAttribute("sff", sff);
			mv.setViewName("redirect:person/taskview.jsp");//返回计划管理
		}else{
			session.setAttribute("mess", "计划删除失败");
			mv.setViewName("redirect:error.jsp");
		}
		return mv;
	}
	@RequestMapping("insertPlan.do")//新建计划
	public ModelAndView insertPlan(HttpSession session,@ModelAttribute("plan")Plan plan){
		ModelAndView mv=new ModelAndView();
		int count=planServ.returnInsertPlan(plan);
		if(count>0){
			StaffFrom sff=(StaffFrom) session.getAttribute("sff");
			Task ta=new Task();
			ta.setTask_Id(plan.getTask_Id());
			sff.setPlans(taskServ.returnPlanByTaskId(ta,1,9999));
			session.setAttribute("sff", sff);
			mv.setViewName("redirect:person/taskview.jsp");//返回计划管理
		}else{
			session.setAttribute("mess", "计划删除失败");
			mv.setViewName("redirect:error.jsp");
		}
		return mv;
	}
	
	@RequestMapping("queryPlanByTaskIdByEmpId.do")//高级查询计划
	public ModelAndView queryPlanByTaskIdByEmpId(HttpSession session,HttpServletRequest request,@ModelAttribute("plan")Plan plan,@RequestParam("implementor_Id")int impID){
		ModelAndView mv=new ModelAndView();
		

		String No=request.getParameter("pageNo");
		PageBean<Plan>pb=new PageBean<Plan>();
		int pageNo=1;//页码
		int pageSize=2;//页大小
		if(No!=null){
			pageNo=Integer.parseInt(No);//如果传递了页码
		}
		System.out.println("条件"+plan.getPlan_Name());
		
		if(plan.getPlan_Name()!=null){
			System.out.println("有条件");
			session.setAttribute("plan",plan);
		}else{
			if(session.getAttribute("plan")!=null){//如果不为空，则代表有条件
				System.out.println("没条件");
				plan=(Plan)session.getAttribute("plan");
			};
		}
		
		Task task=new Task();
		task.setImplementor_Id(impID);//设置实施人ID
		
		List<Plan> plans=planServ.returnQueryPlanByTaskIdByEmpId(task,plan,pageNo,pageSize);//根据条件查询实施人下所有的计划
		
		Employee emp=new Employee();
		emp.setEmployee_Id(task.getImplementor_Id());
		System.out.println("实施人:"+emp.getEmployee_Id());
		List<Task>tas=taskServ.returnQueryTaskByEmpId(emp,pageNo,9999);//查询实施人下所有的任务
		Map<Integer,Object> ts=new HashMap<Integer, Object>();
		for (int i = 0; i < tas.size(); i++) {
			Task ta= tas.get(i);
			ts.put(ta.getTask_Id(),ta);
		}
		
		
		session.setAttribute("tas", ts);
		
		
		pb.setData(plans);
		
		pb.setRecordCount(taskServ.GroupQueryueryPlanCountByTaskId(task, plan));
		pb.setPageNo(pageNo);
		pb.setPageSize(pageSize);
		session.setAttribute("pb", pb);
		
		mv.setViewName("redirect:person/checkpro.jsp");//返回高级查询计划页面
		
		return mv;
	}
	
	@RequestMapping("queryPlanByPlanId.do")//按编号查询计划
	public ModelAndView queryPlanByPlanId(HttpSession session,@ModelAttribute("plan")Plan plan){
		ModelAndView mv=new ModelAndView();
		Plan pl=planServ.returnQueryPlanByPlanId(plan);
		session.setAttribute("PlanByPlanId", pl);
		mv.setViewName("redirect:person/feedback.jsp");//返回计划反馈页面
		return mv;
	}
	@RequestMapping("updatePlanStateByPlanId.do")//按编号修改计划状态
	public ModelAndView updatePlanStateByPlanId(HttpSession session,@ModelAttribute("plan")Plan plan){
		ModelAndView mv=new ModelAndView();
		int count=planServ.returnUpdatePlanStateByPlanId(plan);//如果修改成功
		if(count>0){
			Plan pl=planServ.returnQueryPlanByPlanId(plan);
			session.setAttribute("PlanByPlanId", pl);
			mv.setViewName("redirect:person/task.jsp");//返回计划反馈页面
		}else{
			session.setAttribute("mess", "计划修改失败");
			mv.setViewName("redirect:error.jsp");
		}
		return mv;
	}
}
