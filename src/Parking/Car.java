package Parking;

public class Car {
	// instance variables
	private String ownerName;
	private int ownerLicenceNum;
	private int registrationNum;

	private int parkingLoc;

	public Car(String name, int licence, int registration) {
		this.ownerName = name;
		this.ownerLicenceNum = licence;
		this.registrationNum = registration;
	}

	public int getParkingLoc() {
		return parkingLoc;
	}

	public void setParkingLoc(int loc) {
		parkingLoc = loc;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getOwnerLicenceNum() {
		return ownerLicenceNum;
	}
	
	public int getRegistrationNum() {
		return registrationNum;
	}

	@Override
	public String toString() {
		// return string representation of a car.
		return ownerName + " owns car " + registrationNum;
	}


	// USE THIS WHEN YOU WANT TO COMPARE TWO OBJECTS
	@Override
	public boolean equals(Object obj) {
		//casting to a Car object. carObj is made up. (Car) is the object casted to
		Car carObj = (Car) obj;
		return this.registrationNum == carObj.registrationNum;
	}

	public static void main(String[] args) {
		Car c1 = new Car("abc", 123, 456);
		System.out.println("look: " + c1);
		Car c2 = new Car("def", 123, 456);
		// same memory location? could be true or false
		System.out.println(c1 == c2);
		// uses overridden equals method which would be true since it's just comparing on the registration #
		System.out.println(c1.equals(c2));
	}
}
