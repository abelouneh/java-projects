package Assessment2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserData {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hangman?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "user";
    private static final String DB_PASSWORD = "nopass";

    public UserData() throws SQLException {
        // Load MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC driver not found.", e);
        }
    }

    // Login method
    public boolean login(String username, String password) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    // Register method
    public boolean register(String username, String password) throws SQLException {
        String checkQuery = "SELECT * FROM users WHERE username = ?";
        String insertQuery = "INSERT INTO users (username, password, score) VALUES (?, ?, 0)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
            checkStmt.setString(1, username);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next()) {
                    return false; // Username already exists
                }
            }

            try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                insertStmt.setString(1, username);
                insertStmt.setString(2, password);
                insertStmt.executeUpdate();
                return true;
            }
        }
    }

    // Get user by username
    public User getUser(String username) throws SQLException {
        String query = "SELECT username, score FROM users WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getString("username"), rs.getInt("score"));
                } else {
                    return null;
                }
            }
        }
    }

    // Update user score (only if newScore > current score)
    public void updateScore(String username, int newScore) throws SQLException {
        String getScoreQuery = "SELECT score FROM users WHERE username = ?";
        String updateScoreQuery = "UPDATE users SET score = ? WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement getStmt = conn.prepareStatement(getScoreQuery)) {
            getStmt.setString(1, username);
            try (ResultSet rs = getStmt.executeQuery()) {
                if (rs.next()) {
                    int currentScore = rs.getInt("score");
                    if (newScore > currentScore) {
                        try (PreparedStatement updateStmt = conn.prepareStatement(updateScoreQuery)) {
                            updateStmt.setInt(1, newScore);
                            updateStmt.setString(2, username);
                            updateStmt.executeUpdate();
                        }
                    }
                }
            }
        }
    }

    // Get leaderboard - returns top 10 users sorted by score descending
    public List<User> getLeaderboard() throws SQLException {
        List<User> leaderboard = new ArrayList<>();
        String query = "SELECT username, score FROM users ORDER BY score DESC LIMIT 10";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                leaderboard.add(new User(rs.getString("username"), rs.getInt("score")));
            }
        }
        return leaderboard;
    }
}
