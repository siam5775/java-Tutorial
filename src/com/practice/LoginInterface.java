
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

    public LoginInterface() {
        initComponents();
    }

    public void initComponents() {

        c = QuizTheme.page();
        c.setLayout(null);
        this.setContentPane(c);

        // Login image
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
        JPanel card = QuizTheme.card(700, 62, 390, 330);
        c.add(card);

        // Heading
        heading = QuizTheme.label(
            "Quiz Game", 36, 34, 320, 42,
            QuizTheme.TITLE, QuizTheme.INK
        );
        card.add(heading);

        JLabel subheading = QuizTheme.label(
            "Enter your name to begin",
            38, 82, 300, 28,
            QuizTheme.SUBTITLE, QuizTheme.MUTED
        );
        card.add(subheading);

        // Name field
        tf1 = new JTextField();
        tf1.setBounds(38, 138, 314, 42);
        QuizTheme.styleTextField(tf1);
        card.add(tf1);

        // Play button
        play = QuizTheme.primaryButton(
            "Play", 38, 222, 145, 42
        );
        card.add(play);

        // Back button
        back = QuizTheme.secondaryButton(
            "Back", 207, 222, 145, 42
        );
        card.add(back);

        // Play action
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String username = tf1.getText().trim();

                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        LoginInterface.this,
                        "Please enter your name!"
                    );
                } else {
                    dispose();

                    SubjectSelection ss =
                        new SubjectSelection(username);

                    ss.setTitle("Subject Selection");
                    ss.setSize(1200, 500);
                    ss.setLocationRelativeTo(null);
                    ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ss.setResizable(false);
                    ss.setVisible(true);
                }
            }
        });

        // Back to Welcome Page
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();

                Welcome welcome = new Welcome();
                welcome.setTitle("Online Quiz Management System");
                welcome.setSize(1200, 500);
                welcome.setLocationRelativeTo(null);
                welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                welcome.setResizable(false);
                welcome.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                LoginInterface frame = new LoginInterface();

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1200, 500);
                frame.setTitle("Quiz Game");
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
