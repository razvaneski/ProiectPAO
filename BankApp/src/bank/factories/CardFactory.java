package bank.factories;

import bank.card.*;

public final class CardFactory {
    private static int id = 0;
    public Card addCard(String IBAN, String name){
        return new Card(id++, IBAN, name);
    }
    public DebitCard createDebitCard(String IBAN, String name){
        return new DebitCard(id++, IBAN, name);
    }
    public CreditCard createCreditCard(String IBAN, String name){
        return new CreditCard(id++, IBAN, name);
    }
}
