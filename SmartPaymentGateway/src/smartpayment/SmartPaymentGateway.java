package smartpayment;

import java.util.Scanner;

public class SmartPaymentGateway {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner (System.in);
		
		System.out.println("enter the benificiary name and account num : ") ;
		String beneficiaryName = sc.nextLine();
		String accNum = sc.nextLine();
		
		Beneficiary beneficiary = new Beneficiary(beneficiaryName, accNum);
        boolean continuePayment = true;
        
        while (continuePayment) {
            System.out.println("Choose Payment Method: 1.UPI  2.Wallet  3.CreditCard  4.NetBanking");
            int paymentChoice = sc.nextInt();

            System.out.println("Enter Amount: ");
            double amount = sc.nextDouble();

            Payment payment = null;

            try {
                switch (paymentChoice) {
                    case 1:
                        System.out.println("Enter UPI ID: ");
                        String upi = sc.next();
                        System.out.println("Enter PIN: ");
                        String pin = sc.next();
                        payment = new UPI(amount, beneficiary, upi, pin);
                        break;

                    case 2:
                        System.out.println("Enter Wallet Balance: ");
                        double balance = sc.nextDouble();
                        payment = new Wallet(amount, beneficiary, balance);
                        break;

                    case 3:
                        System.out.println("Enter Card Number: ");
                        String card = sc.next();
                        System.out.println("Enter CVV: ");
                        String cvv = sc.next();
                        payment = new CreditCard(amount, beneficiary, card, cvv);
                        break;

                    case 4:
                        System.out.println("Enter Username: ");
                        String user = sc.next();
                        System.out.println("Enter Password: ");
                        String pass = sc.next();
                        payment = new NetBanking(amount, beneficiary, user, pass);
                        break;

                    default:
                        System.out.println("Invalid option!");
                }

                if (payment != null)
                    payment.processPayment();

            } catch (InvalidAmountException e) {
                System.out.println("Error: Invalid Amount.");
            } catch (InvalidCredentialsException e) {
                System.out.println("Invalid credentials.");
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            } catch (BeneficiaryNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                try {
                    throw new TransactionFailedException(e);
                } catch (TransactionFailedException ex) {
                    System.out.println(ex.getMessage());
                }
            }

            System.out.println("\nDo you want to make another payment? (yes/no): ");
            continuePayment = sc.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thank you.");
        sc.close();
    }
		
		
}


