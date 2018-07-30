package ex1_prime_number;

import java.util.Vector;

/**
 * Exercise 1 - print prime numbers 
 * @author Wenqing
 */

public class exercise1 {	
	/*
	 Implement a version of the program to calculate prime numbers that you saw in Chapter 4
	 to use a Vector<> object instead of an array to store the primes. (Hint: Remember the Integer class.)
	 */	
	public static boolean isPrime(long num){
		//if number is divisible besides 1 and itself, it is not prime
	    for(long i=2; i<num; i++){
	    if(num%i == 0){
	        return false;
	        }
	    }
	    return true; 
	}
	public static void main(String[] args){
		//print prime number between 2 and 100
		Vector<Long> primelist = new Vector<>();		
		for(long i=2; i<=100; i++){			
			if(isPrime(i)){
				primelist.add(i);
			}		
		}
		
		for (Long l: primelist){
			System.out.println(l);
		}		
	}
}