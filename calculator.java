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
        // ggg
    }
}
