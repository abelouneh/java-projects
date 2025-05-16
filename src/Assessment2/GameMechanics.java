package Assessment2;

import javax.swing.*;
import java.sql.SQLException;

public class GameMechanics {

    private String wordToGuess;
    private StringBuilder maskedWord;
    private int attemptsLeft;
    private final int MAX_ATTEMPTS = 6;
    private GamePanel gamePanel;
    private User user;

    public GameMechanics(GamePanel gamePanel, User user) {
        this.gamePanel = gamePanel;
        this.user = user;
        startNewGame();
    }

    public void startNewGame() {
        try {
            wordToGuess = WordGetter.getRandomWord().toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
            wordToGuess = "default"; // fallback word if API call fails
        }

        maskedWord = new StringBuilder();
        for (int i = 0; i < wordToGuess.length(); i++) {
            maskedWord.append("_");
        }
        attemptsLeft = MAX_ATTEMPTS;

        updateDisplay();
    }

    public void handleGuess(String guess) {
        if (guess == null || guess.length() != 1) {
            JOptionPane.showMessageDialog(gamePanel, "Please enter a single letter.");
            return;
        }

        char guessedChar = guess.toLowerCase().charAt(0);
        boolean correct = false;

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guessedChar && maskedWord.charAt(i) == '_') {
                maskedWord.setCharAt(i, guessedChar);
                correct = true;
            }
        }

        if (!correct) {
            attemptsLeft--;
        }

        updateDisplay();

        if (isGameWon()) {
            user.addScore(10); // add 10 points to user's in-memory score

            try {
                UserData userData = new UserData();
                userData.updateScore(user.getUsername(), user.getScore()); // update DB with new total score
            } catch (SQLException e) {
                e.printStackTrace();
            }

            updateScoreLabel(); // update UI score display
            showEndDialog("🎉 Congratulations! You won!");
        } else if (attemptsLeft == 0) {
            showEndDialog("💀 Game Over! The word was: " + wordToGuess);
        }
    }

    private void updateDisplay() {
        gamePanel.updateWordDisplay(maskedWord.toString());
        gamePanel.updateAttemptsLeft(attemptsLeft);
    }

    private boolean isGameWon() {
        return maskedWord.toString().equals(wordToGuess);
    }

    private void showEndDialog(String message) {
        int option = JOptionPane.showOptionDialog(
                gamePanel,
                message + "\nWould you like to play again?",
                "Game Over",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Play Again", "Exit"},
                "Play Again"
        );

        if (option == JOptionPane.YES_OPTION) {
            startNewGame();
        } else {
            System.exit(0);
        }
    }

    private void updateScoreLabel() {
        gamePanel.updateScoreLabel(user.getScore());
    }
}
