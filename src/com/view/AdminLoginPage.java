package com.view;
import java.awt.event.*;  
import javax.swing.*;

import com.model.Admin;
import com.model.SuperAdmin;
import com.service.AdminService;
import com.service.SuperAdminService;

public class AdminLoginPage {  
	
	public void add() {  
		
		JFrame frame=new JFrame("Admin Login");

		final JTextField textField1=new JTextField();
	
		JPasswordField passwordField1 = new JPasswordField();
		

		JButton button1=new JButton("Submit");
		JButton button2=new JButton("Cancel");
		
		JButton signupButton = new JButton("admin signup");
				

		JLabel label1=new JLabel("AdminId");
		JLabel label2=new JLabel("Password");
	

		label1.setBounds(50,50, 100,30);
		label2.setBounds(50,100, 100,30);
		

		textField1.setBounds(150,50, 100,30);
		passwordField1.setBounds(150,100, 100,30);
		

		button1.setBounds(50,200,95,30);
		button2.setBounds(150,200,95,30);
		
	    signupButton.setBounds(450,250,200,30);

	    button1.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent actionEvent){

		    	Admin admin = new Admin();
				AdminService adminService = new AdminService();

				admin.setId(Integer.parseInt(textField1.getText()));
				admin.setPassword(passwordField1.getText());
				admin.setIdentity(0);

				if(adminService.searchAdminService(admin)){
		    		AdminWorkArea adminWorkArea = new AdminWorkArea();
					adminWorkArea.add();
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
	  
	    
	    signupButton.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		   	    
		    		
		    	AddAdminPage addAdminPage = new AddAdminPage();
				addAdminPage.add();
				frame.dispose();		    	
		    	
		    }  
	    });
	    
	   

		frame.add(label1);
		frame.add(label2);
		

		frame.add(textField1);
		frame.add(passwordField1);
		
	

		frame.add(button1);
		frame.add(button2);
		
		frame.add(signupButton);

		frame.setSize(800,600);
		frame.setLayout(null);
	    frame.setVisible(true);   
	}

}  