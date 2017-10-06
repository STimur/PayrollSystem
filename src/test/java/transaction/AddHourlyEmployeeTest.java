package transaction;

import boundary.PayrollDatabase;
import entity.*;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class AddHourlyEmployeeTest {
    @Test
    public void addHourlyEmployee() throws Exception {
        int empdId = 2;
        AddHourlyEmployee t = new AddHourlyEmployee(empdId, "Bob", "Home", 50);
        t.execute();

        Employee e = PayrollDatabase.getEmployee(empdId);
        assertEquals("Bob", e.name);
        assertEquals("Home", e.address);

        PaymentClassification pc = e.classification;
        assertTrue(pc instanceof HourlyClassification);
        HourlyClassification hc = (HourlyClassification) pc;
        assertEquals(50, hc.hourlyRate);
        PaymentSchedule ps = e.schedule;
        assertTrue(ps instanceof WeeklySchedule);

        PaymentMethod pm = e.method;
        assertTrue(pm instanceof HoldMethod);
    }
}
