package org.anveshgadde.constructorcopy;

public class XeroxConstructors {

	String errorMessage;
	int pid;

	XeroxConstructors(String message, int id) {
		this.errorMessage = message;
		this.pid = id;
	}

	XeroxConstructors(XeroxConstructors sObj) {
		errorMessage = sObj.errorMessage;
		pid = sObj.pid;
	}

	void errorDis() {
		System.out.println("For id " + pid + " error is : " + errorMessage);
	}

	public static void main(String[] args) {

		String message = "Job failed due to tHiveRow issue!";
		int id = 143543;

		XeroxConstructors cons = new XeroxConstructors(message, id);

		cons.errorDis();

	}

}
