package transaction;

import boundary.PayrollDatabase;
import entity.Affiliation;
import entity.Employee;
import entity.NoAffiliation;
import entity.UnionAffiliation;

public class ChangeUnaffiliatedTransaction extends ChangeAffiliationTransaction {
    public ChangeUnaffiliatedTransaction(int empId) {
        super(empId);
    }

    @Override
    protected Affiliation makeAffiliation() {
        return new NoAffiliation();
    }

    @Override
    protected void recordMembership(Employee e) {
        Affiliation affiliation = e.affiliation;
        if (affiliation instanceof UnionAffiliation) {
            UnionAffiliation unionAffiliation = (UnionAffiliation) affiliation;
            int memberId = unionAffiliation.memberId;
            PayrollDatabase.removeUnionMember(memberId);
        }
    }
}
