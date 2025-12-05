package default_package;

public class ProcessPayment {

	// The main method is the entry point of any Java application.
    // It is where the program starts executing.
    public static void main(String[] args) {
        // These lines demonstrate basic output using System.out.println.
        // They print text to the console.
        System.out.println("Hello world!");
        System.out.println("I am learning Java.");
        System.out.println("It is awesome!");

        // These lines show how to call a method multiple times.
        // The method 'myMethod' is defined below and will be executed each time it's called.
        myMethod();
        myMethod();
        myMethod();
        
        ProcessPayment obj = new ProcessPayment();

        // Call the non-static method using the object
        obj.myNewMethod();
        obj.myNewMethod();
        obj.myNewMethod();

    }

    // This is a static method named 'myMethod'.
    // It prints a message when called.
    // The 'static' keyword means it belongs to the class, not an instance of the class.
    static void myMethod() {
        System.out.println("I just got executed!");
    }
    void myNewMethod() {
        System.out.println("I just got executed!");
    }



}
