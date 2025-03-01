import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class calculator extends JFrame implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[11];
    JButton addButton, subButton, multiplyButton, divideButton;
    JButton decimalButton, deleteButton, equalButton, clearButton, percentageButton, sqrButton, negativeButton;
    JPanel panel = new JPanel();
    
    Font myFont = new Font("Ink Free", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    String operator;
    boolean isResultDisplayed = false;

    calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        
        textField = new JTextField();
        textField.setBounds(10, 15, 280, 60);
        textField.setEditable(false);
        textField.setBackground(Color.BLACK);
        textField.setFont(new Font("Arial", Font.BOLD, 30));
        textField.setForeground(Color.white);
        
        addButton = new JButton("+");
        subButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decimalButton = new JButton(".");
        deleteButton = new JButton("<--");
        clearButton = new JButton("C");
        equalButton = new JButton("=");
        percentageButton = new JButton("%");
        sqrButton = new JButton("√");
        negativeButton = new JButton("-/+");
        

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divideButton;
        functionButtons[4] = equalButton;
        functionButtons[5] = clearButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = decimalButton;
        functionButtons[8] = percentageButton;
        functionButtons[9] = sqrButton;
        functionButtons[10] = negativeButton;
        
        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].setBackground(new Color(0,51,89));
            functionButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            functionButtons[i].addActionListener(this);
            functionButtons[i].setForeground(Color.white);
            functionButtons[i].setFocusable(false);
        }
        
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 20));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.BLACK);
            numberButtons[i].setForeground(Color.white);
        }
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 0, 0));
        panel.setBounds(10, 85, 280, 360);
        
        panel.add(clearButton);
        panel.add(sqrButton);
        panel.add(percentageButton);
        panel.add(divideButton);
        
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);
        
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(negativeButton);
        panel.add(equalButton);
        
        add(textField);
        add(panel);
        setVisible(true);
    }
    public static void main(String[] args) {
        new calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){
                if(isResultDisplayed) {
                    textField.setText("");
                    isResultDisplayed = false;
                }
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decimalButton){
            if(isResultDisplayed) {
                textField.setText(".");
                isResultDisplayed = false;
            } else {
                textField.setText(textField.getText().concat("."));
            }
        }
        if(e.getSource() == addButton || e.getSource() == subButton || e.getSource() == multiplyButton || e.getSource() == divideButton){
            num1 = Double.parseDouble(textField.getText());
            operator = e.getActionCommand();
            textField.setText("");
        }
        if(e.getSource() == equalButton) {
            if (!textField.getText().isEmpty()) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "*": result = num1 * num2; break;
                    case "/": result = (num2 == 0) ? 0 : num1 / num2; break;
                    case "%": result = num1 / 100; break;
                    case "√": result = Math.sqrt(num1); break;
                    default: break;
                }
                textField.setText(String.valueOf(result));
                num1 = result;
                isResultDisplayed = true;
            }
        }
        if(e.getSource() == negativeButton) {
            if (!textField.getText().isEmpty()) {
                double value = Double.parseDouble(textField.getText());
                textField.setText(String.valueOf(-value));
            }
        }
        if(e.getSource() == clearButton){
            textField.setText("");
            num1 = 0;
            num2 = 0;
            operator = null;
            isResultDisplayed = false;
        }
    }
}
