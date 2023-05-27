package bank.factories;

import bank.account.*;
public final class AccountFactory {
    private static int id = 0;
    public Account createAccount(String name, int customerId){
        return new Account(name, customerId, id++);
    }
    public SavingsAccount createSavingsAccount(String name, int customerId){
        return new SavingsAccount(name, customerId, id++);
    }
}
