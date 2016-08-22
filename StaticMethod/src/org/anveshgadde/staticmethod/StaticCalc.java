package org.anveshgadde.staticmethod;

class CubeDime {
	static int cube(int x) {
		return x * x * x;
	}
}

public class StaticCalc {
	public static void main(String[] args) {
		int cubeRes = CubeDime.cube(6);
		
		System.out.println("Cubecalc is : " +cubeRes);
	}
}
