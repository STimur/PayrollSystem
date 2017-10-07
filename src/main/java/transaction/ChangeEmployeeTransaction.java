package transaction;

import boundary.PayrollDatabase;
import entity.Employee;

public abstract class ChangeEmployeeTransaction implements Transaction {
    protected final int empId;

    public ChangeEmployeeTransaction(int empId) {
        this.empId = empId;
    }

    @Override
    public void execute() {
        Employee e = PayrollDatabase.getEmployee(empId);
        if (e != null)
            change(e);
        else
            throw new InvalidOperationException("No such employee.");
    }

    protected abstract void change(Employee e);

    private class InvalidOperationException extends RuntimeException {
        public InvalidOperationException(String msg) {
            super(msg);
        }
    }
}
