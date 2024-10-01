// Main.java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of vehicle (Car, Bike, Truck): ");
        String vehicleType = scanner.nextLine();

        Vehicle vehicle = factory.createVehicle(vehicleType);
        if (vehicle != null) {
            vehicle.drive();
        } else {
            System.out.println("Invalid vehicle type.");
        }

        scanner.close();
    }
}
