package bank.account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SavingsAccount extends Account{
    private final Date startDate, endDate;
    private final int interestRate;

    public SavingsAccount(String CNP) {
        super(CNP);
        this.startDate = new Date();
        this.interestRate = 3;
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, 1);
        this.endDate = c.getTime();
    }

    public SavingsAccount(ResultSet in) throws SQLException {
        super(in);
        this.startDate = in.getDate("startDate");
        this.endDate = in.getDate("endDate");
        this.interestRate = in.getInt("interestRate");
    }

    public SavingsAccount(Scanner in) {
        super(in);
        this.startDate = new Date();
        this.interestRate = 3;
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, 1);
        this.endDate = c.getTime();
    }

    @Override
    public String toString() {
        return "Savings" + super.toString() +
                " start: " + this.startDate +
                ", end: " + this.endDate +
                ", interest: " + this.interestRate;
    }

    public Date getStartDate() {
        return startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public int getInterestRate() {
        return interestRate;
    }
}
