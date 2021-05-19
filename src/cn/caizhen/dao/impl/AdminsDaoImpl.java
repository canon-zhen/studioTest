package cn.caizhen.dao.impl;

import cn.caizhen.dao.AdminsDao;
import cn.caizhen.domain.Admins;
import cn.caizhen.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class AdminsDaoImpl implements AdminsDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Admins findAdminsBynameAndPassword(String adminName, String adminPassword) {
        try{
            String sql="select * from admins where username= ? and password= ?";
            Admins admins = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Admins>(Admins.class),
                    adminName, adminPassword);
            return admins;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
