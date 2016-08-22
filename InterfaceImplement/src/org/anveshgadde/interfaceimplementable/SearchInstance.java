/**
 * 
 */
package org.anveshgadde.interfaceimplementable;

/**
 * @author anveshg
 *
 */

interface Print {
	void printCricket();

	void printFootball();

	void printMovies();

	void printSongs();
}

abstract class applicable implements Print {
	public void printCricket() {
		System.out.println("Cricket is playing!");
	}
}

class Assisting extends applicable {

	@Override
	public void printFootball() {
		System.out.println("Football has started!");
		// TODO Auto-generated method stub

	}

	@Override
	public void printMovies() {
		System.out.println("Are you a movie freak?");
		// TODO Auto-generated method stub

	}

	@Override
	public void printSongs() {
		System.out.println("Pleasant songs are playing");
		// TODO Auto-generated method stub
	}

}

public class SearchInstance {
	public static void main(String[] args) {

		Print print = new Assisting();

		print.printCricket();

		print.printFootball();

		print.printMovies();

		print.printSongs();

	}
}