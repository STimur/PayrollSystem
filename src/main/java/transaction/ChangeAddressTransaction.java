package transaction;

import entity.Employee;

public class ChangeAddressTransaction extends ChangeEmployeeTransaction {
    private final String newAddress;

    public ChangeAddressTransaction(int empId, String newAddress) {
        super(empId);
        this.newAddress = newAddress;
    }

    protected void change(Employee e) {
        e.address = newAddress;
    }
}
