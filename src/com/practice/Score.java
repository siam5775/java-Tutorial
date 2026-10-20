
package com.practice;

import java.awt.*;
import javax.swing.*;

public class Score extends JFrame {

    private Container c;
    private JLabel heading, lblscore;
    private String name;
    private int score;
    private int totalScore;

    private JButton playAgain, exit, newuser;

    // Constructor for dynamic total score
    Score(String name, String subject, int score, int totalScore) {
        this.name = name;
        this.score = score;
        this.totalScore = Math.max(totalScore, 1);
        initComponents();
    }

    // Backward-compatible constructor
    Score(String name, String subject, int score) {
        this(name, subject, score, 50);
    }

    public void initComponents() {

        c = QuizTheme.page();
        this.setContentPane(c);

        JPanel card = QuizTheme.card(95, 55, 560, 405);
        c.add(card);

        heading = QuizTheme.label(
            "Great work, " + name + "!",
            42, 34, 480, 42,
            QuizTheme.TITLE, QuizTheme.INK
        );
        card.add(heading);

        JLabel subheading = QuizTheme.label(
            "Thank you for taking the quiz.",
            44, 82, 430, 28,
            QuizTheme.SUBTITLE, QuizTheme.MUTED
        );
        card.add(subheading);

        lblscore = QuizTheme.label(
            "Your Score: " + score + " / " + totalScore,
            44, 140, 450, 46,
            new Font("Segoe UI", Font.BOLD, 28),
            QuizTheme.BRAND_DARK
        );
        card.add(lblscore);

        JProgressBar progress = new JProgressBar(0, totalScore);
        progress.setBounds(44, 204, 472, 16);
        progress.setValue(Math.max(0, Math.min(score, totalScore)));
        progress.setStringPainted(true);
        progress.setString(score + " / " + totalScore);
        progress.setForeground(
            score >= totalScore / 2.0
                ? QuizTheme.SUCCESS
                : QuizTheme.DANGER
        );
        progress.setBackground(QuizTheme.SOFT_BLUE);
        progress.setBorderPainted(false);
        card.add(progress);

        playAgain = QuizTheme.primaryButton(
            "Play Again", 44, 284, 145, 42
        );
        card.add(playAgain);

        exit = QuizTheme.secondaryButton(
            "Exit", 371, 284, 145, 42
        );
        card.add(exit);

        newuser = QuizTheme.secondaryButton(
            "New Login", 208, 334, 145, 42
        );
        card.add(newuser);

        // Play Again
        playAgain.addActionListener(e -> {
            dispose();

            SubjectSelection selection = new SubjectSelection(name);
            selection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            selection.setSize(1200, 500);
            selection.setTitle("Subject Selection");
            selection.setResizable(false);
            selection.setLocationRelativeTo(null);
            selection.setVisible(true);
        });

        // New Login
        newuser.addActionListener(e -> {
            dispose();

            LoginInterface login = new LoginInterface();
            login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            login.setSize(1200, 500);
            login.setTitle("Quiz App");
            login.setResizable(false);
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        });

        // Exit
        exit.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {

        Score frame = new Score("Siyam", "Java", 30, 50);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 550);
        frame.setTitle("Show Score");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
