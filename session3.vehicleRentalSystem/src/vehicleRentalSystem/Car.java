package vehicleRentalSystem;

public class Car extends Vehicle {

	// private String carType;
	private String fuelType;
	private int door_count;

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getDoor_count() {
		return door_count;
	}

	public void setDoor_count(int door_count) {
		this.door_count = door_count;
	}

	public Car(String licensePlate, String vehicleType, String make, String model, boolean isAvailable, String fuelType,
			int door_count) {
		super(licensePlate, vehicleType, make, model, isAvailable);
		this.fuelType = fuelType;
		this.door_count = door_count;
	}

}
