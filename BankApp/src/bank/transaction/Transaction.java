package bank.transaction;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public final class Transaction {
    private static int idCount = 0;
    public static void setIdCount(int idCount) {
        Transaction.idCount = idCount;
    }
    private final int transactionId;
    final private String fromIBAN, toIBAN;
    final private double amount;
    final private String description;
    final private Date transactionDate;

    public Transaction(String fromIBAN, String toIBAN, double amount, String description) throws Exception {
        if(amount <= 0)
            throw new Exception("Nu se poate tranzactiona o suma negativa sau nula!");
        this.transactionId = idCount++;
        this.fromIBAN = fromIBAN;
        this.toIBAN = toIBAN;
        this.amount = amount;
        this.description = description;
        this.transactionDate = new Date();
    }

    public Transaction(ResultSet in) throws SQLException {
        this.transactionId = in.getInt("transactionId");
        this.fromIBAN = in.getString("fromIBAN");
        this.toIBAN = in.getString("toIBAN");
        this.amount = in.getDouble("amount");
        this.description = in.getString("description");
        this.transactionDate = in.getDate("transactionDate");
    }

    public int getTransactionId() {
        return transactionId;
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
    public Date getTransactionDate() {
        return transactionDate;
    }
}
