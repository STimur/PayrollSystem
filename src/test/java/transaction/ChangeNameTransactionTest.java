package transaction;

import boundary.PayrollDatabase;
import entity.Employee;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChangeNameTransactionTest {
    @Test
    public void changeNameTransaction() throws Exception {
        int empId = 2;
        Transaction t = new AddHourlyEmployee(empId, "Bill", "Home", 15);
        t.execute();
        Transaction cnt = new ChangeNameTransaction(empId, "Bob");
        cnt.execute();
        Employee e = PayrollDatabase.getEmployee(empId);
        assertEquals("Bob", e.name);
    }
}
