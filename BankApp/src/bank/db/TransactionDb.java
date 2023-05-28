package bank.db;

import java.text.SimpleDateFormat;
import java.util.*;
import bank.transaction.*;
import java.sql.*;
public class TransactionDb {
    private final Connection connection;
    public TransactionDb(Connection connection) { this.connection = connection; }

    public void create(Transaction transaction) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Transactions (transactionId, fromIBAN, toIBAN, amount, description, transactionDate) VALUES (?, ?, ?, ?, ?, ?)"
            );
            statement.setInt(1, transaction.getTransactionId());
            statement.setString(2, transaction.getFromIBAN());
            statement.setString(3, transaction.getToIBAN());
            statement.setDouble(4, transaction.getAmount());
            statement.setString(5, transaction.getDescription());
            statement.setString(6, (new SimpleDateFormat("yyyy-MM-dd")).format(transaction.getTransactionDate()));
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Transaction> read() {
        List<Transaction> transactions = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Transactions ORDER BY transactionId ASC");
            while (result.next()) {
                Transaction current = new Transaction(result);
                transactions.add(current);
                Transaction.setIdCount(current.getTransactionId() + 1);
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return transactions;
    }

    public void update(Transaction transaction) {
        try {
            String query = "UPDATE Transactions SET fromIBAN = ?, toIBAN = ?, amount = ?, description = ?, transactionDate = ? WHERE transactionId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, transaction.getFromIBAN());
            statement.setString(2, transaction.getToIBAN());
            statement.setDouble(3, transaction.getAmount());
            statement.setString(4, transaction.getDescription());
            statement.setString(5, (new SimpleDateFormat("yyyy-MM-dd")).format(transaction.getTransactionDate()));
            statement.setInt(6, transaction.getTransactionId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(Transaction transaction) {
        try {
            String query = "DELETE FROM Transactions WHERE transactionId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, transaction.getTransactionId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
