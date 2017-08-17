package com.view;
import java.awt.event.*;  
import javax.swing.*;  

public class UserWorkArea {  
	
	public void add(int userId) {  
		
		JFrame frame=new JFrame("User WorkArea");
		JLabel label;
		final JTextField textField = new JTextField();
		JButton button1=new JButton("Start Survey");
		JButton button2=new JButton("Cancel");

		textField.setBounds(300,50, 200,30);

		label=new JLabel("Enter SurveyID to give Survey");
		label.setBounds(50,50, 200,30);

		button1.setBounds(50,100,195,30);
		button2.setBounds(350,100,195,30);

	    button1.addActionListener(new ActionListener(){

	    public void actionPerformed(ActionEvent actionEvent){
	    	ViewQuestionUser p=new ViewQuestionUser();
	    	p.view(Integer.parseInt(textField.getText()), userId);
	    	frame.dispose();
	        }
	    });
		button2.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent actionEvent){
				UserLoginPage userLoginPage = new UserLoginPage();
				userLoginPage.add();
				frame.dispose();
			}
		});

		frame.add(textField);
		frame.add(label);
		frame.add(button1);frame.add(button2);
		frame.setSize(800,600);
		frame.setLayout(null);
	    frame.setVisible(true);   
	}

}  
