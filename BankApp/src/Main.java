import bank.account.*;
import bank.db.*;

import java.sql.*;
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
        SavingsAccountDb savingsAccountDb = new SavingsAccountDb(getConnection());
        SavingsAccount savingsAccount = new SavingsAccount(1);
        savingsAccountDb.create(savingsAccount);
        savingsAccountDb.read().forEach(System.out::println);
        savingsAccount.setAmount(1000);
        savingsAccountDb.update(savingsAccount);
        savingsAccountDb.read().forEach(System.out::println);
        savingsAccountDb.delete(savingsAccount);
        savingsAccountDb.read().forEach(System.out::println);
    }
}
