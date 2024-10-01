// VehicleFactory.java

public class VehicleFactory {

    public Vehicle createVehicle(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        if ("Car".equalsIgnoreCase(type)) {
            return new Car();
        }
        if ("Bike".equalsIgnoreCase(type)) {
            return new Bike();
        }
        if ("Truck".equalsIgnoreCase(type)) {
            return new Truck();
        }
        return null;
    }
}
