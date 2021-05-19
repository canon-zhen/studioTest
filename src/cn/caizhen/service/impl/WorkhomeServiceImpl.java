package cn.caizhen.service.impl;

import cn.caizhen.dao.WorkhomeDao;
import cn.caizhen.dao.impl.WorkhomeDaoImpl;
import cn.caizhen.domain.Achievement;
import cn.caizhen.domain.Workhome;
import cn.caizhen.service.WorkhomeService;

import java.util.List;

public class WorkhomeServiceImpl implements WorkhomeService {
    WorkhomeDao dao=new WorkhomeDaoImpl();
    @Override
    public void addWorkHome(Workhome workhome) {
        dao.addWorkHome(workhome);
    }

    @Override
    public void deleteWorkHome(String wname) {
        dao.deleteWorkHome(wname);
    }

    @Override
    public List<Workhome> findAllWorkHomeByname(String workname) {
        return dao.findAllWorkHomeByname(workname);
    }

    @Override
    public List<Achievement> findAllAchievement() {
        return dao.findAllAchievement();
    }

    @Override
    public List<Achievement> findAllAchievementByWkHname(String wkHname) {
        return dao.findAllAchievementByWkHname(wkHname);
    }
}
