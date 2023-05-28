package bank.services;

import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import bank.audit.AuditService;
import bank.customer.*;
import bank.account.*;
import bank.transaction.Transaction;

public class AppService {
    private static AppService instance = null;
    private DataService dataService = DataService.getInstance();
    private AuditService auditService = null;

    private Scanner in = new Scanner(System.in);
    private AppService() {
        try {
            auditService = new AuditService();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static AppService getInstance() {
        if (instance == null) {
            instance = new AppService();
        }
        return instance;
    }

    // Customer actions:
    public void createCustomer() {
        try {
            Customer customer = new Customer(in);
            dataService.addCustomer(customer);
            auditService.logAction("createCustomer");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void getCustomer() {
        try {
            System.out.println("CNP: ");
            String CNP = in.nextLine();
            auditService.logAction("getCustomer");
            List<Customer> customers = dataService.getCustomers();
            for (Customer customer : customers) {
                if (customer.getCNP().equals(CNP)) {
                    System.out.println(customer);
                    return;
                }
            }
            System.out.println("Customer not found!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void updateCustomer() {
        try {
            auditService.logAction("updateCustomer");
            System.out.println("CNP: ");
            String CNP = in.nextLine();
            List<Customer> customers = dataService.getCustomers();
            for (Customer customer : customers) {
                if (customer.getCNP().equals(CNP)) {
                    System.out.println("First name: ");
                    customer.setFirstName(in.nextLine());
                    System.out.println("Last name: ");
                    customer.setLastName(in.nextLine());
                    System.out.println("CNP: ");
                    customer.setCNP(in.nextLine());
                    System.out.println("Birth Date (yyyy-MM-dd): ");
                    customer.setBirthDate(new java.text.SimpleDateFormat("yyyy-MM-dd").parse(in.nextLine()));
                    System.out.println("Email: ");
                    customer.setEmail(in.nextLine());
                    System.out.println("Phone: ");
                    customer.setPhone(in.nextLine());
                    System.out.println("Address: ");
                    customer.setAddress(in.nextLine());
                    dataService.updateCustomer(customer);
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deleteCustomer() {
        try {
            auditService.logAction("deleteCustomer");
            System.out.println("CNP: ");
            String CNP = in.nextLine();
            List<Customer> customers = dataService.getCustomers();
            for (Customer customer : customers) {
                if (customer.getCNP().equals(CNP)) {
                    dataService.deleteCustomer(customer);
                    return;
                }
            }
            System.out.println("Customer not found!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Account actions:
    public void getAccountsIBAN() {
        try {
            auditService.logAction("getAccountsIBAN");
            System.out.println("CNP: ");
            String CNP = in.nextLine();
            Customer customer = null;
            List<Customer> customers = dataService.getCustomers();
            for (Customer c : customers) {
                if (c.getCNP().equals(CNP)) {
                    customer = c;
                    break;
                }
            }
            if (customer == null) {
                System.out.println("Customer not found!");
                return;
            }
            System.out.println("Accounts: ");
            List<Account> accounts = dataService.getAccounts();
            for (Account account : accounts) {
                if (account.getCustomerCNP().equals(CNP)) {
                    System.out.println(account.getIBAN());
                }
            }
            System.out.println("Savings accounts: ");
            List<SavingsAccount> savingsAccounts = dataService.getSavingsAccounts();
            for (SavingsAccount account : savingsAccounts) {
                if (account.getCustomerCNP().equals(CNP)) {
                    System.out.println(account.getIBAN());
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void getAccountInfo() {
        try {
            auditService.logAction("getAccountInfo");
            System.out.println("IBAN: ");
            String IBAN = in.nextLine();
            Account account = null;
            List<Account> accounts = dataService.getAccounts();
            for (Account a : accounts) {
                if (a.getIBAN().equals(IBAN)) {
                    account = a;
                    break;
                }
            }
            if (account == null) {
                System.out.println("Account not found!");
                return;
            }
            System.out.println(account);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void createAccount() {
        try {
            auditService.logAction("createAccount");
            System.out.println("CNP: ");
            String CNP = in.nextLine();
            System.out.println("Account type (1 - current, 2 - savings): ");
            int type = Integer.parseInt(in.nextLine());
            Customer customer = null;
            List<Customer> customers = dataService.getCustomers();
            for (Customer c : customers) {
                if (c.getCNP().equals(CNP)) {
                    customer = c;
                    break;
                }
            }
            if (customer == null) {
                System.out.println("Customer not found!");
                return;
            }
            Account account = new Account(in);
            dataService.addAccount(account);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateAccount() {
        try {
            auditService.logAction("updateAccount");
            System.out.println("IBAN: ");
            String IBAN = in.nextLine();
            Account account = null;
            List<Account> accounts = dataService.getAccounts();
            for (Account a : accounts) {
                if (a.getIBAN().equals(IBAN)) {
                    account = a;
                    break;
                }
            }
            if (account == null) {
                System.out.println("Account not found!");
                return;
            }
            System.out.println("Amount: ");
            account.setAmount(Double.parseDouble(in.nextLine()));
            dataService.updateAccount(account);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deleteAccount() {
        try {
            auditService.logAction("deleteAccount");
            System.out.println("IBAN: ");
            String IBAN = in.nextLine();
            Account account = null;
            List<Account> accounts = dataService.getAccounts();
            for (Account a : accounts) {
                if (a.getIBAN().equals(IBAN)) {
                    account = a;
                    break;
                }
            }
            if (account == null) {
                System.out.println("Account not found!");
                return;
            }
            dataService.deleteAccount(account);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Transactions
    public void createTransaction() {
        try {
            auditService.logAction("createTransaction");
            Transaction transaction = new Transaction(in);
            dataService.addTransaction(transaction);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void getTransactions() {
        try {
            auditService.logAction("getTransactions");
            List<Transaction> transactions = dataService.getTransactions();
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void deleteTransaction() {
        try {
            auditService.logAction("deleteTransaction");
            System.out.println("Transaction ID: ");
            int id = Integer.parseInt(in.nextLine());
            Transaction transaction = null;
            List<Transaction> transactions = dataService.getTransactions();
            for (Transaction t : transactions) {
                if (t.getTransactionId() == id) {
                    transaction = t;
                    break;
                }
            }
            if (transaction == null) {
                System.out.println("Transaction not found!");
                return;
            }
            dataService.deleteTransaction(transaction);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void updateTransaction() {
        try {
            auditService.logAction("updateTransaction");
            System.out.println("Transaction ID: ");
            int id = Integer.parseInt(in.nextLine());
            Transaction transaction = null;
            List<Transaction> transactions = dataService.getTransactions();
            for (Transaction t : transactions) {
                if (t.getTransactionId() == id) {
                    transaction = t;
                    break;
                }
            }
            if (transaction == null) {
                System.out.println("Transaction not found!");
                return;
            }
            System.out.println("Amount: ");
            transaction.setAmount(Double.parseDouble(in.nextLine()));
            dataService.updateTransaction(transaction);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
