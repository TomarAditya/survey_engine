package com.view;

import java.awt.event.*;
import javax.swing.*;  

public class AdminWorkArea {  
	
	public void add() {  
		
		JFrame frame=new JFrame("Admin WorkArea");  

		
	    JLabel label1,label2,label3;  
	    label1=new JLabel("Create/Edit Survey");  
	    label1.setBounds(50,50, 200,30);  
	    label2=new JLabel("Add/View Users");  
	    label2.setBounds(50,150, 200,30);  
	    label3=new JLabel("Report Generation");  
	    label3.setBounds(50,250, 200,30);  

	    frame.add(label1); frame.add(label2);frame.add(label3);  
	    
	    
	    JButton button1=new JButton("Survey Related");  
	    JButton button2=new JButton("Users Related");  
	    JButton button3=new JButton("Report Related"); 
	    JButton button4=new JButton("Logout"); 

	    
	    button1.setBounds(250,50,195,30);
	    button2.setBounds(250,150,195,30);
	    button3.setBounds(250,250,195,30);
	    button4.setBounds(250,350,195,30);

	    button2.setVisible(false);
	    label2.setVisible(false);

	    button1.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent actionEvent){
		    	SurveyEditPage surveyEditPage = new SurveyEditPage();
		    	surveyEditPage.add();
		    	frame.dispose();
		    }  
	    });
		button2.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent actionEvent){
		
		    }  
	    });
		button3.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent actionEvent){
				String name = JOptionPane.showInputDialog(null,"Enter Your SurveyId");
				if(name!=null){
					ReportGeneration reportGeneration;
					reportGeneration = new ReportGeneration();
					reportGeneration.view(Integer.parseInt(name));
		    	}
		    }
	    });
	    button4.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent actionEvent){  
		            AdminLoginPage adminLoginPage= new AdminLoginPage();
		            adminLoginPage.add();
		            frame.dispose();
		    }  
	    });

	    frame.add(button1);frame.add(button2);frame.add(button3);frame.add(button4);
		frame.setSize(800,600);
		frame.setLayout(null);
	    frame.setVisible(true);   
	}

	public static void main(String[] args) {
		AdminWorkArea adminWorkArea = new AdminWorkArea();
		adminWorkArea.add();
	}
}