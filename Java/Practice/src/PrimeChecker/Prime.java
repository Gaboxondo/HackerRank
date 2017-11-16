package PrimeChecker;

import static java.lang.System.*;

class Prime{

    public void checkPrime(int... n){
        for(int i = 0; i < n.length; i++){
            if(testPrime(n[i])){
                out.print(n[i] + " ");
            }
        }
        out.println("");
    }
    
    private boolean testPrime(int n){
        boolean prime = true;
        if( n == 1) {
        	prime = false;
        }
        else {
        	for(int i = 2 ; i< n; i++){
                if(n%i == 0){
                    prime = false;
                }
            }
        }
        
        return prime;
    }
}
