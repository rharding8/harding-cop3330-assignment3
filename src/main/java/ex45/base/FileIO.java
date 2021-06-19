/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Harding
 */

package ex45.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public class FileIO {
  // Class handling methods for file input/output

  // Declare File object "inputFile"
  private File inputFile;

  public void setInputFile(String inFile) {
    // Set inputFile to use the file of the name inFile
    inputFile = new File(inFile);
  }

  public void closeInput() {
    // Close inputFile
    inputFile = null;
  }

  public String[] readFromFile() throws FileNotFoundException {
    /* Declare and Initialize ArrayList<String> variable "fileContents"
    * Declare and Initialize Scanner Object "reader" to inputFile
    * while (there is still a line of code in reader)
    *   Add the next line from reader to fileContents
    * return String[] version of fileContents
    * */
    ArrayList<String> fileContents = new ArrayList<>();
    Scanner reader = new Scanner(inputFile);
    while (reader.hasNextLine()) {
      fileContents.add(reader.nextLine());
    }
    reader.close();
    return fileContents.toArray(new String[0]);
  }

  public void writeToFile(String message, String outFile, String[] fileContents) throws IOException {
    /* Declare and Initialize File object "outputFile" to file named outFile
    * if (file doesn't exist)
    *   Create File
    * Close outputFile
    * Declare and Initialize FileWrite "writer" to file named outputFile
    * Write "Total of [length of fileContents] names" to writer
    * Write horizontal line to writer
    * for (index 0 through length of fileContents)
    *   Write fileContents[index] to writer
    *   Add a line break every time
    * Close writer
    * */

    File outputFile = new File(outFile);
    while (!outputFile.createNewFile()) {
      //noinspection ResultOfMethodCallIgnored
      outputFile.delete();
    }
    FileWriter writer = new FileWriter(outputFile);
    writer.write(message);
    writer.write(String.format("%n-------------------%n"));
    for (String line: fileContents) {
      writer.write(line);
      writer.write(String.format("%n"));
    }
    writer.close();
  }
}
