package transaction;

import boundary.PayrollDatabase;
import entity.CommissionedClassification;
import entity.Employee;
import entity.PaymentClassification;
import entity.SalesReceipt;

import java.time.LocalDate;

public class SalesReceiptTransaction implements Transaction {
    private final LocalDate date;
    private final int amount;
    private final int empId;

    public SalesReceiptTransaction(LocalDate date, int amount, int empId) {
        this.date = date;
        this.amount = amount;
        this.empId = empId;
    }

    @Override
    public void execute() {
        Employee e = PayrollDatabase.getEmployee(empId);

        if (e != null) {
            PaymentClassification pc = e.classification;
            if (pc instanceof CommissionedClassification) {
                CommissionedClassification cc = (CommissionedClassification) pc;
                cc.addSalesReceipt(new SalesReceipt(date, amount));
            } else
                throw new InvalidOperationException("Tried to add sales receipt to" +
                        " non-commissioned employee");
        } else
            throw new InvalidOperationException("No such employee.");
    }

    private class InvalidOperationException extends RuntimeException {
        public InvalidOperationException(String s) {
            super(s);
        }
    }
}
