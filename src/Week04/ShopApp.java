package Week04;
import java.sql.*;      // For database connection and SQL handling
import java.util.*;     // For Scanner and List

// Main class for running the Coffee Shop application
public class ShopApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner to read user input
        OrderData dataSource = null;              // Interface to abstract the data source (CSV or MySQL)

        // Ask user to select the data source: CSV file or MySQL database
        while (true) {
            System.out.println("Choose data source: 1. CSV  2. MySQL");
            System.out.printf("choice : ");
            String input = scanner.nextLine();

            if (input.equals("1")) {
                // Use CSV file as the data source
                dataSource = new CSVSource("orders.csv");
                break;
            } else if (input.equals("2")) {
                try {
                    // Attempt to connect to MySQL database
                    Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/coffee_shop", "root", ""
                    );
                    dataSource = new SQLSource(conn); // Use MySQL data source
                    break;
                } catch (SQLException e) {
                    // If connection fails, print the stack trace and exit
                    e.printStackTrace();
                    return;
                }
            } else {
                // If user enters anything other than 1 or 2
                System.out.println("Please enter either 1 or 2.");
            }
        }

        // Main application menu loop
        while (true) {
            System.out.println("\n1. Add Order");
            System.out.println("2. View orders of a date");
            System.out.println("3. View total amount of a customer");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choiceInput = scanner.nextLine(); // Read user's menu choice
            int choice;

            try {
                choice = Integer.parseInt(choiceInput); // Convert input to integer
            } catch (NumberFormatException e) {
                // Handle non-numeric input
                System.out.println("Invalid input. Please enter a number between 0 and 3.");
                continue;
            }

            switch (choice) {
                case 1:
                    // Add a new order
                    System.out.print("Customer name: ");
                    String name = scanner.nextLine();

                    System.out.print("Amount paid: ");
                    double amount;
                    try {
                        amount = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        // Handle invalid amount input
                        System.out.println("Invalid amount. Please enter a number.");
                        continue;
                    }

                    System.out.print("Date (yyyy/mm/dd): ");
                    String date = scanner.nextLine();

                    // Add the new order using the chosen data source
                    dataSource.addOrder(new Order(name, amount, date));
                    System.out.println("Order added successfully.");
                    break;

                case 2:
                    // View orders for a specific date
                    System.out.print("Enter date (yyyy/mm/dd): ");
                    String d = scanner.nextLine();
                    List<Order> orders = dataSource.getOrdersByDate(d);

                    if (orders.isEmpty()) {
                        System.out.println("No orders found for that date.");
                    } else {
                        for (Order o : orders) {
                            System.out.println(o.getCustomerName() + " - $" + o.getAmount());
                        }
                    }
                    break;

                case 3:
                    // View total amount spent by a specific customer
                    System.out.print("Customer name: ");
                    String customer = scanner.nextLine();
                    double total = dataSource.getTotalAmountByCustomer(customer);
                    System.out.printf("Total amount for %s: $%.2f%n", customer, total);
                    break;

                case 0:
                    // Exit the application
                    System.out.println("Goodbye!");
                    return;

                default:
                    // Handle menu input that is out of range
                    System.out.println("Invalid option. Please choose between 0 and 3.");
            }
        }
    }
}