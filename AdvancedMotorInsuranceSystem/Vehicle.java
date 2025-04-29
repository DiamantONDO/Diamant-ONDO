package AdvancedMotorInsuranceSystem;

public class Vehicle {
    private String vehicleId;
    private String vehicleMake;
    private String vehicleModel;
    private int vehicleYear;
    private String vehicleType;

    public Vehicle(String vehicleId, String vehicleMake, String vehicleModel, int vehicleYear, String vehicleType) {
        if (vehicleYear < 1980 || vehicleYear > java.time.Year.now().getValue()) {
            throw new IllegalArgumentException("Invalid vehicle year.");
        }
        this.vehicleId = vehicleId;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.vehicleType = vehicleType;
    }

    // Getters and Setters
    public String getVehicleType() { return vehicleType; }
    public int getVehicleYear() { return vehicleYear; }
    public String getVehicleId() { return vehicleId; }

    public void updateVehicleDetails(String make, String model, int year, String type) {
        this.vehicleMake = make;
        this.vehicleModel = model;
        this.vehicleYear = year;
        this.vehicleType = type;
    }
}
