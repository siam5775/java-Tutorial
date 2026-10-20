
package com.practice;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Quiz extends JFrame {

    private Container c;
    private JLabel qno, question, timerLabel;
    private JRadioButton opt1, opt2, opt3, opt4;
    private ButtonGroup options;
    private JButton next, submit;
    private JPanel quizCard;

    private String username, subject;

    private List<QuizQuestion> questionList = new ArrayList<>();
    private String[] userAnswers;
    private int count = 0;
    private int timer = 15;

    private Timer countdownTimer;
    private boolean quizReady = false;
    private boolean quizFinished = false;

    // Stores one question and its options
    private static class QuizQuestion {
        String question;
        String optionA;
        String optionB;
        String optionC;
        String optionD;
        String correctAnswer;

        QuizQuestion(
                String question,
                String optionA,
                String optionB,
                String optionC,
                String optionD,
                String correctAnswer) {

            this.question = question;
            this.optionA = optionA;
            this.optionB = optionB;
            this.optionC = optionC;
            this.optionD = optionD;
            this.correctAnswer = correctAnswer;
        }
    }

    Quiz(String name, String subject) {
        this.username = name;
        this.subject = subject;

        loadQuestions();

        if (!questionList.isEmpty()) {
            userAnswers = new String[questionList.size()];
            initComponents();
            quizReady = true;
        }
    }

    public boolean hasQuestions() {
        return quizReady;
    }

    // Load all questions for the selected subject from MySQL
    private void loadQuestions() {

        String sql =
            "SELECT q.question_text, q.option_a, q.option_b, " +
            "q.option_c, q.option_d, q.correct_answer " +
            "FROM Question q " +
            "JOIN Subject s ON q.subject_id = s.subject_id " +
            "WHERE s.subject_name = ? " +
            "ORDER BY q.question_id";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, subject);

            try (ResultSet rs = pst.executeQuery()) {

                while (rs.next()) {
                    questionList.add(new QuizQuestion(
                        rs.getString("question_text"),
                        rs.getString("option_a"),
                        rs.getString("option_b"),
                        rs.getString("option_c"),
                        rs.getString("option_d"),
                        rs.getString("correct_answer")
                    ));
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                null,
                "Could not load questions from database.\n" +
                e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (questionList.isEmpty()) {
            JOptionPane.showMessageDialog(
                null,
                "No questions found for " + subject +
                ". Please add questions from Admin Panel.",
                "No Questions",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public void initComponents() {

        c = QuizTheme.page();
        setContentPane(c);

        JLabel title = QuizTheme.label(
            subject + " Quiz",
            112, 34, 500, 40,
            QuizTheme.TITLE, QuizTheme.INK
        );
        c.add(title);

        JLabel player = QuizTheme.label(
            "Player: " + username,
            114, 76, 420, 26,
            QuizTheme.SUBTITLE, QuizTheme.MUTED
        );
        c.add(player);

        quizCard = QuizTheme.card(110, 118, 1220, 590);
        c.add(quizCard);

        qno = QuizTheme.label(
            "", 52, 82, 54, 36,
            new Font("Segoe UI", Font.BOLD, 26),
            QuizTheme.BRAND_DARK
        );
        quizCard.add(qno);

        question = QuizTheme.label(
            "", 106, 82, 780, 50,
            new Font("Segoe UI", Font.BOLD, 22),
            QuizTheme.INK
        );
        quizCard.add(question);

        timerLabel = new JLabel();
        timerLabel.setBounds(900, 36, 260, 36);
        timerLabel.setFont(QuizTheme.BODY_BOLD);
        timerLabel.setForeground(QuizTheme.DANGER);
        timerLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        quizCard.add(timerLabel);

        opt1 = new JRadioButton();
        QuizTheme.styleOption(opt1, 72, 180, 800, 44);
        quizCard.add(opt1);

        opt2 = new JRadioButton();
        QuizTheme.styleOption(opt2, 72, 242, 800, 44);
        quizCard.add(opt2);

        opt3 = new JRadioButton();
        QuizTheme.styleOption(opt3, 72, 304, 800, 44);
        quizCard.add(opt3);

        opt4 = new JRadioButton();
        QuizTheme.styleOption(opt4, 72, 366, 800, 44);
        quizCard.add(opt4);

        options = new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);

        next = QuizTheme.primaryButton(
            "Next", 925, 392, 210, 46
        );
        next.addActionListener(e -> goToNextQuestion());
        quizCard.add(next);

        submit = QuizTheme.secondaryButton(
            "Submit", 925, 456, 210, 46
        );
        submit.addActionListener(e -> finishQuiz());
        quizCard.add(submit);

        showQuestion();

        countdownTimer = new Timer(1000, e -> {
            timer--;

            timerLabel.setText("Time left: " + timer + " seconds");

            if (timer <= 0) {
                saveAnswer();

                if (count == questionList.size() - 1) {
                    finishQuiz();
                } else {
                    count++;
                    showQuestion();
                }
            }
        });

        countdownTimer.start();
    }

    // Display the current question
    private void showQuestion() {

        QuizQuestion q = questionList.get(count);

        qno.setText((count + 1) + ". ");
        question.setText("<html>" + escapeHtml(q.question) + "</html>");

        opt1.setText(q.optionA);
        opt2.setText(q.optionB);
        opt3.setText(q.optionC);
        opt4.setText(q.optionD);

        options.clearSelection();

        // Update the buttons for the current question
        boolean lastQuestion = count == questionList.size() - 1;

        next.setEnabled(!lastQuestion);
        submit.setEnabled(lastQuestion);

        timer = 15;
        timerLabel.setText("Time left: " + timer + " seconds");
    }

    private String escapeHtml(String text) {
        if (text == null) {
            return "";
        }

        return text.replace("&", "&amp;")
                   .replace("<", "&lt;")
                   .replace(">", "&gt;");
    }

    // Save the selected option as A, B, C or D
    private void saveAnswer() {

        if (opt1.isSelected()) {
            userAnswers[count] = "A";
        } else if (opt2.isSelected()) {
            userAnswers[count] = "B";
        } else if (opt3.isSelected()) {
            userAnswers[count] = "C";
        } else if (opt4.isSelected()) {
            userAnswers[count] = "D";
        } else {
            userAnswers[count] = null;
        }
    }

    private void goToNextQuestion() {

        if (quizFinished || count >= questionList.size() - 1) {
            return;
        }

        saveAnswer();
        count++;
        showQuestion();
    }

    // Calculate score and open the Score window
    private void finishQuiz() {

        if (quizFinished) {
            return;
        }

        saveAnswer();
        quizFinished = true;

        if (countdownTimer != null) {
            countdownTimer.stop();
        }

        int score = 0;

        for (int i = 0; i < questionList.size(); i++) {

            String correct = questionList.get(i).correctAnswer;
            String selected = userAnswers[i];

            if (selected != null && correct != null &&
                selected.trim().equalsIgnoreCase(correct.trim())) {
                score += 10;
            }
        }

        dispose();

        Score scoreFrame = new Score(
            username, subject, score, questionList.size() * 10
        );

        scoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scoreFrame.setSize(750, 550);
        scoreFrame.setTitle("Show Score");
        scoreFrame.setResizable(false);
        scoreFrame.setLocationRelativeTo(null);
        scoreFrame.setVisible(true);
    }
}
