package org.anveshgadde.multilevelinheritance;

class Toss {
	void tossFlip() {
		System.out.println("Toss in the air!");
	}
}

class Batting extends Toss {
	void tossFlip() {
		System.out.println("Captain calls for Heads and chose batting");
	}
}

class Bowling extends Batting {
	void tossFlip() {
		System.out.println("Captain calls for Tails and chose bowling");
	}
}

public class Cricket extends Bowling {
	public static void main(String[] args) {

		Toss flip, bat, bowl;

		flip = new Toss();
		flip.tossFlip();

		bat = new Batting();
		bat.tossFlip();

		bowl = new Bowling();
		bowl.tossFlip();

	}
}
