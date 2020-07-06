package pers.deng.DatangTelecom.service;

import java.util.List;

import pers.deng.DatangTelecom.data.bean.Employee;

public interface IEmployeeService {
	
	/**
	 * 返回员工登录结果的方法
	 */
	public Employee returnEmpLoginResult(Employee emp);
	
	/**
	 * 返回员工记录总数
	 */
	public int returnRecordCount();
	
	/**
	 * 用于返回所有的员工
	 */
	public List<Employee> returnAllEmp(int pageNo,int pageSize);
	
	/**
	 * 用于返回管理员添加员工结果
	 */
	public int returnAdminAddEmpResult(Employee emp);
	
	
	/**
	 * 用于返回管理员删除员工的方法
	 * 
	 */
	public int returnAdminDeleteEmpResult(Employee emp);
	
	/**
	 * 用户返回单个员工
	 */
	public Employee returnAdminQueryByid(Employee emp);
	
	/**
	 * 用于返回所有主管
	 */
	public List<Employee>returnManager();
	
	/**
	 * 返回分配的结果
	 */
	public int returnAllocation(int parentId, int allocationId);
	/**
	 * 返回主管所有的下属员工
	 */
	public List<Employee>returnStaffByManagerId(Employee emp,int pageNo,int pageSize);
	/**
	 * 返回主管所有的下属员工总数
	 */
	public int returnStaffCountByManagerId(Employee emp);
}
