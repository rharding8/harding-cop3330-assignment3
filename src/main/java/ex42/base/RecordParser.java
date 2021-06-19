package ex42.base;

public class RecordParser {

  // Declare Instance Variable String Array recordsList to store the records as an array
  private final String[] recordsList;
  // Declare Instance 2D String Array recordsTable to store records as a table
  private String[][] recordsTable;

  public RecordParser(String[] recordsList) {
    // Constructor: Set Instance recordsList to parameter
    // Call fillTable
    this.recordsList = recordsList;
  }

  public void fillTable() {
    // Initialize recordsTable to have as many rows as recordsList does cells
    recordsTable = new String[recordsList.length][];
    // for (iterate through recordsList)
    //  set row of recordsTable equal to the values in that cell of recordsList,
    //  splitting cells by commas.
    int i;
    for (i = 0; i < recordsList.length; i++) {
      recordsTable[i] = recordsList[i].split(",");
    }
  }

  public String[][] getTable() {
    // Get recordsTable
    return recordsTable;
  }
}
