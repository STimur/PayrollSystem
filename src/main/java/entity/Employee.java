package entity;

public class Employee {
    private int id;
    public String name;
    public String address;
    public PaymentClassification classification;
    public PaymentSchedule schedule;
    public PaymentMethod method;
    public Affiliation affiliation;

    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
