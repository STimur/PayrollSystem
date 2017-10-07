package transaction;

import entity.MonthlySchedule;
import entity.PaymentClassification;
import entity.PaymentSchedule;
import entity.SalariedClassification;

public class ChangeSalariedTransaction extends ChangeClassificationTransaction {
    private final int salary;

    public ChangeSalariedTransaction(int empId, int salary) {
        super(empId);
        this.salary = salary;
    }

    @Override
    protected PaymentSchedule makeSchedule() {
        return new MonthlySchedule();
    }

    @Override
    protected PaymentClassification makeClassification() {
        return new SalariedClassification(salary);
    }
}
