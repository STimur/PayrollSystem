package entity;

public class CommissionedClassification extends PaymentClassification {
    public final int salary;
    public final double commissionRate;

    public CommissionedClassification(int salary, double commissionRate) {
        this.salary = salary;
        this.commissionRate = commissionRate;
    }
}
