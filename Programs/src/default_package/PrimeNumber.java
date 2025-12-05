package default_package;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Prime numbers");

        for (int num = 2; num <= 500; num++) {
            if (isPrime(num))
                System.out.println(num);
        }
	}
	public static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
