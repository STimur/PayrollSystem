package transaction;

import entity.MonthlySchedule;
import entity.PaymentClassification;
import entity.PaymentSchedule;
import entity.SalariedClassification;

public class AddSalariedEmployee extends AddEmployeeTransaction {
    private final int salary;

    public AddSalariedEmployee(int empId, String name, String address, int salary) {
        super(empId, name, address);
        this.salary = salary;
    }

    @Override
    protected PaymentSchedule MakeSchedule() {
        return new MonthlySchedule();
    }

    @Override
    protected PaymentClassification MakeClassification() {
        return new SalariedClassification(salary);
    }
}
