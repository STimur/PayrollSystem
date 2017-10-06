package transaction;

import entity.BiweeklySchedule;
import entity.CommissionedClassification;
import entity.PaymentClassification;
import entity.PaymentSchedule;

public class AddCommissionedEmployee extends AddEmployeeTransaction {
    private int salary;
    private double commissionRate;

    public AddCommissionedEmployee(int empdId, String name, String address, int salary, double commissionRate) {
        super(empdId, name, address);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    protected PaymentSchedule MakeSchedule() {
        return new BiweeklySchedule();
    }

    @Override
    protected PaymentClassification MakeClassification() {
        return new CommissionedClassification(salary, commissionRate);
    }
}
