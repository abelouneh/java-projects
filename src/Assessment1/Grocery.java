package Assessment1;
// this is for food and edible things
public class Grocery extends Product {
    private double weight; // how heavy it is
    private String expirationDate; // don't eat after this pls

    public Grocery(String name, double price, double weight, String expirationDate) {
        super(name, price);
        this.weight = weight;
        this.expirationDate = expirationDate;
    }

    @Override
    public void display() {
        System.out.println("[Grocery] Name: " + name + ", Price: $" + price +
                ", Weight: " + weight + "kg, Expiration Date: " + expirationDate);
    }
}