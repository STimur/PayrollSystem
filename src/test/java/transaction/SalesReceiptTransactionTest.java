package transaction;

import boundary.PayrollDatabase;
import entity.*;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SalesReceiptTransactionTest {
    @Test
    public void salesReceiptTransaction() throws Exception {
        int empId = 6;
        Transaction t = new AddCommissionedEmployee(empId, "Bill", "Home", 1000, 0.2);
        t.execute();
        Transaction srt = new SalesReceiptTransaction(LocalDate.of(2005, 7, 31), 2000, empId);
        srt.execute();

        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);

        PaymentClassification pc = e.classification;
        assertTrue(pc instanceof CommissionedClassification);
        CommissionedClassification cc = (CommissionedClassification) pc;
        SalesReceipt sr = cc.getSalesReceipt(LocalDate.of(2005, 7, 31));
        assertNotNull(sr);
        assertEquals(2000, sr.amount);
    }
}
