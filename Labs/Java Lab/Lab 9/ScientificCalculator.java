// Developing a Scientific Calculator

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ScientificCalculator extends JFrame {
    private JTextField textField;
    private String currentNumber;
    private String operator;
    private double result;

    public ScientificCalculator() {
        super("Scientific Calculator");
        currentNumber = "";
        operator = "";
        result = 0.0;

        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));

        String[] buttonLabels = {
            "1", "2", "3", "+",
            "4", "5", "6", "-",
            "7", "8", "9", "/",
            "0", "√", "square", "mod",
            "=", "log", "clear", "tan"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.matches("[0-9]")) {
                currentNumber += command;
                textField.setText(currentNumber);
            } else if (command.equals("-") || command.equals("+") || command.equals("/") || command.equals("mod")) {
                operator = command;
                result = Double.parseDouble(currentNumber);
                currentNumber = "";
            } else if (command.equals("=")) {
                if (!currentNumber.isEmpty()) {
                    double secondNumber = Double.parseDouble(currentNumber);
                    if (operator.equals("-")) {
                        result -= secondNumber;
                    } else if (operator.equals("+")) {
                        result += secondNumber;
                    } else if (operator.equals("/")) {
                        result /= secondNumber;
                    } else if (operator.equals("mod")) {
                        result %= secondNumber;
                    }
                    textField.setText(String.valueOf(result));
                    currentNumber = "";
                }
            } else if (command.equals("√")) {
                if (!currentNumber.isEmpty()) {
                    double number = Double.parseDouble(currentNumber);
                    result = Math.sqrt(number);
                    textField.setText(String.valueOf(result));
                    currentNumber = "";
                }
            } else if (command.equals("square")) {
                if (!currentNumber.isEmpty()) {
                    double number = Double.parseDouble(currentNumber);
                    result = Math.pow(number, 2);
                    textField.setText(String.valueOf(result));
                    currentNumber = "";
                }
            } else if (command.equals("log")) {
                if (!currentNumber.isEmpty()) {
                    double number = Double.parseDouble(currentNumber);
                    result = Math.log10(number);
                    textField.setText(String.valueOf(result));
                    currentNumber = "";
                }
            } else if (command.equals("clear")) {
                currentNumber = "";
                operator = "";
                result = 0.0;
                textField.setText("");
            } else if (command.equals("tan")) {
                if (!currentNumber.isEmpty()) {
                    double number = Double.parseDouble(currentNumber);
                    result = Math.tan(number);
                    textField.setText(String.valueOf(result));
                    currentNumber = "";
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ScientificCalculator();
            }
        });
    }
}
