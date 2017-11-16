package Calendar;

import java.util.Scanner;
import java.util.Calendar;

public class Solution {
	
    public static String getDay(String day, String month, String year) {
        
        Calendar date = Calendar.getInstance();
        
        date.set(Integer.parseInt(year),(Integer.parseInt(month)-1),Integer.parseInt(day));
        
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        String weekDay = "";
        
        if(dayOfWeek == 1){
            weekDay = "SUNDAY";
        }
		
        else if(dayOfWeek == 2){
            weekDay = "MONDAY";
        }
		
        else if(dayOfWeek == 3){
            weekDay = "TUESDAY";
        }
		
        else if(dayOfWeek == 4){
            weekDay = "WEDNESDAY";
        }
		
        else if(dayOfWeek == 5){
            weekDay = "THURSDAY";
        }
		
        else if(dayOfWeek == 6){
            weekDay = "FRIDAY";
        }
		
        else if(dayOfWeek == 7){
            weekDay = "SATURDAY";
        }
        
        return weekDay;
    }
	
	    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();
        
        System.out.println(getDay(day, month, year));
    }
}
    