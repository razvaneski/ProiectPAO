package bank.db;

import java.util.*;
import bank.account.*;
import java.sql.*;
public final class AccountDb {
    private final Connection connection;
    public AccountDb(Connection connection) {
        this.connection = connection;
    }

    public void create(Account account){
        try {
            String query = "INSERT INTO Accounts (IBAN, swift, amount, customerId) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, account.getIBAN());
            preparedStmt.setString(2, account.getSwift());
            preparedStmt.setDouble(3, account.getAmount());
            preparedStmt.setInt(4, account.getCustomerId());
            preparedStmt.execute();
            preparedStmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public List<Account> read() {
        List<Account> accounts = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Accounts");
            while (result.next()) {
                Account newAccount = new Account(result);
                accounts.add(newAccount);
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return accounts;
    }
    public void update(Account newAccount){
        try {
            String query = "UPDATE Accounts SET amount = ? WHERE IBAN = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setDouble(1, newAccount.getAmount());
            preparedStmt.setString(2, newAccount.getIBAN());
            preparedStmt.executeUpdate();
            preparedStmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void delete(Account account) {
        try {
            String query = "DELETE FROM Accounts WHERE IBAN = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, account.getIBAN());
            preparedStmt.execute();
            preparedStmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
