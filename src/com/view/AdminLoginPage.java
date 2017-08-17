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
		final JTextField textField3 = new JTextField();
		JPasswordField passwordField1 = new JPasswordField();
		JPasswordField passwordField2 = new JPasswordField();

		JButton button1=new JButton("Submit");
		JButton button2=new JButton("Cancel");
		JButton button3=new JButton("Submit");
		JButton button4=new JButton("Cancel");

		JLabel label1=new JLabel("AdminId");
		JLabel label2=new JLabel("Password");
		JLabel label3=new JLabel("SuperAdminId");
		JLabel label4=new JLabel("Password");

		label1.setBounds(50,50, 100,30);
		label2.setBounds(50,100, 100,30);
		label3.setBounds(350,50, 100,30);
		label4.setBounds(350,100, 100,30);

		textField1.setBounds(150,50, 100,30);
		passwordField1.setBounds(150,100, 100,30);
		textField3.setBounds(550,50, 100,30);
		passwordField2.setBounds(550,100, 100,30);

		button1.setBounds(50,200,95,30);
		button2.setBounds(150,200,95,30);
		button3.setBounds(350,200,95,30);
	    button4.setBounds(450,200,95,30);

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
	    button3.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	
		    	SuperAdmin superAdmin = new SuperAdmin();
		    	superAdmin.setUserName(textField3.getText());
		    	superAdmin.setPassword(passwordField2.getText());

				SuperAdminService superAdminService = new SuperAdminService();
		    	if(superAdminService.searchSuperAdminService(superAdmin)){
		    		
		    		SuperAdminWorkArea superAdminWorkArea = new SuperAdminWorkArea();
		    		superAdminWorkArea.add();
		    		frame.dispose();
		    	}
		    	
		    }  
	    });
	    button4.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	WelcomePage welcomePage = new WelcomePage();
	            welcomePage.add();
	            frame.dispose();
		    }  
	    });

		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);

		frame.add(textField1);
		frame.add(passwordField1);
		frame.add(textField3);
		frame.add(passwordField2);

		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);

		frame.setSize(800,600);
		frame.setLayout(null);
	    frame.setVisible(true);   
	}

}  