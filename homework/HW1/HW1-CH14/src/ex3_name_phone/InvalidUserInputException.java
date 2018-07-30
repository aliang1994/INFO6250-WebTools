package ex3_name_phone;

public class InvalidUserInputException extends Exception {
  public InvalidUserInputException() {  }

  public InvalidUserInputException(String message) {
    super(message);
  }

  private static final long serialVersionUID = 9876L;

}
