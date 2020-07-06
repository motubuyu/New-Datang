package pers.deng.DatangTelecom.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pers.deng.DatangTelecom.data.bean.Employee;
import pers.deng.DatangTelecom.data.dao.IEmployeeDao;
import pers.deng.DatangTelecom.service.IEmployeeService;


@Service("empServ")
public class EmployeeServiceImpl implements IEmployeeService {

	@Resource(name="empDao")
	IEmployeeDao empDao;
	
	
	@Override
	public Employee returnEmpLoginResult(Employee emp) {
		return empDao.Stafflogin(emp);
	}
	
	@Override
	public List<Employee> returnAllEmp(int pageNo,int pageSize) {
		return empDao.queryAllEmp(pageNo,pageSize);
	}

	@Override
	public int returnRecordCount() {
		return empDao.queryRecordCount();
	}

	@Override
	public int returnAdminAddEmpResult(Employee emp) {
		return empDao.adminAddEmp(emp);
	}

	@Override
	public int returnAdminDeleteEmpResult(Employee emp) {
		return empDao.adminDeleteEmp(emp);
	}

	@Override
	public Employee returnAdminQueryByid(Employee emp) {
		return empDao.adminQueryEmpByID(emp);
	}

	@Override
	public List<Employee> returnManager() {
		return empDao.queryManager();
	}

	@Override
	public int returnAllocation(int parentId, int allocationId) {
		return empDao.adminAllocation(parentId, allocationId);
	}

	@Override
	public List<Employee> returnStaffByManagerId(Employee emp,int pageNo,int pageSize) {
		return empDao.queryEmpByPrantenId(emp,pageNo,pageSize);
	}

	@Override
	public int returnStaffCountByManagerId(Employee emp) {
		return empDao.queryEmpCountByPrantenId(emp);
	}
	
	
}
