package com.app.process;

public class CheckBalance {

	public static void main(String[] args) {
        System.out.println("Checking Balance");

        BankAccount acc = new BankAccount();
        acc.showAccountDetails();

        System.out.println("Balance is: 5000");
    }

}
