package transaction;

import entity.Affiliation;
import entity.Employee;

public abstract class ChangeAffiliationTransaction extends ChangeEmployeeTransaction {
    public ChangeAffiliationTransaction(int empId) {
        super(empId);
    }

    @Override
    protected void change(Employee e) {
        recordMembership(e);
        e.affiliation = makeAffiliation();
    }

    protected abstract Affiliation makeAffiliation();

    protected abstract void recordMembership(Employee e);
}
