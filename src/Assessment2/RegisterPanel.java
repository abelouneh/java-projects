package Assessment2;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class RegisterPanel extends JPanel {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private GameUserInterface parent;

    public RegisterPanel(GameUserInterface parent) {
        this.parent = parent;

        setLayout(new GridLayout(4, 2, 5, 5));

        add(new JLabel("Choose Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Choose Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton registerButton = new JButton("Register");
        add(registerButton);

        JButton backButton = new JButton("Back to Login");
        add(backButton);

        registerButton.addActionListener(e -> performRegister());
        backButton.addActionListener(e -> parent.switchPanel("login"));
    }

    private void performRegister() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both username and password.");
            return;
        }

        try {
            UserData userData = new UserData();
            boolean registered = userData.register(username, password);

            if (registered) {
                JOptionPane.showMessageDialog(this, "Registration successful! You can now log in.");
                parent.switchPanel("login");
            } else {
                JOptionPane.showMessageDialog(this, "Username already taken. Please choose another.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        }
    }
}
