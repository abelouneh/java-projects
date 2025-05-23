package Assessment2;

public class User {
    private String username;
    private int score;

    public User() {
        // default constructor
    }

    public User(String username, int score) {
        this.username = username;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // Method to add points to the current score
    public void addScore(int points) {
        this.score += points;
    }
}
