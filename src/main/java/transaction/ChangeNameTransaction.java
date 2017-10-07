package transaction;

import boundary.PayrollDatabase;
import entity.Employee;

public class ChangeNameTransaction implements Transaction {
    private final int empId;
    private final String name;

    public ChangeNameTransaction(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    @Override
    public void execute() {
        Employee e = PayrollDatabase.getEmployee(empId);
        if (e != null)
            change(e);
        else
            throw new InvalidOperationException("No such employee.");
    }

    private void change(Employee e) {
        e.name = name;
    }

    private class InvalidOperationException extends RuntimeException {
        public InvalidOperationException(String msg) {
            super(msg);
        }
    }
}
