package ex3_2;

import java.util.HashMap;

/**
 * Exercise 3 and 4 --- Did not find start code, so I wrote simple code myself
 * @author Wenqing
 *
 */

public class exercise3 {	
	public static void main (String[] args){
		HashMap<Person, String> phonemap = new HashMap<Person, String>();
		
		// saving some entries into the map
		String num1 = "123-456-7890";
		Person p1 = new Person("Kelly","Bob");
		phonemap.put(p1, num1);
		
		String num2 = "345-678-9012";
		Person p2 = new Person("Kim","David");
		phonemap.put(p2, num2);
		
		// looking for Kelly,Bob's phone number
		for(Person p: phonemap.keySet()){
			if(p.getName().equals("Kelly,Bob")){
				System.out.println("His phone number is: " + phonemap.get(p));
			}
		}
		
		// looking for the person who has phone number 123-456-7890
		for(Person p: phonemap.keySet()){
			if(phonemap.get(p).equals("123-456-7890")){
				System.out.println("The person who uses this number is: " + p);
			}
		}
	}
}