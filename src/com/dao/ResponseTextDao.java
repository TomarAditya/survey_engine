package com.dao;

import com.factory.SqlFactory;
import com.model.Choices;
import com.model.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResponseTextDao {
    SqlFactory sqlFactory;
    PreparedStatement preparedStatement;
    int result;
    ResultSet resultSet;
    Connection connection;

    public ResponseTextDao() {
        sqlFactory=new SqlFactory();
        connection = sqlFactory.getConnection();
    }

    public int addResponseText(int surveyID,int questionID,int userId,String answer) {
        try {
            preparedStatement = connection.prepareStatement("insert into response_text values(?,?,?,?)");
            preparedStatement.setInt(1, surveyID);
            preparedStatement.setInt(2, questionID);
            preparedStatement.setInt(3, userId);
            preparedStatement.setString(4, answer);
            result = preparedStatement.executeUpdate();
        }catch(SQLException se) {
            System.out.println(se);
        }
        return result;
    }

    public Question reportGenText(int surveyid, int questionID){

        Question question = new Question();
        try{

            preparedStatement=connection.prepareStatement("select answer from response_text where surveyID=? AND questionID=?");
            preparedStatement.setInt(1,surveyid);
            preparedStatement.setInt(2, questionID);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
                String ch1 = resultSet.getString(1);
                question.setChoice1(ch1);
            }
        }catch(SQLException s){System.out.print(s);}
        return question;
    }

}
