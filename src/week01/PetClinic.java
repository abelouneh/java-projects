package week01;
import java.util.Scanner;
public class PetClinic {
    public static void main(String[] args) {
        // Create an array to hold 10 Pet objects
        Pet[] pets = new Pet[10];

        // Initialize the array with various pets and their species
        pets[0] = new Pet("jason", "snake");
        pets[1] = new Pet("chicken", "Chicken");
        pets[2] = new Pet("doggy", "cat");
        pets[3] = new Pet("cupcake", "dog");
        pets[4] = new Pet("habibi", "snake");
        pets[5] = new Pet("sally", "rat");
        pets[6] = new Pet("swimmy", "fish");
        pets[7] = new Pet("flyi", "bird");
        pets[8] = new Pet("jumpy", "rabbit");
        pets[9] = new Pet("speedy", "turtle");

        // Create a Scanner object to get user input
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the type of the pet: ");

        // Read the pet species entered by the user
        String speciekind = sc.nextLine();

        // Initialize variables to count matches and collect pet names
        int counter = 0;
        String petname = "";

        // Loop through all pets to find those matching the input species
        for (int i = 0; i < pets.length; i++) {
            // Compare species ignoring case differences
            if (pets[i].specie.equalsIgnoreCase(speciekind)) {
                counter++;  // Increase count of found pets
                petname += pets[i].name + "\n";  // Add pet's name to the list
            }
        }

        // After searching, print results based on how many were found
        if (counter > 0) {
            System.out.println("nomber of certain species found is " + counter);
            System.out.println("the names of the searched species are :\n" + petname);
        } else {
            // No pets of that species found in the list
            System.out.println("no species found");
        }
    }
}