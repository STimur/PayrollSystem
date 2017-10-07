package transaction;

import boundary.PayrollDatabase;
import entity.DirectMethod;
import entity.Employee;
import entity.PaymentMethod;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ChangeDirectTransactionTest {
    @Test
    public void changeDirectTransaction() throws Exception {
        int empId = 3;
        Transaction t = new AddHourlyEmployee(empId, "Bob", "Home", 30);
        t.execute();
        Transaction cdt = new ChangeDirectTransaction(empId, "Citibank", 1234);
        cdt.execute();
        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);
        PaymentMethod pm = e.method;
        assertTrue(pm instanceof DirectMethod);
        DirectMethod dm = (DirectMethod) pm;
        assertEquals("Citibank", dm.bank);
        assertEquals(1234, dm.account);
    }
}
