package Models;

import java.util.Date;

public final class Transaction {
    private static int idCount = 0;
    private int id;
    private Date transactionDate;
    private double amount;
    private String description;
    private String fromIban;
    private String toIban;

    public Transaction(double amount, String description, String fromIban, String toIban) {
        this.amount = amount;
        this.description = description;
        this.fromIban = fromIban;
        this.toIban = toIban;
        this.id = idCount++;
        this.transactionDate = new Date();
    }

    public int getId() {
        return id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getFromIban() {
        return fromIban;
    }

    public String getToIban() {
        return toIban;
    }
}
