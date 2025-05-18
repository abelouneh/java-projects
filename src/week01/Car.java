package week01;
public class Car {
    // Car properties
    private String plateNumber;   // Unique identifier for the car
    private String model;         // Model of the car (e.g., "Toyota Corolla")
    private int kilometers;       // Total kilometers driven
    private boolean isRented;     // Rental status: true if rented, false otherwise

    // Constructor to initialize a new car with given values
    public Car(String plateNumber, String model, int kilometers) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.kilometers = kilometers;
        this.isRented = false;  // New cars are available by default
    }

    // Getter for plate number
    public String getPlateNumber() {
        return plateNumber;
    }

    // Returns true if the car is currently rented
    public boolean isRented() {
        return isRented;
    }

    // Mark the car as rented
    public void rentCar() {
        isRented = true;
    }

    // Return the car and update its kilometers
    public void returnCar(int newKilometers) {
        isRented = false;
        kilometers += newKilometers;
    }

    // Display the car's information in a user-friendly format
    public void displayInfo() {
        System.out.println("Plate: " + plateNumber +
                ", Model: " + model +
                ", Kilometers: " + kilometers +
                ", Rented: " + (isRented ? "Yes" : "No"));
    }
}