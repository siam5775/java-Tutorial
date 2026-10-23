
package com.practice;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class LoginInterface extends JFrame {

    private Container c;
    private JLabel imgLabel;
    private ImageIcon img;
    private JLabel heading;
    private JTextField idField;
    private JPasswordField passwordField;
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
        JPanel card = QuizTheme.card(700, 40, 390, 390);
        c.add(card);

        // Heading
        heading = QuizTheme.label(
            "Student Login", 36, 25, 320, 42,
            QuizTheme.TITLE, QuizTheme.INK
        );
        card.add(heading);

        JLabel subheading = QuizTheme.label(
            "Enter your Student ID and Password",
            38, 70, 320, 28,
            QuizTheme.SUBTITLE, QuizTheme.MUTED
        );
        card.add(subheading);

        // Student ID label
        JLabel idLabel = QuizTheme.label(
            "Student ID", 38, 112, 300, 22,
            QuizTheme.SUBTITLE, QuizTheme.MUTED
        );
        card.add(idLabel);

        // Student ID field
        idField = new JTextField();
        idField.setBounds(38, 137, 314, 38);
        QuizTheme.styleTextField(idField);
        card.add(idField);

        // Password label
        JLabel passwordLabel = QuizTheme.label(
            "Password", 38, 185, 300, 22,
            QuizTheme.SUBTITLE, QuizTheme.MUTED
        );
        card.add(passwordLabel);

        // Password field
        passwordField = new JPasswordField();
        passwordField.setBounds(38, 210, 314, 38);
        QuizTheme.styleTextField(passwordField);
        card.add(passwordField);

        // Login button
        play = QuizTheme.primaryButton(
            "Login", 38, 285, 145, 42
        );
        card.add(play);

        // Back button
        back = QuizTheme.secondaryButton(
            "Back", 207, 285, 145, 42
        );
        card.add(back);

        // Login action
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginStudent();
            }
        });

        // Enter key submits login
        getRootPane().setDefaultButton(play);

        // Back to Welcome Page
        back.addActionListener(new ActionListener() {
            @Override
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

    // Verify student credentials from database
    private void loginStudent() {

        String idText = idField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (idText.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(
                this,
                "Please enter your Student ID and Password.",
                "Missing Information",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        int studentId;

        try {
            studentId = Integer.parseInt(idText);

            if (studentId <= 0) {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Student ID must be a valid positive number.",
                "Invalid Student ID",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String sql = "SELECT student_id, student_name "
                   + "FROM Student "
                   + "WHERE student_id = ? AND password = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, studentId);
            pst.setString(2, password);

            try (ResultSet rs = pst.executeQuery()) {

                if (rs.next()) {

                    int loggedInStudentId =
                        rs.getInt("student_id");

                    String studentName =
                        rs.getString("student_name");

                    JOptionPane.showMessageDialog(
                        this,
                        "Login Successful!\nWelcome, "
                            + studentName + "!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                    );

                    dispose();

                    SubjectSelection ss =
                        new SubjectSelection(
                            loggedInStudentId,
                            studentName
                        );

                    ss.setTitle("Subject Selection");
                    ss.setSize(1200, 500);
                    ss.setLocationRelativeTo(null);
                    ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ss.setResizable(false);
                    ss.setVisible(true);

                } else {

                    JOptionPane.showMessageDialog(
                        this,
                        "Invalid Student ID or Password.",
                        "Login Failed",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Database Error: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                LoginInterface frame = new LoginInterface();

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1200, 500);
                frame.setTitle("Student Login");
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
