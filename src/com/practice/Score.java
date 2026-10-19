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
        c = QuizTheme.page();
        this.setContentPane(c);

        JPanel card = QuizTheme.card(95, 55, 560, 405);
        c.add(card);

        heading = QuizTheme.label("Great work, " + name + "!", 42, 34, 480, 42, QuizTheme.TITLE, QuizTheme.INK);
        card.add(heading);

        JLabel subheading = QuizTheme.label("Thank you for taking the quiz.", 44, 82, 430, 28, QuizTheme.SUBTITLE, QuizTheme.MUTED);
        card.add(subheading);

        lblscore = QuizTheme.label("Your Score: " + score, 44, 140, 300, 46, new Font("Segoe UI", Font.BOLD, 28), QuizTheme.BRAND_DARK);
        card.add(lblscore);

        JProgressBar progress = new JProgressBar(0, 50);
        progress.setBounds(44, 204, 472, 16);
        progress.setValue(score);
        progress.setForeground(score >= 30 ? QuizTheme.SUCCESS : QuizTheme.DANGER);
        progress.setBackground(QuizTheme.SOFT_BLUE);
        progress.setBorderPainted(false);
        card.add(progress);

        playAgain = QuizTheme.primaryButton("Play Again", 44, 284, 145, 42);
        card.add(playAgain);

        exit = QuizTheme.secondaryButton("Exit", 371, 284, 145, 42);
        card.add(exit);

        newuser = QuizTheme.secondaryButton("New Login", 208, 334, 145, 42);
        card.add(newuser);

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
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
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
