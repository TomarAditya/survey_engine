package com.service;

import com.dao.AdminDao;
import com.dao.QuestionDao;
import com.model.Question;

import java.util.ArrayList;


public class QuestionService {

    QuestionDao questionDao;

    public QuestionService() {
        questionDao=new QuestionDao();

    }

	public int addQuestion(Question question)
	{
		return questionDao.insertQuestion(question);
	}

	public int updateQuestionService(Question question){
    	return questionDao.updateQuestion(question); }

	public ArrayList<Question> viewQuestionService(int surveyid){
		return questionDao.viewQuestion(surveyid);
	}

	public int deleteQuestionService(int questionId) {
		return questionDao.deleteQuestionDAO(questionId);
	}

	public int maxQuesService() {
		System.out.println(questionDao.maxQuesDAO());
		return questionDao.maxQuesDAO();
	}
}
