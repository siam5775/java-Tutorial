
package com.practice;

import java.awt.*;
import javax.swing.*;

public class AdminDashboard extends JFrame {

    private Container c;
    private JLabel heading;

    private JButton addQuestion;
    private JButton manageQuestions;
    private JButton studentHistory;
    private JButton logout;

    public AdminDashboard() {
        initComponents();

        setTitle("Admin Dashboard");
        setSize(1200, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void initComponents() {

        c = QuizTheme.page();
        setContentPane(c);

        JPanel card = QuizTheme.card(350, 40, 500, 400);
        c.add(card);

        heading = QuizTheme.label(
                "Admin Dashboard",
                36, 30, 400, 45,
                QuizTheme.TITLE,
                QuizTheme.INK
        );
        card.add(heading);

        // Add Question Button
        addQuestion = QuizTheme.primaryButton(
                "Add Question",
                38, 95, 424, 45
        );
        card.add(addQuestion);

        // Manage Questions Button
        manageQuestions = QuizTheme.secondaryButton(
                "Manage Questions",
                38, 150, 424, 45
        );
        card.add(manageQuestions);

        // Student History Button
        studentHistory = QuizTheme.primaryButton(
                "Student History",
                38, 205, 424, 45
        );
        card.add(studentHistory);

        // Logout Button
        logout = QuizTheme.secondaryButton(
                "Logout",
                38, 260, 424, 45
        );
        card.add(logout);

        // Add Question Action
        addQuestion.addActionListener(e -> {

            AddQuestion frame = new AddQuestion();

            frame.setDefaultCloseOperation(
                    JFrame.DISPOSE_ON_CLOSE
            );
            frame.setSize(1200, 500);
            frame.setTitle("Add Question");
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        // Manage Questions Action
        manageQuestions.addActionListener(e -> {

            ManageQuestions frame = new ManageQuestions();

            frame.setDefaultCloseOperation(
                    JFrame.DISPOSE_ON_CLOSE
            );
            frame.setSize(1200, 620);
            frame.setTitle("Manage Questions");
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        // Student History Action
        studentHistory.addActionListener(e -> {

            AdminStudentHistory frame =
                    new AdminStudentHistory();

            frame.setVisible(true);
        });

        // Logout Action
        logout.addActionListener(e -> {

            dispose();

            AdminLogin frame = new AdminLogin();

            frame.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE
            );
            frame.setSize(1200, 500);
            frame.setTitle("Admin Login");
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            AdminDashboard frame = new AdminDashboard();
            frame.setVisible(true);

        });
    }
}
