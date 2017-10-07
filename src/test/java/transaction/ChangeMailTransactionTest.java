package transaction;

import boundary.PayrollDatabase;
import entity.DirectMethod;
import entity.Employee;
import entity.MailMethod;
import entity.PaymentMethod;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ChangeMailTransactionTest {
    @Test
    public void changeMailTransaction() throws Exception {
        int empId = 3;
        Transaction t = new AddHourlyEmployee(empId, "Bob", "Home", 30);
        t.execute();
        Transaction cmt = new ChangeMailTransaction(empId, "abc@mail.com");
        cmt.execute();
        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);
        PaymentMethod pm = e.method;
        assertTrue(pm instanceof MailMethod);
        MailMethod mm = (MailMethod) pm;
        assertEquals("abc@mail.com", mm.email);
    }
}
