package JavaBitSet;

import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    	
    	int n = 0;
    	int m = 0;
        
        Scanner reader = new Scanner(System.in);
        
        n = reader.nextInt();
        
        BitSet B1 = new BitSet(n);
        BitSet B2 = new BitSet(n);
        
        m = reader.nextInt();
        Operation[] operations = new Operation[m];
        reader.nextLine();
        
        for(int i = 0; i< m; i++) {
        	
        	String lectureLine = reader.nextLine();
        	
        	String[] splited = lectureLine.split(" ");
        	
        	OperationName name = OperationName.fromString(splited[0]);
        	Integer argumentOne = Integer.parseInt(splited[1]);
        	Integer argumentTwo = Integer.parseInt(splited[2]);

        	operations[i] = new Operation(name,argumentOne,argumentTwo);
        	
        }
        reader.close();
        
        for(int i = 0 ; i < m ; i ++) {
        	
        	/*
        	System.out.println("i: " + i);
        	System.out.println("Operation: " + operations[i].getOperationName());
        	*/
        	
        	if(operations[i].getOperationName() == OperationName.AND) {
        		if(operations[i].getVal1() == 1) {
        			B1.and(B2);
        		}
        		else if(operations[i].getVal1() == 2) {
        			B2.and(B1);
        		}
        		else {
        			System.out.println("Error");
        		}
        	}
        	else if(operations[i].getOperationName() == OperationName.OR) {
        		if(operations[i].getVal1() == 1) {
        			B1.or(B2);
        		}
        		else if(operations[i].getVal1() == 2) {
        			B2.or(B1);
        		}
        		else {
        			System.out.println("Error");
        		}
        	}
        	else if(operations[i].getOperationName() == OperationName.XOR) {
        		if(operations[i].getVal1() == 1) {
        			B1.xor(B2);
        		}
        		else if(operations[i].getVal1() == 2) {
        			B2.xor(B1);
        		}
        		else {
        			System.out.println("Error");
        		}
        	}
        	else if(operations[i].getOperationName() == OperationName.FLIP) {
        		if(operations[i].getVal1() == 1) {
        			B1.flip(operations[i].getVal2());
        		}
        		else if(operations[i].getVal1() == 2) {
        			B2.flip(operations[i].getVal2());
        		}
        		else {
        			System.out.println("Error");
        		}
        	}
        	else if(operations[i].getOperationName() == OperationName.SET) {
        		if(operations[i].getVal1() == 1) {
        			B1.set(operations[i].getVal2());
        		}
        		else if(operations[i].getVal1() == 2) {
        			B2.set(operations[i].getVal2());
        		}
        		else {
        			System.out.println("Error");
        		}
        	}
        	else {
        		System.out.println("Error");
        	}
        	
        	Integer numberOfOnesB1 = B1.cardinality();
        	Integer numberOfOnesB2 = B2.cardinality();
        	
        	System.out.println(numberOfOnesB1 + " " + numberOfOnesB2);
        }
    }
}