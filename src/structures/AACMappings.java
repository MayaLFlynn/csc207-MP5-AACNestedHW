package structures;

import java.util.Scanner;
import structures.AssociativeArrayStruct.AssociativeArray;
import structures.AssociativeArrayStruct.KeyNotFoundException;
import structures.AssociativeArrayStruct.NullKeyException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Determines how to translate images into categories into which ones determine speech
 */

public class AACMappings {

  /**
   * 
   */

  final AACCategory DEFAULTCATEGORY = new AACCategory("");
  AACCategory currentCategory;
  AssociativeArray<String, AACCategory> allCategories = new AssociativeArray<String, AACCategory>();

  /**
   * "this method should read in the file and create the relevant mappings from images to categories
   * and add all the items to each category. It should also start the AAC on the homescreen"
   */
  public AACMappings(java.lang.String filename) throws FileNotFoundException {
    this.currentCategory = DEFAULTCATEGORY;
    Scanner file = new Scanner(new File(filename));
    while (file.hasNext()) {
      String textLine = file.nextLine();
      String[] lineArray = textLine.split(" ");
      String imageLoc = lineArray[0];
      String spokenText = "";
      for (int i = 1; i < lineArray.length; i++) {
        spokenText = spokenText.concat(lineArray[i] + " ");
      }
      if (textLine.charAt(0) != '>') {
        this.currentCategory = DEFAULTCATEGORY;
        add(imageLoc, spokenText);
      } else {
        add(imageLoc, spokenText);
      }
    }


    file.close();
    this.currentCategory = DEFAULTCATEGORY;
  } //

  /**
   * Adds the mapping to the current category
   * 
   * @param imageLoc
   * @param text
   */
  public void add(java.lang.String imageLoc, java.lang.String text) {
    if (currentCategory.equals(DEFAULTCATEGORY)) {

      this.currentCategory.addItem(imageLoc, text);
      AACCategory cat = new AACCategory(text);
      this.currentCategory = cat;
      try {
        allCategories.set(text, cat);
      } catch (NullKeyException e) {
      }

    } else {
      if (imageLoc.charAt(0) == '>') {
        String image = imageLoc.substring(1);
        this.currentCategory.addItem(image, text);
      } else {
        this.currentCategory.addItem(imageLoc, text);
      } // else
    }
  } // add(java.lang.String, java.lang.String)


  /**
   * Gets the name of the current category
   */
  public java.lang.String getCurrentCategory() {
    return this.currentCategory.name;
  } // getCurrentCategory

  /**
   * Provides an array of all of the images in the current category
   */
  public java.lang.String[] getImageLocs() {
    return this.currentCategory.getImages();
  } // getImageLocs()

  /**
   * Given the image location, return the associated text with the image
   * 
   * @param imageLoc
   */
  public java.lang.String getText(java.lang.String imageLoc) throws ElementNotFoundException {
    try {
      this.currentCategory = allCategories.get(currentCategory.getText(imageLoc));
    } catch (KeyNotFoundException e) {
    }
    return this.currentCategory.getText(imageLoc);
  } // getText(java.lang.String)


  /**
   * Determines if the image represents a category or text to speech
   * 
   * @param imageLoc
   */
  public boolean isCategory(java.lang.String imageLoc) { 
    if (imageLoc.charAt(0) == '>') {
      return true;
    }
    return false;
  } // isCategory(java.lang.String)


  /**
   * Resets the current category of the AAC back to the default category
   */
  public void reset() {
    this.currentCategory = this.DEFAULTCATEGORY;
  } // reset()


  /**
   * Writes the AAC mappings stored to a file
   * 
   * @param filename
   */
  public void writeToFile(java.lang.String filename) throws FileNotFoundException {
    this.currentCategory = DEFAULTCATEGORY;
    PrintWriter newFile = new PrintWriter("AACMappingsNew.txt");
    for (int i = 0; i < DEFAULTCATEGORY.getImages().length; i++) {
      newFile.println(DEFAULTCATEGORY.getImages()[i] + " " + allCategories.grabKey(i));
      this.currentCategory = allCategories.grabValue(i);
      for (int j = 0; j < this.currentCategory.getImages().length; j++) {
        try { 
          newFile.println(">" + currentCategory.getImages()[j] + " " + currentCategory.getText(currentCategory.getImages()[j]));
        } catch (ElementNotFoundException e) {}
      } // for the inner items
    } // for the outer categories
    newFile.close();
    this.currentCategory = DEFAULTCATEGORY;
  } // writeToFile
} // class AACMappings
