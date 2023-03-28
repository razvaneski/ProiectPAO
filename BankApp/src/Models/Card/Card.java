package Models.Card;

import Models.Account.Account;
import Models.Account.CurrentAccount;

public abstract class Card {
    protected static int idCount = 0;
    protected int id;
    protected String cardNumber;
    protected int accountId;

    public Card(CurrentAccount account) {
        this.accountId = account.getId();
        this.id = idCount++;
        this.cardNumber = String.format("%04d", this.id);
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
