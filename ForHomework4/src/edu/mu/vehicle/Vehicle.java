package edu.mu.vehicle;

public abstract class Vehicle {
	protected String brand;
	protected String make;
	protected long modelYear;
	protected double price;
	protected VehicleColor color;
	protected FuelType fuelType;
	protected double mileage;
	protected double mass;
	protected int cylinders;
	protected double gasTankCapacity;
	protected StartMechanism startType;
	
	public Vehicle(String brand, String make, long modelYear,double price, VehicleColor color,FuelType fuelType, double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		this.brand = brand;
		this.make = make;
		this.color = color;
		this.cylinders = cylinders;
		this.fuelType = fuelType;
		this.gasTankCapacity = gasTankCapacity;
		this.mass = mass;
		this.mileage = mileage;
		this.modelYear = modelYear;
		this.price = price;
		this.startType = startType;
	}
	
	
	
	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getMake() {
		return make;
	}



	public void setMake(String make) {
		this.make = make;
	}



	public long getModelYear() {
		return modelYear;
	}



	public void setModelYear(long modelYear) {
		this.modelYear = modelYear;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public VehicleColor getColor() {
		return color;
	}



	public void setColor(VehicleColor color) {
		this.color = color;
	}



	public FuelType getFuelType() {
		return fuelType;
	}
	
	public double getFuelPrice(FuelType fuelType) {
		double fuelPrice = 0;
		switch(fuelType) {
			case DIESEL:
				fuelPrice = 4.68;
				return fuelPrice;
			case ELECTRIC:
				fuelPrice = 1.38;
				return fuelPrice;
			case GASOLINE:
				fuelPrice = 2.89;
				return fuelPrice;
			case HYBRID:
				fuelPrice = 2.10;
				return fuelPrice;
			default:
				break;
		}
		return fuelPrice;
	}


	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}



	public double getMileage() {
		return mileage;
	}



	public void setMileage(double mileage) {
		this.mileage = mileage;
	}



	public double getMass() {
		return mass;
	}



	public void setMass(double mass) {
		this.mass = mass;
	}



	public int getCylinders() {
		return cylinders;
	}



	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}



	public double getGasTankCapacity() {
		return gasTankCapacity;
	}



	public void setGasTankCapacity(double gasTankCapacity) {
		this.gasTankCapacity = gasTankCapacity;
	}



	public StartMechanism getStartType() {
		return startType;
	}



	public void setStartType(StartMechanism startType) {
		this.startType = startType;
	}



	public abstract String getVehicle();
	public abstract double calculateMaintenaceCost(double distance); 
	public abstract double calculateFuelEfficiency(double distance, double fuelPrice); 
	public abstract void startEngine();
	
	@Override
	public String toString() {
		return "Vehicle [brand: " + brand + ", make: " + make + ", modelYear: " + modelYear + ", price: " + price
				+ ", color: " + color + ", fuelType: " + fuelType + ", mileage: " + mileage + ", mass: " + mass
				+ ", cylinders: " + cylinders + ", gasTankCapacity: " + gasTankCapacity + ", startType: " + startType
				+ "]";
	}
	
	
	
}
