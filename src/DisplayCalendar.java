import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class DisplayCalendar {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int month, year;
		String months[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov", "Dec"};
		String daysOfWeek[] = {" Sun", " Mon", "Tues", " Wed", "Thurs", " Fri", " Sat"};
		System.out.print("Enter the month (XX): ");
		month = scan.nextInt();
		month -= 1;
		System.out.print("Enter the year (XXXX): ");
		year = scan.nextInt();
		
		// create calendar with Eastern Standard Time time zone
		String[] ids = TimeZone.getAvailableIDs(-5 * 60 * 60 * 1000);		
		 SimpleTimeZone est = new SimpleTimeZone(-5 * 60 * 60 * 1000, ids[0]);		 
		Calendar calendar = new GregorianCalendar(est);
		
		Date currTime = new Date(); // get current date
		calendar.setTime(currTime);
		//System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
		
		// System.out.println("MONTH: " + calendar.get(Calendar.MONTH));		
		
		
		// create a Gregorian calendar with a particular date
		// Year must be a four digit integer
		// Month is an integer from 0 to 11
		// Day must be an integer from 1 to 31
		GregorianCalendar gc = new GregorianCalendar(year, month, 1);

		//System.out.println("Month:" + gc.get(Calendar.MONTH));
		// show the month from the array
		//System.out.println(gc.get(Calendar.MONTH));
		System.out.print("\n               " + months[gc.get(Calendar.MONTH)]);
		System.out.println("Day:" + gc.get(Calendar.DATE));
		System.out.println(" " + gc.get(Calendar.YEAR));
		for (int i=0;i<daysOfWeek.length;i++) {
			System.out.print(daysOfWeek[i]+"  ");
		}
		int daysInMonth = 30;
		for (int i=0;i<daysInMonth;i++) {
			if (i % 7 == 0) {
				System.out.println("");
				System.out.print(" ");
			}
			System.out.print(String.format("%2d", i)+"    ");
		}
		

	}

}
