import java.util.Scanner;
public class DOWFinder {
	
	public String findDOW(int day, int month, int year) {
		int yearDiff, daysDiff, leapYears;
		yearDiff = year - 1900;
		daysDiff = yearDiff * 365;
		leapYears = (year - 1900)/4;
		if((year % 4 == 0 || year % 400 == 0) && (month == 1 || month == 2)) {
			leapYears -= 1;
		}
		daysDiff += leapYears;
		int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
		for(int i=0;i<(12-month + 1);i++) {
			daysDiff += days[i];
		}
		daysDiff += day;
		daysDiff = daysDiff % 7;
		
		switch (daysDiff) {
		case 0: return "Sunday";
		case 1: return "Monday";
		case 2: return "Tuesday";
		case 3: return "Wednesday";
		case 4: return "Thursday";
		case 5: return "Friday";
		case 6: return "Saturday";
		}
		return "";
	}
	
	
	
	public static void main(String[] args) {
		DOWFinder finder = new DOWFinder();
		int day, month, year;
		Scanner scan = new Scanner(System.in);
		day = scan.nextInt();
		month = scan.nextInt();
		year = scan.nextInt();
		System.out.println(finder.findDOW(day, month, year));
		scan.close();
	}
}
