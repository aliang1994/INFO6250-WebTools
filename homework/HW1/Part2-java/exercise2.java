package ex2_card_deck;

import java.util.LinkedList;

import java.util.ListIterator;
import java.util.Random;
import java.util.Vector;


/**
 * Exercise 2: print 4 hands of shuffled cards
 * @author Wenqing
 *
 */


public class exercise2 {
	
	public static void main(String[] args){
		Vector<String> carddeck = new Vector<>(52);
		LinkedList<String> shuffleddeck = new LinkedList<>();
		
		String[] suit = {"c","d","h","s"}; // club, diamond, heart, spade
		String[] value = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		
		//new unshuffled card deck
		for(String s1: suit){
			for(String s2: value){
				carddeck.add(s1 + s2);
			}
		}
		
		//transfer to shuffled deck
		Random rand = new Random();
		for(int i=0; i<52; i++){
			int index = rand.nextInt(carddeck.size());
			String card = carddeck.remove(index);
			shuffleddeck.add(card);
		}
		
		
		// Split into four hands
	    StringBuffer[] hand = {new StringBuffer("Hand1:"), new StringBuffer("Hand2:"),
	                             new StringBuffer("Hand3:"), new StringBuffer("Hand4:")};
	    ListIterator<String> itr = shuffleddeck.listIterator();

	    while(itr.hasNext()) {
	    	for(StringBuffer sb : hand) {
	    		sb.append(' ').append(itr.next());
	        }
	    }

	    // print
	    for(StringBuffer sb : hand) {
	    	System.out.println(sb);
	    }
	}

}
