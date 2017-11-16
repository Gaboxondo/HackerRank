package CurrencyFormater;


import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        NumberFormat formater = NumberFormat.getCurrencyInstance(Locale.US);
        String us = formater.format(payment);
        NumberFormat fch = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String china = fch.format(payment);
        NumberFormat ff = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = ff.format(payment);
        
        Locale INDIA = new Locale("en","IN");
        NumberFormat fin = NumberFormat.getCurrencyInstance(INDIA);
        String india = fin.format(payment);
        
        
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}