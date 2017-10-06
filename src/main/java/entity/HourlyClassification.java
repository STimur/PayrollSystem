package entity;

public class HourlyClassification extends PaymentClassification {
    public int hourlyRate;

    public HourlyClassification(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
