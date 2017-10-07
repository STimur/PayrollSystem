package transaction;

import boundary.PayrollDatabase;
import entity.Employee;
import entity.ServiceCharge;
import entity.UnionAffiliation;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ServiceChargeTransactionTest {
    @Test
    public void addServiceCharge() throws Exception {
        int empId = 2;
        Transaction t = new AddHourlyEmployee(empId, "Bill", "Home", 15);
        t.execute();
        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);

        UnionAffiliation af = new UnionAffiliation(2356, 22.13);
        e.affiliation = af;
        int memberId = 86; // Maxwell Smart
        PayrollDatabase.addUnionMember(memberId, e);
        Transaction sct = new ServiceChargeTransaction(memberId, LocalDate.of(2005, 8, 8), 13);
        sct.execute();
        ServiceCharge sc = af.getServiceCharge(LocalDate.of(2005, 8, 8));
        assertNotNull(sc);
        assertEquals(13, sc.amount);
    }
}
