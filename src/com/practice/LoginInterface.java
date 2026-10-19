package com.practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginInterface extends JFrame {
    private Container c;
    private JLabel imgLabel;
    private ImageIcon img;
    private JLabel heading;
    private JTextField tf1;
    private JButton play, back;

    LoginInterface() {
        initComponents();
    }

    public void initComponents() {
        c = QuizTheme.page();
        this.setContentPane(c);

        img = new ImageIcon(getClass().getResource("login.jpeg"));
        imgLabel = new JLabel(img);
        imgLabel.setBounds(70, 45, img.getIconWidth(), img.getIconHeight());
        c.add(imgLabel);

        JPanel card = QuizTheme.card(700, 62, 390, 330);
        c.add(card);

        heading = QuizTheme.label("Quiz Game", 36, 34, 320, 42, QuizTheme.TITLE, QuizTheme.INK);
        card.add(heading);

        JLabel subheading = QuizTheme.label("Enter your name to begin", 38, 82, 300, 28, QuizTheme.SUBTITLE, QuizTheme.MUTED);
        card.add(subheading);

        tf1 = new JTextField();
        tf1.setBounds(38, 138, 314, 42);
        QuizTheme.styleTextField(tf1);
        card.add(tf1);

        play = new JButton("Play");
        play = QuizTheme.primaryButton("Play", 38, 222, 145, 42);
        card.add(play);

        back = new JButton("Back");
        back = QuizTheme.secondaryButton("Back", 207, 222, 145, 42);
        card.add(back);

        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = tf1.getText();
                if(username.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter your name!");
                } else {
                    dispose();
                    SubjectSelection ss = new SubjectSelection(username);
                    ss.setTitle("Subject Selection");
                    ss.setSize(1200, 500);
                    ss.setLocationRelativeTo(null);
                    ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ss.setResizable(false);
                    ss.setVisible(true);
                }
            }
        });
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        LoginInterface frame = new LoginInterface();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 500);
        frame.setTitle("Quiz Game");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
