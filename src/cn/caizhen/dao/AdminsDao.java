package cn.caizhen.dao;

import cn.caizhen.domain.Admins;

/**
 * 管理员操作DAO
 */
public interface AdminsDao {
    /**
     * 通过用户名和密码查询管理员
     * 用来登录使用
     * @param adminName
     * @param adminPassword
     * @return
     */
    Admins findAdminsBynameAndPassword(String adminName ,String adminPassword);
}
