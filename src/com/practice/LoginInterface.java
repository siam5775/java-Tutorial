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
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        img = new ImageIcon(getClass().getResource("login.jpeg"));
        imgLabel = new JLabel(img);
        imgLabel.setBounds(50, 20, img.getIconWidth(), img.getIconHeight());
        c.add(imgLabel);

        heading = new JLabel("Enter your name");
        heading.setBounds(735, 120, 300, 50);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 25));
        heading.setForeground(new Color(30, 144, 254));
        c.add(heading);

        tf1 = new JTextField();
        tf1.setBounds(735, 200, 300, 25);
        tf1.setFont(new Font("Arial", Font.PLAIN, 16));
        tf1.setHorizontalAlignment(JTextField.CENTER);
        c.add(tf1);

        play = new JButton("Play");
        play.setBounds(735, 270, 120, 25);
        play.setBackground(new Color(30, 144, 254));
        play.setForeground(Color.WHITE);
        c.add(play);

        back = new JButton("Back");
        back.setBounds(915, 270, 120, 25);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        c.add(back);

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
        back.addActionListener(e -> System.exit(0));
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
