package com.service;

import com.dao.SuperAdminDao;
import com.model.*;

import java.util.ArrayList;


public class SuperAdminService {
    SuperAdminDao superAdminDao;

    public SuperAdminService() {
        superAdminDao = new SuperAdminDao();
    }

    public boolean searchSuperAdminService(SuperAdmin superAdmin){
        return superAdminDao.searchSuperAdmin(superAdmin);
    }
   }
