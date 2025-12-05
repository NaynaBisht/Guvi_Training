package com.app.work;

public class JobProcessing {
	public static void main(String[] args) {
		
		WorkerThread obj = new WorkerThread();
		
		Thread t2 = new Thread();
		t2.start();
		
		JobThread t1 = new JobThread();
		t1.start();
		
		System.out.print(t1.getId());
		System.out.print(t1.getName());
		System.out.print(t1.getPriority());
		System.out.print(t1.getState());
	}

}
