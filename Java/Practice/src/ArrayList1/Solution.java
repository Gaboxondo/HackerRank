package ArrayList1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	private static Scanner reader = new Scanner(System.in);
	
    private static List<List<Integer>> filas = new ArrayList<List<Integer>>();
    private static List<List<Integer>> queries = new ArrayList<List<Integer>>();
    
    private static int n = 0;
    private static int q = 0;
    
    public static void main(String[] args) {
        
    	n = askRowsNumber();
    	fillArrayList(filas,n);
    	
    	q = askQueriesNumber();
    	
    	fillQuerieList(queries,q);
    	checkQuerieList(queries,filas,q);
        
        
    }
    
    public static int askRowsNumber() {
    	System.out.println("Introduzca el numero de lineas : ");
        int a = reader.nextInt();
        
        return a;
    }
    
    
    public static void fillArrayList(List<List<Integer>> f, int rows) {
    	
    	
    	int [] dlines = new int[rows];
      //Para cada fila
        for(int i = 0; i < rows; i++ )
        {
        	//pedir el numero de elementos de la fila
        	System.out.println("Introduzca el numero de elementos de la linea " + i + " : ");
            dlines[i] = reader.nextInt();
            
            //Crear una arraylist de enteros
            
            ArrayList<Integer> aux = new ArrayList<Integer>();
            //Para cada numero de elementos por fila
            for(int k = 0; k<dlines[i];k++) {
            	
            	//pedir los elementos
            	System.out.println("Introduzca el elemento "  + k + " de la linea " + i +" :");
            	aux.add(reader.nextInt());
            }
            
            //meter la fila de elementos en el arraylist
            f.add(aux);
        }
    }
    
    public static int askQueriesNumber() {
    	 System.out.println("Introduzca el numero de queries: ");
         int b = reader.nextInt();
         
         return b;
    }
    
    public static void fillQuerieList(List<List<Integer>> f, int j) {
    	//Pedir el numero de queries
       
        
        for(int i = 0; i<j;i++) {
        	
        	int x = 0;
        	int y = 0;
        	
        	List<Integer> aux = new ArrayList<Integer>();
        	System.out.println("Introduzca el X de la querie " + i + ": ");
        	x = reader.nextInt();
        	System.out.println("Introduzca el Y de la querie " + i + ": ");
        	y = reader.nextInt();
        	
        	aux.add(x);
        	aux.add(y);
        	
        	f.add(aux);
        }
    }
    
    public static void checkQuerieList(List<List<Integer>> q,List<List<Integer>> f, int b) {
    	
    	for(int i = 0; i<b; i++) {
        	
        	List<Integer> aux = q.get(i);
        	
        	int xaux = aux.get(0) - 1;
        	int yaux = aux.get(1) - 1;
        	
        	System.out.println("xaux: " + xaux);
        	System.out.println("yaux: " + yaux);
        	
        	int valor = 0;
        	
        	System.out.println("filas size: " + f.size());
        	
        	if(f.size() > xaux) {
        		List<Integer> aux2 = f.get(xaux);
        		System.out.println("aux4: " + aux2);
        		
        		System.out.println("aux4 size: " + aux2.size());
        		
        		if(aux2.size() > yaux) {
        			valor = aux2.get(yaux);
        			System.out.println(valor);
        		}
        		else {
        			System.out.println("ERROR!");
        		}
        	}else {
        		System.out.println("ERROR!");
        	}
        }  
    }
}