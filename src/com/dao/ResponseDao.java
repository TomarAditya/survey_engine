package com.dao;

import com.factory.SqlFactory;
import com.model.Choices;
import com.model.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Zeo Dragoneel on 12-07-2017.
 */
public class ResponseDao {

    SqlFactory sqlFactory;
    PreparedStatement preparedStatement;
    int result;
    ResultSet resultSet;
    Connection connection;

    public ResponseDao() {
        sqlFactory=new SqlFactory();
        connection = sqlFactory.getConnection();
    }
    public int insertResponse(int choice,int surveyID, int questionID){
        try
        {
            if(choice == 1){
                preparedStatement=connection.prepareStatement("insert into response values(?,?,?,?,?,?,?)");
                preparedStatement.setInt(1, surveyID);
                preparedStatement.setInt(2, questionID);
                preparedStatement.setInt(3, choice);
                preparedStatement.setInt(4, 0);
                preparedStatement.setInt(5, 0);
                preparedStatement.setInt(6, 0);
                preparedStatement.setInt(7, 0);
                result = preparedStatement.executeUpdate();
            }else if(choice == 2){
                preparedStatement=connection.prepareStatement("insert into response values(?,?,?,?,?,?,?)");
                preparedStatement.setInt(1, surveyID);
                preparedStatement.setInt(2, questionID);
                preparedStatement.setInt(3, choice);
                preparedStatement.setInt(4, 0);
                preparedStatement.setInt(5, 0);
                preparedStatement.setInt(6, 0);
                preparedStatement.setInt(7, 0);
                result=preparedStatement.executeUpdate();
            }else{
                result=1;
            }
        }catch(SQLException se){
            System.out.print(se);
        }

        return result;
    }

    public int addChoice(int choice,int surveyID, int questionID) {
        try
        {
            preparedStatement=connection.prepareStatement("select ch1,ch2,ch3,ch4 from response where survey_id = ? && ques_id = ?");
            preparedStatement.setInt(1, surveyID);
            preparedStatement.setInt(2, questionID);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            { if(choice == 1){
                result = resultSet.getInt(1);
                preparedStatement=connection.prepareStatement("update response set ch1 = ? where survey_id = ? && ques_id = ?");
                result = result+1;
                preparedStatement.setInt(1, result);
                preparedStatement.setInt(2, surveyID);
                preparedStatement.setInt(3, questionID);
                result = preparedStatement.executeUpdate();


            }else if(choice == 2){
                result = resultSet.getInt(2);
                preparedStatement=connection.prepareStatement("update response set ch2 = ? where survey_id= ? && ques_id = ?");
                result = result+1;
                preparedStatement.setInt(1, result);
                preparedStatement.setInt(2, surveyID);
                preparedStatement.setInt(3, questionID);
                result = preparedStatement.executeUpdate();


            }else if(choice == 3){
                result = resultSet.getInt(3);
                preparedStatement=connection.prepareStatement("update response set ch3 = ? where survey_id = ? && ques_id = ?");
                result = result+1;
                preparedStatement.setInt(1, result);
                preparedStatement.setInt(2, surveyID);
                preparedStatement.setInt(3, questionID);
                result = preparedStatement.executeUpdate();


            }else{
                result = resultSet.getInt(4);
                preparedStatement=connection.prepareStatement("update response set ch4 = ? where survey_id = ? && ques_id = ?");
                result = result+1;
                preparedStatement.setInt(1, result);
                preparedStatement.setInt(2, surveyID);
                preparedStatement.setInt(3, questionID);
                result = preparedStatement.executeUpdate();

            }}


        }catch(SQLException se){
            System.out.print(se);
        }

        return result;
    }

    public int deleteResponseDAO(int questionId) {
        try {
            preparedStatement = connection.prepareStatement("Delete from response where ques_id=? ");
            preparedStatement.setInt(1,questionId);
            result= preparedStatement.executeUpdate();

        }catch(SQLException se) {
            System.out.println(se);
        }
        return result;
    }

    public Choices reportGeneration(int surveyid, int questionID){
        Choices choices  = new Choices();

        try{

            preparedStatement=connection.prepareStatement("select ch1,ch2,ch3,ch4 from response where survey_id=? AND ques_id=?");
            preparedStatement.setInt(1,surveyid);
            preparedStatement.setInt(2, questionID);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
                float choice1 = resultSet.getInt(1);
                float choice2 = resultSet.getInt(2);
                float choice3 = resultSet.getInt(3);
                float choice4 = resultSet.getInt(4);
                float f = choice1 + choice2 + choice3 + choice4;
                choice1 = (choice1 / f) * 100;
                choice2 = (choice2 / f) * 100;
                choice3 = (choice3 / f) * 100;
                choice4 = (choice4 / f) * 100;

                choices.setChoice1(choice1);
                choices.setChoice2(choice2);
                choices.setChoice3(choice3);
                choices.setChoice4(choice4);
            }
        }catch(SQLException se){System.out.print(se);}
        return choices;
    }
}
