package Assessment2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class LeaderboardPanel extends JPanel {

    private JTable leaderboardTable;
    private DefaultTableModel tableModel;
    private GameUserInterface parent;

    public LeaderboardPanel(GameUserInterface parent) {
        this.parent = parent;
        setLayout(new BorderLayout());

        // Table columns: Username and Score
        String[] columns = {"Username", "Score"};
        tableModel = new DefaultTableModel(columns, 0);
        leaderboardTable = new JTable(tableModel);
        leaderboardTable.setEnabled(false); // Make table read-only

        add(new JScrollPane(leaderboardTable), BorderLayout.CENTER);

        // Button to return to the main game screen
        JButton backButton = new JButton("Back to Game");
        backButton.addActionListener(e -> parent.switchPanel("game"));
        add(backButton, BorderLayout.SOUTH);

        loadLeaderboard();
    }

    public void loadLeaderboard() {
        try {
            UserData userData = new UserData();
            List<User> leaderboard = userData.getLeaderboard();

            // Clear existing rows
            tableModel.setRowCount(0);

            // Add rows to the table model
            for (User user : leaderboard) {
                Object[] row = {user.getUsername(), user.getScore()};
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading leaderboard: " + e.getMessage());
        }
    }
}
