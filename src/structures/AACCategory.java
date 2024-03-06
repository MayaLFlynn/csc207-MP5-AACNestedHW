package structures;

import structures.AssociativeArrayStruct.AssociativeArray;
import structures.AssociativeArrayStruct.KeyNotFoundException;
import structures.AssociativeArrayStruct.NullKeyException;

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
    this.category = new AssociativeArray<String, String>();
  } // AACategory

  /**
   * Adds the mapping of the imageLoc to the category
   * 
   * @param imageLoc
   * @param text
   */
  public void addItem(java.lang.String imageLoc, java.lang.String text) {
    try {
      this.category.set(imageLoc, text);
    } catch (NullKeyException e) {
    } // does nothing with a null key
  } // addItem(java.lang.String, java.lang.String)


  /**
   * Returns the name of the category
   */
  public java.lang.String getCategory() {
    return this.name;
  } // getCategory()


  /**
   * Returns an array of all of the images in the category
   */
  public java.lang.String[] getImages() {
    java.lang.String[] images = new String[category.size()];
    for (int i = 0; i < category.size(); i++) {
      images[i] = category.grabKey(i);
    }
    return images;
  } // getImages()


  /**
   * Returns the text associated with the given image loc in this category
   * 
   * @param imageLoc
   */
  public java.lang.String getText(java.lang.String imageLoc) throws ElementNotFoundException {
    try {
      return category.get(imageLoc);
    } catch (KeyNotFoundException e) {
      throw new ElementNotFoundException();
    }
  } // getText()


  /**
   * Determines if the provided image is stored in the category
   * 
   * @param imageLoc
   */
  public boolean hasImage(java.lang.String imageLoc) {
    return category.hasKey(imageLoc);
  } // hasImage()
} // class AACCategory
