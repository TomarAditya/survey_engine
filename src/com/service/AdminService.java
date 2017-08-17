package com.service;

import com.dao.AdminDao;
import com.model.*;


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
