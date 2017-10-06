package entity;

import java.time.LocalDate;

public class SalesReceipt {
    public final LocalDate date;
    public final int amount;

    public SalesReceipt(LocalDate date, int amount) {
        this.date = date;
        this.amount = amount;
    }
}
