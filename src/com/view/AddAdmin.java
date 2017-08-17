package com.view;
import java.awt.event.*;  
import javax.swing.*;  
import com.model.*;
import com.service.*;

public class AddAdmin {  

	public void add(){
		
		JFrame frame=new JFrame("SuperAdmin(Add Admin)");

		JLabel label1=new JLabel("Admin ID");
		JLabel label2=new JLabel("Admin Name");
		JLabel label3=new JLabel("Admin Password");
		JLabel label4=new JLabel("Confirm Password");
		JButton button1=new JButton("Add");
		JButton button2=new JButton("Cancel");

		final JTextField textField1 = new JTextField();
		final JTextField textField2 = new JTextField();
		JPasswordField passwordField1 = new JPasswordField();
		JPasswordField passwordField2 = new JPasswordField();

		textField1.setBounds(300,50, 100,30);
		textField2.setBounds(300,150, 100,30);
		passwordField1.setBounds(300,250, 100,30);
		passwordField2.setBounds(300,350, 100,30);

		label1.setBounds(50,50, 200,30);
		label2.setBounds(50,150, 200,30);
		label3.setBounds(50,250, 200,30);
		label4.setBounds(50,350, 200,30);

		button1.setBounds(250,500,95,30);
	    button2.setBounds(450,500,95,30);

	    button1.addActionListener(new ActionListener(){  
	    
	    public void actionPerformed(ActionEvent actionEvent){
	    	
	    	Admin admin=new Admin();
		  	  
		  	  admin.setId(Integer.parseInt(textField1.getText()));
		  	  admin.setName(textField2.getText());
		  	  admin.setPassword(passwordField1.getText());
		  	  
		  	  AdminService adminService = new AdminService();
		  	  int x= adminService.addAdminService(admin);
	           frame.dispose();
	        }  
	    });
	    button2.addActionListener(new ActionListener(){  
		    
		    public void actionPerformed(ActionEvent actionEvent){
		    
		    	WelcomePage welcomePage= new WelcomePage();
		    	welcomePage.add();
		    	frame.dispose();
		
		        }  
		    });

		frame.add(textField1);
		frame.add(textField2);
		frame.add(passwordField1);
		frame.add(passwordField2);
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
        frame.add(button1);
        frame.add(button2);
		frame.setSize(800,600);
		frame.setLayout(null);
	    frame.setVisible(true);   
	} 
}
 