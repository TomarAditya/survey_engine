package com.service;

import com.dao.SurveyDao;
import com.model.Survey;

/**
 * Created by Zeo Dragoneel on 12-07-2017.
 */
public class SurveyService {

    SurveyDao surveyDao;

    public SurveyService(){
        surveyDao = new SurveyDao();
    }

    public int maxQuesService() {
        return surveyDao.maxQuesDAO();
    }

    public int updateSurveyService(Survey survey) {
        return surveyDao.updateSurvey(survey);
    }

    public int addSurvey(Survey survey) {
        System.out.println(survey.getSurveyID()+"    "+survey.getSurveyName());
        return surveyDao.insertSurvey(survey);
    }
}
