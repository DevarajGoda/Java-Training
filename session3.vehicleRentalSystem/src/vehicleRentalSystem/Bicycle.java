package vehicleRentalSystem;

public class Bicycle extends Vehicle {

	private Boolean is_Gears;
	private int pedalRpm;
	private double wheelDiameter;

	public int getPedalRpm() {
		return pedalRpm;
	}

	public void setPedalRpm(int pedalRpm) {
		this.pedalRpm = pedalRpm;
	}

	public double getWheelDiameter() {
		return wheelDiameter;
	}

	public void setWheelDiameter(double wheelDiameter) {
		this.wheelDiameter = wheelDiameter;
	}

	public Boolean getIs_Gears() {
		return is_Gears;
	}

	public void setIs_Gears(Boolean is_Gears) {
		this.is_Gears = is_Gears;
	}

	public Bicycle(String licensePlate, String vehicleType, String make, String model, boolean isAvailable,
			Boolean is_Gears, int pedalRpm, double wheelDiameter) {
		super(licensePlate, vehicleType, make, model, isAvailable);
		this.is_Gears = is_Gears;
		this.pedalRpm = pedalRpm;
		this.wheelDiameter = wheelDiameter;
	}

}
