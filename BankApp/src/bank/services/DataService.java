package bank.services;

import bank.customer.*;
import bank.account.*;
import bank.card.*;
import bank.transaction.Transaction;

import java.util.*;
public final class DataService {
    private static DataService instance = null;
    private List<Customer> customers = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private List<SavingsAccount> savingsAccounts = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();
    private List<DebitCard> debitCards = new ArrayList<>();
    private List<CreditCard> creditCards = new ArrayList<>();

    private static DbService dbService = DbService.getInstance();

    private DataService() {
        reloadData();
    }
    public static DataService getInstance() {
        if (instance == null) {
            instance = new DataService();
        }
        return instance;
    }

    private void reloadData() {
        this.customers = dbService.getCustomers();
        this.accounts = dbService.getAccounts();
        this.savingsAccounts = dbService.getSavingsAccounts();
        this.transactions = dbService.getTransactions();
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }
    public void addCustomer(Customer customer) {
        try {
            dbService.addCustomer(customer);
            this.customers.add(customer);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void updateCustomer(Customer customer) {
        try {
            dbService.updateCustomer(customer);
            this.customers = dbService.getCustomers();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deleteCustomer(Customer customer) {
        try {
            dbService.deleteCustomer(customer);
            this.customers = dbService.getCustomers();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }
    public List<SavingsAccount> getSavingsAccounts() {
        return this.savingsAccounts;
    }
    public void addAccount(Account account) {
        try {
            dbService.addAccount(account);
            this.accounts = dbService.getAccounts();
            this.savingsAccounts = dbService.getSavingsAccounts();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deleteAccount(Account account) {
        try {
            dbService.deleteAccount(account);
            this.accounts = dbService.getAccounts();
            this.savingsAccounts = dbService.getSavingsAccounts();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void updateAccount(Account account) {
        try {
            dbService.updateAccount(account);
            this.accounts = dbService.getAccounts();
            this.savingsAccounts = dbService.getSavingsAccounts();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }
    public void addTransaction(Transaction transaction) {
        try {
            dbService.addTransaction(transaction);
            this.transactions = dbService.getTransactions();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deleteTransaction(Transaction transaction) {
        try {
            dbService.deleteTransaction(transaction);
            this.transactions = dbService.getTransactions();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void updateTransaction(Transaction transaction) {
        try {
            dbService.updateTransaction(transaction);
            this.transactions = dbService.getTransactions();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
