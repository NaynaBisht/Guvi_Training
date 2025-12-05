// File: src/com/example/util/BalanceComparator.java
package com.example.util;

import com.example.model.Account;
import java.util.Comparator;

public class BalanceComparator implements Comparator<Account> {
    @Override
    public int compare(Account a1, Account a2) {
        return Double.compare(a1.getBalance(), a2.getBalance());
    }
}