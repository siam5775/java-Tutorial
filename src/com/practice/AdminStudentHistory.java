
package com.practice;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminStudentHistory extends JFrame {

    private Container c;

    private JTable studentTable;
    private JTable attemptTable;
    private JTable answerTable;

    private DefaultTableModel studentModel;
    private DefaultTableModel attemptModel;
    private DefaultTableModel answerModel;

    public AdminStudentHistory() {
        initComponents();
        loadStudents();

        setTitle("Student Quiz History");
        setSize(1250, 880);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void initComponents() {
        c = QuizTheme.page();
        setContentPane(c);
        setLayout(null);

        // Back to Admin Dashboard
        JButton backButton = QuizTheme.secondaryButton(
                "Back to Dashboard", 35, 15, 220, 40
        );

        backButton.addActionListener(e -> {
            dispose();

            AdminDashboard dashboard = new AdminDashboard();
            dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dashboard.setSize(1200, 500);
            dashboard.setTitle("Admin Dashboard");
            dashboard.setResizable(false);
            dashboard.setLocationRelativeTo(null);
            dashboard.setVisible(true);
        });

        c.add(backButton);

        // Heading
        JLabel heading = QuizTheme.label(
                "Student Quiz History",
                270, 15, 700, 42,
                QuizTheme.TITLE,
                QuizTheme.INK
        );
        c.add(heading);

        // Students Section
        JPanel studentCard = QuizTheme.card(25, 70, 1180, 215);
        c.add(studentCard);

        JLabel studentTitle = QuizTheme.label(
                "All Students",
                18, 10, 500, 28,
                QuizTheme.SUBTITLE,
                QuizTheme.INK
        );
        studentCard.add(studentTitle);

        studentModel = new DefaultTableModel(
                new String[]{
                    "Student ID",
                    "Student Name",
                    "Email",
                    "Total Attempts"
                }, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        studentTable = new JTable(studentModel);
        styleTable(studentTable);

        JScrollPane studentScroll = new JScrollPane(studentTable);
        studentScroll.setBounds(15, 43, 1150, 145);
        studentCard.add(studentScroll);

        // Quiz Attempts Section
        JPanel attemptCard = QuizTheme.card(25, 300, 1180, 220);
        c.add(attemptCard);

        JLabel attemptTitle = QuizTheme.label(
                "Quiz Attempts",
                18, 10, 500, 28,
                QuizTheme.SUBTITLE,
                QuizTheme.INK
        );
        attemptCard.add(attemptTitle);

        attemptModel = new DefaultTableModel(
                new String[]{
                    "Attempt ID",
                    "Subject",
                    "Score",
                    "Attempt Date & Time"
                }, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        attemptTable = new JTable(attemptModel);
        styleTable(attemptTable);

        JScrollPane attemptScroll = new JScrollPane(attemptTable);
        attemptScroll.setBounds(15, 43, 1150, 150);
        attemptCard.add(attemptScroll);

        // Answer Details Section
        JPanel answerCard = QuizTheme.card(25, 535, 1180, 240);
        c.add(answerCard);

        JLabel answerTitle = QuizTheme.label(
                "Answer Details",
                18, 10, 500, 28,
                QuizTheme.SUBTITLE,
                QuizTheme.INK
        );
        answerCard.add(answerTitle);

        answerModel = new DefaultTableModel(
                new String[]{
                    "Question",
                    "Selected Answer",
                    "Correct Answer",
                    "Result"
                }, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        answerTable = new JTable(answerModel);
        styleTable(answerTable);
        answerTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        answerTable.getColumnModel().getColumn(0)
                .setPreferredWidth(550);
        answerTable.getColumnModel().getColumn(1)
                .setPreferredWidth(150);
        answerTable.getColumnModel().getColumn(2)
                .setPreferredWidth(150);
        answerTable.getColumnModel().getColumn(3)
                .setPreferredWidth(120);

        JScrollPane answerScroll = new JScrollPane(answerTable);
        answerScroll.setBounds(15, 43, 1150, 170);
        answerCard.add(answerScroll);

        // Select Student to Load Attempts
        studentTable.getSelectionModel()
                .addListSelectionListener(e -> {
                    if (e.getValueIsAdjusting()) {
                        return;
                    }

                    int row = studentTable.getSelectedRow();

                    if (row >= 0) {
                        int modelRow =
                                studentTable.convertRowIndexToModel(row);

                        int studentId = Integer.parseInt(
                                studentModel.getValueAt(modelRow, 0)
                                        .toString()
                        );

                        loadAttempts(studentId);
                    }
                });

        // Select Attempt to Load Answers
        attemptTable.getSelectionModel()
                .addListSelectionListener(e -> {
                    if (e.getValueIsAdjusting()) {
                        return;
                    }

                    int row = attemptTable.getSelectedRow();

                    if (row >= 0) {
                        int modelRow =
                                attemptTable.convertRowIndexToModel(row);

                        int attemptId = Integer.parseInt(
                                attemptModel.getValueAt(modelRow, 0)
                                        .toString()
                        );

                        System.out.println(
                                "Selected Attempt ID: " + attemptId
                        );

                        loadAnswers(attemptId);
                    }
                });
    }

    // Table Styling
    private void styleTable(JTable table) {
        table.setFont(QuizTheme.BODY);
        table.setRowHeight(28);
        table.setForeground(QuizTheme.INK);
        table.setBackground(Color.WHITE);
        table.setGridColor(QuizTheme.LINE);

        table.setSelectionBackground(new Color(220, 235, 255));
        table.setSelectionForeground(QuizTheme.INK);

        table.getTableHeader().setFont(QuizTheme.BODY_BOLD);
        table.getTableHeader().setBackground(QuizTheme.BRAND_DARK);
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setReorderingAllowed(false);
    }

    // Load All Students
    private void loadStudents() {
        studentModel.setRowCount(0);

        String sql =
                "SELECT s.student_id, s.student_name, s.email, " +
                "COUNT(qa.attempt_id) AS total_attempts " +
                "FROM Student s " +
                "LEFT JOIN Quiz_Attempt qa " +
                "ON s.student_id = qa.student_id " +
                "GROUP BY s.student_id, s.student_name, s.email " +
                "ORDER BY s.student_id";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()
        ) {
            while (rs.next()) {
                studentModel.addRow(new Object[]{
                    rs.getInt("student_id"),
                    rs.getString("student_name"),
                    rs.getString("email"),
                    rs.getInt("total_attempts")
                });
            }
        } catch (SQLException e) {
            showDatabaseError("Could not load students.", e);
        }
    }

    // Load Quiz Attempts for Selected Student
    private void loadAttempts(int studentId) {
        attemptModel.setRowCount(0);
        answerModel.setRowCount(0);

        String sql =
                "SELECT qa.attempt_id, sub.subject_name, " +
                "qa.score, qa.attempt_date " +
                "FROM Quiz_Attempt qa " +
                "LEFT JOIN Subject sub " +
                "ON qa.subject_id = sub.subject_id " +
                "WHERE qa.student_id = ? " +
                "ORDER BY qa.attempt_date DESC";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)
        ) {
            pst.setInt(1, studentId);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    String subject = rs.getString("subject_name");

                    if (subject == null) {
                        subject = "Unknown Subject";
                    }

                    attemptModel.addRow(new Object[]{
                        rs.getInt("attempt_id"),
                        subject,
                        rs.getInt("score"),
                        rs.getTimestamp("attempt_date")
                    });
                }
            }
        } catch (SQLException e) {
            showDatabaseError("Could not load quiz attempts.", e);
        }
    }

    // Load Answer Details for Selected Attempt
    private void loadAnswers(int attemptId) {
        answerModel.setRowCount(0);

        System.out.println(
                "Loading answers for Attempt ID: " + attemptId
        );

        String sql =
                "SELECT aa.answer_id, aa.question_id, " +
                "aa.selected_answer, aa.is_correct, " +
                "q.question_text, q.correct_answer " +
                "FROM Attempt_Answer aa " +
                "LEFT JOIN Question q " +
                "ON aa.question_id = q.question_id " +
                "WHERE aa.attempt_id = ? " +
                "ORDER BY aa.answer_id";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)
        ) {
            pst.setInt(1, attemptId);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    String question = rs.getString("question_text");
                    String selected = rs.getString("selected_answer");
                    String correct = rs.getString("correct_answer");

                    boolean isCorrect = rs.getBoolean("is_correct");

                    if (question == null || question.trim().isEmpty()) {
                        question = "Question ID: "
                                + rs.getInt("question_id");
                    }

                    if (selected == null || selected.trim().isEmpty()) {
                        selected = "Not Answered";
                    }

                    if (correct == null || correct.trim().isEmpty()) {
                        correct = "Not Available";
                    }

                    String result;

                    if ("Not Answered".equals(selected)) {
                        result = "Not Answered";
                    } else {
                        result = isCorrect ? "Correct" : "Wrong";
                    }

                    answerModel.addRow(new Object[]{
                        question,
                        selected,
                        correct,
                        result
                    });
                }
            }

            answerTable.revalidate();
            answerTable.repaint();

            System.out.println(
                    "Answer rows loaded: " + answerModel.getRowCount()
            );

            if (answerModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "No answer records found for Attempt ID: "
                                + attemptId,
                        "Answer Details",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }

        } catch (SQLException e) {
            showDatabaseError("Could not load answer details.", e);
        }
    }

    // Display Database Errors
    private void showDatabaseError(String message, SQLException e) {
        JOptionPane.showMessageDialog(
                this,
                message + "\n" + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}
