package com.Quiz.src.prc;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

public class Quiz extends JFrame { 
    private Container c; 
    private String questions[][] = new String[5][5]; 
    private String answers[][] = new String[5][1]; 
    private String useranswers[][] = new String[5][1]; 
    private JLabel qno, question, timerLabel; 
    private JRadioButton opt1, opt2, opt3, opt4; 
    private ButtonGroup options; 
    private JButton next, submit; 
    private int timer = 15; 
    private int count = 0; 
    private String username, subject; 
    private Timer countdownTimer; 

    private String dsQuestions[][] = new String[5][5]; 
    private String dsAnswers[][] = new String[5][1]; 
    private String oopQuestions[][] = new String[5][5]; 
    private String oopAnswers[][] = new String[5][1]; 
    private String algoQuestions[][] = new String[5][5]; 
    private String algoAnswers[][] = new String[5][1]; 
    private String gkQuestions[][] = new String[5][5]; 
    private String gkAnswers[][] = new String[5][1]; 

    Quiz(String name, String subject) { 
        this.username = name; 
        this.subject = subject; 
        loadQuestions(subject); 
        useranswers = new String[questions.length][1]; 
        initComponents(); 
    } 

    public void initComponents() { 
        c = this.getContentPane(); 
        c.setLayout(null); 
        c.setBackground(Color.WHITE); 

        qno = new JLabel(); 
        qno.setBounds(100, 200, 50, 30); 
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24)); 
        c.add(qno); 

        question = new JLabel(); 
        question.setBounds(150, 200, 900, 30); 
        question.setFont(new Font("Tahoma", Font.PLAIN, 24)); 
        c.add(question); 

        timerLabel = new JLabel("Time left: 15 seconds"); 
        timerLabel.setBounds(1100, 200, 300, 30); 
        timerLabel.setFont(new Font("Tahoma", Font.BOLD, 20)); 
        timerLabel.setForeground(Color.RED); 
        c.add(timerLabel); 

        opt1 = new JRadioButton(); 
        opt1.setBounds(170, 270, 700, 30); 
        opt1.setBackground(Color.WHITE); 
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20)); 
        c.add(opt1); 

        opt2 = new JRadioButton(); 
        opt2.setBounds(170, 320, 700, 30); 
        opt2.setBackground(Color.WHITE); 
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20)); 
        c.add(opt2); 

        opt3 = new JRadioButton(); 
        opt3.setBounds(170, 370, 700, 30); 
        opt3.setBackground(Color.WHITE); 
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20)); 
        c.add(opt3); 

        opt4 = new JRadioButton(); 
        opt4.setBounds(170, 420, 700, 30); 
        opt4.setBackground(Color.WHITE); 
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20)); 
        c.add(opt4); 

        options = new ButtonGroup(); 
        options.add(opt1); 
        options.add(opt2); 
        options.add(opt3); 
        options.add(opt4); 

        setupButtonsAndTimer(); 
    } 

    public void setupButtonsAndTimer() { 
        next = new JButton("Next"); 
        next.setBounds(1100, 500, 200, 40); 
        next.setFont(new Font("Tahoma", Font.PLAIN, 22)); 
        next.setBackground(new Color(30, 144, 255)); 
        next.setForeground(Color.WHITE); 
        next.addActionListener(e -> { 
            saveAnswer(); 
            if (count == questions.length - 2) { 
                next.setEnabled(false); 
                submit.setEnabled(true); 
            } 
            count++; 
            start(count); 
            timer = 15; 
        }); 
        c.add(next); 

        submit = new JButton("Submit"); 
        submit.setBounds(1100, 550, 200, 40); 
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22)); 
        submit.setBackground(new Color(30, 144, 255)); 
        submit.setForeground(Color.WHITE); 
        submit.setEnabled(false); 
        submit.addActionListener(e -> { 
            saveAnswer(); 
            countdownTimer.stop(); 
            int score = 0; 
            for (int i = 0; i < useranswers.length; i++) { 
                if (useranswers[i][0] != null && useranswers[i][0].equals(answers[i][0])) { 
                    score += 10; 
                } 
            } 
            dispose(); 
            Score scoreFrame = new Score(username, subject, score); 
            scoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            scoreFrame.setBounds(400, 150, 750, 550); 
            scoreFrame.setTitle("Show Score"); 
            scoreFrame.setResizable(false); 
            scoreFrame.setVisible(true); 
            scoreFrame.setLocationRelativeTo(null); 
        }); 
        c.add(submit); 

        start(count); 

        countdownTimer = new Timer(1000, new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                timerLabel.setText("Time left: " + timer + " seconds"); 
                timer--; 
                if (timer < 0) { 
                    saveAnswer(); 
                    timer = 15; 
                    if (count == questions.length - 2) { 
                        next.setEnabled(false); 
                        submit.setEnabled(true); 
                    } 
                    if (count == questions.length - 1) { 
                        countdownTimer.stop(); 
                        submit.doClick(); 
                        return; 
                    } 
                    count++; 
                    start(count); 
                } 
            } 
        }); 
        countdownTimer.start(); 
    } 
 

    public void loadQuestions(String subject) { 
        // ---------------- Data Structure ---------------- 
        dsQuestions[0][0]="Which data structure uses LIFO?"; 
        dsQuestions[0][1]="Queue"; 
        dsQuestions[0][2]="Stack"; 
        dsQuestions[0][3]="Array"; 
        dsQuestions[0][4]="LinkedList"; 
        dsAnswers[0][0]="Stack"; 

        dsQuestions[1][0]="Which data structure uses FIFO?"; 
        dsQuestions[1][1]="Stack"; 
        dsQuestions[1][2]="Queue"; 
        dsQuestions[1][3]="Array"; 
        dsQuestions[1][4]="Tree"; 
        dsAnswers[1][0]="Queue"; 

        dsQuestions[2][0]="Which is a linear data structure?"; 
        dsQuestions[2][1]="Tree"; 
        dsQuestions[2][2]="Graph"; 
        dsQuestions[2][3]="Array"; 
        dsQuestions[2][4]="Heap"; 
        dsAnswers[2][0]="Array"; 

        dsQuestions[3][0]="Which structure uses nodes and pointers?"; 
        dsQuestions[3][1]="Array"; 
        dsQuestions[3][2]="Stack"; 
        dsQuestions[3][3]="Queue"; 
        dsQuestions[3][4]="LinkedList"; 
        dsAnswers[3][0]="LinkedList"; 

        dsQuestions[4][0]="Which is not a primitive data structure?"; 
        dsQuestions[4][1]="Array"; 
        dsQuestions[4][2]="Stack"; 
        dsQuestions[4][3]="Queue"; 
        dsQuestions[4][4]="LinkedList"; 
        dsAnswers[4][0]="LinkedList"; 
 

        // ---------------- OOP ---------------- 
        oopQuestions[0][0]="Which keyword is used for inheritance in Java?"; 
        oopQuestions[0][1]="this"; 
        oopQuestions[0][2]="super"; 
        oopQuestions[0][3]="extends"; 
        oopQuestions[0][4]="implements"; 
        oopAnswers[0][0]="extends"; 

        oopQuestions[1][0]="What is encapsulation?"; 
        oopQuestions[1][1]="Hiding data"; 
        oopQuestions[1][2]="Polymorphism"; 
        oopQuestions[1][3]="Inheritance"; 
        oopQuestions[1][4]="Abstraction"; 
        oopAnswers[1][0]="Hiding data"; 

        oopQuestions[2][0]="What is polymorphism?"; 
        oopQuestions[2][1]="One interface, many forms"; 
        oopQuestions[2][2]="Data hiding"; 
        oopQuestions[2][3]="Class extension"; 
        oopQuestions[2][4]="Object creation"; 
        oopAnswers[2][0]="One interface, many forms"; 

        oopQuestions[3][0]="Which keyword is used to refer parent class object?"; 
        oopQuestions[3][1]="super"; 
        oopQuestions[3][2]="this"; 
        oopQuestions[3][3]="extends"; 
        oopQuestions[3][4]="final"; 
        oopAnswers[3][0]="super"; 

        oopQuestions[4][0]="What is abstraction?"; 
        oopQuestions[4][1]="Hiding details"; 
        oopQuestions[4][2]="Multiple objects"; 
        oopQuestions[4][3]="Looping"; 
        oopQuestions[4][4]="Inheritance"; 
        oopAnswers[4][0]="Hiding details"; 

  

        // ---------------- Algorithm ---------------- 
        algoQuestions[0][0]="Which is a searching algorithm?"; 
        algoQuestions[0][1]="Bubble Sort"; 
        algoQuestions[0][2]="Binary Search"; 
        algoQuestions[0][3]="Selection Sort"; 
        algoQuestions[0][4]="Merge Sort"; 
        algoAnswers[0][0]="Binary Search"; 

        algoQuestions[1][0]="Which is a sorting algorithm?"; 
        algoQuestions[1][1]="Binary Search"; 
        algoQuestions[1][2]="DFS"; 
        algoQuestions[1][3]="Merge Sort"; 
        algoQuestions[1][4]="BFS"; 
        algoAnswers[1][0]="Merge Sort"; 

        algoQuestions[2][0]="What is complexity of Binary Search?"; 
        algoQuestions[2][1]="O(n)"; 
        algoQuestions[2][2]="O(log n)"; 
        algoQuestions[2][3]="O(n^2)"; 
        algoQuestions[2][4]="O(n log n)"; 
        algoAnswers[2][0]="O(log n)"; 

        algoQuestions[3][0]="DFS stands for?"; 
        algoQuestions[3][1]="Depth First Search"; 
        algoQuestions[3][2]="Data Flow Search"; 
        algoQuestions[3][3]="Direct First Search"; 
        algoQuestions[3][4]="Depth Function Search"; 
        algoAnswers[3][0]="Depth First Search"; 

        algoQuestions[4][0]="BFS stands for?"; 
        algoQuestions[4][1]="Breadth First Search"; 
        algoQuestions[4][2]="Binary First Search"; 
        algoQuestions[4][3]="Breadth Function Search"; 
        algoQuestions[4][4]="Best First Search"; 
        algoAnswers[4][0]="Breadth First Search"; 
 

        // ---------------- General Knowledge ---------------- 
        gkQuestions[0][0]="Capital of Bangladesh?"; 
        gkQuestions[0][1]="Dhaka"; 
        gkQuestions[0][2]="Chittagong"; 
        gkQuestions[0][3]="Khulna"; 
        gkQuestions[0][4]="Barishal"; 
        gkAnswers[0][0]="Dhaka"; 

        gkQuestions[1][0]="Who wrote Harry Potter?"; 
        gkQuestions[1][1]="J.K. Rowling"; 
        gkQuestions[1][2]="Tolkien"; 
        gkQuestions[1][3]="Lewis"; 
        gkQuestions[1][4]="Rowling"; 
        gkAnswers[1][0]="J.K. Rowling"; 

        gkQuestions[2][0]="Which planet is known as Red Planet?"; 
        gkQuestions[2][1]="Mars"; 
        gkQuestions[2][2]="Venus"; 
        gkQuestions[2][3]="Jupiter"; 
        gkQuestions[2][4]="Saturn"; 
        gkAnswers[2][0]="Mars"; 

        gkQuestions[3][0]="Which is largest ocean?"; 
        gkQuestions[3][1]="Atlantic"; 
        gkQuestions[3][2]="Pacific"; 
        gkQuestions[3][3]="Indian"; 
        gkQuestions[3][4]="Arctic"; 
        gkAnswers[3][0]="Pacific"; 

        gkQuestions[4][0]="Who discovered gravity?"; 
        gkQuestions[4][1]="Newton"; 
        gkQuestions[4][2]="Einstein"; 
        gkQuestions[4][3]="Galileo"; 
        gkQuestions[4][4]="Tesla"; 
        gkAnswers[4][0]="Newton"; 

         

        if(subject.equals("Data Structure")) { 
            questions = dsQuestions; 
            answers = dsAnswers; 
        } 
        else if(subject.equals("OOP")) { 
            questions = oopQuestions; 
            answers = oopAnswers; 
        } 
        else if(subject.equals("Algorithm")) { 
            questions = algoQuestions; 
            answers = algoAnswers; 
        } 
        else if(subject.equals("General Knowledge")) { 
            questions = gkQuestions; 
            answers = gkAnswers; 
        } 
    }
    public void start(int count) { 
        qno.setText("" + (count + 1) + ". "); 
        question.setText(questions[count][0]); 
        opt1.setText(questions[count][1]); 
        opt2.setText(questions[count][2]); 
        opt3.setText(questions[count][3]); 
        opt4.setText(questions[count][4]); 
        options.clearSelection(); 
    } 

    public void saveAnswer() { 
        String answer = ""; 
        if (opt1.isSelected()) answer = opt1.getText(); 
        else if (opt2.isSelected()) answer = opt2.getText(); 
        else if (opt3.isSelected()) answer = opt3.getText(); 
        else if (opt4.isSelected()) answer = opt4.getText(); 
        useranswers[count][0] = answer; 
    }  
}
