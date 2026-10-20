
package com.practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Welcome extends JFrame {

    private Container c;
    private JLabel imgLabel;
    private ImageIcon img;
    private JLabel heading;
    private JLabel subheading;
    private JButton adminButton, studentButton, registerButton;

    public Welcome() {
        initComponents();
    }

    public void initComponents() {

        // Same theme as LoginInterface
        c = QuizTheme.page();
        this.setContentPane(c);
        c.setLayout(null);

        // Left-side image
        java.net.URL imageURL = getClass().getResource("login.jpeg");

        if (imageURL != null) {
            img = new ImageIcon(imageURL);
            imgLabel = new JLabel(img);
            imgLabel.setBounds(
                70, 45, img.getIconWidth(), img.getIconHeight()
            );
            c.add(imgLabel);
        }

        // Main card
        JPanel card = QuizTheme.card(700, 45, 390, 370);
        c.add(card);

        // Heading
        heading = QuizTheme.label(
            "Quiz Game",
            36, 25, 320, 45,
            QuizTheme.TITLE,
            QuizTheme.INK
        );
        card.add(heading);

        subheading = QuizTheme.label(
            "Choose your login option",
            38, 72, 310, 28,
            QuizTheme.SUBTITLE,
            QuizTheme.MUTED
        );
        card.add(subheading);

        // Admin Login button
        adminButton = QuizTheme.primaryButton(
            "Admin Login", 38, 125, 314, 42
        );
        card.add(adminButton);

        // Student Login button
        studentButton = QuizTheme.primaryButton(
            "Student Login", 38, 183, 314, 42
        );
        card.add(studentButton);

        // Student Registration button
        registerButton = QuizTheme.secondaryButton(
            "Student Registration", 38, 241, 314, 42
        );
        card.add(registerButton);

        // Admin Login action
        adminButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();

                AdminLogin admin = new AdminLogin();
                admin.setTitle("Admin Login");
                admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                admin.setSize(1200, 500);
                admin.setLocationRelativeTo(null);
                admin.setResizable(false);
                admin.setVisible(true);
            }
        });

        // Student Login action
        studentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();

                LoginInterface login = new LoginInterface();
                login.setTitle("Quiz Game");
                login.setSize(1200, 500);
                login.setLocationRelativeTo(null);
                login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                login.setResizable(false);
                login.setVisible(true);
            }
        });

        // Student Registration action
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(
                    Welcome.this,
                    "Student Registration will be connected next.",
                    "Student Registration",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                Welcome frame = new Welcome();
                frame.setTitle("Online Quiz Management System");
                frame.setSize(1200, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
