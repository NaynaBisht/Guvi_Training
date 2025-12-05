// File: src/com/example/model/Account.java
package com.example.model;

import java.util.Objects;

public class Account implements Comparable<Account> {
    private String accountholdername;
    private long accountno;
    private String transcode;
    private String country;
    private String ifsccode;
    private double balance;

    public Account(String accountholdername, long accountno, String transcode, String country, String ifsccode, double balance) {
        this.accountholdername = accountholdername;
        this.accountno = accountno;
        this.transcode = transcode;
        this.country = country;
        this.ifsccode = ifsccode;
        this.balance = balance;
    }

    // Getters for sorting
    public String getAccountholdername() { return accountholdername; }
    public long getAccountno() { return accountno; }
    public double getBalance() { return balance; }

    /**
     * Comparable: Provides natural sorting order.
     * Here, we define the natural order to be by accountholdername.
     */
    @Override
    public int compareTo(Account other) {
        return this.accountholdername.compareTo(other.accountholdername);
    }

    /**
     * equals(): Defines logical equality.
     * Two Account objects are considered equal if their name and account number are the same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountno == account.accountno &&
               Objects.equals(accountholdername, account.accountholdername);
    }

    /**
     * hashCode(): Must be consistent with equals().
     * If two objects are equal, they MUST have the same hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(accountholdername, accountno);
    }

    @Override
    public String toString() {
        return String.format("Account{name='%s', no=%d, balance=%.2f}",
                accountholdername, accountno, balance);
    }
}