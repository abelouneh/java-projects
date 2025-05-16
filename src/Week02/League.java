package Week02;
import java.util.ArrayList;
import java.util.List;

// This class manages the league - stores games and calculates performance
public class League {
    // A list to hold all the games that have been added
    private List<Game> games;

    // Constructor initializes the list
    public League() {
        games = new ArrayList<>();
    }

    // Method to add a game to the list
    public void addGame(Game game) {
        games.add(game);
    }

    // Method to calculate and display wins, losses, and draws for a given team
    public void getTeamPerformance(String teamName) {
        int wins = 0;
        int losses = 0;
        int draws = 0;

        // Loop through every game in the list
        for (Game game : games) {
            // Check if the team was either home or away in this game
            boolean isHome = game.getHomeTeam().equalsIgnoreCase(teamName);
            boolean isAway = game.getAwayTeam().equalsIgnoreCase(teamName);

            // If the team participated in this game
            if (isHome || isAway) {
                if (game.isDraw()) {
                    draws++; // Game ended in a tie
                } else {
                    // Determine the winner
                    String winner = game.getWinner();
                    if (winner.equalsIgnoreCase(teamName)) {
                        wins++; // Team won the game
                    } else {
                        losses++; // Team lost the game
                    }
                }
            }
        }

        // Display performance stats
        System.out.println("Performance of " + teamName + ":");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
    }
}
