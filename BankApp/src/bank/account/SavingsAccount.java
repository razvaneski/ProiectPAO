package bank.account;

import java.util.Calendar;
import java.util.Date;

public class SavingsAccount extends Account{
    private final Date startDate, endDate;
    private final int interestRate;

    public SavingsAccount(String name, int customerId, int id) {
        super(name, customerId, id);
        this.startDate = new Date();
        this.interestRate = 3;
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, 1);
        this.endDate = c.getTime();
    }

    public SavingsAccount(String IBAN, String swift, double amount, String name, int customerId, Date startDate, Date endDate, int interest) {
        super(IBAN, swift, amount, name, customerId);
        this.startDate = startDate;
        this.endDate = endDate;
        this.interestRate = interest;
    }

    public Date getStartDate() {
        return startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public int getInterest() {
        return interestRate;
    }
}
