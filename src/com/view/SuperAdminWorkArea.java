package com.view;
import java.awt.event.*;  
import javax.swing.*;  

public class SuperAdminWorkArea {  
	
	public  void add() {  
		
		JFrame frame=new JFrame("SuperAdmin");
		JLabel label;
		JButton button1=new JButton("Add");
		JButton button2=new JButton("View");
		JButton button3=new JButton("Logout");
		label=new JLabel("Add New Admin");
		
		label.setBounds(50,50, 200,30);
		
	    button1.setBounds(250,50,95,30);
	    button2.setBounds(250,150,95,30);
	    button3.setBounds(250,250,95,30);

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent){

				AddAdminPage addAdminPage = new AddAdminPage();
				addAdminPage.add();
				frame.dispose();
			}
		});
		button3.addActionListener(new ActionListener() {  
		    public void actionPerformed(ActionEvent actionEvent){  
		            AdminLoginPage adminLoginPage= new AdminLoginPage();
		            adminLoginPage.add();
		            frame.dispose();
		    }  
	    });

	    frame.add(label);
	    frame.add(button1);
	    frame.add(button3);
		frame.setSize(800,600);
		frame.setLayout(null);
	    frame.setVisible(true);   
	}
	
}  