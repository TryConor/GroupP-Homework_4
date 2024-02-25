# GroupP-CS3330-Hw4

## Group members
1. Eli Wuerth
2. Kristyn Morgenthaler
3. Conor McLaughlin
4. Michael Keeney

### Project Overview
This Java program, a part of the Object-Oriented Programming homework, implements a vehicle showroom management system. The system includes classes for various vehicle types (`Car`, `Truck`, `SUV`, and `MotorBike`), a singleton class (`VehicleManager`) for managing vehicle information, and methods for handling inventory through a CSV file.

### Key Contributions
- **Eli Wuerth**: Implemented method which reads from the CSV file and adds vehicles to a list called *vehicleList* in the `VehicleManager` class. Also implemented methods to display all `Car`, `Truck`, `SUV`, `MotorBike`, and `Vehicle` information and added imports in the `VehicleManager` class to ensure methods were functional.
- **Michael Keeney**: Contributed to the project setup and completed abstract `Vehicle` class with `Vehicle` attributes, abstract methods, the *toString* method, and getter and setter methods. Also added Enums (`FuelType`, `StartMechanism`, and `VehicleColor`) to the project. 
- **Kristyn Morgenthaler**: Set up and organized the project by adding files and creating packages/classes (`Main`, `Car`, `Truck`, `SUV`, `MotorBike`, `Vehicle`, and `VehicleManager`). Also contributed to the implementation of *calculateFuelEfficiency*, *calculateMaintenanceCost*, *isVehicleType,* and *getNumberOfVehiclesByType* methods.
- **Conor McLaughlin**: Completed the `Main` class (includes calling methods to read from *vehicleList.csv*, to add/remove vehicles, to display vehicle information, and to calculate cost and efficiency values about the vehicles). Also contributed to the implementation of methods in `VehicleManager` to save, add, and remove vehicles and calculate lowest, highest, and average fuel efficiencies/maintenance costs.

### How to Run
The program can be executed by running the `Main` class. Ensure all required Java files are present, which includes *vehicleList.csv* in the *files* folder, and ensure dependencies are satisfied.

