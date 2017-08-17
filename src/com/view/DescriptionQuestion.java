package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.model.Question;
import com.service.*;

public class DescriptionQuestion {

	QuestionService questionService;
	ResponseService responseService;

	int localquestionID;

	public void add(int surveyID,int questionID){

		JFrame frame=new JFrame("Add Descriptive Question");
		JTextArea textArea = new JTextArea("Questions Goes Here !");
		JButton button1 = new JButton("Add");
		JButton button2 = new JButton("Done");
		JLabel label1 = new JLabel("Add Question Statement");

		label1.setBounds(50,50, 200,30);
		textArea.setBounds(200,50, 400,150);

		button1.setBounds(350,250,95,30);
		button2.setBounds(450,500,95,30);

        button1.addActionListener(new ActionListener(){

    public void actionPerformed(ActionEvent actionEvent){

		Question question=new Question();
 	    question.setId(questionID);
 	    question.setSurveyId(surveyID);
 	    question.setText(textArea.getText());
 	    question.setChoice1(null);
 	    question.setChoice2(null);
 	    question.setChoice3(null);
 	    question.setChoice4(null);
 	    question.setQuestionType(3);

 	    questionService = new QuestionService();
 	    responseService = new ResponseService();
 	    if(questionService.addQuestion(question)==1) {
			if (responseService.addResponse(3, surveyID, questionID) == 1)
				JOptionPane.showMessageDialog(null, "Your question with id " + (questionID) + " has been added from the survey.");
		}
	}
    });
		button2.addActionListener(new ActionListener(){

	    public void actionPerformed(ActionEvent actionEvent){

	    	EditSurveyPage1 editSurveyPage1= new EditSurveyPage1();
	    	editSurveyPage1.add(surveyID);
	    	frame.dispose();
	    }
	    });

		frame.add(label1);
		frame.add(textArea);
		frame.add(button1);
    	frame.add(button2);
		frame.setSize(800,600);
		frame.setLayout(null);
    	frame.setVisible(true);

}
}
