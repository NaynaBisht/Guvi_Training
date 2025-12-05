package fund_transfer;

import java.io.*;
import java.util.*;

public class Transaction {
	String senderName, senderCountry, senderIFSC, receiverName, receiverCountry, receiverIFSC, transferType;
    long senderAccNum, receiverAccNum;
    double senderBalance, amountTransferred;

    public Transaction(String senderName, String senderCountry, long senderAccNum, String senderIFSC,
                       double senderBalance, double amountTransferred, String transferType,
                       String receiverName, String receiverCountry, long receiverAccNum, String receiverIFSC) {
        this.senderName = senderName;
        this.senderCountry = senderCountry;
        this.senderAccNum = senderAccNum;
        this.senderIFSC = senderIFSC;
        this.senderBalance = senderBalance;
        this.amountTransferred = amountTransferred;
        this.transferType = transferType;
        this.receiverName = receiverName;
        this.receiverCountry = receiverCountry;
        this.receiverAccNum = receiverAccNum;
        this.receiverIFSC = receiverIFSC;
    }
}
