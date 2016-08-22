package org.anveshgadde.mutlithreading.threadrunnable;

public class ThreadRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Runnable thread Started!");
	}

	public static void main(String[] args) {
		ThreadRunnable trbl = new ThreadRunnable();
		Thread trt = new Thread(trbl);
		trt.run();
	}
}
