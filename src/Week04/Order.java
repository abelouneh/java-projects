package Week04;
// This class represents an order made by a customer in the coffee shop
public class Order {

    // The name of the customer who placed the order
    private String customerName;

    // The total amount paid for the order
    private double amount;

    // The date the order was placed, formatted as yyyy/mm/dd
    private String date;

    // Constructor to create a new Order object with all required fields
    public Order(String customerName, double amount, String date) {
        this.customerName = customerName; // Assign the provided customer name to the field
        this.amount = amount;             // Assign the amount paid to the field
        this.date = date;                 // Assign the order date to the field
    }

    // Getter method to retrieve the customer's name
    public String getCustomerName() {
        return customerName;
    }

    // Getter method to retrieve the amount paid
    public double getAmount() {
        return amount;
    }

    // Getter method to retrieve the date of the order
    public String getDate() {
        return date;
    }
}