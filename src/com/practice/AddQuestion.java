package com.practice;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddQuestion extends JFrame {

    private Container c;

    private JLabel heading;
    private JLabel subjectLabel;
    private JLabel questionLabel;
    private JLabel optionALabel;
    private JLabel optionBLabel;
    private JLabel optionCLabel;
    private JLabel optionDLabel;
    private JLabel correctLabel;

    private JComboBox<String> subjectBox;
    private JTextField questionField;
    private JTextField optionAField;
    private JTextField optionBField;
    private JTextField optionCField;
    private JTextField optionDField;
    private JComboBox<String> correctBox;

    private JButton addButton;
    private JButton backButton;

    AddQuestion() {
        initComponents();
    }

    public void initComponents() {

        c = QuizTheme.page();
        this.setContentPane(c);

        JPanel card = QuizTheme.card(300, 25, 600, 440);
        c.add(card);

        heading = QuizTheme.label(
                "Add Question",
                36, 20, 400, 45,
                QuizTheme.TITLE,
                QuizTheme.INK
        );
        card.add(heading);

        subjectLabel = QuizTheme.label(
                "Subject",
                30, 75, 100, 25,
                QuizTheme.SUBTITLE,
                QuizTheme.MUTED
        );
        card.add(subjectLabel);

        subjectBox = new JComboBox<>();
        subjectBox.setBounds(150, 72, 390, 35);
        card.add(subjectBox);

        questionLabel = QuizTheme.label(
                "Question",
                30, 120, 100, 25,
                QuizTheme.SUBTITLE,
                QuizTheme.MUTED
        );
        card.add(questionLabel);

        questionField = new JTextField();
        questionField.setBounds(150, 117, 390, 35);
        QuizTheme.styleTextField(questionField);
        card.add(questionField);

        optionALabel = QuizTheme.label(
                "Option A",
                30, 165, 100, 25,
                QuizTheme.SUBTITLE,
                QuizTheme.MUTED
        );
        card.add(optionALabel);

        optionAField = new JTextField();
        optionAField.setBounds(150, 162, 390, 35);
        QuizTheme.styleTextField(optionAField);
        card.add(optionAField);

        optionBLabel = QuizTheme.label(
                "Option B",
                30, 210, 100, 25,
                QuizTheme.SUBTITLE,
                QuizTheme.MUTED
        );
        card.add(optionBLabel);

        optionBField = new JTextField();
        optionBField.setBounds(150, 207, 390, 35);
        QuizTheme.styleTextField(optionBField);
        card.add(optionBField);

        optionCLabel = QuizTheme.label(
                "Option C",
                30, 255, 100, 25,
                QuizTheme.SUBTITLE,
                QuizTheme.MUTED
        );
        card.add(optionCLabel);

        optionCField = new JTextField();
        optionCField.setBounds(150, 252, 390, 35);
        QuizTheme.styleTextField(optionCField);
        card.add(optionCField);

        optionDLabel = QuizTheme.label(
                "Option D",
                30, 300, 100, 25,
                QuizTheme.SUBTITLE,
                QuizTheme.MUTED
        );
        card.add(optionDLabel);

        optionDField = new JTextField();
        optionDField.setBounds(150, 297, 390, 35);
        QuizTheme.styleTextField(optionDField);
        card.add(optionDField);

        correctLabel = QuizTheme.label(
                "Correct Answer",
                30, 345, 110, 25,
                QuizTheme.SUBTITLE,
                QuizTheme.MUTED
        );
        card.add(correctLabel);

        correctBox = new JComboBox<>(
                new String[]{"A", "B", "C", "D"}
        );
        correctBox.setBounds(150, 342, 100, 35);
        card.add(correctBox);

        addButton = QuizTheme.primaryButton(
                "Add Question",
                150, 390, 180, 40
        );
        card.add(addButton);

        backButton = QuizTheme.secondaryButton(
                "Back",
                350, 390, 120, 40
        );
        card.add(backButton);

        loadSubjects();

        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                addQuestionToDatabase();
            }
        });

        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });
    }

    private void loadSubjects() {

        String sql = "SELECT subject_id, subject_name FROM Subject";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("subject_id");
                String name = rs.getString("subject_name");

                subjectBox.addItem(id + " - " + name);
            }

            con.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    null,
                    "Could not load subjects!"
            );

            ex.printStackTrace();
        }
    }

    private void addQuestionToDatabase() {

        if (subjectBox.getSelectedItem() == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "Please select a subject!"
            );

            return;
        }

        String question = questionField.getText();
        String optionA = optionAField.getText();
        String optionB = optionBField.getText();
        String optionC = optionCField.getText();
        String optionD = optionDField.getText();
        String correctAnswer =
                correctBox.getSelectedItem().toString();

        if (question.isEmpty() ||
                optionA.isEmpty() ||
                optionB.isEmpty() ||
                optionC.isEmpty() ||
                optionD.isEmpty()) {

            JOptionPane.showMessageDialog(
                    null,
                    "Please fill in all fields!"
            );

            return;
        }

        String selectedSubject =
                subjectBox.getSelectedItem().toString();

        int subjectId = Integer.parseInt(
                selectedSubject.split(" - ")[0]
        );

        String sql =
                "INSERT INTO Question " +
                "(subject_id, question_text, option_a, option_b, " +
                "option_c, option_d, correct_answer) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement pst =
                    con.prepareStatement(sql);

            pst.setInt(1, subjectId);
            pst.setString(2, question);
            pst.setString(3, optionA);
            pst.setString(4, optionB);
            pst.setString(5, optionC);
            pst.setString(6, optionD);
            pst.setString(7, correctAnswer);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Question Added Successfully!"
            );

            questionField.setText("");
            optionAField.setText("");
            optionBField.setText("");
            optionCField.setText("");
            optionDField.setText("");

            con.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    null,
                    "Could not add question!"
            );

            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        AddQuestion frame = new AddQuestion();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 500);
        frame.setTitle("Add Question");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}