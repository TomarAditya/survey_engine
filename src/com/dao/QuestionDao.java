package com.dao;

import com.factory.SqlFactory;
import com.model.Question;
import com.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Zeo Dragoneel on 12-07-2017.
 */
public class QuestionDao {
    SqlFactory sqlFactory;
    PreparedStatement preparedStatement;
    int result;
    ResultSet resultSet;
    Connection connection;

    public QuestionDao() {
        sqlFactory = new SqlFactory();
        connection = sqlFactory.getConnection();
    }

    public int insertQuestion(Question question) {
        try
        {
            preparedStatement = connection.prepareStatement("Insert into question values(?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,question.getId());
            preparedStatement.setInt(2,question.getSurveyId());
            preparedStatement.setString(3,question.getText());
            preparedStatement.setString(4,question.getChoice1());
            preparedStatement.setString(5,question.getChoice2());
            preparedStatement.setString(6,question.getChoice3());
            preparedStatement.setString(7,question.getChoice4());
            preparedStatement.setInt(8, question.getQuestionType());

            result = preparedStatement.executeUpdate();
        }catch(SQLException se) {
            System.out.print(se);
        }
        return result;
    }

    public int updateQuestion(Question question) {
        try {
            preparedStatement = connection.prepareStatement("Update question set name=? where id=?");
            preparedStatement.setInt(2, question.getId());
            preparedStatement.setString(1, question.getText());
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

    public ArrayList<Question> viewQuestion(int surveyID) {
        ArrayList<Question> arrayList = new ArrayList<Question>();
        try {
            preparedStatement =connection.prepareStatement("select * from question where survey_id=?");
            preparedStatement.setInt(1,surveyID);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Question question=new Question();
                question.setId(resultSet.getInt(1));
                question.setSurveyId(resultSet.getInt(2));
                question.setText(resultSet.getString(3));
                question.setChoice1(resultSet.getString(4));
                question.setChoice2(resultSet.getString(5));
                question.setChoice3(resultSet.getString(6));
                question.setChoice4(resultSet.getString(7));
                question.setQuestionType(resultSet.getInt(8));

                arrayList.add(question);
            }
        } catch(SQLException e){
            System.out.print(e);
          }
        return arrayList;
    }

    public int deleteQuestionDAO(int questionId) {
        try {
            preparedStatement = connection.prepareStatement("Delete from question where ques_id=? ");
            preparedStatement.setInt(1,questionId);
            result = preparedStatement.executeUpdate();

        } catch(SQLException se) {
            System.out.println(se);
          }finally {
            sqlFactory.closeConnection();
           }
        return result;
    }

    public int maxQuesDAO() {
        try {
            preparedStatement= connection.prepareStatement("select max(ques_id) from question");
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                result=resultSet.getInt(1);
            }
        }catch(SQLException se) {
            System.out.println(se);
        }
        return result;

    }
}
