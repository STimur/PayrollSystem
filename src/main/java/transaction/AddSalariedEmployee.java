package transaction;

import boundary.PayrollDatabase;
import entity.Employee;

public class AddSalariedEmployee {
    private final int empId;
    private final String name;
    private final String address;
    private final int salary;

    public AddSalariedEmployee(int empdId, String name, String address, int salary) {
        this.empId = empdId;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public void execute() {
        Employee employee = new Employee(empId, name, address, salary);
        PayrollDatabase.addEmployee(empId, employee);
    }
}
