package transaction;

import boundary.PayrollDatabase;
import entity.Employee;
import entity.ServiceCharge;
import entity.UnionAffiliation;

import java.time.LocalDate;

public class ServiceChargeTransaction implements Transaction {
    private final int memberId;
    private final LocalDate date;
    private final int charge;

    public ServiceChargeTransaction(int memberId, LocalDate date, int charge) {
        this.memberId = memberId;
        this.date = date;
        this.charge = charge;
    }

    @Override
    public void execute() {
        Employee e = PayrollDatabase.getUnionMember(memberId);

        if (e != null) {
            UnionAffiliation ua = null;
            if (e.affiliation instanceof UnionAffiliation)
                ua = (UnionAffiliation) e.affiliation;

            if (ua != null)
                ua.addServiceCharge(new ServiceCharge(date, charge));
            else
                throw new InvalidOperationException("Tries to add service charge " +
                        "to union member without a union affiliation");
        } else
            throw new InvalidOperationException("No such union member.");
    }

    private class InvalidOperationException extends RuntimeException {
        public InvalidOperationException(String msg) {
            super(msg);
        }
    }
}
