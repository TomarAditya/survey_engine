package com.view;

import java.util.ArrayList;
import java.awt.event.*;

import javax.swing.*;

import com.model.Question;
import com.service.*;

public class ViewQuestionUser {

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
	JButton button2,button1;
	ButtonGroup buttonGroup = new ButtonGroup();
	ArrayList<Question> questionList= new ArrayList<Question>();
	UserWorkArea userWorkArea;
	int localUserId,x,i=0,count=0,z=0;
	String text;


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
		
	    JButton button1=new JButton("Next");
        button1.setBounds(50,400, 90, 30);
		button1.setEnabled(false);
		JButton button2= Submit();
		button2.setEnabled(false);
        
		frame.getContentPane().add(button1);
		frame.getContentPane().add(button2);
        
		if (count==x) {
			button2.setVisible(true);
			button1.setVisible(false);
			i=1;
		}
		
		radioButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				button1.setEnabled(true);
				button2.setEnabled(true);
			}
		});
		radioButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				button1.setEnabled(true);
				button2.setEnabled(true);
			}
		});
		radioButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				button1.setEnabled(true);
				button2.setEnabled(true);
			}
		});
		radioButton4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				button1.setEnabled(true);
				button2.setEnabled(true);
			}
		});

		button1.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent actionEvent){
				responseService = new ResponseService();
    	    	if(radioButton1.isSelected()){
					   responseService.addChoiceService(1, question.getSurveyId(), question.getId());
				} else if(radioButton2.isSelected()){
		        	   responseService.addChoiceService(2, question.getSurveyId(), question.getId());
    	    	} else if(radioButton3.isSelected()){
		        	   responseService.addChoiceService(3, question.getSurveyId(), question.getId());
				} else{
		        	   responseService.addChoiceService(4, question.getSurveyId(), question.getId());
				}

    	    	frame.dispose();
				view(question.getSurveyId(), localUserId);
			}
		});
		
		button2.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e){
				  userWorkArea = new UserWorkArea();
				  userWorkArea.add(localUserId);
				  JOptionPane.showMessageDialog(null,"Thanks for your time and input!");
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
        buttonGroup.add(radioButton1);buttonGroup.add(radioButton2);

        frame.setSize(800,600);
	    frame.getContentPane().setLayout(null);  
	    frame.setVisible(true);   

	    button1=new JButton("Next");
        button1.setBounds(50,400, 90, 30);
        button1.setEnabled(false);
        JButton button2=Submit();
		button2.setEnabled(false);

		frame.getContentPane().add(button1);
		frame.getContentPane().add(button2);

		if (count==x) {
			button2.setVisible(true);
			button1.setVisible(false);
			i = 1;
		}
		radioButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				button1.setEnabled(true);
				button2.setEnabled(true);
			}
		});
		radioButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				button1.setEnabled(true);
				button2.setEnabled(true);
			}
		});

		button1.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent actionEvent){
				responseService = new ResponseService();
    	    	if(radioButton1.isSelected()){
					    responseService.addChoiceService(1, question.getSurveyId(), question.getId());
		           }
		           else{
					    responseService.addChoiceService(2, question.getSurveyId(), question.getId());
    	    	}
                frame.dispose();
    	    	view(question.getSurveyId(), localUserId);
                }
    	    });
		button2.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
				if(radioButton1.isSelected()){
					responseService = new ResponseService();
				  if(responseService.addChoiceService(1, question.getSurveyId(), question.getId())==1){
					userWorkArea = new UserWorkArea();
					userWorkArea.add(localUserId);
					JOptionPane.showMessageDialog(null,"Thanks for your time and input!");
					frame.dispose();
				}
				}
				else{
					 responseService = new ResponseService();
					if(responseService.addChoiceService(2, question.getSurveyId(), question.getId())==1){
						userWorkArea = new UserWorkArea();
						userWorkArea.add(localUserId);
						JOptionPane.showMessageDialog(null,"Thanks for your time and input!");
						frame.dispose();
					}
				}

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

        JButton button1=new JButton("Next");
        button1.setBounds(50,400, 90, 30);
        JButton button2 = Submit();

        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);

        if (count==x) {
			button2.setVisible(true);
			button1.setVisible(false);
			i=1;
		}

        button1.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent actionEvent){
    	    	text=textArea.getText();
                System.out.println(text);
                if(text.length()>0){
                    responseTextService = new ResponseTextService();
    	    	    responseTextService.addResponseText(question.getSurveyId(),question.getId(),localUserId,text);
					frame.dispose();
					view(question.getSurveyId(), localUserId);
				}else{
                    JOptionPane.showMessageDialog(null,"Please! provide some response.");
				}
    	        }
    	    });
        
        button2.addActionListener(new ActionListener(){
    	    public void actionPerformed(ActionEvent e){
                text=textArea.getText();
                System.out.println(text);
                if(text.length()>0){
    	    	    responseTextService = new ResponseTextService();
                    responseTextService.addResponseText(question.getSurveyId(),question.getId(),localUserId,text);
                    frame.dispose();
                    userWorkArea = new UserWorkArea();
                    userWorkArea.add(localUserId);
                    JOptionPane.showMessageDialog(null,"Thanks for your time and input!");
                    frame.dispose();
                }else {
                    JOptionPane.showMessageDialog(null, "Please! provide some response.");
                }

    	    	}
    	    });
}
	public void view(int surveyID, int userID){
         localUserId = userID;
		questionService = new QuestionService();
		 questionList=questionService.viewQuestionService(surveyID);
		 x=questionList.size()-1;
		 questions = questionList.toArray(new Question[100]);

		 if(questionList.size()!=count)
		{	if(questions[count].getQuestionType() == 1){
				addMcq(questions[count]);
			}else if(questions[count].getQuestionType() == 2){
				addYesNo(questions[count]);
			}else{
				addDesc(questions[count]);
			}
			count++;
		} else{
			System.exit(0);
		}
	}
	public JButton Submit() {
		button2 = new JButton("Submit");
		button2.setBounds(50, 400, 90, 30);
		if(i==0)
		{button2.setVisible(false);}
		return button2;
	}

}