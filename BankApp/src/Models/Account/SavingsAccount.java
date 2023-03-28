package Models.Account;

import Models.Account.Account;
import Models.Customer;

public final class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(Customer customer, double balance, double interestRate) {
        super(customer, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
