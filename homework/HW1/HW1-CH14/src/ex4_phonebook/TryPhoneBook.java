package ex4_phonebook;

// Chapter 14 Exercise 4
/*
   You could search the phone book for a given second name but
   I chose to go with a new strategy for how you store entries in the map.
   You can't just use second names as keys for BookEntry values because
   it is more than likely there will be duplicate second names from time to time,
   and duplicate keys are not allowed.

   My approach is to use the second name as a key and store a linked list of
   BookEntry objects corresponding to the name as the value. This has a useful
   side effect in that it will accommodate multiple entries with the same name
   but different numbers - something that the previous implementation did not allow for.
   This means that searching for the number corresponding to a given name may return
   more than one number. Normally you would have an address as a further
   distinguishing feature and you may want to try adding this to the BookEntry class.

   To continue to allow searching for a number, I also keep the second map with
   PhoneNumber objects as keys, but extend it to allow multiple entries per number by
   making the value for a key a linked list of entries. This will accommodate
   several people with the same phone number

   The program uses a different name for the file here because the file contents will
   be quite different from that of the previous exercise.

   Another thing you might like to try is to implement a "delete" operation for entries.
   This has the complication that you must find entries in two maps for deletion.
*/

class TryPhoneBook {
  public static void main(String[] args) {
    PhoneBook book = new PhoneBook();                                                              // The phone book
    FormattedInput in = new FormattedInput();                                                      // Keyboard input
    Person someone = null;
    BookEntry[] entries = null;
    int what = 0;

    for(;;) {
      System.out.println("Enter 1 to enter a new phone book entry\n"+
                         "Enter 2 to find the numbers for a second name\n"+
                         "Enter 3 to find the number for a first and second name\n"+
                         "Enter 4 to find the name for a number\n" +
                         "Enter 5 to list all the entries\n" +
                         "Enter 9 to quit.");
      try {
        what = in.readInt();
      } catch(InvalidUserInputException e) {
        System.out.println(e.getMessage()+"\nTry again.");
        continue;
      }
      switch(what) {
        case 1:
          book.addEntry(BookEntry.readEntry());
          break;
        case 2:                                                                                    // Get names and numbers for a second name
          System.out.println("\nEnter second name:");
          String name = null;
          try {
            name = in.readString().trim();
          } catch(InvalidUserInputException e) {
            System.out.println(e.getMessage()+"\nError Reading a string.");
            break;
          }
          entries = book.getEntries(name);
          if(entries.length == 0) {
            System.out.println("No entries found for "+name);
          } else {
            System.out.println("Entries found for " + name + ":");
            for(BookEntry entry : entries) {
              System.out.println("\n" + entry);
            }
          }

          break;
        case 3:                                                                                    // Get number for a person
          someone = Person.readPerson();
          entries = book.getEntries(someone);
          if(entries.length == 0) {
            System.out.println("The number for "+someone + " was not found. ");
          } else {
            System.out.println("The number(s) for "+someone + " are:");
            for(BookEntry entry : entries) {
              System.out.println(entry.getNumber());
            }
          }
          break;
        case 4:                                                                                    // Get persons at a given number
          PhoneNumber number = PhoneNumber.readNumber();
          entries = book.getEntries(number);
          if(entries.length == 0) {
            System.out.println("No entry for the number " + number + " was found.");
          } else {
            System.out.println("Entries found for " + number + ":");
            for(BookEntry entry : entries) {
              System.out.println("\n" + entry.getPerson());
            }
          }
          break;
        case 5:                                                                                    // List all the entries
          book.listEntries();
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
