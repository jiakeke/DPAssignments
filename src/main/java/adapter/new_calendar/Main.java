package adapter.new_calendar;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        // Create a Calendar instance
        Calendar calendar = Calendar.getInstance();

        // Create an adapter for the Calendar instance
        NewDateInterface newDate = new CalendarToNewDateAdapter(calendar);

        // Set to October 15, 2023
        newDate.setYear(2023);
        newDate.setMonth(7);
        newDate.setDay(5);


        // Use the adapter to manipulate the date
        System.out.println("Original Date: " + newDate.getDay() + "/" + (newDate.getMonth()) + "/" + newDate.getYear());
        newDate.advanceDays(10);
        System.out.println("After advancing 10 days: " + newDate.getDay() + "/" + (newDate.getMonth()) + "/" + newDate.getYear());
    }
}
