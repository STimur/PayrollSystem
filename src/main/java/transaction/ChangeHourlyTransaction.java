package transaction;

import entity.HourlyClassification;
import entity.PaymentClassification;
import entity.PaymentSchedule;
import entity.WeeklySchedule;

public class ChangeHourlyTransaction extends ChangeClassificationTransaction {
    private final int hourlyRate;

    public ChangeHourlyTransaction(int empId, int hourlyRate) {
        super(empId);
        this.hourlyRate = hourlyRate;
    }

    @Override
    protected PaymentSchedule makeSchedule() {
        return new WeeklySchedule();
    }

    @Override
    protected PaymentClassification makeClassification() {
        return new HourlyClassification(hourlyRate);
    }
}
