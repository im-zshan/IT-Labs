// Implement a java code using Date Class / Gregorian calender / Time.

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.GregorianCalendar;


public class Q1 {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();
        System.out.println("LocalDate: " + ld);

        LocalTime lt = LocalTime.now();
        System.out.println("LocalTime: " + lt);

        GregorianCalendar gc = new GregorianCalendar();
        System.out.println("The Gregorian Calendar is as follows:");
        System.out.println(" Here's Day: " + gc.get(GregorianCalendar.DAY_OF_MONTH));
        System.out.println(" Here's Month: " + gc.get(GregorianCalendar.MONTH));
        System.out.println(" Here's Year: " + gc.get(GregorianCalendar.YEAR));
    }
}