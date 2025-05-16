package Assessment2;

import javax.swing.*;
import java.awt.*;

public class GameUserInterface extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private GamePanel gamePanel;
    private LoginPanel loginPanel;
    private RegisterPanel registerPanel;
    private LeaderboardPanel leaderboardPanel;

    private User currentUser;

    public GameUserInterface() {
        setTitle("Hangman Game");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Initialize all panels
        gamePanel = new GamePanel(this);
        loginPanel = new LoginPanel(this);
        registerPanel = new RegisterPanel(this);
        leaderboardPanel = new LeaderboardPanel(this);

        // Add panels to cardPanel
        cardPanel.add(loginPanel, "login");
        cardPanel.add(registerPanel, "register");
        cardPanel.add(gamePanel, "game");
        cardPanel.add(leaderboardPanel, "leaderboard");

        add(cardPanel);
        switchPanel("login"); // Start on login screen

        setVisible(true);
    }

    public void switchPanel(String panelName) {
        cardLayout.show(cardPanel, panelName);
        if (panelName.equals("game") && currentUser != null) {
            gamePanel.startGame(currentUser);
        } else if (panelName.equals("leaderboard")) {
            leaderboardPanel.loadLeaderboard(); // Refresh leaderboard when shown
        }
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
