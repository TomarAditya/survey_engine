package com.service;

import com.dao.ResponseDao;
import com.model.Choices;

/**
 * Created by Zeo Dragoneel on 12-07-2017.
 */
public class ResponseService {
    ResponseDao responseDao;

    public ResponseService(){
        responseDao = new ResponseDao();
    }

    public Choices reportGeneration(int surveyID, int quesID)
    {
        return responseDao.reportGeneration(surveyID, quesID);
    }

    public int deleteResponseService(int questionID) {
        return responseDao.deleteResponseDAO(questionID);
    }

    public int addResponse(int choice,int surveyID, int quesID) {
        return responseDao.insertResponse(choice, surveyID, quesID);
    }

    public int addChoiceService(int choice,int surveyID, int questionID) {
        return responseDao.addChoice(choice, surveyID, questionID);
    }
}
