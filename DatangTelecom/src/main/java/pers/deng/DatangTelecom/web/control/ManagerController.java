package pers.deng.DatangTelecom.web.control;

import java.util.ArrayList;
import java.util.List;

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
import pers.deng.DatangTelecom.service.ITaskService;
import pers.deng.DatangTelecom.web.util.PageBean;
import pers.deng.DatangTelecom.web.util.StaffFrom;

@Controller
public class ManagerController {
	@Resource(name="empServ")
	IEmployeeService empServ;
	@Resource(name="planService")
	IPlanService planServ;
	@Resource(name="taskServ")
	ITaskService taskServ;
	
	@RequestMapping("queryTaskByAssigner.do")//���ƶ��˲�ѯ����
	public ModelAndView queryTaskByAssigner(HttpSession session,HttpServletRequest request,@ModelAttribute("task")Task task){
		ModelAndView mv=new ModelAndView();
		String No=request.getParameter("pageNo");
		PageBean<StaffFrom>pb=new PageBean<StaffFrom>();
		int pageNo=1;//ҳ��
		int pageSize=4;//ҳ��С
		if(No!=null){
			pageNo=Integer.parseInt(No);//���������ҳ��
		}
		
		List<StaffFrom> sffs=new ArrayList<StaffFrom>();//�����ӦԱ������
		List<Task>tas=taskServ.returnQueryTaskByAssigner(task,pageNo,pageSize);
		
		for (int i = 0; i < tas.size(); i++) {
			StaffFrom sff=new StaffFrom();
			Employee emp=new Employee();
			emp.setEmployee_Id(tas.get(i).getImplementor_Id());//����ʵʩ��id��ѯʵʩ��
			sff.setTask(tas.get(i));//�������
			sff.setEmp(empServ.returnAdminQueryByid(emp));//���ʵʩ�˽�ҳ����ʾ������
			task.setTask_Id(tas.get(i).getTask_Id());//��������id
			sff.setPlans(taskServ.returnPlanByTaskId(task,1,2));//��ѯ�����µ����мƻ�
			sffs.add(sff);
		}
		pb.setRecordCount(taskServ.returnQueryTaskCountByAssigner(task));//���ü�¼����
		pb.setData(sffs);
		pb.setPageNo(pageNo);
		pb.setPageSize(pageSize);
		
		session.setAttribute("pb", pb);
		
		
		mv.setViewName("redirect:manager/taskview.jsp");//���ؼƻ�����ҳ��
		return mv;
	}
	
	
	
	@RequestMapping("managerQueryPlanByTaskId.do")//���ܸ�������Id��ѯ�ƻ�
	public ModelAndView managerQueryPlanByTaskId(HttpSession session,HttpServletRequest request,@ModelAttribute("task")Task task){
		ModelAndView mv=new ModelAndView();
		StaffFrom sff=new StaffFrom();
		String No=request.getParameter("pageNo");
		PageBean<StaffFrom>pb=new PageBean<StaffFrom>();
		int pageNo=1;//ҳ��
		int pageSize=4;//ҳ��С
		if(No!=null){
			pageNo=Integer.parseInt(No);//���������ҳ��
		}
		Task managerQueryTask=taskServ.returnQueryTaskById(task);
		sff.setTask(managerQueryTask);
		Employee emp=new Employee();//����ʵʩ��id
		emp.setEmployee_Id(managerQueryTask.getImplementor_Id());
		sff.setEmp(empServ.returnAdminQueryByid(emp));
		
		sff.setPlans(taskServ.returnPlanByTaskId(managerQueryTask,pageNo,pageSize));//���������µ����мƻ�
		
		pb.setRecordCount(taskServ.queryPlanCountByTaskId(task));
		pb.setPageNo(pageNo);
		pb.setPageSize(pageSize);
		pb.setData1(sff);
		session.setAttribute("pb", pb);
		
		mv.setViewName("redirect:manager/taskparticular.jsp");
		return mv;
	}
	
	@RequestMapping("managerQueryPlanByPlanId.do")//���ܸ��ݼƻ���Ų�ѯ�ƻ�
	public ModelAndView managerQueryPlanByPlanId(HttpSession session,@ModelAttribute("plan")Plan plan){
		ModelAndView mv=new ModelAndView();
		Plan managerQueryPlanById= planServ.returnQueryPlanByPlanId(plan);
		session.setAttribute("managerQueryPlanById", managerQueryPlanById);
		System.out.println("����:"+managerQueryPlanById.toString());
		mv.setViewName("redirect:manager/program.jsp");
		return mv;
	}
	
	@RequestMapping("managerQueryStaff.do")//���ܲ�ѯ����Ա��
	public ModelAndView managerQueryStaff(HttpSession session,@ModelAttribute("emp")Employee emp){
		ModelAndView mv=new ModelAndView();
		List<Employee> managerQueryStaff=empServ.returnStaffByManagerId(emp,1,9999);
		session.setAttribute("managerQueryStaff", managerQueryStaff);
		mv.setViewName("redirect:manager/task.jsp");
		return mv;
	}
	
	@RequestMapping("managerNewTask.do")//���ܸ��ݼƻ���Ų�ѯ�ƻ�
	public ModelAndView managerNewTask(HttpSession session,HttpServletRequest request,@ModelAttribute("task")Task task){
		ModelAndView mv=new ModelAndView();
		int count=taskServ.returnManagerNewTask(task);
		if(count>0){
			this.queryTaskByAssigner(session,request, task);//��ת����������
			mv.setViewName("redirect:manager/taskview.jsp");
		}else{
			session.setAttribute("mess", "�ƶ�������ʧ��");
			mv.setViewName("redirect:error.jsp");
		}
		return mv;
	}
	
	@RequestMapping("queryDeleteTaskByAssigner.do")//���ƶ��˲�ѯɾ�������б�
	public ModelAndView queryDeleteTaskByAssigner(HttpSession session,HttpServletRequest request,@ModelAttribute("task")Task task){
		ModelAndView mv=new ModelAndView();
		String No=request.getParameter("pageNo");
		PageBean<StaffFrom>pb=new PageBean<StaffFrom>();
		int pageNo=1;//ҳ��
		int pageSize=4;//ҳ��С
		if(No!=null){
			pageNo=Integer.parseInt(No);//���������ҳ��
		}
		List<StaffFrom> sffs=new ArrayList<StaffFrom>();//�����ӦԱ������
		List<Task>tas=taskServ.returnQueryTaskByAssigner(task,pageNo,pageSize);
		for (int i = 0; i < tas.size(); i++) {
			StaffFrom sff=new StaffFrom();
			Employee emp=new Employee();
			emp.setEmployee_Id(tas.get(i).getImplementor_Id());//����ʵʩ��id��ѯʵʩ��
			sff.setTask(tas.get(i));//�������
			sff.setEmp(empServ.returnAdminQueryByid(emp));//���ʵʩ�˽�ҳ����ʾ������
			
			task.setTask_Id(tas.get(i).getTask_Id());//��������id
			sffs.add(sff);
		}
		pb.setData(sffs);
		pb.setRecordCount(taskServ.returnQueryTaskCountByAssigner(task));
		pb.setPageNo(pageNo);
		pb.setPageSize(pageSize);
		session.setAttribute("pb", pb);
		
		mv.setViewName("redirect:manager/taskundone.jsp");//���ؼƻ�����ҳ��
		return mv;
	}
	
	@RequestMapping("queryDeleteTaskByTaskId.do")//���ƶ��˲�ѯɾ�������б�
	public ModelAndView queryDeleteTaskByTaskId(HttpSession session,HttpServletRequest request,@RequestParam("taskids")String[] taskids,
			@ModelAttribute("task")Task task){
		ModelAndView mv=new ModelAndView();
		int count=taskServ.returnManagerDeleteTask(taskids);
		System.out.println("������ɾ��������Ŀ:"+count);
		if(count>0){
			this.queryTaskByAssigner(session,request, task);//��ת����������
			mv.setViewName("redirect:manager/taskundone.jsp");
		}else{
			session.setAttribute("mess", "ɾ�������г����˴���");
			mv.setViewName("refirect:error.jsp");
		}
		return mv;
	}
	
	@RequestMapping("managerQueryTaskGOUpdate.do")//���ܸ���id��ѯ����
	public ModelAndView managerQueryStaffGOUpdate(HttpSession session,@ModelAttribute("task")Task task,
			@ModelAttribute("emp")Employee emp){
		ModelAndView mv=new ModelAndView();
		List<Employee> managerQueryStaff=empServ.returnStaffByManagerId(emp,1,99999);//
		Task ta=taskServ.returnQueryTaskById(task);
		session.setAttribute("managerQueryStaff", managerQueryStaff);//�������е�����Ա��
		session.setAttribute("managerQueryTask", ta);//��������
		mv.setViewName("redirect:manager/adjust.jsp");
		return mv;
	}
	@RequestMapping("managerUpdateTaskById.do")//���ƶ��˲�ѯɾ�������б�
	public ModelAndView managerUpdateTaskById(HttpSession session,HttpServletRequest request,@ModelAttribute("task")Task task){
		ModelAndView mv=new ModelAndView();
		int count=taskServ.returnManagerUpdateTaskByid(task);
		if(count>0){
			this.queryDeleteTaskByAssigner(session,request, task);//��ת����������
			mv.setViewName("redirect:manager/taskundone.jsp");
		}else{
			mv.setViewName("redirect:error.jsp");
			session.setAttribute("mess", "�����޸�������Ϣ������!");
		}
		return mv;
	}
	
	@RequestMapping("managerQueryStaffList.do")//���ܲ�ѯ����Ա��
	public ModelAndView managerQueryStaffList(HttpSession session,HttpServletRequest request,@ModelAttribute("emp")Employee emp){
		ModelAndView mv=new ModelAndView();

		String No=request.getParameter("pageNo");
		PageBean<Employee>pb=new PageBean<Employee>();
		int pageNo=1;//ҳ��
		int pageSize=4;//ҳ��С
		if(No!=null){
			pageNo=Integer.parseInt(No);//���������ҳ��
		}
		List<Employee> managerQueryStaff=empServ.returnStaffByManagerId(emp,pageNo,pageSize);
		
		pb.setData(managerQueryStaff);
		pb.setRecordCount(empServ.returnStaffCountByManagerId(emp));
		pb.setPageNo(pageNo);
		pb.setPageSize(pageSize);
		mv.setViewName("redirect:manager/checkper.jsp");
		
		session.setAttribute("pb", pb);
		return mv;
	}
	
	@RequestMapping("managerQueryStaffByStaffId.do")//���ܲ�ѯ����Ա����ϸ��Ϣ
	public ModelAndView managerQueryStaffByStaffId(HttpSession session,@ModelAttribute("emp")Employee emp){
		ModelAndView mv=new ModelAndView();
		Employee managerQueryStaff=empServ.returnAdminQueryByid(emp);
		session.setAttribute("managerQueryStaffByStaffId", managerQueryStaff);
		System.out.println("�����û�Ա��:"+managerQueryStaff.toString());
		mv.setViewName("redirect:manager/personinfo.jsp");
		return mv;
	}
	
	@RequestMapping("trackingTaskList.do")//���ܵ����������
	public ModelAndView trackingTaskList(HttpSession session,HttpServletRequest request,@ModelAttribute("task")Task task){
		ModelAndView mv=new ModelAndView();
		String No=request.getParameter("pageNo");
		PageBean<StaffFrom>pb=new PageBean<StaffFrom>();
		int pageNo=1;//ҳ��
		int pageSize=4;//ҳ��С
		if(No!=null){
			pageNo=Integer.parseInt(No);//���������ҳ��
		}
		List<Task>tas=taskServ.returnQueryTaskByAssigner(task,pageNo,pageSize);
		
		List<StaffFrom> sffs=new ArrayList<StaffFrom>();
		for (int i = 0; i < tas.size(); i++) {
			StaffFrom sff=new StaffFrom();
			sff.setTask(tas.get(i));
			Employee emp=new Employee();
			emp.setEmployee_Id(tas.get(i).getImplementor_Id());//��ȡʵʩ��id��ѯʵʩ��
			sff.setEmp(empServ.returnAdminQueryByid(emp));
			sffs.add(sff);
		}
		
		pb.setData(sffs);
		pb.setRecordCount(taskServ.returnQueryTaskCountByAssigner(task));
		pb.setPageNo(pageNo);
		pb.setPageSize(pageSize);
		
		session.setAttribute("pb",pb);
		
		mv.setViewName("redirect:manager/intendance.jsp");
		return mv;
	}
	
	@RequestMapping("trackingTaskByTaskId.do")//�����ڸ���������������ϸ
	public ModelAndView trackingTaskByTaskId(HttpSession session,HttpServletRequest request,@ModelAttribute("task")Task task){
		ModelAndView mv=new ModelAndView();
		StaffFrom sff=new StaffFrom();
		String No=request.getParameter("pageNo");
		PageBean<StaffFrom>pb=new PageBean<StaffFrom>();
		int pageNo=1;//ҳ��
		int pageSize=4;//ҳ��С
		if(No!=null){
			pageNo=Integer.parseInt(No);//���������ҳ��
		}
		Task managerQueryTask=taskServ.returnQueryTaskById(task);
		sff.setTask(managerQueryTask);
		Employee emp=new Employee();//����ʵʩ��id
		emp.setEmployee_Id(managerQueryTask.getImplementor_Id());
		sff.setEmp(empServ.returnAdminQueryByid(emp));
		sff.setPlans(taskServ.returnPlanByTaskId(managerQueryTask,pageNo,pageSize));//���������µ����мƻ�
		pb.setData1(sff);
		pb.setRecordCount(taskServ.queryPlanCountByTaskId(task));
		pb.setPageNo(pageNo);
		pb.setPageSize(pageSize);
		session.setAttribute("pb", pb);
		mv.setViewName("redirect:manager/programinten.jsp");
		return mv;
	}
	
	@RequestMapping("checkboxPlan.do")//���ݸ�ѡ��ѡ���Ƿ���ʾ�ƻ�
	public ModelAndView checkboxPlan(HttpSession session,@RequestParam("plan_id")String[] taskids){
		ModelAndView mv=new ModelAndView();
		PageBean<StaffFrom>pb=(PageBean<StaffFrom>) session.getAttribute("pb");
		StaffFrom sff= pb.getData1();
		List<Plan>plans=new ArrayList<Plan>();
		System.out.println("��������"+taskids.toString());
		for (int i = 0; i <taskids.length; i++) {
			for (int j = 0; j <sff.getPlans().size() ; j++) {
				if(sff.getPlans().get(j).getPlan_Id()==Integer.parseInt(taskids[i])){
					plans.add(sff.getPlans().get(j));
				}
			}
		}
		pb.setData1(sff);
		pb.setRecordCount(taskids.length);
		System.out.println("���ݵ�id"+taskids.toString());
		System.out.println("�����:"+plans.toString());
		sff.setPlans(plans);
		session.setAttribute("pb", pb);
		mv.setViewName("redirect:manager/programinten.jsp");
		return mv;
	}
	@RequestMapping("managerUpdateStatus.do")//�����޸�����״̬
	public ModelAndView checkboxPlan(HttpSession session,HttpServletRequest request,@ModelAttribute("task")Task task){
		ModelAndView mv=new ModelAndView();
		int count=taskServ.returnManagerUpdateStatus(task);
		
		if(count>0){
			this.trackingTaskList(session,request, task);//�������ܵ��������ٵķ���
			mv.setViewName("redirect:manager/intendance.jsp");
		}else{
			session.setAttribute("mess", "�����޸�����״̬����");
			mv.setViewName("redirect:error.jsp");
		}
		return mv;
	}
	
}
