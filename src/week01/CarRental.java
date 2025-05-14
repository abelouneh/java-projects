package week01;

import java.util.Scanner;

public class CarRental {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car[] cars = {
                new Car("HIV690", "Toyota Corolla", 50000),
                new Car("SPI420", "Honda Civic", 45000),
                new Car("JWX999", "Ford Focus", 60000),
                new Car("AL4K5O", "BMW X3", 30000),
                new Car("GPK100", "Audi A4", 40000)
        };

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Rent a car");
            System.out.println("2. Return a car");
            System.out.println("3. Display all cars");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            if (choice == 1) {
                System.out.print("Enter plate number: ");
                String plate = scanner.nextLine();
                boolean found = false;
                for (Car car : cars) {
                    if (car.getPlateNumber().equalsIgnoreCase(plate)) {
                        found = true;
                        if (!car.isRented()) {
                            car.rentCar();
                            System.out.println("Car rented successfully.");
                        } else {
                            System.out.println("Sorry, this car is already rented.");
                        }
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Car not found.");
                }

            } else if (choice == 2) {
                System.out.print("Enter plate number: ");
                String plate = scanner.nextLine();
                boolean found = false;
                for (Car car : cars) {
                    if (car.getPlateNumber().equalsIgnoreCase(plate)) {
                        found = true;
                        if (car.isRented()) {
                            System.out.print("Enter new kilometers: ");
                            int newKm = scanner.nextInt();
                            scanner.nextLine();  // consume newline
                            car.returnCar(newKm);
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
                for (Car car : cars) {
                    car.displayInfo();
                }

            } else if (choice == 4) {
                System.out.println("Exiting. Peace out!");
                break;

            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
