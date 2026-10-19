package com.practice;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class QuizTheme {
    static final Color INK = new Color(24, 32, 46);
    static final Color MUTED = new Color(96, 111, 132);
    static final Color BRAND = new Color(31, 110, 235);
    static final Color BRAND_DARK = new Color(15, 75, 184);
    static final Color SOFT_BLUE = new Color(232, 240, 255);
    static final Color SURFACE = new Color(255, 255, 255);
    static final Color LINE = new Color(218, 226, 239);
    static final Color DANGER = new Color(220, 53, 69);
    static final Color SUCCESS = new Color(35, 146, 89);

    static final Font TITLE = new Font("Segoe UI", Font.BOLD, 30);
    static final Font SUBTITLE = new Font("Segoe UI", Font.PLAIN, 16);
    static final Font BODY = new Font("Segoe UI", Font.PLAIN, 16);
    static final Font BODY_BOLD = new Font("Segoe UI", Font.BOLD, 16);
    static final Font BUTTON = new Font("Segoe UI", Font.BOLD, 15);

    private QuizTheme() {
    }

    static JPanel page() {
        JPanel panel = new GradientPanel();
        panel.setLayout(null);
        return panel;
    }

    static JPanel card(int x, int y, int width, int height) {
        JPanel panel = new RoundedPanel(24, SURFACE);
        panel.setLayout(null);
        panel.setBounds(x, y, width, height);
        panel.setBorder(new CompoundBorder(new LineBorder(LINE, 1, true), new EmptyBorder(20, 20, 20, 20)));
        return panel;
    }

    static JLabel label(String text, int x, int y, int width, int height, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(font);
        label.setForeground(color);
        return label;
    }

    static JButton primaryButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(BUTTON);
        button.setBackground(BRAND);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(new EmptyBorder(8, 18, 8, 18));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    static JButton secondaryButton(String text, int x, int y, int width, int height) {
        JButton button = primaryButton(text, x, y, width, height);
        button.setBackground(SOFT_BLUE);
        button.setForeground(BRAND_DARK);
        return button;
    }

    static void styleTextField(JTextField field) {
        field.setFont(BODY);
        field.setForeground(INK);
        field.setHorizontalAlignment(JTextField.CENTER);
        field.setBorder(new CompoundBorder(new LineBorder(LINE, 1, true), new EmptyBorder(8, 12, 8, 12)));
    }

    static void styleOption(JRadioButton option, int x, int y, int width, int height) {
        option.setBounds(x, y, width, height);
        option.setFont(BODY_BOLD);
        option.setForeground(INK);
        option.setBackground(SURFACE);
        option.setFocusPainted(false);
        option.setBorder(new CompoundBorder(new LineBorder(LINE, 1, true), new EmptyBorder(10, 14, 10, 14)));
        option.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private static class GradientPanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setPaint(new GradientPaint(0, 0, new Color(245, 248, 255), getWidth(), getHeight(), new Color(230, 246, 241)));
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.dispose();
        }
    }

    private static class RoundedPanel extends JPanel {
        private final int arc;
        private final Color color;

        RoundedPanel(int arc, Color color) {
            this.arc = arc;
            this.color = color;
            setOpaque(false);
        }

        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arc, arc);
            g2.dispose();
            super.paintComponent(g);
        }
    }
}
