package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CommissionedClassification extends PaymentClassification {
    public final int salary;
    public final double commissionRate;
    private List<SalesReceipt> salesReceipts = new ArrayList<>();

    public CommissionedClassification(int salary, double commissionRate) {
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    public SalesReceipt getSalesReceipt(LocalDate date) {
        for (SalesReceipt sr : salesReceipts)
            if (sr.date.equals(date))
                return sr;
        return null;
    }

    public void addSalesReceipt(SalesReceipt salesReceipt) {
        salesReceipts.add(salesReceipt);
    }
}
