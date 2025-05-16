package Week02;
import java.util.Scanner;

// This is the main class containing the menu and user interaction
public class main {
    public static void main(String[] args) {
        League leagueManager = new League(); // Manager to handle games
        Scanner scanner = new Scanner(System.in); // Scanner for user input
        int choice; // User menu choice

        // Display menu until user chooses to exit
        do {
            // Print the main menu
            System.out.println("\nFootball League of Elbonia which is definitely a made up country");
            System.out.println("1. Add Game");
            System.out.println("2. Team Performance");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt(); // Read user's choice
            scanner.nextLine(); // Consume leftover newline

            switch (choice) {
                case 1:
                    // Add a new game
                    System.out.print("Enter home team: ");
                    String home = scanner.nextLine();

                    System.out.print("Enter away team: ");
                    String away = scanner.nextLine();

                    System.out.print("Enter home score: ");
                    int homeScore = scanner.nextInt();

                    System.out.print("Enter away score: ");
                    int awayScore = scanner.nextInt();
                    scanner.nextLine(); // Consume leftover newline

                    // Create a new Game object with input data
                    Game game = new Game(home, away, homeScore, awayScore);

                    // Add the game to the league
                    leagueManager.addGame(game);

                    System.out.println("Game added successfully!");
                    break;

                case 2:
                    // Show performance for a team
                    System.out.print("Enter team name: ");
                    String team = scanner.nextLine();

                    // Call method to calculate and print stats
                    leagueManager.getTeamPerformance(team);
                    break;

                case 0:
                    // Exit the program
                    System.out.println("Exiting...");
                    break;

                default:
                    // Handle invalid menu input
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0); // Keep looping unless user exits

        scanner.close(); // Close scanner to avoid resource leak
    }
}
