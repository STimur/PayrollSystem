package transaction;

import boundary.PayrollDatabase;
import entity.*;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class AddCommissionedEmployeeTest {
    @Test
    public void addCommissionedEmployee() throws Exception {
        int empdId = 2;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empdId, "Bob", "Home", 1000, 0.2);
        t.execute();

        Employee e = PayrollDatabase.getEmployee(empdId);
        assertEquals("Bob", e.name);
        assertEquals("Home", e.address);

        PaymentClassification pc = e.classification;
        assertTrue(pc instanceof CommissionedClassification);
        CommissionedClassification cc = (CommissionedClassification) pc;
        assertEquals(1000, cc.salary);
        assertEquals(0.2, cc.commissionRate, 0.01);
        PaymentSchedule ps = e.schedule;
        assertTrue(ps instanceof BiweeklySchedule);

        PaymentMethod pm = e.method;
        assertTrue(pm instanceof HoldMethod);
    }
}
