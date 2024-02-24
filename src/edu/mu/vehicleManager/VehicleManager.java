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
    	
    public boolean removeVehicle(Vehicle vehicleToRemove) {
        // Remove the vehicle from the list
        boolean removed = vehicleList.remove(vehicleToRemove);

        if (removed) {
            // Write the updated list of vehicles back to the CSV file
            try {
                FileWriter writer = new FileWriter(vehicleFilePath);
                writer.write("Type,Brand,Make,ModelYear,Price,Color,FuelType,Mileage,Mass,Cylinders,GasTankCapacity,StartMechanism\n");
                for (Vehicle vehicle : vehicleList) {
                    writer.write(vehicleToCSV(vehicle) + "\n");
                }
                writer.close();
                return true; // Successfully removed and updated CSV
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false; // Vehicle not found or error occurred
    }

    public boolean addVehicle(Vehicle vehicleToAdd) {
        // Add the vehicle to the list
        boolean added = vehicleList.add(vehicleToAdd);

        if (added) {
            try {
                FileWriter writer = new FileWriter(vehicleFilePath, true); // append mode
                writer.write(vehicleToCSV(vehicleToAdd) + "\n");
                writer.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false; // Failed to add the vehicle
    }

    public boolean saveVehicleList() {
        try {
            FileWriter writer = new FileWriter(vehicleFilePath);
            writer.write("Type,Brand,Make,ModelYear,Price,Color,FuelType,Mileage,Mass,Cylinders,GasTankCapacity,StartMechanism\n");
            for (Vehicle vehicle : vehicleList) {
                writer.write(vehicleToCSV(vehicle) + "\n");
            }
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    private String vehicleToCSV(Vehicle vehicle) {
    	//Convert vehicle object to CSV format 
    	return String.format("%s,%s,%s,%d,%.2f,%s,%s,%.2f,%.2f,%d,%.2f,%s",
                vehicle.getClass().getSimpleName(),
                vehicle.getBrand(),
                vehicle.getMake(),
                vehicle.getModelYear(),
                vehicle.getPrice(),
                vehicle.getColor(),
                vehicle.getFuelType(),
                vehicle.getMileage(),
                vehicle.getMass(),
                vehicle.getCylinders(),
                vehicle.getGasTankCapacity(),
                vehicle.getStartType()
        );
    }

	public ArrayList<Vehicle> getVehicleList() {
		// TODO Auto-generated method stub
		return vehicleList;
	}
    
}
