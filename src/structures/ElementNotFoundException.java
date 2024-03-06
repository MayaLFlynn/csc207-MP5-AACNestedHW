package structures;
/**
 * Exceptions that indicate that a key is not in an associative array
 * (dictionary, map, etc.).
 *
 * @author Samuel A. Rebelsky
 */
public class ElementNotFoundException extends Exception{
  /**
   * Create a new exception.
   */
  public ElementNotFoundException() {
    super("element not found");
  } // ElementNotFoundException()

  /**
   * Create a new exception with a particular message.
   */
  public ElementNotFoundException(String message) {
    super(message);
  } // ElementNotFoundException(String)
} // class ElementNotFoundException
