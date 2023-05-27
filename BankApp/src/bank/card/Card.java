package bank.card;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Card {
    private final int cardId, CVV;
    private String number, name;
    private String IBAN;
    private final Date expirationDate;
    static private final Set<String> usedNumbers = new HashSet<>();

    public Card(int cardId, String IBAN, String name) {
        this.cardId = cardId;
        this.IBAN = IBAN;
        this.name = name;
        this.number = this.generateCardNumber();

        while(usedNumbers.contains(this.number))
            this.number = this.generateCardNumber();
        usedNumbers.add(this.number);

        this.CVV = this.generateCardCVV();

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, 3);
        this.expirationDate = c.getTime();
    }

    public void read(Scanner in){
        System.out.println("IBAN: ");
        this.IBAN = in.nextLine();
        System.out.println("Name: ");
        this.name = in.nextLine();
    }

    private String generateCardNumber(){
        byte[] arr = new byte[16];
        new Random().nextBytes(arr);
        return new String(arr, StandardCharsets.UTF_8);
    }

    private int generateCardCVV(){
        var rand = new Random();
        return 100 + rand.nextInt(899);
    }

    public int getCardId() {
        return cardId;
    }
    public String getNumber() {
        return number;
    }
    public String getName() {
        return name;
    }
    public int getCVV() {
        return CVV;
    }
    public String getIBAN() {
        return IBAN;
    }
    public Date getExpirationDate() {
        return expirationDate;
    }
}
