package bank.customer;

import java.sql.ResultSet;
import java.util.*;
import bank.account.*;
import bank.transaction.*;
import java.sql.SQLException;

public final class Customer {
    private static int customerIdCounter = 0;
    public static void setCustomerIdCounter(int customerIdCounter) {
        Customer.customerIdCounter = customerIdCounter;
    }

    private final int customerId;
    private String firstName, lastName, CNP;
    private Date birthDate;
    private String email, phone;
    private String address;

    public Customer(
            String firstName,
            String lastName,
            String CNP,
            Date birthDate,
            String email,
            String phone,
            String address
    ) {
        this.customerId = customerIdCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.CNP = CNP;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Customer(ResultSet in) throws SQLException {
        this.customerId = in.getInt("customerId");
        this.firstName = in.getString("firstName");
        this.lastName = in.getString("lastName");
        this.CNP = in.getString("CNP");
        this.birthDate = in.getDate("birthDate");
        this.email = in.getString("email");
        this.phone = in.getString("phone");
        this.address = in.getString("address");
    }

    public List<Account> filterAccounts(List<Account> allAccounts){
        var accounts = new ArrayList<Account>();
        for(var account: allAccounts)
            if(account.getCustomerId() == this.getCustomerId())
                accounts.add(account);
        return accounts;
    }

    public List<Transaction> filterTransactions(List<Account> allAccounts, List<Transaction> allTransactions){
        var transactions = new ArrayList<Transaction>();
        var accounts = this.filterAccounts(allAccounts);
        for(var account: accounts)
            transactions.addAll(account.filterTransactions(allTransactions));
        return transactions;
    }

    public int getCustomerId() {
        return customerId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCNP() {
        return CNP;
    }
    public void setCNP(String CNP) {
        this.CNP = CNP;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
