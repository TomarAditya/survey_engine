package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.model.Question;
import com.service.*;

public class YesNoQuestions {
	QuestionService questionService;
	ResponseService responseService;
	int localQuestionID;

	public void add(int surveyId,int quesId){
	localQuestionID= quesId;
	JFrame frame=new JFrame("Add Yes/Nos");
	
	JTextArea textArea = new JTextArea("Questions Goes Here !");
    textArea.setBounds(200,50, 400,150);
    frame.add(textArea);
    
    JLabel label1;  
    label1=new JLabel("Add Question Statement");  
    label1.setBounds(50,50, 200,30);  
    frame.add(label1);   
    
    
    JButton button1=new JButton("Add"); 
    JButton button2=new JButton("Done");
    
    
    button1.setBounds(350,250,95,30);
    button2.setBounds(450,500,95,30);

    frame.add(button1);
    frame.add(button2);
    button1.addActionListener(new ActionListener(){  
    
    public void actionPerformed(ActionEvent actionEvent){
    	
    	 Question question=new Question();
 	    question.setId(localQuestionID);
 	    question.setSurveyId(surveyId);
 	    question.setText(textArea.getText());
 	    question.setChoice1("Yes");
 	    question.setChoice2("NO");
 	    question.setChoice3(null);
 	    question.setChoice4(null);
 	    question.setQuestionType(2);

		questionService = new QuestionService();
		responseService = new ResponseService();
 	    if(questionService.addQuestion(question)==1) {
			if (responseService.addResponse(2, surveyId, quesId) == 1)
				JOptionPane.showMessageDialog(null, "Your question with id " + (quesId) + " has been added from the survey.");
		}
        }
    });
    
    button2.addActionListener(new ActionListener(){
	    
	    public void actionPerformed(ActionEvent actionEvent){
	    
	    	EditSurveyPage1 editSurveyPage1= new EditSurveyPage1();
	    	editSurveyPage1.add(surveyId);
	    	frame.dispose();
	        }  
	    });

    frame.setSize(800,600);
    frame.setLayout(null);  
    frame.setVisible(true);   

}
}