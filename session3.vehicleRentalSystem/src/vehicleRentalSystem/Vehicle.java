package vehicleRentalSystem;

public class Vehicle implements VehicleOperations {

	private String licensePlate;
	private String vehicleType;
	private String make;
	private String model;
	private boolean isAvailable;

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Vehicle(String licensePlate, String vehicleType, String make, String model, boolean isAvailable) {
		super();
		this.licensePlate = licensePlate;
		this.vehicleType = vehicleType;
		this.make = make;
		this.model = model;
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Vehicle [licensePlate=" + licensePlate + ", vehicleType=" + vehicleType + ", make=" + make + ", model="
				+ model + ", isAvailable=" + isAvailable + "]";
	}

}
