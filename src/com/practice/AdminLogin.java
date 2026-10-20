
package com.practice;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AdminLogin extends JFrame {

    private Container c;
    private JLabel heading;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton login, back;

    public AdminLogin() {
        initComponents();
    }

    public void initComponents() {

        c = QuizTheme.page();
        this.setContentPane(c);

        JPanel card = QuizTheme.card(350, 55, 500, 350);
        c.add(card);

        heading = QuizTheme.label(
                "Admin Login",
                36, 32, 400, 45,
                QuizTheme.TITLE,
                QuizTheme.INK
        );
        card.add(heading);

        JLabel usernameLabel = QuizTheme.label(
                "Username",
                38, 95, 300, 25,
                QuizTheme.SUBTITLE,
                QuizTheme.MUTED
        );
        card.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(38, 125, 424, 42);
        QuizTheme.styleTextField(usernameField);
        card.add(usernameField);

        JLabel passwordLabel = QuizTheme.label(
                "Password",
                38, 180, 300, 25,
                QuizTheme.SUBTITLE,
                QuizTheme.MUTED
        );
        card.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(38, 210, 424, 42);
        QuizTheme.styleTextField(passwordField);
        card.add(passwordField);

        login = QuizTheme.primaryButton(
                "Login",
                38, 275, 200, 42
        );
        card.add(login);

        back = QuizTheme.secondaryButton(
                "Back",
                262, 275, 200, 42
        );
        card.add(back);

        // Admin Login Button
        login.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String username = usernameField.getText().trim();

                String password =
                        new String(passwordField.getPassword());

                if (username.isEmpty() || password.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            AdminLogin.this,
                            "Please enter username and password!"
                    );

                    return;
                }

                String sql =
                        "SELECT * FROM Admin " +
                        "WHERE username = ? AND password = ?";

                try (
                        Connection con = DBConnection.getConnection();
                        PreparedStatement pst = con.prepareStatement(sql)
                ) {

                    pst.setString(1, username);
                    pst.setString(2, password);

                    try (ResultSet rs = pst.executeQuery()) {

                        if (rs.next()) {

                            JOptionPane.showMessageDialog(
                                    AdminLogin.this,
                                    "Login Successful!"
                            );

                            dispose();

                            // Open Admin Dashboard
                            AdminDashboard frame =
                                    new AdminDashboard();

                            frame.setDefaultCloseOperation(
                                    JFrame.EXIT_ON_CLOSE
                            );

                            frame.setSize(1200, 500);
                            frame.setTitle("Admin Dashboard");
                            frame.setResizable(false);
                            frame.setLocationRelativeTo(null);
                            frame.setVisible(true);

                        } else {

                            JOptionPane.showMessageDialog(
                                    AdminLogin.this,
                                    "Invalid Username or Password!"
                            );
                        }
                    }

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(
                            AdminLogin.this,
                            "Database Connection Error!\n"
                                    + ex.getMessage()
                    );

                    ex.printStackTrace();
                }
            }
        });

        // Back Button: Return to Welcome Page
        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                dispose();

                Welcome welcome = new Welcome();

                welcome.setDefaultCloseOperation(
                        JFrame.EXIT_ON_CLOSE
                );

                welcome.setSize(1200, 500);
                welcome.setTitle("Online Quiz Management System");
                welcome.setResizable(false);
                welcome.setLocationRelativeTo(null);
                welcome.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                AdminLogin frame = new AdminLogin();

                frame.setDefaultCloseOperation(
                        JFrame.EXIT_ON_CLOSE
                );

                frame.setSize(1200, 500);
                frame.setTitle("Admin Login");
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
