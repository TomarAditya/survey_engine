package com.view;
import java.awt.event.*;  
import javax.swing.*;

import com.model.User;
import com.service.*;

public class UserLoginPage {

	UserService userService;
	
	public  void add() {  
		
		JFrame frame=new JFrame("User Login");
		final JTextField textField = new JTextField();
		JPasswordField passwordField = new JPasswordField();
		JLabel label1,label2,label3;
		JButton button1=new JButton("Submit");
		JButton button2=new JButton("Cancel");
		JButton button3=new JButton("Signup !");


		textField.setBounds(150,50, 100,30);
		passwordField.setBounds(150,100, 100,30);

		label1=new JLabel("UserName");
		label1.setBounds(50,50, 100,30);
		label2=new JLabel("Password");
		label2.setBounds(50,100, 100,30);
		label3=new JLabel("New User? Signup !");
		label3.setBounds(500,50, 200,30);

        button1.setBounds(50,200,95,30);
		button2.setBounds(150,200,95,30);
		button3.setBounds(500,150,95,30);

		button1.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	            
	    		User user = new User();
	    		user.setUserID(Integer.parseInt(textField.getText()));
	    		user.setPassword(passwordField.getText());
	    		int userId=Integer.parseInt(textField.getText());
	    		 userService = new UserService();
	    		if(userService.searchUserService(user)){
	    			UserWorkArea userWorkArea = new UserWorkArea();
	    			userWorkArea.add(userId);
	    			frame.dispose();
	    		}
	        }  
	    });
		button2.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		WelcomePage welcomePage = new WelcomePage();
	    		welcomePage.add();
	    		frame.dispose();
	    	}  
	    });
		button3.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	            UserSignUpPage userSignUpPage = new UserSignUpPage();
	            userSignUpPage.add();
	            frame.dispose();
	        }  
	    });

		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(button1);frame.add(button2);frame.add(button3);
		frame.add(textField);frame.add(passwordField);

		frame.setSize(800,600);
		frame.setLayout(null);
		frame.setVisible(true);
	}  
}  