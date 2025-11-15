package com.Quiz.src.prc;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;


public class Login extends JFrame{
    private ImageIcon img,img2;
    private Container c;
    private JLabel heading,imgset;
    private JTextField tf1;
    private JButton play,back;

    Login(){
        initComponents();
    }

    public void initComponents(){
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.BLUE);

        img = new ImageIcon(getClass().getResource("image1.png"));
        this.setIconImage(img.getImage());
        
        img2 = new ImageIcon(getClass().getResource("image.png"));
        imgset = new JLabel(img2);
        imgset.setBounds(50,20,img2.getIconWidth(),img2.getIconHeight());
        c.add(imgset);

        heading = new JLabel("Enter your name");
        heading.setBounds(735,120,300,50);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 25));
        heading.setForeground(new Color(ABORT));
        c.add(heading);
        
        tf1 = new JTextField();
        tf1.setBounds(735,200,300,25);
        tf1.setFont(new Font("Arial",Font.PLAIN,16));
        tf1.setHorizontalAlignment(JTextField.CENTER);
        c.add(tf1);

        play = new JButton("Play");
        play.setBounds(735,270,120,25);
        play.setBackground(new Color(30,144,254));
        play.setForeground(Color.magenta);
        c.add(play);

        back = new JButton("Back");
        back.setBounds(915,270,120,25);
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.magenta);
        c.add(back);

        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String username = tf1.getText();
                if(username.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter your name");
                }else{
                    dispose();
                    SubjectSelection ss = new SubjectSelection(username);
                    ss.setVisible(true);
                    ss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ss.setSize(1200, 500);
                    ss.setTitle("Subject Selection");
                    ss.setResizable(false);
                    ss.setLocationRelativeTo(null);
                }
            }
        });
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        Login frame = new Login();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 500);
        frame.setTitle("Login page");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}