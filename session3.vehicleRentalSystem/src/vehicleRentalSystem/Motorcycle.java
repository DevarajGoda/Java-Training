package vehicleRentalSystem;

public class Motorcycle extends Vehicle {

	private String bikeType;
	private Boolean is_Electric;
	private int no_Of_Gear;

	public Boolean getIs_Electric() {
		return is_Electric;
	}

	public void setIs_Electric(Boolean is_Electric) {
		this.is_Electric = is_Electric;
	}

	public String getBikeType() {
		return bikeType;
	}

	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}

	public int getNo_Of_Gear() {
		return no_Of_Gear;
	}

	public void setNo_Of_Gear(int no_Of_Gear) {
		this.no_Of_Gear = no_Of_Gear;
	}

	public Motorcycle(String licensePlate, String vehicleType, String make, String model, boolean isAvailable,
			String bikeType, Boolean is_Electric, int no_Of_Gear) {
		super(licensePlate, vehicleType, make, model, isAvailable);
		this.bikeType = bikeType;
		this.is_Electric = is_Electric;
		this.no_Of_Gear = no_Of_Gear;
	}

}
