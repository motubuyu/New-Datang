package pers.deng.DatangTelecom.data.dao;

import java.util.List;

import pers.deng.DatangTelecom.data.bean.Employee;

public interface IEmployeeDao {
	/**
	 * 登录的方法
	 * @param emp
	 * @return
	 */
	public Employee Stafflogin(Employee emp);
	/**
	 * 查询所有员工的方法
	 * @return
	 */
	public List<Employee> queryAllEmp(int pageNo, int pageSize);
	
	/**
	 * 查询记录总数
	 */
	public int queryRecordCount();
	
	
	/**
	 * 系统管理员添加用户
	 */
	public int adminAddEmp(Employee emp);
	
	/**
	 * 系统管理员删除用户
	 */
	public int adminDeleteEmp(Employee emp);
	
	/**
	 * 按编号查询单个员工
	 */
	public Employee adminQueryEmpByID(Employee emp);
	
	/**
	 * 查询所有主管
	 */
	public List<Employee> queryManager();
	
	/**
	 * 分配主管
	 */
	public int adminAllocation(int parentId,int allocationId);
	/**
	 * 查询主管下的所有员工总数
	 */
	public int queryEmpCountByPrantenId(Employee emp);
	
	/**
	 * 查询主管下的所有员工
	 */
	public List<Employee> queryEmpByPrantenId(Employee emp,int pageNo,int pageSize);
}
