package transaction;

import boundary.PayrollDatabase;
import entity.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ChangeHourlyTransactionTest {
    @Test
    public void changeHourlyTransaction() throws Exception {
        int empId = 3;
        Transaction t = new AddCommissionedEmployee(empId, "Lance", "Home", 2500, 3.2);
        t.execute();
        Transaction cht = new ChangeHourlyTransaction(empId, 28);
        cht.execute();
        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);
        PaymentClassification pc = e.classification;
        assertNotNull(pc);
        assertTrue(pc instanceof HourlyClassification);
        HourlyClassification hc = (HourlyClassification) pc;
        assertEquals(28, hc.hourlyRate);
        PaymentSchedule ps = e.schedule;
        assertTrue(ps instanceof WeeklySchedule);
    }
}
