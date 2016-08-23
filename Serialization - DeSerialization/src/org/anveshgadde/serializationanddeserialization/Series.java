package org.anveshgadde.serializationanddeserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Imple implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2300064735847550805L;
	private final static String name = "Anvesh";
	private final static int age = 27;
	private final static double Id = 515;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getId() {
		return Id;
	}

}

public class Series {

	public static void main(String[] args) throws Exception {

		Imple imple = new Imple();

		FileOutputStream fos = new FileOutputStream("C:\\Users\\anveshg\\Desktop\\Rev.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(imple.getAge() + imple.getName() + imple.getId());
		oos.flush();
		oos.close();

		System.out.println("Success");

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\anveshg\\Desktop\\Rev.txt"));

		Imple imple1 = (Imple) in.readObject();

		System.out.println(imple1.getName() + "-" + imple1.getAge() + "-" + imple1.getId());
		
		in.close();
	}

}
