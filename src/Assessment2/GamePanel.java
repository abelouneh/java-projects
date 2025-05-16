package Assessment2;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private JLabel wordLabel;
    private JLabel attemptsLabel;
    private JLabel scoreLabel;
    private JTextField guessField;
    private JButton guessButton;

    private GameUserInterface parent;
    private GameMechanics mechanics;
    private User currentUser;

    public GamePanel(GameUserInterface parent) {
        this.parent = parent;
        initializeComponents();
    }

    private void initializeComponents() {
        setLayout(new BorderLayout());

        // Top panel with score and attempts
        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        scoreLabel = new JLabel("Score: 0");
        attemptsLabel = new JLabel("Attempts Left: 6");
        topPanel.add(scoreLabel);
        topPanel.add(attemptsLabel);
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
