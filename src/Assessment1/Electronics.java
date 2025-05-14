package Assessment1;
// this is for gadgets and tech stuff
public class Electronics extends Product {
    private String brandName; // like Apple or Samsung or smth
    private int warrantyPeriod; // months of not-breaking guarantee

    public Electronics(String name, double price, String brandName, int warrantyPeriod) {
        super(name, price);
        this.brandName = brandName;
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void display() {
        System.out.println("[Electronics] Name: " + name + ", Price: $" + price +
                ", Brand: " + brandName + ", Warranty: " + warrantyPeriod + " months");
    }
}
