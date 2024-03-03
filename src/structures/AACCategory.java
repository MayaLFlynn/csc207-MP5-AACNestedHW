package structures;

import structures.AssociativeArrayStruct.AssociativeArray;

/**
 * Represents the mappings for a single page of items to be displayed
 */

public class AACCategory {
  /**
   * The name of the category
   */
  java.lang.String name;

  /**
   * An array that maps the image location to the text that should be spoken
   */
  AssociativeArray<String, String> category;

  /**
   * Build a new empty category
   */
  public AACCategory(java.lang.String name) {
    this.name = name;
  } // 

  /**
   * Adds the mapping of the imageLoc to the category
   * 
   * @param imageLoc
   * @param text
   */
  public void addItem(java.lang.String imageLoc, java.lang.String text) {
    // STUB
  } // addItem(java.lang.String, java.lang.String)


  /**
   * Returns the name of the category
   */
  public java.lang.String getCategory() {
    return ""; // STUB
  } // getCategory()


  /**
   * Returns an array of all of the images in the category
   */
  public java.lang.String[] getImages() {
    java.lang.String[] images = {"", ""};
    return images; // STUB
  } // getImages()


  /**
   * Returns the text associated with the given image loc in this category
   * 
   * @param imageLoc
   */
  public java.lang.String getText(java.lang.String imageLoc) {
    return ""; // STUB
  } // getText()


  /**
   * Determines if the provided image is stored in the category
   * 
   * @param imageLoc
   */
  public boolean hasImage(java.lang.String imageLoc) {
    return false; // STUB
  } // hasImage()
} // class AACCategory
