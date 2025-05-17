package Week04;
import java.sql.*;      // For JDBC SQL operations
import java.util.*;     // For using List and ArrayList

// SQLSource implements OrderData and provides MySQL database operations for storing and retrieving orders
public class SQLSource implements OrderData {
    private Connection conn; // JDBC connection to the MySQL database

    // Constructor that accepts a Connection object
    public SQLSource(Connection conn) {
        this.conn = conn;
    }

    // Method to add a new order into the database
    @Override
    public void addOrder(Order order) {
        try {
            // SQL query with placeholders to insert a new order into the 'orders' table
            String sql = "INSERT INTO orders (customer_name, amount, order_date) VALUES (?, ?, ?)";

            // PreparedStatement prevents SQL injection and allows us to safely set values
            PreparedStatement ps = conn.prepareStatement(sql);

            // Set the values for the placeholders in the SQL query
            ps.setString(1, order.getCustomerName());
            ps.setDouble(2, order.getAmount());
            ps.setString(3, order.getDate());

            // Execute the SQL insert statement
            ps.executeUpdate();
        } catch (SQLException e) {
            // Print error details if something goes wrong with the database
            e.printStackTrace();
        }
    }

    // Method to retrieve all orders for a specific date
    @Override
    public List<Order> getOrdersByDate(String date) {
        List<Order> orders = new ArrayList<>();

        try {
            // SQL query to get all orders for a given date
            String sql = "SELECT * FROM orders WHERE order_date = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            // Set the date value in the SQL query
            ps.setString(1, date);

            // Execute the query and get the result set
            ResultSet rs = ps.executeQuery();

            // Iterate over each result and convert it into an Order object
            while (rs.next()) {
                orders.add(new Order(
                        rs.getString("customer_name"), // Read customer name from result set
                        rs.getDouble("amount"),        // Read amount from result set
                        rs.getString("order_date")     // Read order date from result set
                ));
            }

        } catch (SQLException e) {
            // Print error details if the query fails
            e.printStackTrace();
        }

        // Return the list of orders found for the given date
        return orders;
    }

    // Method to calculate the total amount spent by a specific customer
    @Override
    public double getTotalAmountByCustomer(String customerName) {
        double total = 0;

        try {
            // SQL query to sum all amounts for a specific customer
            String sql = "SELECT SUM(amount) FROM orders WHERE customer_name = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            // Set the customer name in the query
            ps.setString(1, customerName);

            // Execute the query
            ResultSet rs = ps.executeQuery();

            // Retrieve the sum from the result set
            if (rs.next()) {
                total = rs.getDouble(1); // Column index 1 holds the SUM result
            }

        } catch (SQLException e) {
            // Print error if something goes wrong during query execution
            e.printStackTrace();
        }

        // Return the total amount spent by the customer
        return total;
    }
}