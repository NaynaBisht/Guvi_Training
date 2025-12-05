// File: src/com/example/main/Main.java
package com.example.main;

import com.example.model.Account;
import com.example.util.AccountNoComparator;
import com.example.util.BalanceComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Charlie", 1234567893L, "T03", "USA", "BOFAUS3N", 5000.75));
        accounts.add(new Account("Alice", 1234567891L, "T01", "UK", "HBUKGB4B", 10200.50));
        accounts.add(new Account("Bob", 1234567892L, "T02", "IN", "SBININBB", 7500.00));
        accounts.add(new Account("David", 1234567890L, "T04", "CA", "ROYCCAT2", 3200.00));

        System.out.println("--- Original List ---");
        printList(accounts);

        // 1. Sort using Comparable (based on accountholdername - Natural Order)
        System.out.println("\n--- Sorted by Name (Comparable) ---");
        Collections.sort(accounts);
        printList(accounts);

        // 2. Sort using Comparator (based on accountno)
        System.out.println("\n--- Sorted by Account Number (Comparator) ---");
        accounts.sort(new AccountNoComparator());
        printList(accounts);

        // 3. Sort using Comparator (based on balance)
        System.out.println("\n--- Sorted by Balance (Comparator) ---");
        accounts.sort(new BalanceComparator());
        printList(accounts);

        // 4. Test equals() and hashCode()
        System.out.println("\n--- Testing equals() and hashCode() ---");
        Account acc1 = new Account("Eve", 9876543210L, "T05", "AU", "CTBAAU2S", 15000.00);
        Account acc2 = new Account("Eve", 9876543210L, "T06", "NZ", "ANZBNZ22", 12000.00); // Same name & acc no
        Account acc3 = new Account("Frank", 9876543210L, "T07", "DE", "DEUTDEFF", 20000.00); // Different name

        System.out.println("\nacc1 hashcode: " + acc1.hashCode());
        System.out.println("acc2 hashcode: " + acc2.hashCode());
        System.out.println("Is acc1 equal to acc2? " + acc1.equals(acc2)); // Should be true
        System.out.println("Is acc1 equal to acc3? " + acc1.equals(acc3)); // Should be false
    }

    public static void printList(List<Account> list) {
        for (Account acc : list) {
            System.out.println(acc);
        }
    }
}