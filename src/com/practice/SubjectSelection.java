
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
    private int studentId;

    // Constructor for registered students
    public SubjectSelection(int studentId, String username) {
        this.studentId = studentId;
        this.username = username;
        initComponents();
    }

    // Compatibility constructor for older code
    public SubjectSelection(String username) {
        this.studentId = -1;
        this.username = username;
        initComponents();
    }

    public void initComponents() {

        c = QuizTheme.page();
        this.setContentPane(c);

        f = QuizTheme.BUTTON;

        JPanel card = QuizTheme.card(270, 52, 660, 350);
        c.add(card);

        heading = QuizTheme.label(
            "Welcome, " + username + "!",
            42, 28, 580, 42,
            QuizTheme.TITLE, QuizTheme.INK
        );
        card.add(heading);

        JLabel subheading = QuizTheme.label(
            "Choose a subject and get ready for the quiz.",
            44, 78, 520, 28,
            QuizTheme.SUBTITLE, QuizTheme.MUTED
        );
        card.add(subheading);

        dsButton = QuizTheme.primaryButton(
            "Data Structure", 46, 145, 255, 48
        );
        dsButton.setFont(f);
        card.add(dsButton);

        oopButton = QuizTheme.secondaryButton(
            "OOP", 359, 145, 255, 48
        );
        oopButton.setFont(f);
        card.add(oopButton);

        algoButton = QuizTheme.secondaryButton(
            "Algorithm", 46, 222, 255, 48
        );
        algoButton.setFont(f);
        card.add(algoButton);

        gkButton = QuizTheme.primaryButton(
            "General Knowledge", 359, 222, 255, 48
        );
        gkButton.setFont(f);
        card.add(gkButton);

        // Subject selection action
        ActionListener subjectListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String subject =
                    ((JButton) e.getSource()).getText();

                dispose();

                Rules rulesFrame;

                if (studentId > 0) {
                    rulesFrame = new Rules(
                        studentId, username, subject
                    );
                } else {
                    // Compatibility with the previous name-only flow
                    rulesFrame = new Rules(username, subject);
                }

                rulesFrame.setTitle("Quiz Rules");
                rulesFrame.setSize(1200, 500);
                rulesFrame.setLocationRelativeTo(null);
                rulesFrame.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE
                );
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
