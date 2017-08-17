package com.service;

import com.dao.ResponseTextDao;


public class ResponseTextService {
    ResponseTextDao responseTextDao;

    public ResponseTextService() {
        responseTextDao = new ResponseTextDao();
    }

    public int addResponseText(int surveyID,int quesID,int userID,String answer) {
	return responseTextDao.addResponseText(surveyID,quesID,userID,answer);
    }

}
