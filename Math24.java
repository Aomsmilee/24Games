import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.*;

public class Math24 extends JFrame{
    private JPanel panel;
    private static boolean[] buttonClicked = new boolean[4];
    private static Random rnd = new Random();
    private static int score = 0;
    private static Timer countdownTimer;
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
    }
    private int secondsRemaining = 180;

    JFrame frame = new JFrame();
    JButton btn = new JButton("Random");
    JTextField ans = new JTextField();
    JButton btncheck = new JButton("Check");
    JLabel rdLabel = new JLabel("1");
    JLabel rdLabel1 = new JLabel("2");
    JLabel rdLabel2 = new JLabel("3");
    JLabel rdLabel3 = new JLabel("4");
    JLabel scoreLabel = new JLabel("Score : 0");
    JLabel timeLabel = new JLabel("Time : seconds");


    Math24() {
        frame.setTitle("twentyfour game");
        frame.setSize(600, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ปิดโปรแกรม

        ImageIcon icon = new ImageIcon("image/icon.png"); // เปลี่ยน path เป็นที่อยู่ของไอคอนของคุณ
        frame.setIconImage(icon.getImage());

        panel = new BackPlay();

        panel.add(btn);
        btn.setBounds(190, 480, 200, 40);
        btn.setOpaque(false);//หลังใส
        btn.setContentAreaFilled(false);//พทปุ่มจะไม่มีสีเข้ามา
        btn.setBorderPainted(false);//ไม่แสดงขอบ
        btn.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        btn.setForeground(Color.BLACK);

        ans.setEditable(false);
        ans.setBorder(null);
        ans.setOpaque(false);
        panel.add(ans);
        ans.setBounds(100, 270, 300, 40);

        panel.add(btncheck);
        btncheck.setBounds(410, 270, 100, 40);
        btncheck.setOpaque(false);//หลังใส
        btncheck.setContentAreaFilled(false);//พทปุ่มจะไม่มีสีเข้ามา
        btncheck.setBorderPainted(false);//ไม่แสดงขอบ
        btncheck.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btncheck.setForeground(Color.black);

        rdLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        panel.add(rdLabel);
        rdLabel.setBounds(105, 145, 200, 60);

        rdLabel1.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        panel.add(rdLabel1);
        rdLabel1.setBounds(222, 145, 200, 60);

        rdLabel2.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        panel.add(rdLabel2);
        rdLabel2.setBounds(340, 145, 200, 60);

        rdLabel3.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        panel.add(rdLabel3);
        rdLabel3.setBounds(460, 145, 200, 60);

        scoreLabel.setFont(scoreLabel.getFont().deriveFont(32f));
        panel.add(scoreLabel);
        scoreLabel.setBounds(60, 30, 200, 60);
        scoreLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 24));

        timeLabel.setFont(timeLabel.getFont().deriveFont(24f));
        panel.add(timeLabel);
        timeLabel.setBounds(60, 73, 300, 60);
        timeLabel.setBackground(new Color(0, 0, 0, 0));
        timeLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 24));

        frame.setContentPane(panel);
        panel.setLayout(null);
        frame.setVisible(true);

        countdownTimer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            secondsRemaining--;
            timeLabel.setText(secondsRemaining + " seconds");
            if (secondsRemaining == 0) {
                ((Timer) e.getSource()).stop(); // หยุด Timer เมื่อนับถอยหลังเสร็จสิ้น
                JOptionPane.showMessageDialog(frame, "Game Over\nYour Score : " + score, "Game Over", JOptionPane.ERROR_MESSAGE);
                secondsRemaining = 180;
                score = 0;
                scoreLabel.setText("Score : " + score);
                
            }
        }
    });
    btn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Integer> numbers = new ArrayList<>();
            for (int i = 0; i <= 9; i++) {
                numbers.add(i);
            }
            Collections.shuffle(numbers);

            rdLabel.setText(numbers.get(0).toString());
            rdLabel1.setText(numbers.get(1).toString());
            rdLabel2.setText(numbers.get(2).toString());
            rdLabel3.setText(numbers.get(3).toString());
            
            int num1 = Integer.parseInt(rdLabel.getText());
            int num2 = Integer.parseInt(rdLabel1.getText());
            int num3 = Integer.parseInt(rdLabel2.getText());
            int num4 = Integer.parseInt(rdLabel3.getText());

            countdownTimer.start();
            Arrays.fill(buttonClicked, false);
            // Remove existing btn1 if exists
            Component[] components = frame.getContentPane().getComponents();
            for (Component component : components) {
                if (component instanceof JButton && component != btn) {
                    frame.getContentPane().remove(component);
                }
            }
            components = frame.getContentPane().getComponents();
            for (Component component : components) {
                if (component instanceof JTextField && component != ans) {
                    frame.getContentPane().remove(component);
                }
            }
            frame.revalidate();
            frame.repaint();

            ans.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

            JButton btn1 = new JButton("" + num1);
            panel.add(btn1);
            btn1.setBounds(75, 325, 50, 50);
            btn1.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
            btn1.setBackground(new Color(207,237,255));
            btn1.setBorderPainted(false);
            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == btn1) {
                        if (ans.getText().isEmpty() || isOperator(ans.getText().charAt(ans.getText().length() - 1))) {
                            btn1.setEnabled(false);
                            ans.setText(ans.getText().concat(String.valueOf(num1)));
                            buttonClicked[0] = true;
                        }
                    }
                }
            });

            JButton btn2 = new JButton("" + num2);
            panel.add(btn2);
            btn2.setBounds(165, 325, 50, 50);
            btn2.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
            btn2.setBackground(new Color(207,237,255));
            btn2.setBorderPainted(false);
            btn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == btn2) {
                        if (ans.getText().isEmpty() || isOperator(ans.getText().charAt(ans.getText().length() - 1))) {
                            btn2.setEnabled(false);
                            ans.setText(ans.getText().concat(String.valueOf(num2)));
                            buttonClicked[1] = true;
                        }
                    }
                }
            });

            JButton btn3 = new JButton("" + num3);
            panel.add(btn3);
            btn3.setBounds(255, 325, 50, 50);
            btn3.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
            btn3.setBackground(new Color(207,237,255));
            btn3.setBorderPainted(false);
            btn3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == btn3) {
                        if (ans.getText().isEmpty() || isOperator(ans.getText().charAt(ans.getText().length() - 1))) {
                            btn3.setEnabled(false);
                            ans.setText(ans.getText().concat(String.valueOf(num3)));
                            buttonClicked[2] = true;
                        }
                    }
                }
            });

            JButton btn4 = new JButton("" + num4);
            panel.add(btn4);
            btn4.setBounds(345, 325, 50, 50);
            btn4.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
            btn4.setBackground(new Color(207,237,255));
            btn4.setBorderPainted(false);
            btn4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == btn4) {
                        if (ans.getText().isEmpty() || isOperator(ans.getText().charAt(ans.getText().length() - 1))) {
                            btn4.setEnabled(false);
                            ans.setText(ans.getText().concat(String.valueOf(num4)));
                            buttonClicked[3] = true;
                        }
                    }
                }
            });

            JButton mulbtn = new JButton("*");
            panel.add(mulbtn);
            mulbtn.setBounds(75, 400, 50, 50);
            mulbtn.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
            mulbtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == mulbtn) {
                        ans.setText(ans.getText().concat(String.valueOf("*")));
                    }
                }
            });

            JButton divbtn = new JButton("/");
            panel.add(divbtn);
            divbtn.setBounds(150, 400, 50, 50);
            divbtn.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
            divbtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == divbtn) {
                        ans.setText(ans.getText().concat(String.valueOf("/")));
                    }
                }
            });
            JButton addbtn = new JButton("+");
            panel.add(addbtn);
            addbtn.setBounds(225, 400, 50, 50);
            addbtn.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
            addbtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == addbtn) {
                        ans.setText(ans.getText().concat(String.valueOf("+")));
                    }
                }
            });
            JButton subbtn = new JButton("-");
            panel.add(subbtn);
            subbtn.setBounds(300, 400, 50, 50);
            subbtn.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
            subbtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == subbtn) {
                        ans.setText(ans.getText().concat(String.valueOf("-")));
                    }
                }
            });
            JButton rop = new JButton("(");
            panel.add(rop);
            rop.setBounds(375, 400, 50, 50);
            rop.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
            rop.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == rop) {
                        ans.setText(ans.getText().concat(String.valueOf("(")));
                        
                    }
                }
            });
            JButton rc = new JButton(")");
            panel.add(rc);
            rc.setBounds(450, 400, 50, 50);
            rc.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
            rc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == rc) {
                        ans.setText(ans.getText().concat(String.valueOf(")")));
                    }
                }
            });
            JButton deleteBtn = new JButton("Del");
            panel.add(deleteBtn);
            deleteBtn.setBounds(430, 325, 70, 50);
            deleteBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
            deleteBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(e.getSource() == deleteBtn) {
                        String str = ans.getText();
                        ans.setText("");
                        boolean found = false; // ตั้งค่าเริ่มต้นให้ found เป็นเท็จ
                        for(int i = 0; i < str.length()-1 ; i++) {
                            ans.setText(ans.getText()+str.charAt(i));
                        }
                        // เมื่อลบตัวอักษรแล้ว เปิดใช้งานปุ่มตามตำแหน่งที่ถูกลบไปใหม่
                        // โดยตรวจสอบว่าตำแหน่งนั้นมีตัวเลขของปุ่มหรือไม่ และเปิดใช้งานปุ่มนั้น
                        char deletedChar = str.charAt(str.length() - 1);//5
                        if (deletedChar == rdLabel.getText().charAt(0)) {//5
                            if (!found) {
                                btn1.setEnabled(true);
                                found = true; // เปลี่ยนค่า found เป็นจริงเมื่อเปิดปุ่มครั้งแรก
                            }
                        }
                        else if (deletedChar == rdLabel1.getText().charAt(0)) {//5
                            if (!found) {
                                btn2.setEnabled(true);
                                found = true; // เปลี่ยนค่า found เป็นจริงเมื่อเปิดปุ่มครั้งแรก
                            }
                        }
                        else if (deletedChar == rdLabel2.getText().charAt(0)) {
                            if (!found) {
                                btn3.setEnabled(true);
                                found = true; // เปลี่ยนค่า found เป็นจริงเมื่อเปิดปุ่มครั้งแรก
                            }
                        }
                        else if (deletedChar == rdLabel3.getText().charAt(0)) {
                            if (!found) {
                                btn4.setEnabled(true);
                                found = true; // เปลี่ยนค่า found เป็นจริงเมื่อเปิดปุ่มครั้งแรก
                            }
                        }
                        
                    }
                }
            });
            panel.add(btncheck);
        }
    }); 

    btncheck.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean allButtonsClicked = true;
            for (boolean clicked : buttonClicked) {
                if (!clicked) {
                    allButtonsClicked = false;
                    break;
                }
            }

            if (allButtonsClicked) {
                String expression = ans.getText();
                int result = evaluateExpression(expression);
                if (result == 24) {
                    JTextField correct = new JTextField();
                    correct.setEditable(false);
                    correct.setBorder(null);
                    correct.setOpaque(false);
                    panel.add(correct);
                    correct.setText("result : " + result + getCorrect());
                    correct.setFont(new Font("Comic Sans MS", Font.BOLD, 20)); // เปลี่ยนฟอนต์และขนาด
                    correct.setForeground(new Color(193, 255, 114)); // เปลี่ยนสี
                    correct.setBounds(90, 220, 400, 40);
                    score++;
                } else {
                    JTextField wrong = new JTextField();
                    wrong.setEditable(false);
                    wrong.setBorder(null);
                    wrong.setOpaque(false);
                    panel.add(wrong);
                    wrong.setText("result : " + result + getWrong());
                    wrong.setFont(new Font("Comic Sans MS", Font.BOLD, 20)); // เปลี่ยนฟอนต์และขนาด
                    wrong.setForeground(new Color(234, 132, 57));; // เปลี่ยนสี
                    wrong.setBounds(90, 220, 400, 40);
                }
                ans.setText("");
                scoreLabel.setText("Score : " + score);
            } else {
                JOptionPane.showMessageDialog(frame, "Please select all numbers before checking");
                ans.setText("");
            }
        }
    });
    frame.setVisible(true);
    }

    public static String getCorrect() {
        String response = "";
        switch (rnd.nextInt(5)) {
            case 0: response = " Awesome!"; break;
            case 1: response = " Correct!"; break;
            case 2: response = " Very Good!"; break;
            case 3: response = " Excellent"; break;
            case 4: response = " That's Right!"; break;
        }
        return response;
    }

    public static String getWrong() {
        String response = "";
        switch (rnd.nextInt(5)) {
            case 0: response = " Wrong!"; break;
            case 1: response = " Sorry, Please Try Again"; break;
            case 2: response = " Don't Give Up!"; break;
            case 3: response = " Try Once More!"; break;
            case 4: response = " Sorry, Incorrect!"; break;
        }
        return response;
    }

    private static int evaluateExpression(String expression) {
        // Find and evaluate sub-expressions within parentheses
        while (expression.contains("(")) {
            int openIndex = expression.lastIndexOf("(");
            int closeIndex = expression.indexOf(")", openIndex);
            String subExpression = expression.substring(openIndex + 1, closeIndex);
            int subResult = evaluateSubExpression(subExpression);
            expression = expression.substring(0, openIndex) + subResult + expression.substring(closeIndex + 1);
        }
        // Evaluate the expression without parentheses
        return evaluateSubExpression(expression);
    }
    
    // Method to evaluate sub-expression within parentheses
    private static int evaluateSubExpression(String subExpression) {
        // Split the sub-expression into operands and operators
        String[] tokens = subExpression.split("(?<=[*/+-])|(?=[*/+-])");
        // Initialize result to the first operand
        int result = Integer.parseInt(tokens[0]);
        // Perform the calculations based on the operators
        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int operand = Integer.parseInt(tokens[i + 1]);
            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                    break;
                case "/":
                    if (operand != 0) {
                        result /= operand;
                    } else {
                        return Integer.MIN_VALUE; // Indicates division by zero
                    }
                    break;
                default:
                    return Integer.MIN_VALUE; // Indicates unsupported operator
            }
        }
        return result;
    }
}