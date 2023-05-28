package bank.services;

import bank.account.SavingsAccount;
import bank.transaction.*;
import bank.customer.Customer;
import bank.account.Account;
import bank.db.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DbService {
    private static DbService instance = null;
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
    private AccountDb accountDb = new AccountDb(getConnection());
    private SavingsAccountDb savingsAccountDb = new SavingsAccountDb(getConnection());
    private CustomerDb customerDb = new CustomerDb(getConnection());
    private TransactionDb transactionDb = new TransactionDb(getConnection());
    private DbService() {}
    public static DbService getInstance() {
        if (instance == null) {
            instance = new DbService();
        }
        return instance;
    }

    public void addCustomer(Customer customer) throws SQLException {
        customerDb.create(customer);
    }
    public List<Customer> getCustomers() {
        return customerDb.read();
    }
    public void updateCustomer(Customer customer) throws SQLException {
        customerDb.update(customer);
    }
    public void deleteCustomer(Customer customer) throws SQLException {
        customerDb.delete(customer);
    }

    public void addAccount(Account account) throws SQLException {
        if (account instanceof SavingsAccount) {
            savingsAccountDb.create((SavingsAccount) account);
        } else {
            accountDb.create(account);
        }
    }
    public List<Account> getAccounts() {
        return accountDb.read();
    }
    public List<SavingsAccount> getSavingsAccounts() {
        return savingsAccountDb.read();
    }
    public void updateAccount(Account account) throws SQLException {
        if (account instanceof SavingsAccount) {
            savingsAccountDb.update((SavingsAccount) account);
        } else {
            accountDb.update(account);
        }
    }
    public void deleteAccount(Account account) throws SQLException {
        if (account instanceof SavingsAccount) {
            savingsAccountDb.delete((SavingsAccount) account);
        } else {
            accountDb.delete(account);
        }
    }

    public void addTransaction(Transaction transaction) throws SQLException {
        transactionDb.create(transaction);
    }
    public List<Transaction> getTransactions() {
        return transactionDb.read();
    }
    public void updateTransaction(Transaction transaction) throws SQLException {
        transactionDb.update(transaction);
    }
    public void deleteTransaction(Transaction transaction) throws SQLException {
        transactionDb.delete(transaction);
    }
}
