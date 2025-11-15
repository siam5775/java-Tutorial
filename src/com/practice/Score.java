// Score.java
package com.practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Score extends JFrame {
    private Container c;
    private JLabel heading,lblscore;
    private String name;
    private int score;
    private JButton playAgain,exit,newuser;

    Score(String name, String subject, int score){
        this.name = name;
        this.score = score;
        initComponents();
    }

    public void initComponents(){
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        heading = new JLabel("Thank you " + name + " for taking the Quiz!");
        heading.setBounds(165, 30, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        c.add(heading);

        lblscore = new JLabel("Your Score: " + score);
        lblscore.setBounds(300, 100, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 22));
        c.add(lblscore);

        playAgain = new JButton("Play Again");
        playAgain.setBounds(150, 280, 120, 25);
        playAgain.setBackground(new Color(30, 144, 254));
        playAgain.setForeground(Color.WHITE);
        c.add(playAgain);

        exit = new JButton("Exit");
        exit.setBounds(450, 280, 120, 25);
        exit.setBackground(new Color(30, 144, 254));
        exit.setForeground(Color.WHITE);
        c.add(exit);

        newuser = new JButton("New Login");
        newuser.setBounds(300, 350, 150, 25);
        newuser.setBackground(new Color(30, 144, 254));
        newuser.setForeground(Color.WHITE);
        c.add(newuser);

        // Score -> LoginInterface
        playAgain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close Score window
                SubjectSelection login = new SubjectSelection(name);
                login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                login.setSize(1200, 500);
                login.setTitle("Quiz App");
                login.setResizable(false);
                login.setVisible(true);
                login.setLocationRelativeTo(null);
            }
        });
        newuser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close Score window
                LoginInterface login = new LoginInterface();
                login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                login.setSize(1200, 500);
                login.setTitle("Quiz App");
                login.setResizable(false);
                login.setVisible(true);
                login.setLocationRelativeTo(null);
            }
        });
        exit.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        Score frame = new Score("Siyam", "Java", 8);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 150, 750, 550);
        frame.setTitle("Show Score");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
