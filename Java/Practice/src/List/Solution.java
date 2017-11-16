package List;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	private static int  n = 0;
	private static int q = 0;
	
	private static ArrayList<Integer> lista = new ArrayList<Integer>();
	
	private static Scanner reader;
	
    public static void main(String[] args) {
    	
       reader = new Scanner(System.in);
       
       //Pedir el numero de elementos de la lista
       n = reader.nextInt();
       
       
       //Desde el primer elemento de la lista hasta el elemento n
       for(int i = 0; i < n; i++) {
    	   //Pedir un elemento y añadirlo a la lista
    	   lista.add(reader.nextInt());
       }
       
       //Pedir el numero de queries a realizar
       q = reader.nextInt();
       
       //Desde la primera peticion hasta la peticion q
       
       //Aqui lo que hace es meter el primer caracter de escape
       
       for (int j = 0; j< q ;j++) {
    	   
    	   reader.nextLine();   //Aqui lo que hace es meter el primer caracter de escape
    	   
    	   String command = reader.nextLine();
    	   
    	   if(command.equals("Insert")) {
    		   int x = reader.nextInt();
    		   int y = reader.nextInt();
    		   lista.add(x, y);
    	   }
    	   else if(command.equals("Delete")) {
    		   int x = reader.nextInt();
    		   lista.remove(x);
    	   }
    	   else {
    		   //Error
    	   } 
       }
       
       for(int i = 0; i< lista.size();i++) {
    	   System.out.print(lista.get(i) + " ");
       }
       
    }
    
}

