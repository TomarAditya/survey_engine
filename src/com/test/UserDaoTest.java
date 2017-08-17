package com.test;


import com.model.User;
import com.service.UserService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UserDaoTest {
    @Test
    public void testAdminLogin() {
        User user = new User();
        user.setUserID(1);
        user.setPassword("qwe");
        UserService userService = new UserService();

        assertEquals(true, userService.searchUserService(user));

    }
}
