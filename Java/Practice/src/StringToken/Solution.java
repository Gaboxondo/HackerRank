package StringToken;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        
        s = s.trim();
        
        scan.close();
        
        if(s.equals("")) {
        	System.out.println(0);
        }
        else {
        	
            
            String[] divisions = s.split("[ !,?.\\\\_'@]+");
            
	        System.out.println(divisions.length);
	        
	        for(int i = 0; i< divisions.length; i++) {
	        	System.out.println(divisions[i]);
	        }
        }
    }
}
