package week01;

public class Car {
    private String plateNumber;
    private String model;
    private int kilometers;
    private boolean isRented;

    public Car(String plateNumber, String model, int kilometers) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.kilometers = kilometers;
        this.isRented = false;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rentCar() {
        isRented = true;
    }

    public void returnCar(int newKilometers) {
        isRented = false;
        kilometers = newKilometers;
    }

    public void displayInfo() {
        System.out.println("Plate: " + plateNumber +
                ", Model: " + model +
                ", Kilometers: " + kilometers +
                ", Rented: " + (isRented ? "Yes" : "No"));
    }
}
