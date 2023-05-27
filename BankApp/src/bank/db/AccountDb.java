package bank.db;

import java.util.*;
import bank.account.*;
import java.sql.*;
public final class AccountDb {
    private Connection connection;
    public AccountDb(Connection connection) {
        this.connection = connection;
    }

    public List<Account> read() {
        List<Account> accounts = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Accounts");
            while (result.next()) {
                Account current = new Account(result);
                accounts.add(current);
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return accounts;
    }
}
