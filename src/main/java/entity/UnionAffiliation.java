package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UnionAffiliation extends Affiliation {
    private List<ServiceCharge> serviceCharges = new ArrayList<>();

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
