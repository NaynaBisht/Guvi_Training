package default_package;
import java.util.function.*;

public class Calculate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calc = (a,b) -> a+b;
		System.out.print("Sum "+calc.add(5, 3));
	}
	
	
	Runnable r1 = new Runnable() {
	    public void run() {
	        System.out.println("Running without lambda!");
	    }
	};

	Runnable r2 = () -> System.out.println("Running with lambda!");x

}
interface Calculator{
	int add(int a, int b);
}


