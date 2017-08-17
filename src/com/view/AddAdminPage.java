package com.view;
import java.awt.event.*;  
import javax.swing.*;

import com.model.Admin;
import com.service.*;

public class AddAdminPage {

	AdminService adminService;

	public void add() {  
		
		JFrame frame=new JFrame("SuperAdmin(Add Admin)");  
		final JTextField textField1 = new JTextField();  
		final JTextField textField2 = new JTextField();
		JPasswordField textField3 = new JPasswordField();
		JPasswordField textField4 = new JPasswordField();
		final JTextField textField5 = new JTextField();
		JButton button1=new JButton("Add");
		JButton button2=new JButton("Cancel");
		JLabel label1,label2,label3,label4,label5;

		textField1.setBounds(300,50, 100,30);
		textField2.setBounds(300,150, 100,30);
		textField3.setBounds(300,250, 100,30);
		textField4.setBounds(300,350, 100,30);
		textField5.setBounds(300,450, 100,30);

		label1=new JLabel("Admin ID");
		label1.setBounds(50,50, 200,30);
		label2=new JLabel("Admin Name");
		label2.setBounds(50,150, 200,30);
		label3=new JLabel("Admin Password");
		label3.setBounds(50,250, 200,30);
		label4=new JLabel("Confirm Password");
		label4.setBounds(50,350, 200,30);
		label5=new JLabel("Identity (0 - Admin/ 1 - SuperAdmin)");
		label5.setBounds(50,450, 200,30);

        button1.setBounds(50,550,95,30);
		button2.setBounds(250,550,95,30);
	    
	    button1.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent actionEvent){  
	    		
	    		Admin admin = new Admin();
		    	
	    		admin.setId(Integer.parseInt(textField1.getText()));
		    	admin.setName(textField2.getText());
		    	admin.setPassword(textField3.getText());
		    	admin.setIdentity(Integer.parseInt(textField5.getText()));
		    	adminService = new AdminService();
		    	
		    	if(adminService.addAdminService(admin)==1) {
					JOptionPane.showMessageDialog(null, "Admin has been added!");
				}
				
				SuperAdminWorkArea superAdminWorkArea = new SuperAdminWorkArea();
		    	superAdminWorkArea.add();
				
		    	frame.dispose();

	    	}  
	    });
	    button2.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent actionEvent){  
	    		
	    		SuperAdminWorkArea superAdminWorkArea = new SuperAdminWorkArea();
	    		superAdminWorkArea.add();
	    		frame.dispose();
	    	}  
	    });

		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		frame.add(label4);
		frame.add(label5);
		frame.add(textField1);
		frame.add(textField2);
		frame.add(textField3);
		frame.add(textField4);
		frame.add(textField5);
		frame.add(button1);
		frame.add(button2);
		frame.setSize(800,600);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
}