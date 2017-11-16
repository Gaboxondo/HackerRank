package Array2Dex;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        int max = -63;
        
        int arr[][] = new int[6][6];
        
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
            	System.out.println("Introduce i[" + i + "] j[" + j + "] :");
                arr[i][j] = in.nextInt();
            }
        }
        for(int j = 0 ; j < 4 ; j++ ){
            for(int i = 0 ; i < 4 ; i++ ){
            	
                int[] sup = new int[7];
                sup[0] = arr[j][i];
                sup[1] = arr[j][i+1];
                sup[2] = arr[j][i+2];
                sup[3] = arr[j+1][i+1];
                sup[4] = arr[j+2][i];
                sup[5] = arr[j+2][i+1];
                sup[6] = arr[j+2][i+2];
                
                int suma = 0;
                
                for(int n=0; n < 7; n++){
                    suma = suma + sup[n];
                }
                
                if(suma > max){
                    max = suma;
                }
            }
        }
        
        System.out.println(max);
    }
}

