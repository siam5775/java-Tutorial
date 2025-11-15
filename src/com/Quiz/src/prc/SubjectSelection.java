package com.Quiz.src.prc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubjectSelection extends JFrame{
    private String username;
    private Container c;
    private Font f;
    private JLabel heading;
    private JButton dsButton,oopButton,algoButton,gkButton;


    SubjectSelection(String username){
        this.username = username;
        initComponents();
    }

    public void initComponents(){
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLUE);

        f = new Font("Arial",Font.BOLD,18);

        heading = new JLabel("Welcome " + username + " ! choose a subject");
        heading.setBounds(300,50,600,50);
        heading.setFont(new Font("Times New Roman",Font.BOLD,25));
        heading.setForeground(new Color(30,144,254));
        c.add(heading);

        dsButton = new JButton("Data Structure");
        dsButton.setBounds(400, 150, 200, 35);
        dsButton.setFont(f);
        dsButton.setBackground(new Color(30, 144, 254));
        dsButton.setForeground(Color.WHITE);
        c.add(dsButton);

        oopButton = new JButton("OOP");
        oopButton.setBounds(400, 200, 200, 35);
        oopButton.setFont(f);
        oopButton.setBackground(new Color(30, 144, 254));
        oopButton.setForeground(Color.WHITE);
        c.add(oopButton);

        algoButton = new JButton("Algorithm");
        algoButton.setBounds(400, 250, 200, 35);
        algoButton.setFont(f);
        algoButton.setBackground(new Color(30, 144, 254));
        algoButton.setForeground(Color.WHITE);
        c.add(algoButton);

        gkButton = new JButton("General Knowledge");
        gkButton.setBounds(400, 300, 200, 35);
        gkButton.setFont(f);
        gkButton.setBackground(new Color(30, 144, 254));
        gkButton.setForeground(Color.WHITE);
        c.add(gkButton);
        
        ActionListener sub = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String subject = ((JButton)e.getSource()).getText();
                dispose();
                Rules rulesFrame = new Rules(username, subject);
                rulesFrame.setTitle("Quiz Rules");
                rulesFrame.setSize(1200, 500);
                rulesFrame.setLocationRelativeTo(null);
                rulesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                rulesFrame.setResizable(false);
                rulesFrame.setVisible(true);

            }
        };

        dsButton.addActionListener(sub);
        oopButton.addActionListener(sub);
        algoButton.addActionListener(sub);
        gkButton.addActionListener(sub);
    }
}

