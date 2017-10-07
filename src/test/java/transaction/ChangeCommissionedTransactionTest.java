package transaction;

import boundary.PayrollDatabase;
import entity.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ChangeCommissionedTransactionTest {
    @Test
    public void changeCommissionedTransaction() throws Exception {
        int empId = 3;
        Transaction t = new AddHourlyEmployee(empId, "Bob", "Home", 30);
        t.execute();
        Transaction cct = new ChangeCommissionedTransaction(empId, 3000, 0.5);
        cct.execute();
        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);
        PaymentClassification pc = e.classification;
        assertNotNull(pc);
        assertTrue(pc instanceof CommissionedClassification);
        CommissionedClassification cc = (CommissionedClassification) pc;
        assertEquals(3000, cc.salary);
        assertEquals(0.5, cc.commissionRate, 0.01);
        PaymentSchedule ps = e.schedule;
        assertTrue(ps instanceof BiweeklySchedule);
    }
}
