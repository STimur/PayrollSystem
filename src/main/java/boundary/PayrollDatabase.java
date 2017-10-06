package boundary;

import entity.Employee;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {
    private static Map<Integer, Employee> employees = new HashMap<>();
    private static Map<Integer, Employee> unionMembers = new HashMap<>();

    public static Employee getEmployee(int id) {
        return employees.get(id);
    }

    public static void addEmployee(int id, Employee employee) {
        employees.put(id, employee);
    }

    public static void deleteEmployee(int empId) {
        employees.remove(empId);
    }

    public static void addUnionMember(int memberId, Employee e) {
        unionMembers.put(memberId, e);
    }

    public static Employee getUnionMember(int memberId) {
        return unionMembers.get(memberId);
    }
}
