package edu.mu.VehicleTypes;

import edu.mu.vehicle.FuelType;
import edu.mu.vehicle.StartMechanism;
import edu.mu.vehicle.Vehicle;
import edu.mu.vehicle.VehicleColor;

public class MotorBike extends Vehicle{

	public MotorBike(String brand, String make, long modelYear,double price, VehicleColor color,FuelType fuelType, double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		// TODO Auto-generated constructor stub
		super(brand,make,modelYear,price,color,fuelType, mileage, mass, cylinders, gasTankCapacity, startType);	
		}

	@Override
	public double calculateMaintenaceCost(double distance) {
		// TODO Auto-generated method stub
		int currentYear = 2024;
		double maintenanceCost=distance * mass * (currentYear-modelYear) * cylinders * 0.0002;
		return maintenanceCost;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		// TODO Auto-generated method stub
		double fuelEfficiency = cylinders * gasTankCapacity * fuelPrice / (distance * 0.001);
		return fuelEfficiency;
	}

	@Override
	public void startEngine() {
		// TODO Auto-generated method stub
		setStartType(StartMechanism.KICKSTART);
	}

	@Override
	public String getVehicle() {
		// TODO Auto-generated method stub
		return "MotorBike";
	}

	
}