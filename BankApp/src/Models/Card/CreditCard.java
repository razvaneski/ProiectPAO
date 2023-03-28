package Models.Card;

import Models.Account.CurrentAccount;
import Models.Card.Card;

public final class CreditCard extends Card {
    private double creditLimit;
    private double interestRate;

    public CreditCard(CurrentAccount account, double creditLimit, double interestRate) {
        super(account);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }
}
