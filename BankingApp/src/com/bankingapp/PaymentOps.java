package com.bankingapp;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class PaymentOps {

    public static void main(String[] args) {

        Account acc = new Account("3458748574", 443865375233.0);
        System.out.println("account details " + acc.accountNo() + " balance " + acc.balance());

        // Test call
        fundTransferExample();
    }

    public static void fundTransferExample() {

        var nameList = new ArrayList<String>();
        nameList.addAll(List.of("John", "Jack", "Michel", "James", "Andrew", "Julia"));

        // Predicate: names starting with J
        Predicate<String> startsWithJ = p -> p.startsWith("J");

        // Consumer: print names
        Consumer<String> printName = name -> System.out.println("Name: " + name);

        // Function: take first 3 chars of name
        Function<String, String> firstThreeLetters = name -> name.substring(0, 3);

        // MAP example
        nameList.stream().map(firstThreeLetters).forEach(System.out::println);

        // FILTER + FOR EACH
        System.out.println("\nNames starting with J:");
        nameList.stream().filter(startsWithJ).forEach(printName);

        
        // ACCOUNT LIST PROCESSING
        

        Account acc1 = new Account("11111", 2000);
        Account acc2 = new Account("22222", 5000);
        Account acc3 = new Account("33333", 1200);

        List<Account> accList = List.of(acc1, acc2, acc3);

        // Sorted by account number
        var sortedByAccNo = accList.stream()
                .sorted(Comparator.comparing(Account::accountNo))
                .toList();

        System.out.println("\nSorted by Account No:");
        sortedByAccNo.forEach(a -> System.out.println(a.accountNo()));

        // Filter > 2000 balance
        System.out.println("\nFiltered (balance > 2000):");
        accList.stream()
                .filter(a -> a.balance() > 2000)
                .forEach(a -> System.out.println(a));

        // ===========================
        // STREAM OF INTEGERS
        // ===========================
        System.out.println("\nSorted integer stream:");
        Stream.of(2, 3, 4123, 47, 34, 120)
                .sorted()
                .forEach(a -> System.out.println("sorted values " + a));

        // ===========================
        // ✅ RETURN MAP: key = accountNo, value = balance
        // ===========================
        Map<String, Double> accMap = accList.stream()
                .collect(Collectors.toMap(Account::accountNo, Account::balance));

        System.out.println("\nMap of Account Number → Balance");
        accMap.forEach((k, v) -> System.out.println(k + " => " + v));
    }
}
