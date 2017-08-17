package com.view;
import java.awt.event.*;  
import javax.swing.*;

import com.model.Question;
import com.service.*;

public class MultipleChoiceQuestions {

	AdminService adminService;
	QuestionService questionService;
	ResponseService responseService;
	int localQuestionID,s;
	
	public int add(int surveyID,int questionID) {

		localQuestionID=questionID;

		JFrame frame=new JFrame("Add MCQs");
		JButton button1=new JButton("Add");
		JButton button2=new JButton("Done");
		JTextArea textArea = new JTextArea("Questions Goes Here !");
		final JTextField textField1 = new JTextField();
		final JTextField textField2 = new JTextField();
		final JTextField textField3 = new JTextField();
		final JTextField textField4 = new JTextField();
		JLabel label1,label2,label3,label4,label5,label6;

		textArea.setBounds(200,50, 400,150);

		textField1.setBounds(200,250, 200,30);
		textField2.setBounds(200,300, 200,30);
		textField3.setBounds(200,350, 200,30);
		textField4.setBounds(200,400, 200,30);

		label1=new JLabel("Add Question Statement");
		label1.setBounds(50,50, 200,30);
		label2=new JLabel("Add Options :");
		label2.setBounds(50,210, 100,30);
		label3=new JLabel("Choice 1 :");
		label3.setBounds(50,250, 100,30);
		label4=new JLabel("Choice 2 :");
		label4.setBounds(50,300, 100,30);
		label5=new JLabel("Choice 3 :");
		label5.setBounds(50,350, 100,30);
		label6=new JLabel("Choice 4 :");
		label6.setBounds(50,400, 100,30);

		button2.setBounds(450,500,95,30);
		button1.setBounds(350,500,95,30);

	    button1.addActionListener(new ActionListener(){

	    public void actionPerformed(ActionEvent actionEvent) {
			Question question = new Question();
			question.setId(localQuestionID);
			question.setSurveyId(surveyID);
			question.setText(textArea.getText());
			question.setChoice1(textField1.getText());
			question.setChoice2(textField2.getText());
			question.setChoice3(textField3.getText());
			question.setChoice4(textField4.getText());
			question.setQuestionType(1);

			questionService = new QuestionService();
			responseService = new ResponseService();

			if(questionService.addQuestion(question)==1) {
				if (responseService.addResponse(1, surveyID, questionID) == 1)
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

		frame.add(button1);
		frame.add(button2);
		frame.add(textArea);
		frame.add(textField1);
		frame.add(textField2);
		frame.add(textField3);
		frame.add(textField4);
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
		frame.add(label6);

		frame.setSize(800,600);
		frame.setLayout(null);
		frame.setVisible(true);

	    return s;
	}  
}