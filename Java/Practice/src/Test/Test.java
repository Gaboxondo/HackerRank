package Test;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		
		int x = 0;
		String palabra = "";
		x = Integer.parseInt(lector.nextLine());
		
		palabra = lector.nextLine();
		
		System.out.println(x);
		System.out.println(palabra);
	}
}
