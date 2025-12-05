package default_package;

public class PrimeNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("Prime numbers");
		for (int num = 2; num <= 500; num++) {
            boolean isPrimeFlag = true;

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrimeFlag = false;
                    break;
                }
            }

            if (isPrimeFlag)
                System.out.println(num);
        }

	}

}
