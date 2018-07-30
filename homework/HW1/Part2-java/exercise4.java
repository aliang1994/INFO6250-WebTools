package ex3_2;

import java.util.HashMap;

public class exercise4 {	
	public static void main(String[] args){
		HashMap<Person, String> phonemap = new HashMap<Person, String>();
		
		// saving some entries into the map
		String num1 = "123-456-7890";
		Person p1 = new Person("Kelly","Bob");
		phonemap.put(p1, num1);
				
		String num2 = "345-678-9012";
		Person p2 = new Person("Kim","David");
		phonemap.put(p2, num2);
		
		String num3 = "456-7890-123";
		Person p3 = new Person ("Kelly", "David");
		phonemap.put(p3, num3);
		
		String num4 = "567-8901-234";
		Person p4 = new Person ("Kim", "Bob");
		phonemap.put(p4, num4);
		
		//Searching by last name
		System.out.println("Last name Kelly:");		
		for(Person p: phonemap.keySet()){			
			if(p.getLast().equals("Kelly")){				
				System.out.println(p + "  " + phonemap.get(p));
			}
		}
				
		
	}
}