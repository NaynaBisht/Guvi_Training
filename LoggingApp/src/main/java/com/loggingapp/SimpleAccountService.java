package com.loggingapp;
public class SimpleAccountService implements AccountService {

    private double balanceA1 = 500;
    private double balanceA2 = 1000;

    @Override
    public boolean exists(String accountNumber) {
        return accountNumber.equals("A1") || accountNumber.equals("A2");
    }

    @Override
    public double getBalance(String accountNumber) {
        if (accountNumber.equals("A1")) return balanceA1;
        if (accountNumber.equals("A2")) return balanceA2;
        return 0;
    }

    @Override
    public boolean debit(String accountNumber, double amount) {
        if (accountNumber.equals("A1") && balanceA1 >= amount) {
            balanceA1 -= amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean credit(String accountNumber, double amount) {
        if (accountNumber.equals("A2")) {
            balanceA2 += amount;
            return true;
        }
        return false;
    }
}
