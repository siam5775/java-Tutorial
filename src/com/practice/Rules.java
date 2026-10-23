
package com.practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Rules extends JFrame {

    private Container c;
    private String name, subject;
    private int studentId;

    private JLabel heading;
    private JTextArea tf;
    private JButton back, start;

    // Constructor for registered student
    public Rules(int studentId, String name, String subject) {
        this.studentId = studentId;
        this.name = name;
        this.subject = subject;
        initComponents();
    }

    // Constructor for the old login flow
    public Rules(String name, String subject) {
        this.studentId = -1;
        this.name = name;
        this.subject = subject;
        initComponents();
    }

    public void initComponents() {

        c = QuizTheme.page();
        this.setContentPane(c);

        JPanel card = QuizTheme.card(200, 42, 800, 380);
        c.add(card);

        heading = QuizTheme.label(
                "Welcome " + name,
                42, 24, 700, 42,
                QuizTheme.TITLE, QuizTheme.INK
        );
        card.add(heading);

        JLabel subheading = QuizTheme.label(
                subject + " Quiz Rules",
                44, 70, 620, 28,
                QuizTheme.SUBTITLE, QuizTheme.MUTED
        );
        card.add(subheading);

        tf = new JTextArea();
        tf.setBounds(44, 122, 710, 165);
        tf.setFont(QuizTheme.BODY_BOLD);
        tf.setForeground(QuizTheme.INK);
        tf.setEditable(false);
        tf.setBackground(new Color(248, 251, 255));

        tf.setBorder(new CompoundBorder(
                new LineBorder(QuizTheme.LINE, 1, true),
                new EmptyBorder(14, 18, 14, 18)
        ));

        tf.setLineWrap(true);
        tf.setWrapStyleWord(true);

        tf.setText(
                "1. You will have 15 seconds per question.\n" +
                "2. Each correct answer gives 10 points.\n" +
                "3. You can't go back to previous questions.\n" +
                "4. Only one lifeline can be used per quiz.\n" +
                "5. Questions are based on: " + subject + ".\n" +
                "6. Be honest and do not cheat!\n" +
                "7. Click Start to begin the quiz."
        );

        card.add(tf);

        back = QuizTheme.secondaryButton(
                "Back", 44, 316, 150, 42
        );
        card.add(back);

        start = QuizTheme.primaryButton(
                "Start", 604, 316, 150, 42
        );
        card.add(start);

        // Start Quiz
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();

                Quiz quizFrame;

                if (studentId > 0) {
                    quizFrame = new Quiz(
                            studentId, name, subject
                    );
                } else {
                    quizFrame = new Quiz(name, subject);
                }

                quizFrame.setBounds(50, 0, 1440, 850);
                quizFrame.setTitle("Quiz Question");
                quizFrame.setVisible(true);
            }
        });

        // Back to Subject Selection
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();

                SubjectSelection ss;

                if (studentId > 0) {
                    ss = new SubjectSelection(
                            studentId, name
                    );
                } else {
                    ss = new SubjectSelection(name);
                }

                ss.setBounds(100, 100, 1200, 500);
                ss.setTitle("Subject Selection");
                ss.setVisible(true);
            }
        });
    }
}
