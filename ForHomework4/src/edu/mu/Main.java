package edu.mu;


import java.util.ArrayList;

import edu.mu.VehicleManager.VehicleManager;
import edu.mu.VehicleTypes.*;
import edu.mu.vehicle.FuelType;
import edu.mu.vehicle.StartMechanism;
import edu.mu.vehicle.Vehicle;
import edu.mu.vehicle.VehicleColor;

public class Main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		VehicleManager manager = new VehicleManager();
		
		// Display all vehicle information
		System.out.println("Displaying all vehicles: ");
        manager.displayAllVehicleInformation();

        // Display all car information
        System.out.println("\nList of Cars: ");
        manager.displayAllCarInformation();
        
        // Display all truck information
        System.out.println("\nList of Trucks: ");
        manager.displayAllTruckInformation();

        // Display all SUV information
        System.out.println("\nList of SUVs: ");
        manager.displayAllSUVInformation();

        // Display all MotorBike information
        System.out.println("\nList of MotorBikes: ");
        manager.displayAllMotorBikeInformation();
        
        //Display a specific vehicle information
        Car car = new Car("Honda", "Civic", 2024, 18000, VehicleColor.GRAY, FuelType.ELECTRIC, 50000, 0.25, 6, 14, StartMechanism.PUSHSTART);
        manager.displayVehicleInformation(car);

        //manager.saveVehicleList();
    }
}