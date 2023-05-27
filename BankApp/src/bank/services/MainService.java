package bank.services;

import bank.customer.*;
import bank.account.*;
import bank.card.*;
import bank.transaction.Transaction;

import java.util.*;
public final class MainService {
    private List<Customer> customers = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private List<SavingsAccount> savingsAccounts = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();
}
