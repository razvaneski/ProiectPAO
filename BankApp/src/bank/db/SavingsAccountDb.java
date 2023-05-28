package bank.db;

import bank.account.*;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class SavingsAccountDb {
    private final Connection connection;
    public SavingsAccountDb(Connection connection) {
        this.connection = connection;
    }

    public List<SavingsAccount> read() {
        List<SavingsAccount> savingsAccounts = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM SavingsAccounts");
            while (result.next()) {
                SavingsAccount current = new SavingsAccount(result);
                savingsAccounts.add(current);
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return savingsAccounts;
    }

    public void update(SavingsAccount newSavingsAccount) {
        try {
            String query = "UPDATE SavingsAccounts SET amount = ?, customerId = ?, startDate = ?, endDate = ?, interestRate = ? WHERE IBAN = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setDouble(1, newSavingsAccount.getAmount());
            preparedStmt.setInt(2, newSavingsAccount.getCustomerId());
            preparedStmt.setString(3, (new SimpleDateFormat("yyyy-MM-dd")).format(newSavingsAccount.getStartDate()));
            preparedStmt.setString(4, (new SimpleDateFormat("yyyy-MM-dd")).format(newSavingsAccount.getEndDate()));
            preparedStmt.setInt(5, newSavingsAccount.getInterestRate());
            preparedStmt.setString(6, newSavingsAccount.getIBAN());
            preparedStmt.executeUpdate();
            preparedStmt.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void create(SavingsAccount savingsAccount) {
        try {
            String query = "INSERT INTO SavingsAccounts (IBAN, swift, amount, customerId, startDate, endDate, interestRate) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, savingsAccount.getIBAN());
            preparedStmt.setString(2, savingsAccount.getSwift());
            preparedStmt.setDouble(3, savingsAccount.getAmount());
            preparedStmt.setInt(4, savingsAccount.getCustomerId());
            preparedStmt.setString(5, (new SimpleDateFormat("yyyy-MM-dd")).format(savingsAccount.getStartDate()));
            preparedStmt.setString(6, (new SimpleDateFormat("yyyy-MM-dd")).format(savingsAccount.getEndDate()));
            preparedStmt.setInt(7, savingsAccount.getInterestRate());
            preparedStmt.execute();
            preparedStmt.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void delete(SavingsAccount savingsAccount) {
        try {
            String query = "DELETE FROM SavingsAccounts WHERE IBAN = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, savingsAccount.getIBAN());
            preparedStmt.execute();
            preparedStmt.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
