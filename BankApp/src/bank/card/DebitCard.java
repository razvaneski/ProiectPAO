package bank.card;

import java.util.Scanner;
public final class DebitCard extends Card {
    public DebitCard(String IBAN) {
        super(IBAN);
    }
    public DebitCard(Scanner in) {
        super(in);
    }
}
