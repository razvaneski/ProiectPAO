package Models.Card;

import Models.Account.CurrentAccount;
import Models.Card.Card;

public final class DebitCard extends Card {
    public DebitCard(CurrentAccount account) {
        super(account);
    }
}
