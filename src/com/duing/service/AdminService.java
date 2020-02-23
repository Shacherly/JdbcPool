package com.duing.service;

import com.duing.dao.AdminDao;
import com.duing.domain.Admin;
import com.jdbc.sqlsession.DynamicProxy;

import java.sql.SQLException;

public class AdminService {

    // 以前Dao是new出来的，现在是通过jdk的代理帮忙处理的
    private AdminDao adminDao = DynamicProxy.getProxyInstance(AdminDao.class);

    public int update(Admin admin) throws SQLException {
        return adminDao.update(admin);
    }

    public Admin select(int id) throws SQLException {
        return adminDao.selectOne(id);
    }

    public int insert(Admin admin) throws SQLException {
        return (int) adminDao.insert(admin);
    }

}
