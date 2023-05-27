package com.bank.cards;

import com.bank.accounts.CurrentAccount;

public final class DebitCard extends Card {
    public DebitCard(CurrentAccount account) {
        super(account);
    }
}
