package Assessment2;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private JLabel wordLabel;
    private JLabel attemptsLabel;
    private JLabel scoreLabel;
    private JTextField guessField;
    private JButton guessButton;

    private JButton logoutButton;         // Logout button
    private JButton leaderboardButton;    // Leaderboard button

    private GameUserInterface parent;
    private GameMechanics mechanics;
    private User currentUser;

    public GamePanel(GameUserInterface parent) {
        this.parent = parent;
        initializeComponents();
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());

        // Top panel with score, attempts and buttons
        JPanel topPanel = new JPanel(new BorderLayout());

        JPanel labelsPanel = new JPanel(new GridLayout(1, 2));
        scoreLabel = new JLabel("Score: 0");
        attemptsLabel = new JLabel("Attempts Left: 6");
        labelsPanel.add(scoreLabel);
        labelsPanel.add(attemptsLabel);

        JPanel buttonsPanel = new JPanel();
        logoutButton = new JButton("Logout");
        leaderboardButton = new JButton("Leaderboard");
        buttonsPanel.add(leaderboardButton);
        buttonsPanel.add(logoutButton);

        topPanel.add(labelsPanel, BorderLayout.CENTER);
        topPanel.add(buttonsPanel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // Center with masked word
        wordLabel = new JLabel("_ _ _ _ _", SwingConstants.CENTER);
        wordLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(wordLabel, BorderLayout.CENTER);

        // Bottom with guess input
        JPanel bottomPanel = new JPanel();
        guessField = new JTextField(5);
        guessButton = new JButton("Guess");

        bottomPanel.add(new JLabel("Enter a letter:"));
        bottomPanel.add(guessField);
        bottomPanel.add(guessButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Guess button action
        guessButton.addActionListener(e -> {
            String guess = guessField.getText().trim();
            guessField.setText("");
            mechanics.handleGuess(guess);
        });

        // Leaderboard button action
        leaderboardButton.addActionListener(e -> parent.switchPanel("leaderboard"));

        // Logout button action: update score and switch to login
        logoutButton.addActionListener(e -> {
            try {
                UserData userData = new UserData();
                userData.updateScore(currentUser.getUsername(), currentUser.getScore());
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error updating score on logout: " + ex.getMessage());
            }
            parent.setCurrentUser(null);
            parent.switchPanel("login");
        });
    }

    public void startGame(User user) {
        this.currentUser = user;
        mechanics = new GameMechanics(this, currentUser);
        updateScoreLabel(user.getScore());
    }

    public void updateWordDisplay(String word) {
        wordLabel.setText(word.replace("", " ").trim());
    }

    public void updateAttemptsLeft(int attempts) {
        attemptsLabel.setText("Attempts Left: " + attempts);
    }

    public void updateScoreLabel(int score) {
        scoreLabel.setText("Score: " + score);
    }
}
