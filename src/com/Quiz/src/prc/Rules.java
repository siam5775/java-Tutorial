package prc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rules extends JFrame {
    private Container c;
    private String name, subject;
    private JLabel heading;
    private JTextArea tf;
    private JButton back, start;

    Rules(String name, String subject) {
        this.name = name;
        this.subject = subject;
        initComponents();
    }

    public void initComponents() {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        heading = new JLabel("Welcome " + name + " to the " + subject + " Quiz");
        heading.setBounds(100, 20, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));
        c.add(heading);

        tf = new JTextArea();
        tf.setBounds(130, 100, 700, 250);
        tf.setFont(new Font("Tahoma", Font.BOLD, 16));
        tf.setEditable(false);
        tf.setBackground(Color.WHITE);

        tf.setText(
                "1. You will have 15 seconds per question.\n" +
                "2. Each correct answer gives 10 points.\n" +
                "3. You can't go back to previous questions.\n" +
                "4. Only one lifeline can be used per quiz.\n" +
                "5. Questions are based on: " + subject + ".\n" +
                "6. Be honest and do not cheat!\n" +
                "7. Click Start to begin the quiz."
        );

        c.add(tf);

        back = new JButton("Back");
        back.setBounds(250, 350, 100, 30);
        back.setBackground(new Color(30, 144, 254));
        back.setForeground(Color.WHITE);
        c.add(back);

        start = new JButton("Start");
        start.setBounds(500, 350, 100, 30);
        start.setBackground(new Color(30, 144, 254));
        start.setForeground(Color.WHITE);
        c.add(start);

        // Rules -> Quiz
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close Rules window
                Quiz quizFrame = new Quiz(name, subject);
                quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                quizFrame.setBounds(50, 0, 1440, 850);
                quizFrame.setTitle("Quiz Question");
                quizFrame.setResizable(false);
                quizFrame.setVisible(true);
                quizFrame.setLocationRelativeTo(null);
            }
        });

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                SubjectSelection ss = new SubjectSelection(name);
                ss.setTitle("Subject Selection");
                ss.setSize(1200, 500);
                ss.setLocationRelativeTo(null);
                ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ss.setResizable(false);
                ss.setVisible(true);
            }
        });
    }
}

