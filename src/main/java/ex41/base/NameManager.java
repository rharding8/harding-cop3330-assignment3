package ex41.base;

import java.util.ArrayList;
import java.util.Collections;

public class NameManager {
  // Class to handle the lists of names as they are

  // Declare ArrayList<String> object "nameList"
  private final ArrayList<String> nameList = new ArrayList<>();

  public void setNames(String[] names) {
    // Copy all contents of names into nameList
    Collections.addAll(nameList, names);
  }

  public String[] getNames() {
    // Return nameList as an Array of Strings
    return nameList.toArray(new String[0]);
  }

  public void sortAlpha() {
    // Sort nameList in alphabetical order of Strings
    nameList.sort(String::compareToIgnoreCase);
  }
}
