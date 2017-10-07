package transaction;

import entity.Employee;
import entity.PaymentMethod;

public abstract class ChangeMethodTransaction extends ChangeEmployeeTransaction {
    public ChangeMethodTransaction(int empId) {
        super(empId);
    }

    @Override
    protected void change(Employee e) {
        e.method = makePaymentMethod();
    }

    protected abstract PaymentMethod makePaymentMethod();
}
