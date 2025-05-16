package Week02;
// This class represents a single football game
public class Game{
    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;

    // Constructor to initialize the game with teams and scores
    public Game(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    // Getter method for home team name
    public String getHomeTeam() {
        return homeTeam;
    }

    // Getter method for away team name
    public String getAwayTeam() {
        return awayTeam;
    }

    // Getter method for home team score
    public int getHomeScore() {
        return homeScore;
    }

    // Getter method for away team score
    public int getAwayScore() {
        return awayScore;
    }

    // Determines and returns the winner of the game
    public String getWinner() {
        if (homeScore > awayScore) {
            return homeTeam;  // Home team wins
        } else if (awayScore > homeScore) {
            return awayTeam;  // Away team wins
        } else {
            return "the game is a tie for both teams";    // It's a tie
        }
    }

    // Returns true if the game was a draw
    public boolean isDraw() {
        return homeScore == awayScore;
    }
}
