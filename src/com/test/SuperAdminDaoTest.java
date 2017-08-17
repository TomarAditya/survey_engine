package com.test;

import com.model.SuperAdmin;
import com.service.SuperAdminService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class SuperAdminDaoTest {
    @Test
    public void testAdminLogin() {
        SuperAdmin superAdmin = new SuperAdmin();
        superAdmin.setUserName("Arpit");
        superAdmin.setPassword("Noob");
        SuperAdminService superAdminService = new SuperAdminService();

        assertEquals(true, superAdminService.searchSuperAdminService(superAdmin));

    }
}
