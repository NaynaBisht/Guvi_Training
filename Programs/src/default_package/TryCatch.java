package default_package;

public class TryCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            int a = 10 / 0;  // This will cause ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e);
        }
        System.out.println("Program continues...");
	}

}
