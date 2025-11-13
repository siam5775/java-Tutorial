package com.practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quiz extends JFrame {
    private Container c;
    private String questions[][] = new String[10][5];
    private String answers[][] = new String[10][2];
    private String useranswers[][] = new String[10][1];
    private JLabel qno, question, timerLabel;
    private JRadioButton opt1, opt2, opt3, opt4;
    private ButtonGroup options;
    private JButton next, submit;
    private int timer = 15;
    private int count = 0;
    private String username,subject;
    private Timer countdownTimer;

    Quiz(String name, String subject) {
        this.username = name;
        this.subject = subject;
        initComponents();
    }

    public void initComponents() {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        qno = new JLabel();
        qno.setBounds(100, 200, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        c.add(qno);

        question = new JLabel();
        question.setBounds(150, 200, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        c.add(question);

        timerLabel = new JLabel("Time left: 15 seconds");
        timerLabel.setBounds(1100, 200, 300, 30);
        timerLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        timerLabel.setForeground(Color.RED);
        c.add(timerLabel);

        opt1 = new JRadioButton();
        opt1.setBounds(170, 270, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        c.add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 320, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        c.add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 370, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        c.add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 420, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        c.add(opt4);

        options = new ButtonGroup();
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);

        setupButtonsAndTimer();
    }

    public void setupButtonsAndTimer() {
        next = new JButton("Next");
        next.setBounds(1100, 500, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.WHITE);
        next.addActionListener(e -> {
            saveAnswer();
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
            timer = 15;
        });
        c.add(next);

        submit = new JButton("Submit");
        submit.setBounds(1100, 550, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.WHITE);
        submit.setEnabled(false);

        // Quiz -> Score
        submit.addActionListener(e -> {
            saveAnswer();
            countdownTimer.stop();

            int score = 0;
            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0] != null && useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                }
            }

            dispose(); // Close Quiz
            Score scoreFrame = new Score(username, subject, score);
            scoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            scoreFrame.setBounds(400, 150, 750, 550);
            scoreFrame.setTitle("Show Score");
            scoreFrame.setResizable(false);
            scoreFrame.setVisible(true);
            scoreFrame.setLocationRelativeTo(null);
        });
        c.add(submit);

        loadQuestions();
        start(count);

        countdownTimer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timerLabel.setText("Time left: " + timer + " seconds");
                timer--;
                if (timer < 0) {
                    saveAnswer();
                    timer = 15;
                    if (count == 8) {
                        next.setEnabled(false);
                        submit.setEnabled(true);
                    }
                    if (count == 9) {
                        countdownTimer.stop();
                        submit.doClick(); // Auto submit
                        return;
                    }
                    count++;
                    start(count);
                }
            }
        });
        countdownTimer.start();
    }

    public void loadQuestions() {
        questions[0][0] = "Which data structure uses LIFO?";
        questions[0][1] = "Queue";
        questions[0][2] = "Stack";
        questions[0][3] = "Array";
        questions[0][4] = "LinkedList";

        questions[1][0] = "What is the size of int in Java?";
        questions[1][1] = "2 bytes";
        questions[1][2] = "4 bytes";
        questions[1][3] = "8 bytes";
        questions[1][4] = "Depends on system";

        questions[2][0] = "Which keyword is used for inheritance in Java?";
        questions[2][1] = "this";
        questions[2][2] = "super";
        questions[2][3] = "extends";
        questions[2][4] = "implements";

        questions[3][0] = "What is the default value of boolean in Java?";
        questions[3][1] = "true";
        questions[3][2] = "false";
        questions[3][3] = "0";
        questions[3][4] = "null";

        questions[4][0] = "Which method is the entry point in Java?";
        questions[4][1] = "start()";
        questions[4][2] = "main()";
        questions[4][3] = "run()";
        questions[4][4] = "init()";

        questions[5][0] = "Which data structure uses FIFO?";
        questions[5][1] = "Stack";
        questions[5][2] = "Queue";
        questions[5][3] = "Array";
        questions[5][4] = "Tree";

        questions[6][0] = "Which of these is a valid loop in Java?";
        questions[6][1] = "do-then";
        questions[6][2] = "repeat-until";
        questions[6][3] = "while";
        questions[6][4] = "loop-end";

        questions[7][0] = "What is the superclass of all classes in Java?";
        questions[7][1] = "Object";
        questions[7][2] = "Class";
        questions[7][3] = "Super";
        questions[7][4] = "Base";

        questions[8][0] = "Which keyword is used to define a constant in Java?";
        questions[8][1] = "const";
        questions[8][2] = "define";
        questions[8][3] = "static";
        questions[8][4] = "final";

        questions[9][0] = "Which operator is used for comparison?";
        questions[9][1] = "=";
        questions[9][2] = "==";
        questions[9][3] = "!=";
        questions[9][4] = "<>";

        answers[0][1] = "Stack";
        answers[1][1] = "4 bytes";
        answers[2][1] = "extends";
        answers[3][1] = "false";
        answers[4][1] = "main()";
        answers[5][1] = "Queue";
        answers[6][1] = "while";
        answers[7][1] = "Object";
        answers[8][1] = "final";
        answers[9][1] = "==";
    }

    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt4.setText(questions[count][4]);
        options.clearSelection();
    }

    public void saveAnswer() {
        String answer = "";
        if (opt1.isSelected()) answer = opt1.getText();
        else if (opt2.isSelected()) answer = opt2.getText();
        else if (opt3.isSelected()) answer = opt3.getText();
        else if (opt4.isSelected()) answer = opt4.getText();
        useranswers[count][0] = answer;
    }
}
