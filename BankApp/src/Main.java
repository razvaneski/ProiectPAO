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
        SavingsAccountDb accountDb = new SavingsAccountDb(getConnection());
        SavingsAccount account = new SavingsAccount("Gigel", 1, 1);
        accountDb.create(account);
        List<SavingsAccount> accounts = accountDb.read();
        for (SavingsAccount a : accounts) {
            System.out.println(a);
        }
        account.setAmount(100);
        accountDb.update(account);
        accounts = accountDb.read();
        for (SavingsAccount a : accounts) {
            System.out.println(a);
        }
        accountDb.delete(account);
        accounts = accountDb.read();
        for (SavingsAccount a : accounts) {
            System.out.println(a);
        }
    }
}
