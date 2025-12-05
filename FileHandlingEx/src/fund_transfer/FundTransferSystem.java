package fund_transfer;

import java.io.*;
import java.util.*;

public class FundTransferSystem {

    public static void main(String[] args) {
        String fileName = "transactions.csv";
        List<Transaction> transactions = readTransactions(fileName);

        double totalHdfcTransfer = 0;

        System.out.println("=== Transaction Summary ===\n");
        for (Transaction t : transactions) {
            if (validateTransaction(t)) {
                System.out.println("Transfer Successful!");
                System.out.println(t.senderName + " transferred ₹" + t.amountTransferred +
                        " to " + t.receiverName + " (" + t.transferType + ")");
                System.out.println("-----------------------------------");

                if (t.senderIFSC.startsWith("HDFC"))
                    totalHdfcTransfer += t.amountTransferred;

            } else {
                System.out.println("Transfer Failed for " + t.senderName + " -> " + t.receiverName);
            }
        }

        System.out.println("Total Amount Transferred by HDFC Bank: ₹" + totalHdfcTransfer);
    }

    static List<Transaction> readTransactions(String fileName) {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Transaction t = new Transaction(
                        data[0], data[1], Long.parseLong(data[2]), data[3],
                        Double.parseDouble(data[4]), Double.parseDouble(data[5]),
                        data[6], data[7], data[8], Long.parseLong(data[9]), data[10]
                );
                transactions.add(t);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return transactions;
    }

    static boolean validateTransaction(Transaction t) {
        if (t.amountTransferred <= 0) {
            System.out.println("Invalid transfer amount!");
            return false;
        }
        if (t.senderBalance < t.amountTransferred) {
            System.out.println("Insufficient balance!");
            return false;
        }
        if (String.valueOf(t.senderAccNum).length() < 9 || String.valueOf(t.receiverAccNum).length() < 9) {
            System.out.println("Invalid account number!");
            return false;
        }
        return true;
    }
}