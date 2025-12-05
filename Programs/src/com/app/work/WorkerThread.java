package com.app.work;

public class WorkerThread implements Runnable {

	@Override
	public void run() {
		System.out.print("This is inside run");
	}
}
