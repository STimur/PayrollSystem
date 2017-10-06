package transaction;

import boundary.PayrollDatabase;
import entity.Employee;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class DeleteEmployeeTest {
    @Test
    public void deleteEmployee() throws Exception {
        int empId = 4;
        AddCommissionedEmployee t = new AddCommissionedEmployee(empId, "Bill", "Home", 2500, 3.2);
        t.execute();

        Employee e = PayrollDatabase.getEmployee(empId);
        assertNotNull(e);
        DeleteEmployeeTransaction dt = new DeleteEmployeeTransaction(empId);
        dt.execute();

        e = PayrollDatabase.getEmployee(empId);
        assertNull(e);
    }
}
