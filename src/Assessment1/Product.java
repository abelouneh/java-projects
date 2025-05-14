package Assessment1;
// base class thingy for all the stuff in the store
public abstract class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name; // name duh
        this.price = price; // how much $ it costs
    }

    public String getName() {
        return name; // give me the name pls
    }

    public void setPrice(double price) {
        this.price = price; // update the price if it changes or whatever
    }

    // each product shows itself in its own way (fancy)
    public abstract void display();
}
