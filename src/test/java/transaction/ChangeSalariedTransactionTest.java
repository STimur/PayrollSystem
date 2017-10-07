package transaction;

import boundary.PayrollDatabase;
import entity.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ChangeSalariedTransactionTest {
    @Test
    public void changeSalariedTransaction() throws Exception {
        int empId = 3;
        Transaction t = new AddHourlyEmployee(empId, "Bob", "Home", 30);
        t.execute();
        Transaction cst = new ChangeSalariedTransaction(empId, 3000);
        cst.execute();
        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);
        PaymentClassification pc = e.classification;
        assertNotNull(pc);
        assertTrue(pc instanceof SalariedClassification);
        SalariedClassification sc = (SalariedClassification) pc;
        assertEquals(3000, sc.salary);
        PaymentSchedule ps = e.schedule;
        assertTrue(ps instanceof MonthlySchedule);
    }
}
