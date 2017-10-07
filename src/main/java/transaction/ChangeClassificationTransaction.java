package transaction;

import entity.Employee;
import entity.PaymentClassification;
import entity.PaymentSchedule;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {
    public ChangeClassificationTransaction(int empId) {
        super(empId);
    }

    @Override
    protected void change(Employee e) {
        e.classification = makeClassification();
        e.schedule = makeSchedule();
    }

    protected abstract PaymentSchedule makeSchedule();

    protected abstract PaymentClassification makeClassification();
}
