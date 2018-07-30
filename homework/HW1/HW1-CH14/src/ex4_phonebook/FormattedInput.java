package ex4_phonebook;

import java.io.StreamTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FormattedInput {

  // Method to read an int value
  public int readInt() throws InvalidUserInputException {
    if (readToken() != StreamTokenizer.TT_NUMBER) {
      throw new InvalidUserInputException(" readInt() failed. Input data not numeric");
    }

    if (tokenizer.nval > (double) Integer.MAX_VALUE
            || tokenizer.nval < (double) Integer.MIN_VALUE) {
      throw new InvalidUserInputException(" readInt() failed. Input outside int range");
    }

    if (tokenizer.nval != (double) (int) tokenizer.nval) {
      throw new InvalidUserInputException(" readInt() failed. Input not an integer");
    }
    return (int) tokenizer.nval;
  }


  // Method to read a double value...
  public double readDouble() throws InvalidUserInputException {
    if (readToken() != StreamTokenizer.TT_NUMBER) {
      throw new InvalidUserInputException(" readDouble() failed. Input data not numeric");
    }
    return tokenizer.nval;
  }

  // Method to read a string...
  public String readString() throws InvalidUserInputException {
    if (readToken() == StreamTokenizer.TT_WORD || ttype == '\"'
            || ttype == '\'') {
      return tokenizer.sval;
    } else {
      throw new InvalidUserInputException(" readString() failed. Input data is not a string");
    }
  }

  // Helper method to read the next token
  private int readToken() {
    try {
      ttype = tokenizer.nextToken();
      return ttype;

    } catch (IOException e) {                                                                      // Error reading in nextToken()
      e.printStackTrace();
      System.exit(1);                                                                              // End the program
    }
    return 0;
  }

  // Object to tokenize input from the standard input stream
  private StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
  private int ttype;                                                                               // Stores the token type code
}
