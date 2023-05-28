package bank.account;

import bank.card.*;
import bank.transaction.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Account {
    private String IBAN;
    private String swift;
    private double amount;
    private String CNP;
    private List<Card> cards = new ArrayList<>();

    public Account(String CNP) {
        this.IBAN = this.generateIBAN(CNP, "ING");
        this.swift = this.generateSwift("ING");
        this.amount = 0;
        this.CNP = CNP;
    }

    public Account(ResultSet in) throws SQLException {
        this.IBAN = in.getString("IBAN");
        this.swift = in.getString("swift");
        this.amount = in.getDouble("amount");
        this.CNP = in.getString("CNP");
    }

    public Account(Scanner in) {
        System.out.println("CNP client: ");
        String CNP = in.nextLine();
        this.IBAN = this.generateIBAN(CNP, "ING");
        this.swift = this.generateSwift("ING");
        this.amount = 0;
        this.CNP = CNP;
    }

    public List<Transaction> filterTransactions(List<Transaction> allTransactions){
        List<Transaction> transactions = new ArrayList<>();
        for(var transaction: allTransactions)
            if(transaction.getFromIBAN().equals(this.IBAN))
                transactions.add(transaction);
        return transactions;
    }

    public void addCreditCard(String name){
        CreditCard newCard = new CreditCard(this.IBAN);
        cards.add(newCard);
    }
    public void addDebitCard(String name){
        DebitCard newCard = new DebitCard(this.IBAN);
        cards.add(newCard);
    }

    private String generateIBAN(String CNP, String bank){
        int random = (int)(Math.random() * 10000);
        return "RO12" + bank + "B" + CNP + random;
    }

    private String generateSwift(String bank) {
        return "SWIFT" + bank + "B";
    }

    public String getCustomerCNP() {
        return CNP;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getIBAN() {
        return IBAN;
    }
    public String getSwift() {
        return swift;
    }
    public double getAmount() {
        return amount;
    }
    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return "Account{" +
                "IBAN='" + IBAN + '\'' +
                ", swift='" + swift + '\'' +
                ", amount=" + amount +
                ", CNP=" + CNP +
                ", cards=" + cards +
                '}';
    }
}
