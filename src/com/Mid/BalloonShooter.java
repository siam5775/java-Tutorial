package com.Mid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class BalloonShooter extends JPanel implements ActionListener, MouseListener {

    final int WIDTH = 600;
    final int HEIGHT = 700;

    Timer timer = new Timer(16, this);
    Random random = new Random();

    // shooter
    int shooterX = WIDTH / 2;
    int shooterY = HEIGHT - 80;

    // bullet
    int bulletX, bulletY;
    int dx, dy;
    boolean shooting = false;

    // score
    int score = 0;

    // balloons (grid)
    int rows = 4;
    int cols = 8;
    int[][] bx = new int[rows][cols];
    int[][] by = new int[rows][cols];
    boolean[][] alive = new boolean[rows][cols];

    Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA};

    public BalloonShooter() {

        JFrame frame = new JFrame("Balloon Shooter 💥");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setResizable(false);
        frame.setVisible(true);

        addMouseListener(this);

        // init balloons
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                bx[i][j] = 60 + j * 60;
                by[i][j] = 60 + i * 60;
                alive[i][j] = true;
            }
        }

        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 20, 30);

        // shooter
        g.setColor(Color.WHITE);
        g.fillRect(shooterX - 20, shooterY - 10, 40, 40);

        // bullet
        if (shooting) {
            g.setColor(Color.ORANGE);
            g.fillOval(bulletX - 10, bulletY - 10, 20, 20);
        }

        // balloons
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (alive[i][j]) {
                    g.setColor(colors[(i + j) % colors.length]);
                    g.fillOval(bx[i][j] - 20, by[i][j] - 20, 40, 40);
                }
            }
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (shooting) {
            bulletX += dx;
            bulletY += dy;

            // collision check
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    if (alive[i][j]) {
                        int dist = (int)Math.sqrt(
                                Math.pow(bx[i][j] - bulletX, 2) +
                                Math.pow(by[i][j] - bulletY, 2)
                        );

                        if (dist < 25) {
                            alive[i][j] = false;
                            shooting = false;
                            score += 10;
                            resetBullet();
                        }
                    }
                }
            }

            // reset if out
            if (bulletY < 0 || bulletX < 0 || bulletX > WIDTH) {
                shooting = false;
                resetBullet();
            }
        }

        repaint();
    }

    void resetBullet() {
        bulletX = shooterX;
        bulletY = shooterY;
    }

    public void mouseClicked(MouseEvent e) {

        if (!shooting) {
            bulletX = shooterX;
            bulletY = shooterY;

            double angle = Math.atan2(shooterY - e.getY(), e.getX() - shooterX);

            int speed = 12;
            dx = (int)(Math.cos(angle) * speed);
            dy = (int)(Math.sin(angle) * speed);

            shooting = true;
        }
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new BalloonShooter();
    }
}