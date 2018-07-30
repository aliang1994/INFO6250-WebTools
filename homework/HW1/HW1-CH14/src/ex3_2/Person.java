package ex3_2;

public class Person {
	private String lastname;
	private String firstname;	
	
	public Person(String ln, String fn){
		this.lastname = ln;
		this.firstname = fn;
	}
	
	public String getLast (){
		return lastname;
	}
	
	public String getFirst(){
		return firstname;
	}
	
	public String getName(){
		return lastname+","+firstname;
	}
	
	public String toString(){
		return lastname + "," +firstname;
	}
}