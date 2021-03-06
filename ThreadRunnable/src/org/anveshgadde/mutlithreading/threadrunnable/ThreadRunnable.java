package org.anveshgadde.mutlithreading.threadrunnable;

public class ThreadRunnable extends Thread implements Runnable {

	@Override
	public void run() {
		System.out.println("Thread has been instantiated!");
	}

	public static void main(String[] args) throws InterruptedException {

		ThreadRunnable tr = new ThreadRunnable();
		System.out.println("Thread running from extend Thread method");
		tr.start();
		Thread.sleep(1000);

		Thread trd = new Thread(tr);
		System.out.println("Thread running from implemented Runnable method");
		trd.start();

	}

}
