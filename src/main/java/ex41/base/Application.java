package ex41.base;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {
  // Used as the main hub from which all commands to the two other classes are run

  public static void main(String[] args) {
    /* Create Strings holding file names
    * Create instances of the FileIO Class "myFile" and NameManager Class "nameSet"
    *   Use inputString as parameter for myFile's constructor
    * Call readFromFile in FileIO
    *   Declare and Set String[] "nameList" to the output of above
    * Call setNames from NameManager
    *   Give input of the nameList
    * Call sortAlpha from NameManager
    * Call getNames from NameManager
    *   Store in nameList
    * Call writeToFile from FileIO
    *   Input of nameList
    * Call closeInput from FileIO
    */

    String inputString = "./src/main/java/ex41/base/exercise41_input.txt";
    String outputString = "./src/main/java/ex41/base/exercise41_output.txt";
    FileIO myFile = new FileIO(inputString);
    NameManager nameSet = new NameManager();
    String[] nameList = new String[0];
    try {
      nameList = myFile.readFromFile();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    nameSet.setNames(nameList);
    nameSet.sortAlpha();
    nameList = nameSet.getNames();
    try {
      myFile.writeToFile(outputString, nameList);
    } catch (IOException e) {
      e.printStackTrace();
    }
    myFile.closeInput();
  }
}
