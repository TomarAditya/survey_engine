package com.view;
import java.awt.event.*;  
import javax.swing.*;

import com.model.User;
import com.service.*;

public class UserSignUpPage {
	UserService userService;

	public void add() {

		JFrame frame=new JFrame("User SignUp");
		JLabel label1,label2,label3,label4,label5,label6,label7;
		JButton button1=new JButton("Submit");
		JButton button2=new JButton("Cancel");

		final JTextField textField1=new JTextField();
		final JTextField textField2=new JTextField();
		final JTextField textField3=new JTextField();
		final JTextField textField4=new JTextField();
		final JPasswordField passwordField1 = new JPasswordField();
		final JPasswordField passwordField2 = new JPasswordField();
		final JTextField textField7=new JTextField();

		textField1.setBounds(300,50, 100,30);
		textField2.setBounds(300,100, 100,30);
		textField3.setBounds(300,150, 100,30);
		textField4.setBounds(300,200, 100,30);
		passwordField1.setBounds(300,250, 100,30);
		passwordField2.setBounds(300,300, 100,30);
		textField7.setBounds(300,350, 100,30);

		frame.add(textField1);
		frame.add(textField2);
		frame.add(textField3);
		frame.add(textField4);
		frame.add(passwordField1);
		frame.add(passwordField2);
		frame.add(textField7);

		label1=new JLabel("UserID");
		label1.setBounds(50,50, 100,30);
		label2=new JLabel("First Name");
		label2.setBounds(50,100, 100,30);
		label3=new JLabel("Last Name");
		label3.setBounds(50,150, 100,30);
		label4=new JLabel("Age");
		label4.setBounds(50,200, 100,30);
		label5=new JLabel("Password");
		label5.setBounds(50,250, 100,30);
		label6=new JLabel("Confrim Password");
		label6.setBounds(50,300, 200,30);
		label7=new JLabel("Gender");
		label7.setBounds(50,350, 100,30);


		button1.setBounds(50,400,95,30);
		button2.setBounds(150,400,95,30);

	    button1.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent actionEvent){

		    	User m = new User();
		    	m.setUserID(Integer.parseInt(textField1.getText()));
		    	m.setFirstName(textField2.getText());
		    	m.setLastName(textField3.getText());
		    	m.setAge(Integer.parseInt(textField4.getText()));
		    	m.setPassword(passwordField1.getText());
		    	m.setGender(textField7.getText());

		    	userService = new UserService();
		    	if(userService.addUserService(m) != 0){
		    		UserLoginPage usp = new UserLoginPage();
		    		usp.add();
		    		frame.dispose();
		    	}
		    }
	    });

		button2.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent actionEvent){
		           UserLoginPage usp = new UserLoginPage();
		           usp.add();
		           frame.dispose();
		    }
	    });

		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
		frame.add(label6);
		frame.add(label7);
		frame.add(button1);frame.add(button2);
		frame.setSize(800,600);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}  