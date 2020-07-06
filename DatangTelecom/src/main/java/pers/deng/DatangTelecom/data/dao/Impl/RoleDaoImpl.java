package pers.deng.DatangTelecom.data.dao.Impl;

import org.springframework.stereotype.Repository;
import pers.deng.DatangTelecom.data.bean.Role;
import pers.deng.DatangTelecom.data.dao.IRoleDao;

import java.util.List;
@Repository("roleDao")
public class RoleDaoImpl implements IRoleDao {
    @Override
    public List<Role> queryAllRole() {
        return null;
    }

    @Override
    public Role queryRoleByID(int id) {
        return null;
    }
}
