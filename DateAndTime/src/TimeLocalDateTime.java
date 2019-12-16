import java.time.LocalDateTime;
import java.time.Month;

public class TimeLocalDateTime {

    public static void main(String[] args) {

        // The java.time.LocalDateTime class represents a date-time
        // without a time-zone in the ISO-8601 calendar system, such as 2007-12-03T10:15:30.
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        System.out.println(LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30));
        LocalDateTime.parse("2015-02-20T06:30:00");

        // now.plusDays(1);
        System.out.println(now.plusDays(1));

        now.minusHours(2);
        now.getMonth();
        System.out.println(now.getMonth());
        System.out.println(now.getDayOfYear());
        System.out.println(now.getMonthValue());


        String monthAsString = now.getMonth().toString();
        System.out.println(monthAsString.toLowerCase());




    }
}