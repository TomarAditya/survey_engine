package com.view;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.*;

import com.model.Survey;
import com.service.*;

public class SurveyEditPage {

	AdminService adminService;
	QuestionService questionService;
	ResponseService responseService;
	ResponseTextService responseTextService;
	SuperAdminService superAdminService;
	SurveyService surveyService;
	UserService userService;
	
	public  void add() {  
		
		JFrame frame=new JFrame("Survey Edit");
		JLabel label;
		JButton button1=new JButton("Create New Survey");
		JButton button2=new JButton("Edit Survey");
		JButton button3=new JButton("Cancel");
		final JTextField textField=new JTextField();

		textField.setBounds(150,250, 100,30);
		
		int min=100000,max=1239420;
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);

		label=new JLabel("Enter Survey ID");
		label.setBounds(50,250, 100,30);

		button1.setBounds(50,100,195,30);
		button2.setBounds(50,300,195,30);
		button3.setBounds(300,300,195,30);
	    
	    button1.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent actionEvent){
		    	String name = JOptionPane.showInputDialog(null,"Enter Your Survey Name");
		    	if(name!=null){

		    	Survey survey = new Survey();
		    	surveyService = new SurveyService();

		    	survey.setSurveyID(randomNum);
		    	survey.setSurveyName(name);
		    	surveyService.addSurvey(survey);

		    	JOptionPane.showMessageDialog(null,"Your SurveyID is "+randomNum+" ");
		    	}
		    }  
	    });
		button2.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent actionEvent){
		     EditSurveyPage1 editSurveyPage1 = new EditSurveyPage1();
		     editSurveyPage1.add(Integer.parseInt(textField.getText()));
		     frame.dispose();
		    }  
	    });
		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				AdminWorkArea adminWorkArea = new AdminWorkArea();
				adminWorkArea.add();
				frame.dispose();
			}
		});

		frame.add(textField);
		frame.add(label);
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);

		frame.setSize(800,600);
		frame.setLayout(null);
	    frame.setVisible(true);   
	}
	
}  