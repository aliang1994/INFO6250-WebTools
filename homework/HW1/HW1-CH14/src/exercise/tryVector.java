package exercise;

import java.util.Vector;
import java.util.Iterator;

public class tryVector {
	
	public static void main(String[] args){
		Vector<String> names = new Vector<>(50,5);
		String[] array={"Alice", "Elaine", "Roxy", "Dalton", "Clara"};
		for (String s: array){
			names.add(s);
		}
		
		//method 1
		for (String s: names){
			System.out.println(s);
		}
		
		//method 2
		Iterator<String> iter = names.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

	

}
