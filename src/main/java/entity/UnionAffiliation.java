package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UnionAffiliation extends Affiliation {
    public final double dues;
    private final int memberId;
    private List<ServiceCharge> serviceCharges = new ArrayList<>();

    public UnionAffiliation(int memberId, double dues) {
        this.memberId = memberId;
        this.dues = dues;
    }

    public ServiceCharge getServiceCharge(LocalDate date) {
        for (ServiceCharge sc : serviceCharges)
            if (sc.date.equals(date))
                return sc;
        return null;
    }

    public void addServiceCharge(ServiceCharge serviceCharge) {
        serviceCharges.add(serviceCharge);
    }
}
