package Assessment1;
import java.util.ArrayList;
import java.util.List;

// holds all the stuff in one big list
public class Inventory {
    private List<Product> products = new ArrayList<>(); // it's just a list ok

    public void addProduct(Product product) {
        products.add(product); // yeet into the list
        System.out.println("Product added successfully.\n");
    }

    public void searchProduct(String name) {
        boolean found = false;
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                p.display(); // found u
                found = true;
            }
        }
        if (!found) {
            System.out.println("No product found with that name.\n");
        }
    }

    public void modifyProduct(String name, double newPrice) {
        boolean found = false;
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                p.setPrice(newPrice); // make it more expensive or cheaper idk
                System.out.println("Price updated successfully.\n");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found.\n");
        }
    }
}