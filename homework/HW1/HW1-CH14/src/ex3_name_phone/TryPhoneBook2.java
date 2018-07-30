package ex3_name_phone;

// Chapter 14 Exercise 3

/*
 Extend the program from this chapter that used a map to store
 names and telephone numbers such that you can enter a number to retrieve the name.
 */

 /*
  This should be easy. What you might forget is that the PhoneNumber class must implement
  the hashcode() method and the equals() method. If you don't, you won't be able to find
  the phonebook entry for a number.
  */
public class TryPhoneBook2 {
  public static void main(String[] args) {
    PhoneBook book = new PhoneBook();                                  // The phone book
    FormattedInput in = new FormattedInput();                          // Keyboard input
    Person someone;
    while(true) {
      System.out.println("Enter 1 to enter a new phone book entry\n"+
                         "Enter 2 to find the number for a name\n"+
                         "Enter 3 to list all the entries\n" +
                         "Enter 4 to find the name for a number\n" +
                         "Enter 9 to quit.");
      int what = 0;                                                    // Stores input selection
      try {
        what = in.readInt();

      } catch(InvalidUserInputException e) {
        System.out.println(e.getMessage() + "\nTry again.");
        continue;
      }

      switch(what) {
        case 1:
          book.addEntry(BookEntry.readEntry());
          break;
        case 2:
          someone = Person.readPerson();
          BookEntry entry = book.getEntry(someone);
          if(entry == null) {
            System.out.println("The number for " + someone + " was not found.");
          } else {
            System.out.println("The number for " + someone + " is " + entry.getNumber());
          }
          break;
        case 3:
          book.listEntries();
          break;
        case 4:
          PhoneNumber number = PhoneNumber.readNumber();
          entry = book.getEntry(number);
          if(entry == null) {
            System.out.println("No entry for the number " + number + " was found.");
          } else {
            System.out.println("The name corresponding to the number " + number +
                                               " is " + entry.getPerson().toString());
          }
          break;
        case 9:
          book.save();
          System.out.println("Ending program.");
          return;
        default:
          System.out.println("Invalid selection, try again.");
          break;
      }
    }
  }
}
