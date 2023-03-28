package Models.Account;

import Models.Customer;

public abstract class Account {
    protected static int idCount = 0;
    protected int id;
    protected String iban;
    protected double balance;
    protected int customerId;

    public Account(Customer customer, double balance) {
        this.customerId = customer.getId();
        this.balance = balance;
        this.id = idCount++;
        this.iban = "RO" + String.format("%05d", this.id);
    }

    public int getId() {
        return id;
    }
}
