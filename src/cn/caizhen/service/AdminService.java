package cn.caizhen.service;

import cn.caizhen.domain.Admins;

/**
 * 管理员业务接口类
 */
public interface AdminService {

    /**
     * 管理员登录
     * @param admins
     * @return
     */
    Admins login(Admins admins);

}
