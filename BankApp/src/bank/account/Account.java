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
    private String name;
    private int customerId;
    private List<Card> cards = new ArrayList<>();

    public Account(String IBAN, String swift, double amount, String name, int customerId){
        this.IBAN = IBAN;
        this.swift = swift;
        this.amount = amount;
        this.name = name;
        this.customerId = customerId;
    }

    public Account(String name, int customerId, int id) {
        this.IBAN = this.generateIBAN(id, "ING");
        this.swift = this.generateSwift("ING");
        this.amount = 0;
        this.name = name;
        this.customerId = customerId;
    }

    public Account(ResultSet in) throws SQLException {
        this.IBAN = in.getString("IBAN");
        this.swift = in.getString("swift");
        this.amount = in.getDouble("amount");
        this.name = in.getString("name");
        this.customerId = in.getInt("customerId");
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

    private String generateIBAN(int id, String bank){
        return "RO12" + bank + "B" + id;
    }

    private String generateSwift(String bank) {
        return "SWIFT" + bank + "B";
    }

    public String getName() {
        return name;
    }
    public int getCustomerId() {
        return customerId;
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
                ", name='" + name + '\'' +
                ", customerId=" + customerId +
                ", cards=" + cards +
                '}';
    }
}
