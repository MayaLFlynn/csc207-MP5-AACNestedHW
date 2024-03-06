package structures;
/**
 * Exception indicates that an imageLoc cannot be found in the expected area. 
 * (dictionary, map, etc.).
 *
 * 
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
