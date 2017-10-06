package transaction;

import boundary.PayrollDatabase;
import entity.Employee;
import entity.HourlyClassification;
import entity.PaymentClassification;
import entity.TimeCard;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TimeCardTransactionTest {
    @Test
    public void timeCardTransaction() throws Exception {
        int empId = 5;
        AddHourlyEmployee t = new AddHourlyEmployee(empId, "Bill", "Home", 15);
        t.execute();
        TimeCardTransaction tct = new TimeCardTransaction(LocalDate.of(2005, 7, 31), 8.0, empId);
        tct.execute();

        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);

        PaymentClassification pc = e.classification;
        assertTrue(pc instanceof HourlyClassification);
        HourlyClassification hc = (HourlyClassification) pc;
        TimeCard tc = hc.getTimeCard(LocalDate.of(2005, 7, 31));
        assertNotNull(tc);
        assertEquals(8.0, tc.hours, 0.01);
    }
}
