package ch14examples;

public class Person implements Comparable<Person> {
  // Constructor
  public Person(String firstName, String surname) {
    this.firstName = firstName;
    this.surname = surname;
  }

  @Override
  public String toString() {
    return firstName + " " + surname;
  }

  // Compare Person objects
  public int compareTo(Person person) {
    int result = surname.compareTo(person.surname);
    return result == 0 ? firstName.compareTo(person.firstName) : result;
  }

  private String firstName;            // First name of person
  private String surname;              // Second name of person
}
