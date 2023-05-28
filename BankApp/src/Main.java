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
        AccountDb accountDb = new AccountDb(getConnection());
        Account account = new Account(1);
        accountDb.create(account);
        List<Account> accounts = accountDb.read();
        for (Account a : accounts) {
            System.out.println(a);
        }
        account.setAmount(1000);
        accountDb.update(account);
        accounts = accountDb.read();
        for (Account a : accounts) {
            System.out.println(a);
        }
        accountDb.delete(account);
        accounts = accountDb.read();
        for (Account a : accounts) {
            System.out.println(a);
        }
    }
}
