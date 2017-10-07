package transaction;

import boundary.PayrollDatabase;
import entity.Employee;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChangeAddressTransactionTest {
    @Test
    public void changeAddressTransaction() throws Exception {
        int empId = 2;
        Transaction t = new AddHourlyEmployee(empId, "Bill", "Home", 15);
        t.execute();
        Transaction cat = new ChangeAddressTransaction(empId, "Office");
        cat.execute();
        Employee e = PayrollDatabase.getEmployee(empId);
        assertEquals("Office", e.address);
    }
}
