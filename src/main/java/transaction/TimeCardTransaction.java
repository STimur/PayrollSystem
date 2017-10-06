package transaction;

import boundary.PayrollDatabase;
import entity.Employee;
import entity.HourlyClassification;
import entity.PaymentClassification;
import entity.TimeCard;

import java.time.LocalDate;

public class TimeCardTransaction implements Transaction {
    private final LocalDate date;
    private final double hours;
    private final int empId;

    public TimeCardTransaction(LocalDate date, double hours, int empId) {
        this.date = date;
        this.hours = hours;
        this.empId = empId;
    }

    @Override
    public void execute() {
        Employee e = PayrollDatabase.getEmployee(empId);

        if (e != null) {
            PaymentClassification pc = e.classification;
            if (pc instanceof HourlyClassification) {
                HourlyClassification hc = (HourlyClassification) pc;
                hc.addTimeCard(new TimeCard(date, hours));
            } else
                throw new InvalidOperationException("Tried to add timecard to" +
                        " non-hourly employee");
        } else
            throw new InvalidOperationException("No such employee.");
    }

    private class InvalidOperationException extends RuntimeException {
        public InvalidOperationException(String s) {
            super(s);
        }
    }
}
