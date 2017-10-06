package transaction;

import boundary.PayrollDatabase;
import entity.*;

public abstract class AddEmployeeTransaction implements Transaction {
    private final String address;
    private final String name;
    private final int empId;

    public AddEmployeeTransaction(int empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = address;
    }

    @Override
    public void execute() {
        PaymentClassification pc = MakeClassification();
        PaymentSchedule ps = MakeSchedule();
        PaymentMethod pm = new HoldMethod();

        Employee employee = new Employee(empId, name, address);
        employee.classification = pc;
        employee.schedule = ps;
        employee.method = pm;

        PayrollDatabase.addEmployee(empId, employee);
    }

    protected abstract PaymentSchedule MakeSchedule();

    protected abstract PaymentClassification MakeClassification();
}
