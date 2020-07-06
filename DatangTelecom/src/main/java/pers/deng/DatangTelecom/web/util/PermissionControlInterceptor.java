package pers.deng.DatangTelecom.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import pers.deng.DatangTelecom.data.bean.Employee;

public class PermissionControlInterceptor implements HandlerInterceptor {
	//login.jsp��ΪSpringMVC��������������JSPҳ�棬
		//���login.jsp����Ͳ�������Ȩ��������
		// ������"/input_login.do"��"/mylogin.do"����
				private static final String[] IGNORE_URI = 
				{"stafflogin.do"};
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView mv) throws Exception {
		
		HttpSession session=request.getSession();
		
		
		String [] pathJurisdiction=mv.getViewName().split("/");//��ȡ�����������ж��Ƿ��Ȩ�޲���
		
		
		if(pathJurisdiction[0]!="redirect:login.jsp"){//�ſ�ע����ע��֮���û�лػ���
			Employee empLogin= (Employee)session .getAttribute("empLogin");
			System.out.println("������·��"+mv.getViewName());

			if(empLogin!=null){
				System.out.println("��ݱ��:"+empLogin.getRole().getRole_Id());

				switch (empLogin.getRole().getRole_Id()) {
				case 1:
					//���Ȩ�޶�Ӧ�ſ�����
					//������Ȩ����ת��ֱ��ȡ��Ӧ����ҳ
			
					if(pathJurisdiction[0].equals("redirect:manager")){
						mv.setViewName("redirect:admin/welcome.jsp");
					}else if(pathJurisdiction[0].equals("person")){
						mv.setViewName("redirect:admin/welcome.jsp");
					}
				break;
			case 2:
			
				if(pathJurisdiction[0].equals("redirect:person")){
					mv.setViewName("redirect:manager/welcome.jsp");
				}else if(pathJurisdiction[0].equals("redirect:admin")){
					session.setAttribute("mess", "��ȥ����ӦȨ��ҳ��");
					mv.setViewName("redirect:manager/welcome.jsp");
				}
				break;
			case 3:
			
				if(pathJurisdiction[0].equals("redirect:admin")){
					mv.setViewName("redirect:person/welcome.jsp");
				}if(pathJurisdiction[0].equals("redirect:manager")){
					mv.setViewName("redirect:person/welcome.jsp");//������Ȩ����ת��ֱ��ȡ��Ӧ����ҳ
				}
				break;
			default:
				mv.setViewName("redirect:error.jsp");
				break;
				}
			}
		}
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		boolean isFlag = false;//�����������Ƿ�����
		//��һ����ѭ�������Ϸ���������URL·�������������URLƥ��
		//���һ�£��ſ������������
		String urlPath = request.getServletPath();
		System.out.println("���������URL·����"+urlPath);
		
		for (String requestURL : IGNORE_URI) {
			if (urlPath.contains(requestURL)) {
				//true:��������URLƥ��
				isFlag = true;
				break;
			}
		}
		//�ڶ������Ự��Χ�ڻ�ȡ��¼�û�����ʵ�����������
		//�ſ���������ӦĿ����Դ��ҳ��/��������
		Employee loginUser = (Employee) request.getSession().getAttribute("empLogin");
		if (!isFlag) {
			if (loginUser != null) {
				isFlag = true;//���û�ֱ�ӷſ�����
			} else {
				//���δ��¼ֱ��ȡ��¼ҳ��
				request.getRequestDispatcher("login.jsp").forward(request, response);
				isFlag = false;
			}
		}
		return isFlag;
		
	}

}
