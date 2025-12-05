package carloan;

import java.util.Scanner;

public class CarLoanDemo {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter can variant : ");
        String userInput = scanner.next();
       
        
        double carPrice = 0;
        String variant = "";

        if (userInput.equals("delta")) {
            carPrice = 800000;
            variant = "Delta";
        } else if (userInput.equals("alfa")) {
            carPrice = 1200000;
            variant = "Alfa";
        } else if (userInput.equals("beta")) {
            carPrice = 1000000;
            variant = "Beta";
        } else {
            System.out.println("Invalid variant selected. Exiting program.");
            return;
        }

        System.out.print("car color: ");
        String carColor = scanner.next();

        CarDetails myCar = new CarDetails("Baleno", variant, carPrice, carColor);
        myCar.displayCarDetails();
        
        

        System.out.print("Enter the down payment amount:");
        double downPayment = scanner.nextDouble();
        
        System.out.print("Enter rate:");
        double interestRate = scanner.nextDouble();     
        
        System.out.print("Enter years:");
        int tenure = scanner.nextInt();        
        
        System.out.print("Enter compounding years:");
        int compoundingYears = scanner.nextInt();
        
        
        
        // loan
        double loanAmount = carPrice - downPayment;
        
        CalculateLoan loan = new CalculateLoan(loanAmount, interestRate, tenure);

        double simpleInterest = loan.simpleInterest();
        double compoundInterest = loan.compoundInterest(compoundingYears);
        double totalAmountPayable = loan.totalAmount();
        double emi = loan.emi();

        
        
        
        System.out.println();
        
        System.out.println("Amount: ₹"+ loan.principal);
        System.out.println("Rate: " + loan.annualRate + "%");
        System.out.println("Loan Tenure: " + loan.years + " years");
        System.out.println();
        System.out.println("Simple Interest: ₹"+ simpleInterest);
        System.out.println("Compound Interest: ₹"+ compoundInterest );
        System.out.println("Amount ₹"+ totalAmountPayable);
        System.out.println("EMI : ₹"+ emi);
        
        
    }
}