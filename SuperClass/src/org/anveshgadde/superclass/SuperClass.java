package org.anveshgadde.superclass;

class SubstituteClass {
	int vehicleSpeed = 50;
}

public class SuperClass extends SubstituteClass {

	int vehicleSpeed = 100;

	void speedDisplay() {
		System.out.println((super.vehicleSpeed+this.vehicleSpeed));
	}

	public static void main(String[] args) {
		
		SuperClass scs = new SuperClass();
		
		System.out.print("Previous speed of the vehicle is: ");
		scs.speedDisplay();
		System.out.print(" km/hr");

	}

}
