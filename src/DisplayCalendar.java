import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Locale;

public class DisplayCalendar {

	public static void main(String[] args) {
		int month = 5;
		int year = 2016;
		String monthStr, yearStr;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the month (XX): ");
		month = scan.nextInt();
		
		System.out.print("Enter the year (XXXX): ");
		year = scan.nextInt();
		
		// create a new calendar and set it's date to the year, month, and first day of month
		Calendar cal = new GregorianCalendar();		
		//cal.clear();
		
		//first month of the year in the Gregorian and Julian calendars is JANUARY which is 0
		cal.set(year, month-1, 1);
		
		monthStr = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US).toUpperCase();
				
		int firstWeekDay = cal.get(Calendar.DAY_OF_WEEK);
		//System.out.println("First Week Day: "+firstWeekDay);
		
		int lastDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//System.out.println("Last Day of Month: "+lastDayOfMonth);
		
		System.out.println("\n-----------------------------------");
		System.out.println("          "+monthStr + " " +year);
		System.out.println("");
		System.out.println("  Sun  Mon Tues  Wed Thur  Fri  Sat");
			
		// print blank spaces before the first day of the month
		for (int i=1;i<firstWeekDay;i++) {
			System.out.print("     ");
		}
		
		int currWeekDay = firstWeekDay;
		for (int i=1;i<=lastDayOfMonth;i++) {
			System.out.printf("   %2d", i);			
			if (currWeekDay % 7 == 0) {
				System.out.println("");
			}
			currWeekDay++;
		}
		System.out.println("\n-----------------------------------");		

	}
}
