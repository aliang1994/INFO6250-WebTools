package ex1_prime_number;

// Chapter 14 Exercise 1

/*
 Implement a version of the program to calculate prime numbers that you saw in Chapter 4
 to use a Vector<> object instead of an array to store the primes. (Hint: Remember the Integer class.)
 */

 /*
  You probably didn't need the hint. The point was that a Vector<> container cannot store data
  of primitive types so you must store the primes as objects - of type Long in this case.
  */
import java.util.Vector;

public class MorePrimes {
  public static void main(String[] args) {
    Vector<Long> primes = new Vector<>();                              // Vector to store primes
    int primesRequired = 20;                                           // Number of primes required

    primes.add(new Long(2L));                                          // Seed the first prime
    primes.add(new Long(3L));                                          // and the second
    long number = 5L;                                                  // Next integer to be tested
    long divisor = 0L;                                                  // Stores current trial divisor

    outer:
    for( ; primes.size() < primesRequired; number += 2) {
      // The maximum divisor we need to try is square root of number
      long limit = (long)Math.ceil(Math.sqrt((double)number));

      // Divide by all the primes we have up to limit
      for(int i = 1; i < primes.size() && (divisor = primes.elementAt(i)) <= limit; ++i) {
        if(number%divisor == 0) {                                      // Is it an exact divisor?
          continue outer;                                              // Yes, try the next number
        }
      }
      primes.add(number);                                              // We got one!
    }
    // Output all the primes six to a line
    int count = 0;
    for(Long prime : primes) {
      System.out.printf("%15d", prime);
      if(++count%6 == 0) {
        System.out.println();
      }
    }
  }
}