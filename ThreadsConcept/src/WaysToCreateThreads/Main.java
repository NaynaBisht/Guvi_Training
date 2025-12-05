package WaysToCreateThreads;

class ExtendingThreadClass extends Thread{
	public void run() {
		System.out.println("Thread running "+ Thread.currentThread().getName() );
	}
}

public class Main{
	public static void main(String[] args) {
		ExtendingThreadClass t1 = new ExtendingThreadClass();
		t1.start();
		
		Thread t2 = new Thread( new ImplementingRunnable(), "Job Thread" );
		t2.start();
	}
}

class ImplementingRunnable implements Runnable{
	public void run() {
		System.out.println("Thread running "+ Thread.currentThread().getName() );
	}
}