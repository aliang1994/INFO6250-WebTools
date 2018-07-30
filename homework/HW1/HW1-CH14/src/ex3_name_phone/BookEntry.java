package ex3_name_phone;

import java.io.Serializable;

class BookEntry implements Comparable<BookEntry>, Serializable {
  public int compareTo(BookEntry entry) {
    return person.compareTo(entry.getPerson());
  }

  public BookEntry(Person person, PhoneNumber number) {
   this.person = person;
    this.number = number;
  }

  public Person getPerson() {
    return person;
  }

  public PhoneNumber getNumber() {
    return number;
  }

  @Override
  public String toString() {
    return person.toString() + '\n' + number.toString();
  }

  // Read an entry from the keyboard
  public static BookEntry readEntry() {
    return new BookEntry(Person.readPerson(), PhoneNumber.readNumber());
  }

  private Person person;
  private PhoneNumber number;
  private static final long serialVersionUID = 1001L;
}
