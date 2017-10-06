package boundary;

import entity.Employee;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {
    private static Map<Integer, Employee> employees = new HashMap<>();

    public static Employee getEmployee(int id) {
        return employees.get(id);
    }

    public static void addEmployee(int id, Employee employee) {
        employees.put(id, employee);
    }
}
