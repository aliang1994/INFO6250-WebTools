package ex4_phonebook;

public class InvalidUserInputException extends Exception {
  public InvalidUserInputException() {}

  public InvalidUserInputException(String message) {
    super(message);
  }

  private static final long serialVersionUID = 1002L;
}
