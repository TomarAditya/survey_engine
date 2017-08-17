package com.view;
import java.awt.event.*;

import javax.swing.*;

import com.service.*;


public class EditSurveyPage1 {
	AdminService adminService;
	QuestionService questionService;
	ResponseService responseService;
	ResponseTextService responseTextService;
	SuperAdminService superAdminService;
	SurveyService surveyService;
	UserService userService;

	int quesId;
	public void add(int surveyid) {  
		
		JFrame frame=new JFrame("Edit Survey1");  
		
	   final JTextField textField=new JTextField();
		   
	    textField.setBounds(250,350, 100,30);
		questionService  = new QuestionService();

	    quesId=questionService.maxQuesService();



	    frame.add(textField);
	     
	    JLabel label1,label2;
	    label1=new JLabel("Enter Questions");  
	    label1.setBounds(50,100, 300,30);  
	    frame.add(label1);
	    label2=new JLabel("Enter Question ID to Delete");  
	    label2.setBounds(50,350, 300,30);  
	    frame.add(label2); 

	    
	    
	    JRadioButton radioButton1,radioButton2,radioButton3;   
	    ButtonGroup buttonGroup = new ButtonGroup();  
        radioButton1 = new JRadioButton("MCQs");
        radioButton2 = new JRadioButton("Yes/No");
        radioButton3 = new JRadioButton("Descriptive");
        radioButton1.setBounds(50,150,100,20);  
        radioButton2.setBounds(50,200,100,20);  
        radioButton3.setBounds(50,250,100,20);  
        frame.add(radioButton1);frame.add(radioButton2);frame.add(radioButton3);
        buttonGroup.add(radioButton1);buttonGroup.add(radioButton2);buttonGroup.add(radioButton3);
	    JButton button1=new JButton("View Questions");  
	    JButton button2=new JButton("Delete Question");  
	    JButton button3=new JButton("Proceed");
		JButton button4=new JButton("Back");

		button1.setBounds(50,450,195,30);
	    button2.setBounds(450,350,195,30);
	    button3.setBounds(450,250,195,30);
	    button4.setBounds(350,450,195,30);
	    frame.add(button3);frame.add(button4);

	    button2.addActionListener(new ActionListener(){  
	    
	    public void actionPerformed(ActionEvent actionEvent){
			responseService = new ResponseService();
	            if(responseService.deleteResponseService(Integer.parseInt(textField.getText()))==1)
				{
					System.out.println("response deleted!");
					if(questionService.deleteQuestionService(Integer.parseInt(textField.getText()))==1)
				     JOptionPane.showMessageDialog(null,"Your question with id "+textField.getText()+" has been deleted! from the survey.");
				}
	        }  
	    });
	    button3.addActionListener(new ActionListener(){  
		    
		    public void actionPerformed(ActionEvent actionEvent){
		           if(radioButton1.isSelected()){
		        	   MultipleChoiceQuestions multipleChoiceQuestions = new MultipleChoiceQuestions();
		        	   multipleChoiceQuestions.add(surveyid,quesId + 1);

		        	   frame.dispose();
		           }
		           else if(radioButton2.isSelected()){
		        	   YesNoQuestions yesNoQuestions = new YesNoQuestions();
		        	   yesNoQuestions.add(surveyid,quesId + 1);

		        	   frame.dispose();
		           }
		           else{
		        	   DescriptionQuestion descriptionQuestion = new DescriptionQuestion();
		        	   descriptionQuestion.add(surveyid,quesId + 1);

		        	   frame.dispose();
		           }
		        }  
		    });
	    button1.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent actionEvent){
				frame.dispose();
		    	ViewQuestionAdmin viewQuestionAdmin=new ViewQuestionAdmin();
		    	viewQuestionAdmin.view(surveyid);

		    	}
		    });

	    button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				frame.dispose();
				SurveyEditPage surveyEditPage = new SurveyEditPage();
				surveyEditPage.add();
			}
		});
	    
	    frame.add(button1);frame.add(button2);
		frame.setSize(800,600);
		frame.setLayout(null);
	    frame.setVisible(true);
	    
	}

	public static void main(String[] args) {
		EditSurveyPage1 editSurveyPage1 = new EditSurveyPage1();
		editSurveyPage1.add(362381);
	}


}  