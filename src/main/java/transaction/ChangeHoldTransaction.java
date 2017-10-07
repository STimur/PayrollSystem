package transaction;

import entity.HoldMethod;
import entity.PaymentMethod;

public class ChangeHoldTransaction extends ChangeMethodTransaction {
    public ChangeHoldTransaction(int empId) {
        super(empId);
    }

    @Override
    protected PaymentMethod makePaymentMethod() {
        return new HoldMethod();
    }
}
