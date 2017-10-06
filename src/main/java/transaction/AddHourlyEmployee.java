package transaction;

import boundary.PayrollDatabase;
import entity.*;

public class AddHourlyEmployee extends AddEmployeeTransaction {
    private final int hourlyRate;

    public AddHourlyEmployee(int empId, String name, String address, int hourlyRate) {
        super(empId, name, address);
        this.hourlyRate = hourlyRate;
    }

    @Override
    protected PaymentSchedule MakeSchedule() {
        return new WeeklySchedule();
    }

    @Override
    protected PaymentClassification MakeClassification() {
        return new HourlyClassification(hourlyRate);
    }
}
