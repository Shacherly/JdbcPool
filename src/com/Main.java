package com;

import com.duing.domain.Admin;
import com.duing.service.AdminService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        AdminService adminService = new AdminService();
        // adminService.run();
        // Admin admin = adminService.select(1);
        // System.out.println(admin);

        Admin admin1 = new Admin("a23", 123);
        // admin1.setId(3);
        int id = adminService.insert(admin1);
        System.out.println(id);
        // adminService.update(admin1);
        // LinkedHashSet
    }
}
