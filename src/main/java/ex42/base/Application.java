/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Harding
 */

package ex42.base;

import java.io.FileNotFoundException;

public class Application {
  // Like ex41, this is the gateway from which all commands to the supporting classes are run.

  public static void main(String[] args) {
    // Declare and Initialize "app" as an object of this class
    // Declare and Initialize String "inputFileName" to path and name of the file to open
    // Declare and Initialize FileIO Object "myFile"
    // Call setInputFile in myFile using inputFileName
    // Declare and Set String Array "records" to output of readList()
    // Declare and Initialize RecordParser Object "myParser" using records
    // Initialize and Set 2D String Array "myTable" to output of getTable() in myParser
    // Call printTable using myTable
    // Call closeInput() in myFile just in case
    Application app = new Application();
    String inputFileName = "./src/main/java/ex42/base/exercise42_input.txt";
    FileIO myFile = new FileIO();
    myFile.setInputFile(inputFileName);
    String[] records = app.readList(myFile);
    RecordParser myParser = new RecordParser(records);
    myParser.fillTable();
    String[][] myTable = myParser.getTable();
    app.printTable(myTable, "Salary");
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

  public void printTable(String[][] table, String finalCol) {
    // Prints out a table-format display of table, first column last name, second column first name,
    // and last column uses whatever category is given by finalCol.
    System.out.printf("%-10s%-10s%-10s%n", "Last", "First", finalCol);
    System.out.println("---------------------------");
    for (String[] row: table) {
      for (String cell: row) {
        System.out.printf("%-10s", cell);
      }
      System.out.println();
    }
  }
}
