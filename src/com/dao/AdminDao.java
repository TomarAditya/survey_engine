package com.dao;
import com.model.*;

import java.sql.*;
import java.util.ArrayList;

import com.factory.SqlFactory;

public class AdminDao {

    SqlFactory sqlFactory;
    PreparedStatement preparedStatement;
    int result;
    ResultSet resultSet;
    Connection connection;

    public AdminDao() {
        sqlFactory = new SqlFactory();
        connection = sqlFactory.getConnection();
    }

    public int insertAdmin(Admin admin) {
        try {
            preparedStatement = connection.prepareStatement("Insert into admin values(?,?,?,?)");
            preparedStatement.setInt(1, admin.getId());
            preparedStatement.setString(2, admin.getName());
            preparedStatement.setString(3, admin.getPassword());
            preparedStatement.setInt(4, admin.getIdentity());
            result = preparedStatement.executeUpdate();

        } catch (SQLException se) {
            System.out.print(se);
        }

        return result;

    }

    public int updateAdmin(Admin admin) {
        try {
            preparedStatement = connection.prepareStatement("Update admin set username=?, password=? where admin_id=?");
            preparedStatement.setInt(3, admin.getId());
            preparedStatement.setString(1, admin.getName());
            preparedStatement.setString(2, admin.getPassword());
            result = preparedStatement.executeUpdate();
            if (result > 0) {
                connection.commit();
            }

        } catch (SQLException se) {
            System.out.println(se);
        } finally {
            sqlFactory.closeConnection();
        }
        return result;
    }

    public boolean searchAdmin(Admin admin) {
        boolean flag = false;
        try {
            preparedStatement = connection.prepareStatement("select * from admin where admin_id = ? && password = ? && identity = ?");
            preparedStatement.setInt(1, admin.getId());
            preparedStatement.setString(2, admin.getPassword());
            preparedStatement.setInt(3, admin.getIdentity());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                flag = true;
            }
        } catch (SQLException se) {
            System.out.print(se);
        } finally {
            sqlFactory.closeConnection();
        }

        return flag;

    }

}