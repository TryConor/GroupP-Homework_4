package edu.mu;

import edu.mu.vehicleAttributes.FuelType;
import edu.mu.vehicleAttributes.StartMechanism;
import edu.mu.vehicleAttributes.VehicleColor;
import edu.mu.vehicleManager.VehicleManager;
import edu.mu.vehicles.*;

public class Main {

    public static void main(String[] args) {
        VehicleManager vehicleManager = new VehicleManager();

        // Read vehicle data from the vehicleList.csv file and initialize objects
        if (vehicleManager.initializeStock()) {
            System.out.println("Vehicle data loaded successfully.");
        } else {
            System.out.println("Failed to load vehicle data.");
            return;
        }

        System.out.println("\n");
        
        // Add a new vehicle
        Vehicle vehicleToAdd = new Car("BMW", "X5", 2022, 75000, VehicleColor.BLACK, FuelType.GASOLINE, 20.5, 2200, 6, 80, StartMechanism.KEYSTART);
        if (vehicleManager.addVehicle(vehicleToAdd)) {
            System.out.println("Vehicle added successfully.");
        } else {
            System.out.println("Failed to add the vehicle.");
        }
        
        System.out.println("\n");

        // Remove a vehicle
        boolean removed = vehicleManager.removeVehicle(vehicleToAdd);
        if (removed) {
            System.out.println("Vehicle removed successfully.");
        } else {
            System.out.println("Failed to remove the vehicle.");
        }

        System.out.println("\n");
        
        // Save vehicle list back to the CSV file
        if (vehicleManager.saveVehicleList()) {
            System.out.println("Vehicle list saved successfully.");
        } else {
            System.out.println("Failed to save vehicle list.");
        } 
        
        System.out.println("\n");

        // Display all vehicle information
        System.out.println("Displaying all saved vehicle information.");
        vehicleManager.displayAllVehicleInformation();
        System.out.println("\n");
        
        // Display all car information
        System.out.println("Displaying all car information.");
        vehicleManager.displayAllCarInformation();
        System.out.println("\n");

        // Display all motorbike information
        System.out.println("Displaying all motor bike information.");
        vehicleManager.displayAllMotorBikeInformation();
        System.out.println("\n");

        // Display all truck information
        System.out.println("Displaying all truck information.");
        vehicleManager.displayAllTruckInformation();
        System.out.println("\n");

        // Display all SUV information
        System.out.println("Displaying all SUV information.");
        vehicleManager.displayAllSUVInformation();
        System.out.println("\n");

        // Display the number of vehicles by type
        System.out.println("Number of Cars: " + vehicleManager.getNumberOfVehiclesByType(Car.class));
        System.out.println("\n");
        System.out.println("Number of Motorbikes: " + vehicleManager.getNumberOfVehiclesByType(MotorBike.class));
        System.out.println("\n");
        System.out.println("Number of Trucks: " + vehicleManager.getNumberOfVehiclesByType(Truck.class));
        System.out.println("\n");
        System.out.println("Number of SUVs: " + vehicleManager.getNumberOfVehiclesByType(SUV.class));
        System.out.println("\n");
        
        // Get vehicle with the highest maintenance cost
        double distance = 300; // Example distance for maintenance cost calculation
        Vehicle highestMaintenanceCostVehicle = vehicleManager.getVehicleWithHighestMaintenanceCost(distance);
        System.out.println("Vehicle with highest maintenance cost: " + highestMaintenanceCostVehicle);
        System.out.println("\n");

        // Get vehicle with the lowest maintenance cost
        Vehicle lowestMaintenanceCostVehicle = vehicleManager.getVehicleWithLowestMaintenanceCost(distance);
        System.out.println("Vehicle with lowest maintenance cost: " + lowestMaintenanceCostVehicle);
        System.out.println("\n");

        // Get vehicle with the lowest fuel efficiency
        double fuelPrice = 3.25; // Example fuel price for fuel efficiency calculation
        Vehicle lowestFuelEfficiencyVehicle = vehicleManager.getVehicleWithLowestFuelEfficiency(distance, fuelPrice);
        System.out.println("Vehicle with lowest fuel efficiency: " + lowestFuelEfficiencyVehicle);
        System.out.println("\n");

        // Get vehicle with the highest fuel efficiency
        Vehicle highestFuelEfficiencyVehicle = vehicleManager.getVehicleWithHighestFuelEfficiency(distance, fuelPrice);
        System.out.println("Vehicle with highest fuel efficiency: " + highestFuelEfficiencyVehicle);
        System.out.println("\n");

        // Get average fuel efficiency of SUVs
        double averageFuelEfficiencyOfSUVs = vehicleManager.getAverageFuelEfficiencyOfSUVs(distance, fuelPrice);
        if (averageFuelEfficiencyOfSUVs != -1.0) {
            System.out.println("Average fuel efficiency of SUVs: " + averageFuelEfficiencyOfSUVs);
        } else {
            System.out.println("No SUVs found to calculate average fuel efficiency.");
        }
    }
}
