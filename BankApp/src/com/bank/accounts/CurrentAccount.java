package com.bank.accounts;

import com.bank.Customer;

public final class CurrentAccount extends Account {
    private double overdraft;
    public CurrentAccount(Customer customer, double balance) {
        super(customer, balance);
        this.overdraft = 0;
    }
}
