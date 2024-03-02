package structures;

/**
 * Determines how to translate images into categories into which ones determine speech
 */

public class AACMappings {

  /**
   * Adds the mapping to the current category
   * 
   * @param imageLoc
   * @param text
   */
  public void add(java.lang.String imageLoc, java.lang.String text) {
    // STUB
  } // add(java.lang.String, java.lang.String)


  /**
   * Gets the current category
   */
  public java.lang.String getCurrentCategory() {
    return ""; // STUB
  } // getCurrentCategory

  /**
   * Provides an array of all of the images in the current category
   */
  public java.lang.String[] getImageLocs() {
    java.lang.String[] images = {"", ""};
    return images; // STUB
  }

  /**
   * Given the image location, return the associated text with the image
   * @param imageLoc
   */
  public java.lang.String getText(java.lang.String imageLoc) {
    return ""; // STUB
  } // getText(java.lang.String)


  /**
   * Determines if the image represents a category or text to speech
   * @param imageLoc
   */
  public boolean isCategory(java.lang.String imageLoc) {
    return false; //STUB
  } // isCategory(java.lang.String)


  /** 
   * Resets the current category of the AAC back to the default category
   */
  public void reset() {
    //STUB
  } // reset()


  /**
   * Writes the AAC mappings stored to a file
   * @param filename
   */
  public void writeToFile(java.lang.String filename) {
    //STUB
  } // writeToFile
} // class AACMappings
