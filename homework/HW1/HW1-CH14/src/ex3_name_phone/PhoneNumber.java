package ex3_name_phone;

import java.io.*;

class PhoneNumber implements Serializable {
  public PhoneNumber(String areacode, String number) {
    this.areacode = areacode;
    this.number = number;
  }

  // Read a phone number from the keyboard
  public static PhoneNumber readNumber() {
    String area = null;                                                // Stores the area code
    String localcode = null;                                           // Stores the local code
    try {
      System.out.print("Enter area code: ");
      area = keyboard.readLine().trim();
      System.out.print("Enter local code: ");
      localcode = keyboard.readLine().trim();
      System.out.print("Enter the number: ");
      localcode += " " + keyboard.readLine().trim();
    } catch(IOException e) {
      System.err.println("Error reading a phone number.");
      e.printStackTrace();
      System.exit(1);
    }
    return new PhoneNumber(area, localcode);
  }

  @Override
  public String toString() {
    return areacode + " " + number;
  }

  @Override
  public boolean equals(Object aNumber) {
    PhoneNumber n = (PhoneNumber)aNumber;
    return areacode.equals(n.areacode) && number.equals(n.number);
  }

  @Override
  public int hashCode() {
    return 7*areacode.hashCode()+13*number.hashCode();
  }

  private String areacode;
  private String number;
  private static final long serialVersionUID = 1001L;
  private static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
}
