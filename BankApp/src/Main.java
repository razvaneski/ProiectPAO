import bank.transaction.*;
import bank.db.*;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class Main {
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/bank";
            String user = "root";
            String password = "proiectpao";

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    public static void main(String[] args) {
        TransactionDb transactionDb = new TransactionDb(getConnection());
        try {
            Transaction transaction = new Transaction(
                    "FROMIBAN",
                    "TOIBAN",
                    100.0,
                    "DESCRIPTION"
            );
            transactionDb.create(transaction);
            List<Transaction> transactions = transactionDb.read();
            for (Transaction t : transactions) {
                System.out.println(t);
            }
            transaction.setAmount(200.0);
            transactionDb.update(transaction);
            transactions = transactionDb.read();
            for (Transaction t : transactions) {
                System.out.println(t);
            }
            transactionDb.delete(transaction);
            transactions = transactionDb.read();
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
