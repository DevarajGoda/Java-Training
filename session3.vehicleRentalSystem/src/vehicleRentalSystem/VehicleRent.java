package vehicleRentalSystem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class VehicleRent {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		RentalService rentalService = new RentalService();
		System.out.println("Vehical  Rental System - Menu");
		boolean exit = false;

		while (!exit) {
			System.out.println("1. Add Vehicle \n" + "2. List Available Vehicles \n" + "3. Rent a Vehicle \n"
					+ "4. Calculate Rental Cost \n" + "5. Return Vehicle \n" + "6. Quit \n	");
			System.out.println("Enter your choice:");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {

			case 1:
				addVehicle(rentalService, scanner);
				break;
			case 2:
				listAvailableVehicles(rentalService);
				break;
			case 3:
				rentVehicle(rentalService, scanner);
				break;
			case 4:
				calculateRentalCost(rentalService, scanner);
				break;
			case 5:
				returnVehicle(rentalService, scanner);
				break;

			case 6:
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void addVehicle(RentalService rentalService, Scanner scanner) {
		System.out.print("Enter Vehicle Type(car/motorcycle/bicycle): ");
		String vehicleType = scanner.nextLine();

		System.out.print("Enter license plate: ");
		String licensePlate = scanner.nextLine();

		System.out.print("Enter the make: ");
		String make = scanner.nextLine();

		System.out.print("Enter model: ");
		String model = scanner.nextLine();

		System.out.print("Vehicle Available For Rent(true or fales) ?: ");
		Boolean isAvailable = scanner.nextBoolean();

		Vehicle vehicle;
		switch (vehicleType) {
		case "car":
			System.out.print("Enter no.of doors: ");
			int door_count = scanner.nextInt();
			System.out.print("Enter Fuel Type: ");
			String fuelType = scanner.next();
			vehicle = new Car(licensePlate, vehicleType, make, model, isAvailable, fuelType, door_count);
			break;
		case "motorcycle":
			System.out.print("Is it electric? (True/False): ");
			boolean isElectric = scanner.nextBoolean();
			System.out.print("Enter Bike  Type: ");
			String bikeType = scanner.nextLine();
			System.out.print("Enter No.Of Gears: ");
			int no_Of_Gear = scanner.nextInt();

			vehicle = new Motorcycle(licensePlate, vehicleType, make, model, isAvailable, bikeType, isElectric,
					no_Of_Gear);
			break;
		case "bicycle":
			System.out.print("Does it have Gears ?(True/False): ");
			Boolean is_Gears = scanner.nextBoolean();
			System.out.print("Enter the pedalRpm: ");
			int pedalRpm = scanner.nextInt();
			System.out.print("Enter the wheelDiameter: ");
			int wheelDiameter = scanner.nextInt();
			vehicle = new Bicycle(licensePlate, vehicleType, make, model, isAvailable, is_Gears, pedalRpm,
					wheelDiameter);
			break;
		default:
			System.out.println("Invalid vehicle type. Vehicle not added.");
			return;
		}

		rentalService.addVehicle(vehicle);
		System.out.println("Vehicle added successfully.");
	}

	private static void listAvailableVehicles(RentalService rentalService) {
		List<Vehicle> availableVehicles = rentalService.getAvailableVehicles();
		if (availableVehicles.isEmpty()) {
			System.out.println("No vehicles available for rent.");
		} else {
			System.out.println("Available Vehicles:");
			for (Vehicle vehicle : availableVehicles) {
				System.out.println("License Plate: " + vehicle.getLicensePlate());
				System.out.println("Make: " + vehicle.getMake());
				System.out.println("Model: " + vehicle.getModel());
				System.out.println("Model: " + vehicle.getModel());
			}
		}
	}

	private static void rentVehicle(RentalService rentalService, Scanner scanner) {
		System.out.print("Enter your first name: ");
		String firstName = scanner.nextLine();

		System.out.print("Enter your last name: ");
		String lastName = scanner.nextLine();

		System.out.print("Enter your ID: ");
		String id = scanner.nextLine();

		System.out.print("Enter the license plate of the vehicle you want to rent: ");
		String licensePlate = scanner.nextLine();

		System.out.print("Enter the start date and time (yyyy-MM-dd HH:mm): ");
		String startDateTime = scanner.nextLine();
		LocalDateTime startTime = LocalDateTime.parse(startDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		System.out.print("Enter the end date and time (yyyy-MM-dd HH:mm): ");
		String endDateTime = scanner.nextLine();
		LocalDateTime endTime = LocalDateTime.parse(endDateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

		Customer customer = new Customer(firstName, lastName, id);
		Vehicle selectedVehicle = rentalService.getVehicleByLicensePlate(licensePlate);

		if (selectedVehicle != null) {
			Rental rental = rentalService.rentVehicle(customer, selectedVehicle, startTime, endTime);

			if (rental != null) {
				System.out.println("Rental successful!");
			} else {
				System.out.println("The selected vehicle is not available for rent.");
			}
		} else {
			System.out.println("Invalid license plate. Please try again.");
		}
	}

	private static void calculateRentalCost(RentalService rentalService, Scanner scanner) {
		System.out.print("Enter the rental ID: ");
		String rentalId = scanner.nextLine();

		Rental rental = rentalService.getRentalById(rentalId);
		if (rental != null) {
			BigDecimal rentalCost = rentalService.calculateRentalCost(rental);
			System.out.println("Rental Cost: $" + rentalCost);
		} else {
			System.out.println("Invalid rental ID.");
		}
	}

	private static void returnVehicle(RentalService rentalService, Scanner scanner) {
		System.out.print("Enter the rental ID: ");
		String rentalId = scanner.nextLine();

		Rental rental = rentalService.getRentalById(rentalId);
		if (rental != null) {
			boolean success = rentalService.returnVehicle(rental);
			if (success) {
				System.out.println("Vehicle returned successfully.");
			} else {
				System.out.println("Failed to return the vehicle.");
			}
		} else {
			System.out.println("Invalid rental ID.");
		}

	}
}