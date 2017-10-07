package transaction;

import boundary.PayrollDatabase;
import entity.Employee;
import entity.HoldMethod;
import entity.MailMethod;
import entity.PaymentMethod;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ChangeHoldTransactionTest {
    @Test
    public void changeHoldTransaction() throws Exception {
        int empId = 3;
        Transaction t = new AddHourlyEmployee(empId, "Bob", "Home", 30);
        t.execute();
        Transaction cmt = new ChangeMailTransaction(empId, "abc@mail.com");
        cmt.execute();
        Employee e = PayrollDatabase.getEmployee(empId);
        PaymentMethod pm = e.method;
        assertTrue(pm instanceof MailMethod);
        Transaction cht = new ChangeHoldTransaction(empId);
        cht.execute();
        pm = e.method;
        assertTrue(pm instanceof HoldMethod);
    }
}
