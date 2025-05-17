package week01;
import java.util.Scanner;
public class CarRental {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array of Car objects (pre-defined available cars)
        Car[] cars = {
                new Car("HIV690", "Toyota Corolla", 50000),
                new Car("SPI420", "Honda Civic", 45000),
                new Car("JWX999", "Ford Focus", 60000),
                new Car("AL4K5O", "BMW X3", 30000),
                new Car("GPK100", "Audi A4", 40000)
        };

        // Main loop for the car rental system
        while (true) {
            // Display the menu
            System.out.println("\nMenu:");
            System.out.println("1. Rent a car");
            System.out.println("2. Return a car");
            System.out.println("3. Display all cars");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();      // Read the user's menu choice
            scanner.nextLine();                 // Consume leftover newline character

            if (choice == 1) {
                // Rent a car
                System.out.print("Enter plate number: ");
                String plate = scanner.nextLine();
                boolean found = false;

                for (Car car : cars) {
                    // Match the input plate number with existing cars (case-insensitive)
                    if (car.getPlateNumber().equalsIgnoreCase(plate)) {
                        found = true;

                        // Rent the car only if it is not already rented
                        if (!car.isRented()) {
                            car.rentCar();  // Mark the car as rented
                            System.out.println("Car rented successfully.");
                        } else {
                            System.out.println("Sorry, this car is already rented.");
                        }
                        break;  // Exit the loop after finding the car
                    }
                }

                // If no car matches the input plate
                if (!found) {
                    System.out.println("Car not found.");
                }

            } else if (choice == 2) {
                // Return a car
                System.out.print("Enter plate number: ");
                String plate = scanner.nextLine();
                boolean found = false;

                for (Car car : cars) {
                    if (car.getPlateNumber().equalsIgnoreCase(plate)) {
                        found = true;

                        if (car.isRented()) {
                            // Prompt user for updated kilometers before returning the car
                            System.out.print("Enter new kilometers: ");
                            int newKm = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            car.returnCar(newKm);  // Mark car as returned
                            System.out.println("Car returned successfully.");
                        } else {
                            System.out.println("That car wasn’t rented.");
                        }
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Car not found.");
                }

            } else if (choice == 3) {
                // Display all car details
                for (Car car : cars) {
                    car.displayInfo();
                }

            } else if (choice == 4) {
                // Exit the application
                System.out.println("Exiting. Peace out!");
                break;

            } else {
                // If user entered a non-valid option
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close(); // Close the scanner when the program exits
    }
}