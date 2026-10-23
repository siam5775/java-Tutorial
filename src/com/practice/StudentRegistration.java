
package com.practice;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class StudentRegistration extends JFrame {

    private Container c;
    private JTextField nameField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton registerButton, backButton;

    public StudentRegistration() {
        initComponents();
    }

    public void initComponents() {
        c = QuizTheme.page();
        setContentPane(c);

        JPanel card = QuizTheme.card(350, 25, 500, 440);
        c.add(card);

        JLabel heading = QuizTheme.label(
                "Student Registration",
                35, 20, 430, 45,
                QuizTheme.TITLE, QuizTheme.INK
        );
        card.add(heading);

        JLabel nameLabel = QuizTheme.label(
                "Full Name", 38, 75, 400, 22,
                QuizTheme.SUBTITLE, QuizTheme.MUTED
        );
        card.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(38, 100, 424, 35);
        QuizTheme.styleTextField(nameField);
        card.add(nameField);

        JLabel emailLabel = QuizTheme.label(
                "Email Address", 38, 143, 400, 22,
                QuizTheme.SUBTITLE, QuizTheme.MUTED
        );
        card.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(38, 168, 424, 35);
        QuizTheme.styleTextField(emailField);
        card.add(emailField);

        JLabel passwordLabel = QuizTheme.label(
                "Password", 38, 211, 400, 22,
                QuizTheme.SUBTITLE, QuizTheme.MUTED
        );
        card.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(38, 236, 424, 35);
        QuizTheme.styleTextField(passwordField);
        card.add(passwordField);

        JLabel confirmLabel = QuizTheme.label(
                "Confirm Password", 38, 279, 400, 22,
                QuizTheme.SUBTITLE, QuizTheme.MUTED
        );
        card.add(confirmLabel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(38, 304, 424, 35);
        QuizTheme.styleTextField(confirmPasswordField);
        card.add(confirmPasswordField);

        registerButton = QuizTheme.primaryButton(
                "Register", 38, 365, 200, 42
        );
        card.add(registerButton);

        backButton = QuizTheme.secondaryButton(
                "Back", 262, 365, 200, 42
        );
        card.add(backButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerStudent();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWelcome();
            }
        });

        getRootPane().setDefaultButton(registerButton);
    }

    private void registerStudent() {

        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());
        String confirmPassword =
                new String(confirmPasswordField.getPassword());

        // Check empty fields
        if (name.isEmpty() || email.isEmpty()
                || password.isEmpty() || confirmPassword.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill in all fields.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Basic email validation
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid email address.",
                    "Invalid Email",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Password length check
        if (password.length() < 6) {
            JOptionPane.showMessageDialog(
                    this,
                    "Password must be at least 6 characters long.",
                    "Weak Password",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Confirm password check
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Passwords do not match.",
                    "Password Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String sql = "INSERT INTO Student "
                + "(student_name, email, password) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            pst.setString(1, name);
            pst.setString(2, email);

            // Basic implementation for your current project.
            // For a real deployment, store a securely hashed password.
            pst.setString(3, password);

            int rows = pst.executeUpdate();

            if (rows > 0) {

                int studentId = -1;

                try (ResultSet keys = pst.getGeneratedKeys()) {
                    if (keys.next()) {
                        studentId = keys.getInt(1);
                    }
                }

                if (studentId != -1) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Registration Successful!\n\n"
                            + "Welcome, " + name + "!\n"
                            + "Your Student ID is: " + studentId
                            + "\n\nPlease remember your Student ID.",
                            "Registration Successful",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    nameField.setText("");
                    emailField.setText("");
                    passwordField.setText("");
                    confirmPasswordField.setText("");

                    openStudentLogin();

                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Registration completed, but the Student ID "
                            + "could not be retrieved.",
                            "Registration Notice",
                            JOptionPane.WARNING_MESSAGE
                    );
                }
            }

        } catch (SQLIntegrityConstraintViolationException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "This email is already registered.\n"
                    + "Please use another email address.",
                    "Duplicate Email",
                    JOptionPane.WARNING_MESSAGE
            );

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Database Error: " + ex.getMessage(),
                    "Registration Failed",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void openStudentLogin() {
        dispose();

        LoginInterface login = new LoginInterface();
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setSize(1200, 500);
        login.setTitle("Student Login");
        login.setResizable(false);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }

    private void openWelcome() {
        dispose();

        Welcome welcome = new Welcome();
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welcome.setSize(1200, 500);
        welcome.setTitle("Online Quiz Management System");
        welcome.setResizable(false);
        welcome.setLocationRelativeTo(null);
        welcome.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                StudentRegistration frame = new StudentRegistration();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1200, 500);
                frame.setTitle("Student Registration");
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
