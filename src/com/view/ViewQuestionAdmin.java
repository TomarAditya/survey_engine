package com.view;

import java.util.ArrayList;
import java.awt.event.*;

import javax.swing.*;

import com.model.Question;
import com.model.Question;
import com.service.*;

public class ViewQuestionAdmin {
	AdminService adminService;
	QuestionService questionService;
	ResponseService responseService;
	ResponseTextService responseTextService;
	SuperAdminService superAdminService;
	SurveyService surveyService;
	UserService userService;

	Question[] questions;
	JFrame frame; 
	JLabel label;
	JRadioButton radioButton1,radioButton2,radioButton3,radioButton4;
	JButton button1,button2;
	ButtonGroup buttonGroup = new ButtonGroup();
	ArrayList<Question> questionList = new ArrayList<Question>();
	int x,i=0,count=0, localSurveyID;
	
	
	
	public void addMcq(Question question){
		frame = new JFrame("Question");
		
		label = new JLabel(question.getText());
		label.setBounds(50, 50, 500, 90);
		frame.getContentPane().add(label);
		
		radioButton1 = new JRadioButton(question.getChoice1());
        radioButton2 = new JRadioButton(question.getChoice2());
        radioButton3 = new JRadioButton(question.getChoice3());
        radioButton4 = new JRadioButton(question.getChoice4());
        
        radioButton1.setBounds(50,150,200,20);
        radioButton2.setBounds(50,200,200,20);
        radioButton3.setBounds(50,250,200,20);
        radioButton4.setBounds(50,300,200,20);
        
        frame.getContentPane().add(radioButton1);
        frame.getContentPane().add(radioButton2);
		frame.getContentPane().add(radioButton3);
		frame.getContentPane().add(radioButton4);
        
		buttonGroup.add(radioButton1);
		buttonGroup.add(radioButton2);
		buttonGroup.add(radioButton3);
		buttonGroup.add(radioButton4);
	    
		frame.setSize(800,600); 
	    frame.setLayout(null);
	    frame.setVisible(true);
		
	    button2=new JButton("Next");
        button2.setBounds(150,400, 90, 30);
        JButton button1=Back();
        frame.getContentPane().add(button2);frame.getContentPane().add(button1);
		
        if (count==x) {
			button1.setVisible(true);
			button2.setVisible(false);
			i=1;
		}
		button2.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent actionEvent){
    	    	frame.dispose();
    	    	view(question.getSurveyId());
			}  
    	    });
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent){
				EditSurveyPage1 editSurveyPage1 = new EditSurveyPage1();
				editSurveyPage1.add(localSurveyID);
				frame.dispose();
			}
		});
	}
	
	public void addYesNo(Question question){
		frame = new JFrame("Questions");
		
		label = new JLabel(question.getText());
		label.setBounds(50, 50, 500, 90);
		frame.getContentPane().add(label);  
        
		radioButton1 = new JRadioButton("Yes");
        radioButton2 = new JRadioButton("No");
        radioButton1.setBounds(50,150,100,20);  
        radioButton2.setBounds(50,200,100,20);  
        
        frame.getContentPane().add(radioButton1);
        frame.getContentPane().add(radioButton2);
        
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
	    
        frame.setSize(800,600);  
	    frame.getContentPane().setLayout(null);  
	    frame.setVisible(true);   
		
	    button2=new JButton("Next");
        button2.setBounds(150,400, 90, 30);
		JButton button1=Back();
		frame.getContentPane().add(button2);frame.getContentPane().add(button1);
		
		if (count==x) {
			button1.setVisible(true);
			button2.setVisible(false);
			i=1;
		}
        button2.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent actionEvent){
    	    	frame.dispose();
    	    	view(question.getSurveyId());
			}
    	    });
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent){
				EditSurveyPage1 editSurveyPage1 = new EditSurveyPage1();
				editSurveyPage1.add(localSurveyID);
				frame.dispose();
			}
		});

	}
	
	public void addDesc(Question question){
		frame = new JFrame("Questions");
		
		label = new JLabel(question.getText());
		label.setBounds(50, 50, 500, 90);
		frame.getContentPane().add(label);
		
		JTextArea textArea = new JTextArea("");  
        textArea.setBounds(50,100, 400,150); 
        
        frame.getContentPane().add(textArea);
        frame.setSize(800,600);  
	    frame.getContentPane().setLayout(null);  
	    frame.setVisible(true);
        
	    button2=new JButton("Next");
        button2.setBounds(150,400, 90, 30);
		JButton button1=Back();
		frame.getContentPane().add(button2);frame.getContentPane().add(button1);
		
		if (count==x) {
			button1.setVisible(true);
			button2.setVisible(false);
			i=1;
		}
        
		button2.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent actionEvent){
    	    	  frame.dispose();
                  view(question.getSurveyId());
    	        }  
    	    });
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent actionEvent){
				EditSurveyPage1 editSurveyPage1 = new EditSurveyPage1();
				editSurveyPage1.add(localSurveyID);
				frame.dispose();
			}
		});
	}

	public void view(int surveyID) {
		localSurveyID = surveyID;

		questionService = new QuestionService();
		questionList = questionService.viewQuestionService(surveyID);
		x=questionList.size()-1;
		questions = questionList.toArray(new Question[100]);

		if (questionList.size() != count) {
			if (questions[count].getQuestionType() == 1) {
				addMcq(questions[count]);
			} else if (questions[count].getQuestionType() == 2) {
				addYesNo(questions[count]);
			} else {
				addDesc(questions[count]);
			}
			count++;
		} else {
			System.exit(0);
		}
	}

	public JButton Back() {
			button1 = new JButton("Back to Edit");
			button1.setBounds(50, 400, 90, 30);
			if(i==0)
			{button1.setVisible(false);}
			return button1;
		}
	
}