package transaction;

import entity.BiweeklySchedule;
import entity.CommissionedClassification;
import entity.PaymentClassification;
import entity.PaymentSchedule;

public class ChangeCommissionedTransaction extends ChangeClassificationTransaction {
    private int salary;
    private double commissionRate;

    public ChangeCommissionedTransaction(int empId, int salary, double commissionRate) {
        super(empId);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    protected PaymentSchedule makeSchedule() {
        return new BiweeklySchedule();
    }

    @Override
    protected PaymentClassification makeClassification() {
        return new CommissionedClassification(salary, commissionRate);
    }
}
