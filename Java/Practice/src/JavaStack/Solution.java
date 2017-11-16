package JavaStack;


import java.util.*;

class Solution{
   
	
   public static void main(String []argh)
   {
	   String test = "{}()";
	   System.out.println("Test: " + test);
	   
	   
	   int j = -2;
	   while(j != (-1)) {
		   System.out.println("String Lenght: " + test.length());
		   j = buscaPar(test);
		   if(j == -1) {
			   break;
		   }
		   System.out.println("index founded: " + j);
		   test = eliminaPar(test,j);
		   System.out.println("Test: " + test);
		   
	   }
	   System.out.println("final test: " + test);
   }
    
    public static int buscaPar(String s){
        for(int i = 0; i < ((s.length()) -1); i++){
            String aux = s.substring(i, i+2);
            System.out.println("Aux : " + aux);
            if(aux.equals("[]") || aux.equals("()") || aux.equals("{}")){
                return i;
            }
        }
        return (-1);    
    }
    
    public static String eliminaPar(String s, int n) {
    	String aux = "empty";
    	if(!s.isEmpty()) {
    		if(n == 0) {
    			if(s.length()>2) {
    				aux = s.substring(2);
    			}
    			else {
    				aux = "empty";
    			}
        	}
        	else if(n == (s.length()-2)) {
        		aux = s.substring(0, s.length()-2);
        	}
        	else if(n>0 && n<(s.length()-2)) {
        		aux = s.substring(0, n) + s.substring(n+2);
        	}
        	else {
        		return "Error";
        	}
        	return aux;
    	}
    	else {
    		return aux;
    	}
    }
}
