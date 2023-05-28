package bank.card;

import java.text.ParseException;
import java.util.Scanner;
public final class CreditCard extends Card {
    public CreditCard(String IBAN) {
        super(IBAN);
    }
    public CreditCard(Scanner in) {
        super(in);
    }
}
