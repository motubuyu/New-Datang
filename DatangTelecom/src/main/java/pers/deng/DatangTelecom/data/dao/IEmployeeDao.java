package pers.deng.DatangTelecom.data.dao;

import java.util.List;

import pers.deng.DatangTelecom.data.bean.Employee;

public interface IEmployeeDao {
	/**
	 * ��¼�ķ���
	 * @param emp
	 * @return
	 */
	public Employee Stafflogin(Employee emp);
	/**
	 * ��ѯ����Ա���ķ���
	 * @return
	 */
	public List<Employee> queryAllEmp(int pageNo, int pageSize);
	
	/**
	 * ��ѯ��¼����
	 */
	public int queryRecordCount();
	
	
	/**
	 * ϵͳ����Ա����û�
	 */
	public int adminAddEmp(Employee emp);
	
	/**
	 * ϵͳ����Աɾ���û�
	 */
	public int adminDeleteEmp(Employee emp);
	
	/**
	 * ����Ų�ѯ����Ա��
	 */
	public Employee adminQueryEmpByID(Employee emp);
	
	/**
	 * ��ѯ��������
	 */
	public List<Employee> queryManager();
	
	/**
	 * ��������
	 */
	public int adminAllocation(int parentId,int allocationId);
	/**
	 * ��ѯ�����µ�����Ա������
	 */
	public int queryEmpCountByPrantenId(Employee emp);
	
	/**
	 * ��ѯ�����µ�����Ա��
	 */
	public List<Employee> queryEmpByPrantenId(Employee emp,int pageNo,int pageSize);
}
