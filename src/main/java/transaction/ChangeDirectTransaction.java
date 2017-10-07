package transaction;

import entity.DirectMethod;
import entity.PaymentMethod;

public class ChangeDirectTransaction extends ChangeMethodTransaction {
    private final String bank;
    private final int account;

    public ChangeDirectTransaction(int empId, String bank, int account) {
        super(empId);
        this.bank = bank;
        this.account = account;
    }

    @Override
    protected PaymentMethod makePaymentMethod() {
        return new DirectMethod(bank, account);
    }
}
