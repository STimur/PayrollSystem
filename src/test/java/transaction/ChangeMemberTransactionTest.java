package transaction;

import boundary.PayrollDatabase;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Union;
import entity.Affiliation;
import entity.Employee;
import entity.UnionAffiliation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ChangeMemberTransactionTest {
    @Test
    public void changeMemberTransaction() throws Exception {
        int empId = 8;
        Transaction t = new AddHourlyEmployee(empId, "Bill", "Home", 15);
        t.execute();
        int memberId = 7743;
        ChangeMemberTransaction cmt = new ChangeMemberTransaction(empId, memberId, 99.42);
        cmt.execute();
        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);
        Affiliation affiliation = e.affiliation;
        assertNotNull(affiliation);
        assertTrue(affiliation instanceof UnionAffiliation);
        UnionAffiliation ua = (UnionAffiliation) affiliation;
        assertEquals(99.42, ua.dues, 0.001);
        Employee member = PayrollDatabase.getUnionMember(memberId);
        assertNotNull(member);
        assertEquals(e, member);
    }
}
