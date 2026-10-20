
package com.practice;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ManageQuestions extends JFrame {

    private Container c;
    private JLabel heading;
    private JTable questionTable;
    private DefaultTableModel model;
    private JScrollPane scrollPane;

    private JButton editButton;
    private JButton deleteButton;
    private JButton refreshButton;
    private JButton backButton;

    ManageQuestions() {
        initComponents();
        loadQuestions();
    }

    public void initComponents() {

        c = QuizTheme.page();
        this.setContentPane(c);
        c.setLayout(null);

        JPanel card = QuizTheme.card(30, 20, 1140, 530);
        c.add(card);
        card.setLayout(null);

        heading = QuizTheme.label(
                "Manage Questions",
                30, 15, 500, 45,
                QuizTheme.TITLE,
                QuizTheme.INK
        );
        card.add(heading);

        model = new DefaultTableModel(
                new String[]{
                    "ID", "Subject", "Question",
                    "Option A", "Option B",
                    "Option C", "Option D",
                    "Correct Answer"
                }, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        questionTable = new JTable(model);
        questionTable.setRowHeight(28);
        questionTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );
        questionTable.getTableHeader().setReorderingAllowed(false);

        scrollPane = new JScrollPane(questionTable);
        scrollPane.setBounds(20, 70, 1100, 340);
        card.add(scrollPane);

        editButton = QuizTheme.primaryButton(
                "Edit Question", 100, 435, 180, 40
        );
        card.add(editButton);

        deleteButton = QuizTheme.primaryButton(
                "Delete Question", 310, 435, 180, 40
        );
        card.add(deleteButton);

        refreshButton = QuizTheme.secondaryButton(
                "Refresh", 520, 435, 140, 40
        );
        card.add(refreshButton);

        backButton = QuizTheme.secondaryButton(
                "Back", 690, 435, 120, 40
        );
        card.add(backButton);

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editQuestion();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteQuestion();
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadQuestions();
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void loadQuestions() {

        model.setRowCount(0);

        String sql =
                "SELECT q.question_id, s.subject_name, " +
                "q.question_text, q.option_a, q.option_b, " +
                "q.option_c, q.option_d, q.correct_answer " +
                "FROM Question q " +
                "JOIN Subject s ON q.subject_id = s.subject_id " +
                "ORDER BY q.question_id";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getInt("question_id"),
                    rs.getString("subject_name"),
                    rs.getString("question_text"),
                    rs.getString("option_a"),
                    rs.getString("option_b"),
                    rs.getString("option_c"),
                    rs.getString("option_d"),
                    rs.getString("correct_answer")
                });
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Could not load questions!\n" + ex.getMessage()
            );

            ex.printStackTrace();
        }
    }

    private void editQuestion() {

        int row = questionTable.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(
                    this, "Please select a question first!"
            );
            return;
        }

        int id = (int) model.getValueAt(row, 0);

        JTextField questionField = new JTextField(
                model.getValueAt(row, 2).toString()
        );
        JTextField optionAField = new JTextField(
                model.getValueAt(row, 3).toString()
        );
        JTextField optionBField = new JTextField(
                model.getValueAt(row, 4).toString()
        );
        JTextField optionCField = new JTextField(
                model.getValueAt(row, 5).toString()
        );
        JTextField optionDField = new JTextField(
                model.getValueAt(row, 6).toString()
        );

        JComboBox<String> correctBox = new JComboBox<>(
                new String[]{"A", "B", "C", "D"}
        );
        correctBox.setSelectedItem(
                model.getValueAt(row, 7).toString()
        );

        JPanel panel = new JPanel(new GridLayout(0, 2, 8, 8));

        panel.add(new JLabel("Question:"));
        panel.add(questionField);

        panel.add(new JLabel("Option A:"));
        panel.add(optionAField);

        panel.add(new JLabel("Option B:"));
        panel.add(optionBField);

        panel.add(new JLabel("Option C:"));
        panel.add(optionCField);

        panel.add(new JLabel("Option D:"));
        panel.add(optionDField);

        panel.add(new JLabel("Correct Answer:"));
        panel.add(correctBox);

        int choice = JOptionPane.showConfirmDialog(
                this,
                panel,
                "Edit Question #" + id,
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (choice != JOptionPane.OK_OPTION) {
            return;
        }

        String question = questionField.getText().trim();
        String a = optionAField.getText().trim();
        String b = optionBField.getText().trim();
        String c = optionCField.getText().trim();
        String d = optionDField.getText().trim();
        String correct = correctBox.getSelectedItem().toString();

        if (question.isEmpty() || a.isEmpty() ||
                b.isEmpty() || c.isEmpty() || d.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this, "Please fill in all fields!"
            );
            return;
        }

        String sql =
                "UPDATE Question SET question_text=?, " +
                "option_a=?, option_b=?, option_c=?, " +
                "option_d=?, correct_answer=? " +
                "WHERE question_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, question);
            pst.setString(2, a);
            pst.setString(3, b);
            pst.setString(4, c);
            pst.setString(5, d);
            pst.setString(6, correct);
            pst.setInt(7, id);

            int updated = pst.executeUpdate();

            if (updated > 0) {
                JOptionPane.showMessageDialog(
                        this, "Question Updated Successfully!"
                );
                loadQuestions();
            } else {
                JOptionPane.showMessageDialog(
                        this, "Question was not updated."
                );
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Could not update question!\n" + ex.getMessage()
            );

            ex.printStackTrace();
        }
    }

    private void deleteQuestion() {

        int row = questionTable.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(
                    this, "Please select a question first!"
            );
            return;
        }

        int id = (int) model.getValueAt(row, 0);

        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete this question?",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (choice != JOptionPane.YES_OPTION) {
            return;
        }

        String sql =
                "DELETE FROM Question WHERE question_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);

            int deleted = pst.executeUpdate();

            if (deleted > 0) {
                JOptionPane.showMessageDialog(
                        this, "Question Deleted Successfully!"
                );
                loadQuestions();
            } else {
                JOptionPane.showMessageDialog(
                        this, "Question was not deleted."
                );
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Could not delete question!\n" + ex.getMessage()
            );

            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                ManageQuestions frame = new ManageQuestions();

                frame.setDefaultCloseOperation(
                        JFrame.EXIT_ON_CLOSE
                );
                frame.setSize(1200, 620);
                frame.setTitle("Manage Questions");
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
