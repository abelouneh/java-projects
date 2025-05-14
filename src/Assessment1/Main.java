package Assessment1;
import java.util.*;

// this is the part where stuff happens
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory(); // our big basket of stuff
        int choice;

        do {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product");
            System.out.println("3. Modify Product");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // eat the leftover newline

            switch (choice) {
                case 1 -> {
                    System.out.println("Pick a category: 1. Electronics 2. Clothing 3. Grocery");
                    int category = sc.nextInt();
                    sc.nextLine(); // crunch newline

                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    switch (category) {
                        case 1 -> {
                            System.out.print("Brand name? ");
                            String brand = sc.nextLine();
                            System.out.print("Warranty period (months): ");
                            int warranty = sc.nextInt();
                            sc.nextLine();
                            inventory.addProduct(new Electronics(name, price, brand, warranty));
                        }
                        case 2 -> {
                            System.out.print("Sizes (comma separated, be creative): ");
                            List<String> sizes = Arrays.asList(sc.nextLine().split(","));
                            System.out.print("Material (cotton, steel, etc.): ");
                            String material = sc.nextLine();
                            System.out.print("Colors (rainbow optional): ");
                            List<String> colors = Arrays.asList(sc.nextLine().split(","));
                            inventory.addProduct(new Clothing(name, price, sizes, material, colors));
                        }
                        case 3 -> {
                            System.out.print("Weight in kg (no bananas): ");
                            double weight = sc.nextDouble();
                            sc.nextLine();
                            System.out.print("Expiration date (YYYY-MM-DD): ");
                            String expiry = sc.nextLine();
                            inventory.addProduct(new Grocery(name, price, weight, expiry));
                        }
                        default -> System.out.println("Uhh... what?");
                    }
                }

                case 2 -> {
                    System.out.print("Name of the product to search for: ");
                    String searchName = sc.nextLine();
                    inventory.searchProduct(searchName);
                }

                case 3 -> {
                    System.out.print("Name of the product to modify: ");
                    String modName = sc.nextLine();
                    System.out.print("What's the new price, genius? ");
                    double newPrice = sc.nextDouble();
                    sc.nextLine();
                    inventory.modifyProduct(modName, newPrice);
                }

                case 4 -> System.out.println("Okay bye 👋");
                default -> System.out.println("Try again maybe?");
            }

        } while (choice != 4);

        sc.close(); // very important or Java gets mad
    }
}
