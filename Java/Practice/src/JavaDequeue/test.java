package JavaDequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        
        Deque<Integer> deque = new LinkedList<>();
        Set<Integer> aux = new HashSet<>();
        
        int n = in.nextInt();
        Integer[] array = new Integer[n];
        
        int m = in.nextInt();
        
        int max = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            array[i] = num;
        }
        
        //Inicializacion de la deque
        for(int i = 0; i <m; i++) {
        	deque.addLast(array[i]);
        }
        
        aux.addAll(deque);
        max = aux.size();
        
         for(int i = 1; i < ((n-m)+1); i++) {
        	
        	aux.clear();
        	int currentmax = 0;
        	deque.addLast(array[m+i-1]);
        	deque.removeFirst();
        	aux.addAll(deque);
        	currentmax = aux.size();
        	if(currentmax > max) {
        		max = currentmax;
        	}
        }
        System.out.println(max);
    }
}
