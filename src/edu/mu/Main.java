package edu.mu;

import java.util.ArrayList;

import edu.mu.vehicleAttributes.FuelType;
import edu.mu.vehicleAttributes.StartMechanism;
import edu.mu.vehicleAttributes.VehicleColor;
import edu.mu.vehicleManager.VehicleManager;
import edu.mu.vehicles.Car;
import edu.mu.vehicles.Vehicle;

public class Main {

	public static void main(String[] args) {
		VehicleManager vehicleManager = new VehicleManager();
		// Instantiate vehicleManager, perform operations based on the requirements.
		
		// Read vehicle data from the vehcileList.csv file and initialize objects.
		
		// Display all vehicle information.
		
		// Display all car information.
		
		// Display all motorbike information
		
	//Remove the first vehicle
		ArrayList<Vehicle> vehicleList = vehicleManager.getVehicleList(); 
        if (!vehicleList.isEmpty()) {
            Vehicle vehicleToRemove = vehicleList.get(0); // Remove the first vehicle in the list for testing
            boolean removed = vehicleManager.removeVehicle(vehicleToRemove);
            if (removed) {
                System.out.println("Vehicle removed successfully.");
            } else {
                System.out.println("Failed to remove the vehicle.");
            }
        } else {
            System.out.println("No vehicles in the list to remove.");
        }

        // Display all vehicle information after removal
        vehicleManager.displayAllVehicleInformation();
        
     // Add a new vehicle
        Vehicle vehicleToAdd = new Car("BMW", "X5", 2022, 75000, VehicleColor.BLACK, FuelType.GASOLINE, 20.5, 2200, 6, 80, StartMechanism.PUSHSTART);
        boolean added = vehicleManager.addVehicle(vehicleToAdd);
        if (added) {
            System.out.println("Vehicle added successfully.");
        } else {
            System.out.println("Failed to add the vehicle.");
        }

        // Display all vehicle information after addition
        vehicleManager.displayAllVehicleInformation();
        
//    //Save the updated vehicle list to the CSV file
//        boolean saved = vehicleManager.saveVehicleList();
//        if (saved) {
//        	System.out.println("Vehicle list saved succesfully.");
//        } else {
//        	System.out.println("Failed to save the vehicle list.");
//        }
    }
}

