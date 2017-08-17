package com.dao;
import com.model.*;

import java.sql.*;

import com.factory.SqlFactory;

public class SuperAdminDao {

    SqlFactory sqlFactory;
    PreparedStatement preparedStatement;
    int result;
    ResultSet resultSet;
    Connection  connection;

    public SuperAdminDao() {
        sqlFactory = new SqlFactory();
        connection = sqlFactory.getConnection();
    }

    public boolean searchSuperAdmin(SuperAdmin superAdmin) {
        boolean flag = false;
        try
        {
            preparedStatement=connection.prepareStatement("select * from super_admin where username = ? && password = ? ");
            preparedStatement.setString(1,superAdmin.getUserName());
            preparedStatement.setString(2,superAdmin.getPassword());
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                flag =  true;
            }
        }catch(SQLException se){
            System.out.print(se);
        }finally {
            sqlFactory.closeConnection();
        }

        return flag;

    }
}