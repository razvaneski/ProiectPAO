package bank.transaction;

import java.util.Date;

public final class Transaction {
    final private String fromIBAN, toIBAN;
    final private double amount;
    final private String description;
    final private Date creationDate;

    public Transaction(String fromIBAN, String toIBAN, double amount, String description) throws Exception {

        if(amount <= 0)
            throw new Exception("Nu se poate tranzactiona o suma negativa sau nula!");

        this.fromIBAN = fromIBAN;
        this.toIBAN = toIBAN;
        this.amount = amount;
        this.description = description;
        this.creationDate = new Date();
    }

    public String getFromIBAN() {
        return fromIBAN;
    }
    public String getToIBAN() {
        return toIBAN;
    }
    public double getAmount() {
        return amount;
    }
    public String getDescription() {
        return description;
    }
    public Date getCreationDate() {
        return creationDate;
    }
}
