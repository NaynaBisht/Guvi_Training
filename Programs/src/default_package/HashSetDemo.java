package default_package;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    @Override
    public String toString() {
        return "Account No: " + accountNumber + " | Balance: " + balance;
    }

    // equals() override (based on account number only)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BankAccount that = (BankAccount) obj;
        return Objects.equals(this.accountNumber, that.accountNumber);
    }


    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}

public class HashSetDemo {
    public static void main(String[] args) {
        Set<BankAccount> accounts = new HashSet<>();

        BankAccount acc1 = new BankAccount("1001", 5000);
        BankAccount acc2 = new BankAccount("1002", 7000); 

        accounts.add(acc1);
        accounts.add(acc2); 

        System.out.println(accounts);
    }
}
