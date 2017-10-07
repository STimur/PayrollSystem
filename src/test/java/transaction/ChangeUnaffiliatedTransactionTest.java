package transaction;

import boundary.PayrollDatabase;
import entity.Affiliation;
import entity.Employee;
import entity.NoAffiliation;
import entity.UnionAffiliation;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChangeUnaffiliatedTransactionTest {
    @Test
    public void changeUnaffiliatedTransaction() throws Exception {
        int empId = 8;
        Transaction t = new AddHourlyEmployee(empId, "Bill", "Home", 15);
        t.execute();
        int memberId = 1284;
        ChangeMemberTransaction cmt = new ChangeMemberTransaction(empId, memberId, 99.42);
        cmt.execute();
        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);
        Affiliation affiliation = e.affiliation;
        assertNotNull(affiliation);
        assertTrue(affiliation instanceof UnionAffiliation);
        Employee member = PayrollDatabase.getUnionMember(memberId);
        assertNotNull(member);
        assertEquals(e, member);

        ChangeUnaffiliatedTransaction aut = new ChangeUnaffiliatedTransaction(empId);
        aut.execute();
        affiliation = e.affiliation;
        assertNotNull(affiliation);
        assertTrue(affiliation instanceof NoAffiliation);
        member = PayrollDatabase.getUnionMember(memberId);
        assertNull(member);
    }
}
