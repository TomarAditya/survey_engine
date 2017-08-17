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
public class SurveyDao {
    SqlFactory sqlFactory;
    PreparedStatement preparedStatement;
    int result;
    ResultSet resultSet;
    Connection connection;
    public SurveyDao() {
        sqlFactory=new SqlFactory();
        connection = sqlFactory.getConnection();
    }

    public int insertSurvey(Survey survey) {
        try
        {
            preparedStatement = connection.prepareStatement("Insert into survey values(?,?)");
            preparedStatement.setInt(1,survey.getSurveyID());
            preparedStatement.setString(2,survey.getSurveyName());
            result = preparedStatement.executeUpdate();
            if(result>0)
                connection.commit();
        } catch(SQLException se) {
            System.out.print(se);}
        return result;
    }

    public int updateSurvey(Survey survey) {
        try {
            preparedStatement = connection.prepareStatement("Update survey set name=? where id=?");
            preparedStatement.setInt(2, survey.getSurveyID());
            preparedStatement.setString(1, survey.getSurveyName());
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

    public int maxQuesDAO() {
        try {
            preparedStatement= connection.prepareStatement("select max(ques_id) from question");
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                result =resultSet.getInt(1);
            }
        }catch(SQLException se) {
            System.out.println(se);
        }
        return result;

    }

}
