package Week04;
import java.io.*;         // For file handling: FileReader, FileWriter, BufferedReader, etc.
import java.util.*;       // For using List, ArrayList

// CSVSource implements the OrderData interface to handle orders using a CSV file
public class CSVSource implements OrderData {

    // Path to the CSV file where orders will be saved and read from
    private String filePath;

    // Constructor that accepts the file path of the CSV file
    public CSVSource(String filePath) {
        this.filePath = filePath;
    }

    // Adds a new order to the CSV file
    @Override
    public void addOrder(Order order) {
        // Try-with-resources to automatically close the writer after use
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Write order details as a comma-separated line: name,amount,date
            writer.write(order.getCustomerName() + "," + order.getAmount() + "," + order.getDate());
            writer.newLine(); // Add a newline after the order
        } catch (IOException e) {
            // Print stack trace if any IO error occurs
            e.printStackTrace();
        }
    }

    // Retrieves a list of orders that match a specific date
    @Override
    public List<Order> getOrdersByDate(String date) {
        List<Order> orders = new ArrayList<>(); // List to store matching orders

        // Try-with-resources to ensure the file is properly closed after reading
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read each line from the CSV
            while ((line = reader.readLine()) != null) {
                // Split line into parts by comma
                String[] parts = line.split(",");
                // If the third part (date) matches the target date, add it to the list
                if (parts[2].equals(date)) {
                    orders.add(new Order(parts[0], Double.parseDouble(parts[1]), parts[2]));
                }
            }
        } catch (IOException e) {
            // Print stack trace in case of file read error
            e.printStackTrace();
        }

        return orders; // Return the list of matching orders
    }

    // Calculates the total amount spent by a specific customer
    @Override
    public double getTotalAmountByCustomer(String customerName) {
        double total = 0; // Variable to accumulate the total amount

        // Try-with-resources to read file safely
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Split into parts
                // If the customer name matches (case-insensitive), add amount to total
                if (parts[0].equalsIgnoreCase(customerName)) {
                    total += Double.parseDouble(parts[1]);
                }
            }
        } catch (IOException e) {
            // Print error stack if reading fails
            e.printStackTrace();
        }

        return total; // Return the calculated total amount
    }
}