package com.service;

import com.dao.UserDao;
import com.model.User;

/**
 * Created by Zeo Dragoneel on 12-07-2017.
 */
public class UserService {

    UserDao userDao;

    public UserService(){
        userDao = new UserDao();
    }

    public boolean searchUserService(User user){
        return userDao.searchUser(user);
    }

    public int updateUserService(User user) {
        return userDao.updateUser(user);
    }

    public int addUserService(User user) {
        return userDao.insertUser(user);
    }
}
