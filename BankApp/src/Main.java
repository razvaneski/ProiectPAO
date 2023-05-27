import bank.account.Account;
import bank.db.AccountDb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/bank";
            String user = "root";
            String password = "proiectpao";

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    public static void main(String[] args) {
        AccountDb accountDb = new AccountDb(getConnection());
        Account account = new Account("RO123", "INGB", 1000, "Gigel", 1);
    }
}
