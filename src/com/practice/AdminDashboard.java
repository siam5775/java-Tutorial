
package com.practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminDashboard extends JFrame {

    private Container c;
    private JLabel heading;
    private JButton addQuestion, manageQuestions, logout;

    AdminDashboard() {
        initComponents();
    }

    public void initComponents() {

        c = QuizTheme.page();
        this.setContentPane(c);

        JPanel card = QuizTheme.card(350, 55, 500, 350);
        c.add(card);

        heading = QuizTheme.label(
                "Admin Dashboard",
                36, 35, 400, 45,
                QuizTheme.TITLE,
                QuizTheme.INK
        );
        card.add(heading);

        // Add Question Button
        addQuestion = QuizTheme.primaryButton(
                "Add Question",
                38, 105, 424, 45
        );
        card.add(addQuestion);

        // Manage Questions Button
        manageQuestions = QuizTheme.secondaryButton(
                "Manage Questions",
                38, 165, 424, 45
        );
        card.add(manageQuestions);

        // Logout Button
        logout = QuizTheme.secondaryButton(
                "Logout",
                38, 225, 424, 45
        );
        card.add(logout);

        // Add Question Button Action
        addQuestion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                AddQuestion frame = new AddQuestion();
                frame.setDefaultCloseOperation(
                        JFrame.DISPOSE_ON_CLOSE
                );
                frame.setSize(1200, 500);
                frame.setTitle("Add Question");
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        // Manage Questions Button Action
        manageQuestions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ManageQuestions frame = new ManageQuestions();
                frame.setDefaultCloseOperation(
                        JFrame.DISPOSE_ON_CLOSE
                );
                frame.setSize(1200, 620);
                frame.setTitle("Manage Questions");
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        // Logout Button Action
        logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();

                AdminLogin frame = new AdminLogin();
                frame.setSize(1200, 500);
                frame.setTitle("Admin Login");
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {

        AdminDashboard frame = new AdminDashboard();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 500);
        frame.setTitle("Admin Dashboard");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
