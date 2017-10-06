package transaction;

import boundary.PayrollDatabase;
import entity.Employee;
import entity.HoldMethod;
import entity.MonthlySchedule;
import entity.SalariedClassification;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class AddSalariedEmployeeTest {
    @Test
    public void testAddSalariedEmployee() throws Exception {
        int empdId = 1;
        AddSalariedEmployee t = new AddSalariedEmployee(empdId, "Bob", "Home", 50);
        t.execute();

        Employee e = PayrollDatabase.getEmployee(empdId);
        assertEquals("Bob", e.name);
        assertEquals("Home", e.address);

        SalariedClassification sc = e.classification;
        assertTrue(sc instanceof SalariedClassification);
        assertEquals(50, sc.salary);
        assertTrue(e.schedule instanceof MonthlySchedule);

        assertTrue(e.method instanceof HoldMethod);
    }
}
