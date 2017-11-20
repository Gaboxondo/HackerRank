package Anagrams;

import java.io.*;
import java.util.*;

import Anagrams.Solution.FrecuencyLetter;

public class Solution {

    static boolean isAnagram(String a, String b) {
    	
    	boolean anagram= true;
    	
    	ArrayList<FrecuencyLetter> ABreakDown = new ArrayList<FrecuencyLetter>();
    	ArrayList<FrecuencyLetter> BBreakDown = new ArrayList<FrecuencyLetter>();
    	
    	ABreakDown = BreakDownString(a);
    	BBreakDown = BreakDownString(b);
    	
    	Collections.sort(ABreakDown, new CustomComparator());
    	Collections.sort(BBreakDown, new CustomComparator());
    	
    	if(ABreakDown.size() != BBreakDown.size()) {
    		anagram = false;
    	}
    	else {
    		for(int i = 0; i< ABreakDown.size();i++) {
    			if(Character.toLowerCase(ABreakDown.get(i).getCharac()) != Character.toLowerCase(BBreakDown.get(i).getCharac()) || ABreakDown.get(i).getFrecuency() != BBreakDown.get(i).getFrecuency()) {
    				anagram = false;
    				break;
    			}
    		}
    	}
    	
    	
    	return anagram;
    }
    
    public static ArrayList<FrecuencyLetter> BreakDownString(String a){
    	
    	ArrayList<FrecuencyLetter> st = new ArrayList();
    	
    	st.add(new FrecuencyLetter(a.charAt(0), 1));
    	
    	for (int i = 1; i < a.length(); i++) {
    		
    		char aux = a.charAt(i);
    		boolean repetead = false;
    		
    		for (int j = 0; j<st.size();j++) {
    			if(st.get(j).getCharac() == aux) {
    				st.get(j).setFrecuency(st.get(j).getFrecuency()+1);
    				repetead = true;
    				break;
    			}
    		}
    		
    		if(repetead == false) {
    			st.add(new FrecuencyLetter(aux, 1));
    		}
    	}
    	
    	return st;
    }
    
	public static class FrecuencyLetter{
		private char charac;
		private int frecuency;
		
		public FrecuencyLetter(char charac,int frecuency) {
			this.charac = charac;
			this.frecuency = frecuency;
		}
		
		public void setCharac(char a) {
			this.charac = a;
		}
		
		public void setFrecuency(int f) {
			this.frecuency = f;
		}
		
		public char getCharac() {
			return this.charac;
		}
		
		public int getFrecuency() {
			return this.frecuency;
		}

	}
	
	public static class CustomComparator implements Comparator<FrecuencyLetter> {

		@Override
		public int compare(FrecuencyLetter arg0, FrecuencyLetter arg1) {
			
			char a = Character.toLowerCase(arg0.getCharac());
			char b = Character.toLowerCase(arg1.getCharac());
			
			if(a > b){
				return 1;
			}
			else if(a < b){
				return -1;
			}
			else {
				return 0;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );

	}
	


}
