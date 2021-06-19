/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Harding
 */

package ex41.base;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {
  // Used as the main hub from which all commands to the two other classes are run

  public static void main(String[] args) {
    /* Create Strings holding file names
    * Create instances of the FileIO Class "myFile" and NameManager Class "nameSet"
    *   Use inputString as parameter for myFile's constructor
    * Declare and Set String[] "nameList" to the output of call to readList
    * Call setNames from NameManager
    *   Give input of the nameList
    * Call sortAlpha from NameManager
    * Call getNames from NameManager
    *   Store in nameList
    * Call writeToFile from FileIO
    *   Input of nameList
    * Call closeInput from FileIO
    */

    Application app = new Application();
    String inputString = "./src/main/java/ex41/base/exercise41_input.txt";
    String outputString = "./src/main/java/ex41/base/exercise41_output.txt";
    FileIO myFile = new FileIO();
    myFile.setInputFile(inputString);
    NameManager nameSet = new NameManager();
    String[] nameList = app.readList(myFile);
    nameSet.setNames(nameList);
    nameSet.sortAlpha();
    nameList = nameSet.getNames();
    try {
      myFile.writeToFile("Total of " + nameList.length + " names", outputString, nameList);
    } catch (IOException e) {
      e.printStackTrace();
    }
    myFile.closeInput();
  }

  public String[] readList(FileIO myFile) {
    // Call readFromFile in FileIO
    try {
      return myFile.readFromFile();
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
      return new String[0];
    }
  }
}
