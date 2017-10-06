package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HourlyClassification extends PaymentClassification {
    public int hourlyRate;
    private List<TimeCard> timeCards = new ArrayList<>();

    public HourlyClassification(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public TimeCard getTimeCard(LocalDate date) {
        for (TimeCard tc : timeCards)
            if (tc.date.equals(date))
                return tc;
        return null;
    }

    public void addTimeCard(TimeCard timeCard) {
        timeCards.add(timeCard);
    }
}
