package default_package;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class SaturdaySunday {

    public static void main(String[] args) {

        int year = 2025; 
        int month = 11;  

        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

        System.out.println("Saturdays and Sundays in November " + year + ":");

        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
            DayOfWeek day = date.getDayOfWeek();
            if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
                System.out.println(date + " (" + day + ")");
            }
        }
    }
}