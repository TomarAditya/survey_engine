package com.test;

import com.model.Admin;
import com.service.AdminService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Zeo Dragoneel on 13-07-2017.
 */
public class AdminDaoTest {


     @Test
        public  void testAdminLogin(){
            Admin admin = new Admin();
            admin.setId(15);
            admin.setPassword("hooda");
            AdminService adminService = new AdminService();

            assertEquals(true,adminService.searchAdminService(admin));
        }

    }

