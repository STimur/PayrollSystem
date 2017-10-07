package transaction;

import boundary.PayrollDatabase;
import entity.Affiliation;
import entity.Employee;
import entity.UnionAffiliation;

public class ChangeMemberTransaction extends ChangeAffiliationTransaction {
    private final int memberId;
    private final double dues;

    public ChangeMemberTransaction(int empId, int memberId, double dues) {
        super(empId);
        this.memberId = memberId;
        this.dues = dues;
    }

    @Override
    protected Affiliation makeAffiliation() {
        return new UnionAffiliation(memberId, dues);
    }

    @Override
    protected void recordMembership(Employee e) {
        PayrollDatabase.addUnionMember(memberId, e);
    }
}
