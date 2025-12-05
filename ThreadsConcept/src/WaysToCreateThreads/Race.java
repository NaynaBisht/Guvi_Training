package WaysToCreateThreads;

import java.util.concurrent.atomic.AtomicInteger;

public class Race {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub

		Counter c = new Counter();
		
		Thread t1 = new Thread(() -> {
			for(int i=0; i<1000; i++) c.increment();
		});
		
		Thread t2 = new Thread(()->{
			for(int i=0; i<1000; i++) c.increment();
		});
		
		t1.start(); t2.start();
		t1.join(); t2.join();
		
		System.out.println(c.count);
		
	}

}
class Counter{
	volatile int count = 0;
	synchronized void increment() { // Only one thread enters at a time
		count++;
	}
}

class SafeCounter{
	AtomicInteger count = new AtomicInteger(0);
	void decrement() {
		count.decrementAndGet();
	}
}
