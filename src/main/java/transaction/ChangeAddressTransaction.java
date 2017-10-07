package transaction;

import boundary.PayrollDatabase;
import entity.Employee;

public class ChangeAddressTransaction implements Transaction {
    private final int empId;
    private final String newAddress;

    public ChangeAddressTransaction(int empId, String newAddress) {
        this.empId = empId;
        this.newAddress = newAddress;
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
        e.address = newAddress;
    }

    private class InvalidOperationException extends RuntimeException {
        public InvalidOperationException(String msg) {
        }
    }
}
