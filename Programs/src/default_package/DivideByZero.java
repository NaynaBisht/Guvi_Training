package default_package;

public class DivideByZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            int a = 5, b = 0;
            int result = a / b; // division by zero
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }
	}

}
