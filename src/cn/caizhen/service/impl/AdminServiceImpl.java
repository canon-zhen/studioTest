package cn.caizhen.service.impl;

import cn.caizhen.dao.AdminsDao;
import cn.caizhen.dao.impl.AdminsDaoImpl;
import cn.caizhen.domain.Admins;
import cn.caizhen.service.AdminService;

public class AdminServiceImpl implements AdminService {
    private AdminsDao dao=new AdminsDaoImpl();
    @Override
    public Admins login(Admins admins) {
        return dao.findAdminsBynameAndPassword(admins.getUsername(), admins.getPassword());
    }
}
