package cn.caizhen.dao.impl;

import cn.caizhen.dao.WorkhomeDao;
import cn.caizhen.domain.Achievement;
import cn.caizhen.domain.Student;
import cn.caizhen.domain.Workhome;
import cn.caizhen.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class WorkhomeDaoImpl implements WorkhomeDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public void addWorkHome(Workhome workhome) {
        //定义sql
        String sql="insert into workhome(wname,header,teacher,waddress,wprize,wslogan,wtime) " +
                   " values(?,?,?,?,?,?,?)";
        //执行
        template.update(sql, workhome.getWname(), workhome.getHeader(), workhome.getTeacher(),
                workhome.getWaddress(), workhome.getWprize(), workhome.getWslogan(), workhome.getWtime());
    }

    @Override
    public void deleteWorkHome(String wname) {
        String sql="delete from workhome where wname=?";
        template.update(sql,wname);
    }

    @Override
    public List<Workhome> findAllWorkHomeByname(String workname) {
        //定义sql
        System.out.println(workname);
        String sql="select * from workhome where wname like  CONCAT('%',?,'%')" ;
        //String s2="SELECT area_id FROM sys_area WHERE area_code LIKE ";

        List<Workhome> workhomes = template.query(sql, new BeanPropertyRowMapper<Workhome>(Workhome.class),workname);


        return workhomes;
    }

    @Override
    public List<Achievement> findAllAchievement() {
        //定义sql
        String sql="select * from achievement";
        List<Achievement> achievements = template.query(sql, new BeanPropertyRowMapper<Achievement>(Achievement.class));

        return achievements;
    }

    @Override
    public List<Achievement> findAllAchievementByWkHname(String wkHname) {
        //定义sql
        String sql="select * from achievement where wkHname like  CONCAT('%',?,'%')";
        List<Achievement> achievements = template.query(sql, new BeanPropertyRowMapper<Achievement>(Achievement.class),wkHname);

        return achievements;
    }
}
