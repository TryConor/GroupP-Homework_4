package edu.mu.vehicles;

import edu.mu.vehicleAttributes.FuelType;
import edu.mu.vehicleAttributes.StartMechanism;
import edu.mu.vehicleAttributes.VehicleColor;

public class SUV extends Vehicle{

	public SUV(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType,
			double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		super(brand, make, modelYear, price, color, fuelType, mileage, mass, cylinders, gasTankCapacity, startType);
		// TODO Auto-generated constructor stub
	}

}
