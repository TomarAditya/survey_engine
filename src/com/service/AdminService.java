package com.service;

import com.dao.AdminDao;
import com.model.*;

/**
 * Created by Zeo Dragoneel on 12-07-2017.
 */
public class AdminService {
    AdminDao adminDao;

    public AdminService() {
        adminDao=new AdminDao();

    }

    public int addAdminService(Admin admin)
    {
        return adminDao.insertAdmin(admin);
    }

    public int updateAdminService(Admin admin){
        return adminDao.updateAdmin(admin);
    }

    public boolean searchAdminService(Admin admin){
        return adminDao.searchAdmin(admin);
    }

}
