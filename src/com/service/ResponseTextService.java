package com.service;

import com.dao.ResponseTextDao;

/**
 * Created by Zeo Dragoneel on 12-07-2017.
 */
public class ResponseTextService {
    ResponseTextDao responseTextDao;

    public ResponseTextService() {
        responseTextDao = new ResponseTextDao();
    }

    public int addResponseText(int surveyID,int quesID,int userID,String answer) {
	return responseTextDao.addResponseText(surveyID,quesID,userID,answer);
    }

}
