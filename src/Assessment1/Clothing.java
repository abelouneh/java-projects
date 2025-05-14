package Assessment1;
import java.util.List;

// for pants, shirts, socks, etc.
public class Clothing extends Product {
    private List<String> sizes; // like S, M, L
    private String material; // cotton? leather? who knows
    private List<String> colors; // red, blue, whatever

    public Clothing(String name, double price, List<String> sizes, String material, List<String> colors) {
        super(name, price);
        this.sizes = sizes;
        this.material = material;
        this.colors = colors;
    }

    @Override
    public void display() { //as the name suggests this is our display function that we are gonna use
        System.out.println("[Clothing] Name: " + name + ", Price: $" + price +
                ", Sizes: " + sizes + ", Material: " + material + ", Colors: " + colors);
    }
}
