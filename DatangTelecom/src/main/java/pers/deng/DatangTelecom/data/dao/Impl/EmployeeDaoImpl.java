package pers.deng.DatangTelecom.data.dao.Impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pers.deng.DatangTelecom.data.bean.Employee;
import pers.deng.DatangTelecom.data.dao.IEmployeeDao;

import java.util.List;
@Repository("empDao")
public class EmployeeDaoImpl implements IEmployeeDao {
    @Override
    public Employee Stafflogin(Employee emp) {
        return null;
    }

    @Override
    public List<Employee> queryAllEmp(int pageNo, int pageSize) {
        return null;
    }

    @Override
    public int queryRecordCount() {
        return 0;
    }

    @Override
    public int adminAddEmp(Employee emp) {
        return 0;
    }

    @Override
    public int adminDeleteEmp(Employee emp) {
        return 0;
    }

    @Override
    public Employee adminQueryEmpByID(Employee emp) {
        return null;
    }

    @Override
    public List<Employee> queryManager() {
        return null;
    }

    @Override
    public int adminAllocation(int parentId, int allocationId) {
        return 0;
    }

    @Override
    public int queryEmpCountByPrantenId(Employee emp) {
        return 0;
    }

    @Override
    public List<Employee> queryEmpByPrantenId(Employee emp, int pageNo, int pageSize) {
        return null;
    }
}
