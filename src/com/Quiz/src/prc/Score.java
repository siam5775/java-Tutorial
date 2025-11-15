package com.Quiz.src.prc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Score extends JFrame {
    private Container c;
    private JLabel heading,lblscore;
    private String name;
    private int score;
    private JButton playAgain;

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
        heading.setBounds(50, 30, 700, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        c.add(heading);

        lblscore = new JLabel("Your Score: " + score);
        lblscore.setBounds(300, 100, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 22));
        c.add(lblscore);

        playAgain = new JButton("Play Again");
        playAgain.setBounds(300, 200, 120, 30);
        playAgain.setBackground(new Color(30, 144, 254));
        playAgain.setForeground(Color.WHITE);
        c.add(playAgain);

        // Score -> LoginInterface
        playAgain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close Score window
                Login login = new Login();
                login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                login.setSize(1200, 500);
                login.setTitle("Quiz App");
                login.setResizable(false);
                login.setVisible(true);
                login.setLocationRelativeTo(null);
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

