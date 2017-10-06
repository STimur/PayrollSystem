package entity;

public class Employee {
    private int id;
    public String name;
    public String address;
    public SalariedClassification classification;
    public MonthlySchedule schedule;
    public HoldMethod method;

    public Employee(int id, String name, String address, int salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        classification = new SalariedClassification(salary);
        schedule = new MonthlySchedule();
        method = new HoldMethod();
    }
}
