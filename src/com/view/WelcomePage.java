package com.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;  

public class WelcomePage {  
	
	public URL url;
	
	public void add() {
		JFrame frame=new JFrame("Button Example");
		
		try {
			this.url = new URL("http://res.cloudinary.com/buildi/image/upload/e_blur:444/v1502923517/survey_nfb1eg.png");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Color custom = Color.decode("#ffffff");
		Color customButton = Color.decode("#2566a7");
				
		//frame.getContentPane().setBackground(custom);
		
		 try {
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(url))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    JLabel jLabel;
	    jLabel = new JLabel("Welcome To YMCA Survey");
	    //JLabel textLabel = new JLabel("<html><span style='font-size:20px'>"+Text+"</span></html>");
	    jLabel.setFont(new Font("Serif", Font.PLAIN, 44));
	    jLabel.setForeground(customButton);
	   
	        
	    jLabel.setBounds(100,80, 600,80);
	    
	    jLabel.setHorizontalAlignment(JLabel.CENTER);
	    
	    frame.add(jLabel);
	    
	    
	    JButton button1=new JButton("Login as USER");
	    button1.setFont(new Font("Lato", Font.BOLD, 16));
	    JButton button2=new JButton("Login as ADMIN");
	    button2.setFont(new Font("Lato", Font.BOLD, 16));
	    
	    button1.setBounds(130,330,200,50);
	    button2.setBounds(480,330,200,50);	    
	   
	    button1.setFocusPainted(false);
	    button1.setBackground(custom);
    	button1.setForeground(customButton);
    	button2.setFocusPainted(false);
	    button2.setBackground(custom);
    	button2.setForeground(customButton);
	   	     
	    button1.setBorder(new RoundedBorder(10));
	    button2.setBorder(new RoundedBorder(10));
	    
//	    hover effect	    
	    button1.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	        	ToolTipManager.sharedInstance().setInitialDelay(2000);
	        	button1.setBackground(customButton);	        	
	        	button1.setForeground(Color.white);	
	        	//button1.setBorder( BorderFactory.createBevelBorder( BevelBorder.RAISED, customButton, Color.gray ) );
	       }

	        public void mouseExited(java.awt.event.MouseEvent evt) {
	        	button1.setBackground(custom);
	        	button1.setForeground(customButton);
	        }
	    });
	    
	    button2.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {	        	 
	        	button2.setBackground(customButton);	        	
	        	button2.setForeground(Color.white);	     
	       }

	        public void mouseExited(java.awt.event.MouseEvent evt) {
	        	button2.setBackground(custom);
	        	button2.setForeground(customButton);
	        }
	    });
	    
//	    ends effect
	    
	    button2.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent actionEvent){
	    		AdminLoginPage adminLoginPage = new AdminLoginPage();
	    		adminLoginPage.add();
	    		frame.dispose();
	    	}  
	    });
	    button1.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent actionEvent){
	    		UserLoginPage userLoginPage = new UserLoginPage();
	    		userLoginPage.add();
	    		frame.dispose();
	    	}  
	    });

	    frame.add(button1);
	    frame.add(button2);
	    
	    frame.setSize(800,600);  
	    frame.setLayout(null);  
	    frame.setVisible(true);   
	}

	public static void main(String[] args) {
		WelcomePage welcomePage = new WelcomePage();
		welcomePage.add();
	}
}  