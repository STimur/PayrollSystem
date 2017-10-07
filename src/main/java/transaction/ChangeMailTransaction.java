package transaction;

import entity.MailMethod;
import entity.PaymentMethod;

public class ChangeMailTransaction extends ChangeMethodTransaction {
    private final String email;

    public ChangeMailTransaction(int empId, String email) {
        super(empId);
        this.email = email;
    }

    @Override
    protected PaymentMethod makePaymentMethod() {
        return new MailMethod(email);
    }
}
