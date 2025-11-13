// SubjectSelection.java
package com.practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SubjectSelection extends JFrame {
    private Container c;
    private JLabel heading;
    private JButton dsButton, oopButton, algoButton, gkButton;
    private Font f;
    private String username;

    SubjectSelection(String username) {
        this.username = username;
        initComponents();
    }

    public void initComponents(){
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        f = new Font("Arial", Font.BOLD, 18);

        heading = new JLabel("Welcome, " + username + "! Choose a Subject");
        heading.setBounds(300, 50, 600, 50);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 25));
        heading.setForeground(new Color(30, 144, 254));
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

        // SubjectSelection -> Rules
        ActionListener subjectListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String subject = ((JButton)e.getSource()).getText();
                dispose(); // Close SubjectSelection
                Rules rulesFrame = new Rules(username, subject);
                rulesFrame.setTitle("Quiz Rules");
                rulesFrame.setSize(1200, 500);
                rulesFrame.setLocationRelativeTo(null);
                rulesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                rulesFrame.setResizable(false);
                rulesFrame.setVisible(true);
            }
        };

        dsButton.addActionListener(subjectListener);
        oopButton.addActionListener(subjectListener);
        algoButton.addActionListener(subjectListener);
        gkButton.addActionListener(subjectListener);
    }
}
