package Assessment2;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class LoginPanel extends JPanel {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private GameUserInterface parent;

    public LoginPanel(GameUserInterface parent) {
        this.parent = parent;

        setLayout(new GridLayout(4, 2));  // Increased rows for new button

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginButton = new JButton("Login");
        add(loginButton);

        JButton registerButton = new JButton("Register");  // New register button
        add(registerButton);

        loginButton.addActionListener(e -> performLogin());

        // Switch to register panel on button click
        registerButton.addActionListener(e -> parent.switchPanel("register"));
    }

    private void performLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both username and password.");
            return;
        }

        try {
            UserData userData = new UserData();
            boolean success = userData.login(username, password);

            if (success) {
                User user = userData.getUser(username);
                parent.setCurrentUser(user);
                parent.switchPanel("game");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials. Try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
        }
    }
}
