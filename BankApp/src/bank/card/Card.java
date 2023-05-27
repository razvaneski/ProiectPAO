package bank.card;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Card {
    private final int CVV;
    private String number;
    private String IBAN;
    private final Date expirationDate;
    private static Set<String> usedNumbers = new HashSet<>();
    private static void setUsedNumbers(Set<String> usedNumbers) {
        Card.usedNumbers = usedNumbers;
    }

    public Card(String IBAN) {
        this.IBAN = IBAN;
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

    public void read(Scanner in) {
        // TODO
        System.out.println("IBAN: ");
        this.IBAN = in.nextLine();
        System.out.println("Name: ");
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

    public String getNumber() {
        return number;
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
