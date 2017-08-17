package com.view;
import java.awt.event.*;  
import javax.swing.*;  

public class UserEditPage {  
	
	public static void main(String[] args) {  
		
		JFrame frame=new JFrame("Admin WorkArea");
		final JTextField textField = new JTextField();
		JLabel label1, label2;
		JButton button1=new JButton("Delete");
		JButton button2=new JButton("View");

		textField.setBounds(50,100, 200,30);

		label1=new JLabel("Enter UserID to Delete");
		label1.setBounds(50,50, 200,30);
		label2=new JLabel("View Users");
		label2.setBounds(50,150, 200,30);

		button1.setBounds(300,100,195,30);
		button2.setBounds(300,150,195,30);
	    
	    button1.addActionListener(new ActionListener(){  
	    
	    public void actionPerformed(ActionEvent actionEvent){  
	            
	        }  
	    });

		frame.add(label1); frame.add(label2);
		frame.add(textField);
		frame.add(button1);frame.add(button2);
		frame.setSize(800,600);
		frame.setLayout(null);
		frame.setVisible(true);
	}  
}  