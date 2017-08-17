package com.dao;

import com.factory.SqlFactory;
import com.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Zeo Dragoneel on 11-07-2017.
 */
public class UserDao {

        SqlFactory sqlFactory;
        PreparedStatement preparedStatement;
        int result;
        ResultSet resultSet;
        Connection connection;
        public UserDao()
        {
            sqlFactory=new SqlFactory();
            connection = sqlFactory.getConnection();
        }

        public int insertUser(User user) {
            try
            {
                preparedStatement=connection.prepareStatement("Insert into user values(?,?,?,?,?,?)");
                preparedStatement.setInt(1,user.getUserID());
                preparedStatement.setString(2,user.getFirstName());
                preparedStatement.setString(3,user.getLastName());
                preparedStatement.setInt(4,user.getAge());
                preparedStatement.setString(5, user.getPassword());
                preparedStatement.setString(6, user.getGender());
                result=preparedStatement.executeUpdate();
                if(result>0)
                    connection.commit();
            }catch(SQLException se){
                System.out.print(se);
            }
            return result;
        }

        public int updateUser(User user) {
        try {
            preparedStatement = connection.prepareStatement("Update user set first_name=?,last_name=?,age=?,password=?,gender=? where id=?");
            preparedStatement.setInt(6, user.getUserID());
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getGender());
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

        public boolean searchUser(User user) {
        boolean flag = false;
        try {
            preparedStatement=connection.prepareStatement("select * from user where user_id = ? && password = ?");
            preparedStatement.setInt(1,user.getUserID());
            preparedStatement.setString(2,user.getPassword());
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                flag =  true;
            }
        } catch(SQLException se){
            System.out.print(se);
        }finally {
            sqlFactory.closeConnection();
        }
        return flag;
    }

//*****************************************************UPDATE*******************************


      /*  public int updateUser(User user) {
            try {
                ps = con.prepareStatement("Update survey set first_name=?,last_name=?,age=?,password=?,gender=? where id=?");
                ps.setInt(6, user.getId());
                ps.setString(1, user.getFirst_name());
                ps.setString(2, user.getLast_name());
                ps.setInt(3, user.getAge());
                ps.setString(4, user.getPass());
                ps.setString(5, user.getGender());
                r = ps.executeUpdate();
                if (r > 0) {
                    con.commit();
                }

            } catch (SQLException se) {

                System.out.println(se);
            } finally {
                S.closecon();
            }
            return r;
        }*/


//***********************************************SEARCH*******************************************

//        public boolean searchUser(User m)
//        {
//            boolean flag = false;
//            try
//            {
//                ps=con.prepareStatement("select * from user where user_id = ? && password = ?");
//                ps.setInt(1,m.getId());
//                ps.setString(2,m.getPass());
//                rs = ps.executeQuery();
//
//                if(rs.next()){
//                    flag =  true;
//                }
//            }catch(SQLException e){
//                System.out.print(e);
//            }finally {
//                S.closecon();
//            }
//
//            return flag;
//
//        }


//******************************************************VIEW************************************


    }

