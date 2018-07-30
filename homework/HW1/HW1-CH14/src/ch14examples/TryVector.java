package ch14examples;

import java.util.Vector;
import java.util.ListIterator;
import java.util.Collections;
import java.io.*;

public class TryVector {
  public static void main(String[] args) {
    Person aPerson = null;                                             // A person object
    Vector<Person> filmCast = new Vector<>();

    // Populate the film cast
    while(true) {                                                      // Indefinite loop
      aPerson = readPerson();                                          // Read in a film star
      if(aPerson == null) {                                            // If null obtained...
        break;                                                         // We are done...
      }
      filmCast.add(aPerson);                                           // Otherwise, add to the cast
    }

    int count = filmCast.size();
    System.out.println("You added " + count + (count == 1 ? " person":  " people") + " to the cast:");
    // Show who is in the cast using an iterator
    ListIterator<Person> thisLot = filmCast.listIterator();

    while(thisLot.hasNext()) {       // Output all elements
      System.out.println( thisLot.next());
    }
    System.out.println("\nThe vector currently has room for " + (filmCast.capacity() - count) + " more people.");

    // Now sort the vector contents and list it
    Collections.sort(filmCast);
    System.out.println("\nThe cast in ascending sequence is:");
    for(Person person : filmCast) {
      System.out.println(person);
    }
  }

  // Read a person from the keyboard
  static Person readPerson() {
    // Read in the first name and remove blanks front and back
    String firstName = null;
    String surname = null;
    System.out.println("\nEnter first name or ! to end:");
    try {
      firstName = keyboard.readLine().trim();                          // Read and trim a string

      if(firstName.charAt(0) == '!') {                                 // Check for ! entered
        return null;                                                   // If so, we are done...
      }

      // Read in the surname, also trimming blanks
      System.out.println("Enter surname:");
      surname = keyboard.readLine().trim();                            // Read and trim a string
    } catch(IOException e) {
      System.err.println("Error reading a name.");
      e.printStackTrace();
      System.exit(1);
    }
    return new Person(firstName,surname);
  }


  static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
}
