package entity;

import java.time.LocalDate;

public class ServiceCharge {
    public final LocalDate date;
    public final int amount;

    public ServiceCharge(LocalDate date, int amount) {
        this.date = date;
        this.amount = amount;
    }
}
