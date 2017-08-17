package com.view;

import java.util.ArrayList;
import java.awt.event.*;

import javax.swing.*;

import com.model.Choices;
import com.model.Question;
import com.service.*;

public class ReportGeneration {

    QuestionService questionService;
    ResponseService responseService;

    Question[] questions;
    JFrame frame;
    JLabel label1,choice1,choice2,choice3,choice4;
    JLabel radioButton1,radioButton2,radioButton3,radioButton4;
    JButton jButton1,button2;
    ButtonGroup buttonGroup = new ButtonGroup();
    ArrayList<Question> questionList = new ArrayList<Question>();

    int x,i=0,count=0, localSurveyId;
    Choices choices=new Choices();



    public void addMcq(Question question){

        choices=responseService.reportGeneration(question.getSurveyId(),question.getId());

        responseService = new ResponseService();

        frame = new JFrame("Question");

        label1 = new JLabel(question.getText());

        choice1=new JLabel(Float.toString(choices.getChoice1()));
        choice2=new JLabel(Float.toString(choices.getChoice2()));
        choice3=new JLabel(Float.toString(choices.getChoice3()));
        choice4=new JLabel(Float.toString(choices.getChoice4()));

        radioButton1 = new JLabel(question.getChoice1());
        radioButton2 = new JLabel(question.getChoice2());
        radioButton3 = new JLabel(question.getChoice3());
        radioButton4 = new JLabel(question.getChoice4());

        button2=new JButton("Next");
        JButton button1=Back();

        label1.setBounds(50, 50, 500, 90);

        choice1.setBounds(200,150,100,20);
        choice2.setBounds(200,200,100,20);
        choice3.setBounds(200,250,100,20);
        choice4.setBounds(200,300,100,20);


        radioButton1.setBounds(50,150,150,20);
        radioButton2.setBounds(50,200,150,20);
        radioButton3.setBounds(50,250,150,20);
        radioButton4.setBounds(50,300,150,20);

        button2.setBounds(150,400, 90, 30);
        if (count==x) {
            jButton1.setVisible(true);
            button2.setVisible(false);
            i=1;
        }

        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                frame.dispose();
                view(question.getSurveyId());
        }
        });
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent){
                EditSurveyPage1 editSurveyPage1 = new EditSurveyPage1();
                editSurveyPage1.add(localSurveyId);
                frame.dispose();
            }
        });

        frame.getContentPane().add(label1);
        frame.getContentPane().add(radioButton1);
        frame.getContentPane().add(radioButton2);
        frame.getContentPane().add(radioButton3);
        frame.getContentPane().add(radioButton4);
        frame.add(choice1);
        frame.add(choice2);
        frame.add(choice3);
        frame.add(choice4);
        frame.getContentPane().add(button2);
        frame.getContentPane().add(button1);

        frame.setSize(800,600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public void addYesNo(Question question){

        responseService = new ResponseService();
        choices=responseService.reportGeneration(question.getSurveyId(),question.getId());

        frame = new JFrame("Questions");
        label1 = new JLabel(question.getText());
        button2=new JButton("Next");
        JButton button1=Back();
        radioButton1 = new JLabel("Yes");
        radioButton2 = new JLabel("No");
        choice1=new JLabel(Float.toString(choices.getChoice1()));
        choice2=new JLabel(Float.toString(choices.getChoice2()));


        label1.setBounds(50, 50, 500, 90);

        radioButton1.setBounds(50,150,100,20);
        radioButton2.setBounds(50,200,100,20);

        choice1.setBounds(200,150,100,20);
        choice2.setBounds(200,200,100,20);

        button2.setBounds(150,400, 90, 30);

        if (count==x) {
            jButton1.setVisible(true);
            button2.setVisible(false);
            i=1;
        }

        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                EditSurveyPage1 editSurveyPage1 = new EditSurveyPage1();
                editSurveyPage1.add(localSurveyId);
                frame.dispose();
            }
        });
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                frame.dispose();
                view(question.getSurveyId());
            }
        });

        frame.getContentPane().add(radioButton1);
        frame.getContentPane().add(radioButton2);
        frame.getContentPane().add(label1);
        frame.getContentPane().add(button2);
        frame.getContentPane().add(button1);
        frame.add(choice1);
        frame.add(choice2);
        frame.setSize(800,600);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);


    }
    public void addDesc(Question question){

        frame = new JFrame("Questions");

        label1 = new JLabel(question.getText());
        JTextArea textArea = new JTextArea("");
        button2=new JButton("Next");
        JButton button1=Back();

        label1.setBounds(50, 50, 500, 90);

        textArea.setBounds(50,130, 400,150);

        button2.setBounds(150,400, 90, 30);

        if (count==x) {
            jButton1.setVisible(true);
            button2.setVisible(false);
            i=1;
        }
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                frame.dispose();
                view(question.getSurveyId());
            }
        });
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                EditSurveyPage1 editSurveyPage1 = new EditSurveyPage1();
                editSurveyPage1.add(localSurveyId);
                frame.dispose();
            }
        });

        frame.getContentPane().add(button2);
        frame.getContentPane().add(button1);
        frame.getContentPane().add(label1);
        frame.getContentPane().add(textArea);
        frame.setSize(800,600);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
    }

    public void view(int surveyid) {
        localSurveyId = surveyid;
        questionService = new QuestionService();

        questionList = questionService.viewQuestionService(surveyid);
        x=questionList.size()-1;

        questions = questionList.toArray(new Question[100]);

        if (questionList.size() != count) {
            if (questions[count].getQuestionType() == 1) {
                addMcq(questions[count]);
            } else if (questions[count].getQuestionType() == 2) {
                addYesNo(questions[count]);
            } else {
               addDesc(questions[count]);
            }
            count++;
        } else {
            System.exit(0);
        }
    }

    public JButton Back() {
        jButton1 = new JButton("Back to Edit");
        jButton1.setBounds(50, 400, 200, 30);
        if(i==0)
        {jButton1.setVisible(false);}
        return jButton1;
    }
}