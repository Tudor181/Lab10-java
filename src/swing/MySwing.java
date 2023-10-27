package swing;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MySwing extends JFrame {
    public void initialize() {
        JPanel mainPanel = new JPanel();

        JTextField usernameField = new JTextField(20);
        usernameField.setText("Enter username");
        usernameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (usernameField.getText().equals("Enter username")) {
                    usernameField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (usernameField.getText().isEmpty()) {
                    usernameField.setText("Enter username");
                }
            }
        });

        mainPanel.add(new JLabel("Username: "));
        mainPanel.add(usernameField);

        JTextField passwordField = new JTextField(20);
        passwordField.setText("Enter password");
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passwordField.getText().equals("Enter password")) {
                    passwordField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getText().isEmpty()) {
                    passwordField.setText("Enter password");
                }
            }
        });
        mainPanel.add(new JLabel("Password: "));
        mainPanel.add(passwordField);

        JButton loginButton = new JButton("Login");
        mainPanel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a modal dialog
                String question = "Are you sure you want to log in?";
                int choice = JOptionPane.showConfirmDialog(MySwing.this, question, "Login Confirmation",
                        JOptionPane.YES_NO_CANCEL_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "You have selected to log in!", "Result",
                            JOptionPane.INFORMATION_MESSAGE);
                    // Handle 'Yes' button action
                    // You can add your login logic here
                    System.out.println("User clicked 'Yes' to log in.");
                } else if (choice == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "You have selected not to log in!", "Result",
                            JOptionPane.WARNING_MESSAGE);
                    System.out.println("User clicked 'No' to cancel login.");
                } else {
                    JOptionPane.showMessageDialog(null, "You have selected cancel!", "Result",
                            JOptionPane.ERROR_MESSAGE);
                    System.out.println("User clicked 'Cancel'.");
                }
            }
        });

        add(mainPanel);

        setTitle("LOGIN");
        setSize(400, 150);
        setMinimumSize(new Dimension(300, 150));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
