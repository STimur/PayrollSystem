package transaction;

import boundary.PayrollDatabase;
import entity.*;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class AddSalariedEmployeeTest {
    @Test
    public void AddSalariedEmployee() throws Exception {
        int empdId = 1;
        Transaction t = new AddSalariedEmployee(empdId, "Bob", "Home", 50);
        t.execute();

        Employee e = PayrollDatabase.getEmployee(empdId);
        assertEquals("Bob", e.name);
        assertEquals("Home", e.address);

        PaymentClassification pc = e.classification;
        assertTrue(pc instanceof SalariedClassification);
        SalariedClassification sc = (SalariedClassification) pc;
        assertEquals(50, sc.salary);
        PaymentSchedule ps = e.schedule;
        assertTrue(ps instanceof MonthlySchedule);

        PaymentMethod pm = e.method;
        assertTrue(pm instanceof HoldMethod);
    }
}
