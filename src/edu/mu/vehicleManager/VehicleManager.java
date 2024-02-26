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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Random;
import java.util.ArrayList;


public class VehicleManager {
	private final static double distance = 300;
	private final static double fuelPrice = 3.25;
    private ArrayList<Vehicle> vehicleList;
	private final static String vehicleFilePath = "Files/vehicleList.csv";
	
    public VehicleManager(){
    	vehicleList = new ArrayList<>();
    	initializeStock();
    }

    public boolean initializeStock() {
        try (BufferedReader reader = new BufferedReader(new FileReader(vehicleFilePath))) {
            String line;
            boolean headerSkipped = false;
            while ((line = reader.readLine()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue; // Skip the header line
                }
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
                        vehicle = new Car(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                        break;
                    case "Truck":
                        vehicle = new Truck(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                        break;
                    case "SUV":
                        vehicle = new SUV(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                        break;
                    case "MotorBike":
                        vehicle = new MotorBike(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
                        break;
                    default:
                        throw new IOException("Invalid vehicle type");
                }
                vehicleList.add(vehicle);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
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
    
    public void displayVehicleInformation(Vehicle v) {
        if (v == null) {
            System.out.println("Vehicle is null");
            return;
        }

        if (v instanceof Vehicle) {
            Vehicle vehicle = (Vehicle) v;
            System.out.println(vehicle.toString() + ", MaintenanceCost: " + vehicle.calculateMaintenaceCost(distance) +  ", FuelEfficiency: " + vehicle.calculateFuelEfficiency(distance, fuelPrice));
        } else if (v instanceof Car) {
            Car Car = (Car) v;
            System.out.println(Car.toString() + ", MaintenanceCost: " + Car.calculateMaintenaceCost(distance) +  ", FuelEfficiency: " + Car.calculateFuelEfficiency(distance, fuelPrice));
        } else if (v instanceof Truck) {
            Truck Truck = (Truck) v;
            System.out.println(Truck.toString() + ", MaintenanceCost: " + Truck.calculateMaintenaceCost(distance) +  ", FuelEfficiency: " + Truck.calculateFuelEfficiency(distance, fuelPrice));
        } else if (v instanceof SUV) {
            SUV SUV = (SUV) v;
            System.out.println(SUV.toString() + ", MaintenanceCost: " + SUV.calculateMaintenaceCost(distance) +  ", FuelEfficiency: " + SUV.calculateFuelEfficiency(distance, fuelPrice));
        } else if (v instanceof MotorBike) {
            MotorBike MotorBike = (MotorBike) v;
            System.out.println(MotorBike.toString() + ", MaintenanceCost: " + MotorBike.calculateMaintenaceCost(distance) +  ", FuelEfficiency: " + MotorBike.calculateFuelEfficiency(distance, fuelPrice));
        } else {
            System.out.println("Unknown vehicle type");
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
            // Create a temporary file to write the updated vehicle list
            String tempFilePath = "Files/tempVehicleList.csv";
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(tempFilePath)));

            // Write the header line to the temporary file
            writer.println("Type,Brand,Make,ModelYear,Price,Color,FuelType,Mileage,Mass,Cylinders,GasTankCapacity,StartMechanism");

            // Write each vehicle from the list to the temporary file
            for (Vehicle vehicle : vehicleList) {
                writer.println(vehicleToCSV(vehicle));
            }

            // Close the writer
            writer.close();

            // Replace the original file with the temporary file
            Files.deleteIfExists(Paths.get(vehicleFilePath));
            Files.move(Paths.get(tempFilePath), Paths.get(vehicleFilePath));

            return true; // Successfully saved the updated vehicle list
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Error occurred while saving the file
        }
    }
    
    public void displayAllVehicleInformation() {
        // Implement displaying the information of all vehicles
    	for (Vehicle vehicle : vehicleList) {
    		System.out.println(vehicle + " MaintenanceCost: " + vehicle.calculateMaintenaceCost(distance) +  ", FuelEfficiency: " + vehicle.calculateFuelEfficiency(distance, fuelPrice));
//    		System.out.println(vehicle + ", MaintenanceCost: " + vehicle.calculateMaintenaceCost(5000) +  ", FuelEfficiency: " + vehicle.calculateFuelEfficiency(5000, vehicle.getFuelPrice(vehicle.getFuelType())));
    	}
    }
    
    private boolean isVehicleType(Vehicle v, Class clazz) {
        // Implement checking if the given vehicle is a specific type of Vehicle subclass
    	if(v.getClass().equals(clazz)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }

    public int getNumberOfVehiclesByType(Class clazz) {
    	// Implement returning the number of objects in the vehicleList based on the object vehicle type
    	
    	int vehicleTypeCount = 0;
    	//for each vehicle in vehicleList test to see if it is specified object vehicle type
    	for(Vehicle v : vehicleList) {
    		//if the vehicle types match (isVehicleType returns true) add 1 to counter
    		//otherwise loop goes to next vehicle in list
    		if(isVehicleType(v,clazz)) {
    			vehicleTypeCount++;
    		}
    	}
    	//return count of objects with object vehicle type clazz
    	return vehicleTypeCount++;
    }

    public Vehicle getVehicleWithHighestMaintenanceCost(double distance) {
        if (vehicleList.isEmpty()) {
            return null; // Return null if the vehicle list is empty
        }

        Vehicle vehicleWithHighestCost = vehicleList.get(0); // Initialize with the first vehicle
        double highestCost = vehicleWithHighestCost.calculateMaintenaceCost(distance);

        Random random = new Random();
        for (int i = 1; i < vehicleList.size(); i++) {
            Vehicle currentVehicle = vehicleList.get(i);
            double currentCost = currentVehicle.calculateMaintenaceCost(distance);
            if (currentCost > highestCost) {
                highestCost = currentCost;
                vehicleWithHighestCost = currentVehicle;
            } else if (currentCost == highestCost) {
                // Randomly select one of the vehicles if they have the same cost
                if (random.nextBoolean()) {
                    vehicleWithHighestCost = currentVehicle;
                }
            }
        }

        return vehicleWithHighestCost;
    }

    public Vehicle getVehicleWithLowestMaintenanceCost(double distance) {
        if (vehicleList.isEmpty()) {
            return null; // Return null if the vehicle list is empty
        }

        double lowestCost = Double.MAX_VALUE;
        ArrayList<Vehicle> vehiclesWithLowestCost = new ArrayList<>();

        for (Vehicle vehicle : vehicleList) {
            double currentCost = vehicle.calculateMaintenaceCost(distance);
            if (currentCost < lowestCost) {
                lowestCost = currentCost;
                vehiclesWithLowestCost.clear(); // Clear previous lowest cost vehicles
                vehiclesWithLowestCost.add(vehicle);
            } else if (currentCost == lowestCost) {
                vehiclesWithLowestCost.add(vehicle);
            }
        }

        if (!vehiclesWithLowestCost.isEmpty()) {
            if (vehiclesWithLowestCost.size() == 1) {
                return vehiclesWithLowestCost.get(0); // Return the single vehicle if only one has the lowest cost
            } else {
                // Return the first vehicle in the ArrayList if multiple vehicles have the same lowest cost
                return vehiclesWithLowestCost.get(0);
            }
        } else {
            return null; // Return null if no vehicles found
        }
    }

    
    public Vehicle getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice) {
        if (vehicleList.isEmpty()) {
            return null; // Return null if the vehicle list is empty
        }

        double lowestEfficiency = Double.MAX_VALUE;
        ArrayList<Vehicle> vehiclesWithLowestEfficiency = new ArrayList<>();

        for (Vehicle vehicle : vehicleList) {
            double currentEfficiency = vehicle.calculateFuelEfficiency(distance, fuelPrice);
            if (currentEfficiency < lowestEfficiency) {
                lowestEfficiency = currentEfficiency;
                vehiclesWithLowestEfficiency.clear(); // Clear previous vehicles with lowest efficiency
                vehiclesWithLowestEfficiency.add(vehicle);
            } else if (currentEfficiency == lowestEfficiency) {
                vehiclesWithLowestEfficiency.add(vehicle);
            }
        }

        if (!vehiclesWithLowestEfficiency.isEmpty()) {
            if (vehiclesWithLowestEfficiency.size() == 1) {
                return vehiclesWithLowestEfficiency.get(0); // Return the single vehicle if only one has the lowest efficiency
            } else {
                // Return the first vehicle in the ArrayList if multiple vehicles have the same lowest efficiency
                return vehiclesWithLowestEfficiency.get(0);
            }
        } else {
            return null; // Return null if no vehicles found
        }
    }
    
    public Vehicle getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice) {
        if (vehicleList.isEmpty()) {
            return null; // Return null if the vehicle list is empty
        }

        double highestEfficiency = Double.MIN_VALUE;
        Vehicle vehicleWithHighestEfficiency = null;

        for (Vehicle vehicle : vehicleList) {
            double currentEfficiency = vehicle.calculateFuelEfficiency(distance, fuelPrice);
            if (currentEfficiency > highestEfficiency) {
                highestEfficiency = currentEfficiency;
                vehicleWithHighestEfficiency = vehicle;
            }
        }

        return vehicleWithHighestEfficiency;
    }

    
    public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice) {
        double sumFuelEfficiency = 0.0;
        int countSUVs = 0;

        for (Vehicle vehicle : vehicleList) {
            if (isVehicleType(vehicle, SUV.class)) {
                sumFuelEfficiency += vehicle.calculateFuelEfficiency(distance, fuelPrice);
                countSUVs++;
            }
        }

        if (countSUVs == 0) {
            return -1.0; // Indicates no SUVs found
        }

        return sumFuelEfficiency / countSUVs;
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
