package edu.mu.vehicleManager;

import edu.mu.vehicleAttributes.FuelType;
import edu.mu.vehicleAttributes.StartMechanism;
import edu.mu.vehicleAttributes.VehicleColor;
import edu.mu.vehicles.Car;
import edu.mu.vehicles.MotorBike;
import edu.mu.vehicles.SUV;
import edu.mu.vehicles.Truck;
import edu.mu.vehicles.Vehicle;
import java.io.*;
import java.util.*;


public class VehicleManager {
	private final static double distance = 300;
	private final static double fuelPrice = 3.25;
    private ArrayList<Vehicle> vehicleList;
	private final static String vehicleFilePath = "Files/vehicleList.csv";
	
    public VehicleManager(){
    	vehicleList = new ArrayList<>();
    	readFromFile(vehicleFilePath);
    }

    public boolean readFromFile(String fileName) {
    	try {
    	FileInputStream fis = new FileInputStream(fileName);
        Scanner scanner = new Scanner(fis);
        String dataSkip = scanner.nextLine();
        while (scanner.hasNextLine()) {
        	String line = scanner.nextLine();
            String[] tokens = line.split(",");
			String type = tokens[0];
            String brand = tokens[1];
            String make = tokens[2];
            long modelYear = Long.parseLong(tokens[3]);
            double price = Double.parseDouble(tokens[4]);
            VehicleColor color = VehicleColor.valueOf(tokens[5]);
        	FuelType fuelType = FuelType.valueOf(tokens[6]);
        	double mileage = Double.parseDouble(tokens[7]);
        	double mass = Double.parseDouble(tokens[8]);
        	int cylinders = Integer.parseInt(tokens[9]);
        	double gasTankCapacity = Double.parseDouble(tokens[10]);
        	StartMechanism startType = StartMechanism.valueOf(tokens[11]);
            
            Vehicle vehicle;
            switch (type) {
                case "Car":
                    vehicle = new Car(brand,make,modelYear,price,color,fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                    break;
                case "Truck":
                    vehicle = new Truck(brand,make,modelYear,price,color,fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                    break;
                case "SUV":
                    vehicle = new SUV(brand,make,modelYear,price,color,fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                    break;
                case "MotorBike":
                    vehicle = new MotorBike(brand,make,modelYear,price,color,fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                    break;
                default:
                    throw new IOException("Invalid vehicle type");
            }
            
			vehicleList.add(vehicle);
//			for(Vehicle v: vehicleList) {
//				System.out.println(v);
//			}
        }
        	scanner.close();
        	fis.close();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
    }
    public void displayAllCarInformation() {
        // Implement displaying the information of all cars
    	ArrayList<Vehicle> carList = new ArrayList<>();
    	for (Vehicle vehicle : vehicleList) {
            if (vehicle instanceof Car) {
            	carList.add(vehicle);
            	System.out.println(vehicle + " MaintenanceCost: " + vehicle.calculateMaintenaceCost(distance) +  ", FuelEfficiency: " + vehicle.calculateFuelEfficiency(distance, fuelPrice));
//            	System.out.println(vehicle + " MaintenanceCost: " + vehicle.calculateMaintenaceCost(5000) +  ", FuelEfficiency: " + vehicle.calculateFuelEfficiency(5000, vehicle.getFuelPrice(vehicle.getFuelType())));
            }
        }
    }

    public void displayAllTruckInformation() {
        // Implement displaying the information of all trucks
    	ArrayList<Vehicle> truckList = new ArrayList<>();
    	for (Vehicle vehicle : vehicleList) {
            if (vehicle instanceof Truck) {
            	truckList.add(vehicle);
            	System.out.println(vehicle + " MaintenanceCost: " + vehicle.calculateMaintenaceCost(distance) +  ", FuelEfficiency: " + vehicle.calculateFuelEfficiency(distance, fuelPrice));
//            	System.out.println(vehicle + " MaintenanceCost: " + vehicle.calculateMaintenaceCost(5000) +  ", FuelEfficiency: " + vehicle.calculateFuelEfficiency(5000, vehicle.getFuelPrice(vehicle.getFuelType())));
            }
        }
    }

    public void displayAllSUVInformation() {
        // Implement displaying the information of all SUVs
    	ArrayList<Vehicle> suvList = new ArrayList<>();
    	for (Vehicle vehicle : vehicleList) {
            if (vehicle instanceof SUV) {
            	suvList.add(vehicle);
            	System.out.println(vehicle + " MaintenanceCost: " + vehicle.calculateMaintenaceCost(distance) +  ", FuelEfficiency: " + vehicle.calculateFuelEfficiency(distance, fuelPrice));
//            	System.out.println(vehicle + " MaintenanceCost: " + vehicle.calculateMaintenaceCost(5000) +  ", FuelEfficiency: " + vehicle.calculateFuelEfficiency(5000, vehicle.getFuelPrice(vehicle.getFuelType())));
            }
        }
    }

    public void displayAllMotorBikeInformation() {
        // Implement displaying the information of all motor bikes
    	ArrayList<Vehicle> motorbikeList = new ArrayList<>();
    	for (Vehicle vehicle : vehicleList) {
            if (vehicle instanceof MotorBike) {
            	motorbikeList.add(vehicle);
            	System.out.println(vehicle + " MaintenanceCost: " + vehicle.calculateMaintenaceCost(distance) +  ", FuelEfficiency: " + vehicle.calculateFuelEfficiency(distance, fuelPrice));
//            	System.out.println(vehicle + " MaintenanceCost: " + vehicle.calculateMaintenaceCost(5000) +  ", FuelEfficiency: " + vehicle.calculateFuelEfficiency(5000, vehicle.getFuelPrice(vehicle.getFuelType())));
            }
        }
    }

    public void displayAllVehicleInformation() {
        // Implement displaying the information of all vehicles
    	for (Vehicle vehicle : vehicleList) {
    		System.out.println(vehicle + " MaintenanceCost: " + vehicle.calculateMaintenaceCost(distance) +  ", FuelEfficiency: " + vehicle.calculateFuelEfficiency(distance, fuelPrice));
//    		System.out.println(vehicle + ", MaintenanceCost: " + vehicle.calculateMaintenaceCost(5000) +  ", FuelEfficiency: " + vehicle.calculateFuelEfficiency(5000, vehicle.getFuelPrice(vehicle.getFuelType())));
    	}
    }
}
