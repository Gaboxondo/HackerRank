package JavaMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String []argh){
		
		Scanner reader = new Scanner(System.in);
		
		Map<String,Integer> phonelist = new HashMap<>();
		
		int n=reader.nextInt();
		//Esto devuelve el entero pero no el \n por lo que añadimos un nextLine que elimine este problema
		
		//Añade el primer caracter de escape
		reader.nextLine();
		
		for(int i=0;i<n;i++)
		{
			String name=reader.nextLine();
			Integer phone=reader.nextInt();
			
			phonelist.put(name, phone);
			reader.nextLine();
		}
		
		List<String> queries = new ArrayList<>();
		
		while(reader.hasNext())
		{
			String s =reader.nextLine();
			queries.add(s);
		}
		
		for(int i = 0; i< queries.size(); i++) {
			//System.out.println(queries.get(i));
			if(phonelist.containsKey(queries.get(i))) {
				System.out.print(queries.get(i));
				System.out.print("=");
				System.out.println(phonelist.get(queries.get(i)));
			}
			else {
				System.out.println("Not found");
				
			}
		}
	}
}
