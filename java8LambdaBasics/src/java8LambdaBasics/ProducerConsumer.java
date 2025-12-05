import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ProducerConsumer {

    public static void main(String[] args) {
        // Shared resources
        Queue<Integer> buffer = new LinkedList<>();
        final int CAPACITY = 5; // Max size of the buffer
        Object lock = new Object(); // The lock for synchronization

        // --- 1. Define Producer and Consumer using Functional Interfaces ---

        // The Producer is a Supplier. It takes no arguments and "supplies" an Integer.
        Supplier<Integer> producer = () -> {
            int value = new Random().nextInt(100);
            System.out.println("Produced: " + value);
            return value;
        };

        // The Consumer is a Consumer. It "consumes" an Integer and returns nothing.
        Consumer<Integer> consumer = (value) -> {
            System.out.println("Consumed: " + value);
        };

        // --- 2. Create the Producer Thread ---
        Runnable producerTask = () -> {
            while (true) {
                try {
                    synchronized (lock) {
                        // Wait if the buffer is full
                        while (buffer.size() == CAPACITY) {
                            System.out.println("Buffer is full, Producer is waiting...");
                            lock.wait();
                        }

                        // Use the Supplier to get a new value
                        int value = producer.get(); 
                        buffer.add(value);

                        // Notify the consumer thread that there's new data
                        lock.notifyAll();
                    }
                    Thread.sleep(1000); // Slow down for demonstration
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // --- 3. Create the Consumer Thread ---
        Runnable consumerTask = () -> {
            while (true) {
                try {
                    synchronized (lock) {
                        // Wait if the buffer is empty
                        while (buffer.isEmpty()) {
                            System.out.println("Buffer is empty, Consumer is waiting...");
                            lock.wait();
                        }

                        // Poll from buffer and use the Consumer to accept it
                        int value = buffer.poll();
                        consumer.accept(value); 

                        // Notify the producer thread that there's new space
                        lock.notifyAll();
                    }
                    Thread.sleep(1500); // Slow down for demonstration
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // --- 4. Start the Threads ---
        Thread producerThread = new Thread(producerTask);
        Thread consumerThread = new Thread(consumerTask);

        producerThread.start();
        consumerThread.start();
    }
}