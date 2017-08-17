package com.service;

import com.dao.SuperAdminDao;
import com.model.*;

import java.util.ArrayList;

/**
 * Created by Zeo Dragoneel on 12-07-2017.
 */
public class SuperAdminService {
    SuperAdminDao superAdminDao;

    public SuperAdminService() {
        superAdminDao = new SuperAdminDao();
    }

    public boolean searchSuperAdminService(SuperAdmin superAdmin){
        return superAdminDao.searchSuperAdmin(superAdmin);
    }
   }
